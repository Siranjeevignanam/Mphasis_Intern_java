package MongoToPojo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;

import org.bson.Document;
import pojo.Customer;
import pojo.Transaction;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MongoToPojo {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, true);

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongoClient.getDatabase("Example1");

        MongoCollection<Document> customerCol = db.getCollection("Customer");
        MongoCollection<Document> transactionCol = db.getCollection("Transaction");

        // Load customers into Map<cus_id, Customer>
        Map<String, Customer> customerMap = new HashMap<>();
        for (Document doc : customerCol.find()) {
            Customer customer = mapper.readValue(doc.toJson(), Customer.class);
            customerMap.put(customer.cus_id(), customer);
        }

        // Date formatter matching timestamp format: ISO_LOCAL_DATE_TIME
        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

        // Group transactions by date and customer
        Map<LocalDate, Map<String, List<Transaction>>> groupedData = new HashMap<>();
        for (Document doc : transactionCol.find()) {
            Transaction tx = mapper.readValue(doc.toJson(), Transaction.class);

            // Parse timestamp string to LocalDate
            LocalDate date = LocalDateTime.parse(tx.timestamp(), isoFormatter).toLocalDate();

            groupedData
                .computeIfAbsent(date, d -> new HashMap<>())
                .computeIfAbsent(tx.cus_id(), c -> new ArrayList<>())
                .add(tx);
        }

        // Write to .txt files grouped by date
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (Map.Entry<LocalDate, Map<String, List<Transaction>>> dateEntry : groupedData.entrySet()) {
            String fileName = outputFormatter.format(dateEntry.getKey()) + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (Map.Entry<String, List<Transaction>> custEntry : dateEntry.getValue().entrySet()) {
                    Customer customer = customerMap.get(custEntry.getKey());

                    if (customer != null) {
                        for (Transaction tx : custEntry.getValue()) {
                            Map<String, Object> mapCustomer = mapper.convertValue(customer, Map.class);
                            Map<String, Object> mapTransaction = mapper.convertValue(tx, Map.class);

                            String customerValues = String.join(",", mapCustomer.values().stream()
                                .map(String::valueOf).toList());

                            String transactionValues = String.join(",", mapTransaction.values().stream()
                                .map(String::valueOf).toList());

                            writer.write(customerValues + " | " + transactionValues);
                            writer.newLine();
                        }
                    }
                }
            }
        }

        System.out.println("Files written successfully with values-only output.");
    }
}
