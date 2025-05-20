//package MongoToPojo;
//
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.mongodb.client.*;
//
//import org.bson.Document;
//import project.*;
//
//import java.io.BufferedWriter;
//import java.io.FileWriter;
//import java.time.LocalDate;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//
//public class MongoToPojo {
//
//    public static void main(String[] args) throws Exception {
//        ObjectMapper mapper = new ObjectMapper();
//        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//
//        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
//        MongoDatabase db = mongoClient.getDatabase("Transaction_Details");
//
//        // Load all collections into Map<CustomerMMID, List<POJO>>
//        Map<String, List<Address>> addressMap = loadCollection(db, "Address", Address.class, mapper);
//        Map<String, List<Account>> accountMap = loadCollection(db, "Account", Account.class, mapper);
//        Map<String, List<Bank>> bankMap = loadCollection(db, "Bank", Bank.class, mapper);
//        Map<String, List<CreditCard>> creditCardMap = loadCollection(db, "CreditCard", CreditCard.class, mapper);
//        Map<String, List<DebitCard>> debitCardMap = loadCollection(db, "DebitCard", DebitCard.class, mapper);
//        Map<String, List<Status>> statusMap = loadCollection(db, "Status", Status.class, mapper);
//        Map<String, List<Loan>> loanMap = loadCollection(db, "Loan", Loan.class, mapper);
//        Map<String, List<UPI>> upiMap = loadCollection(db, "UPI", UPI.class, mapper);
//
//        // Load transactions grouped by date -> CustomerMMID -> List<Transaction>
//        MongoCollection<Document> transactionCol = db.getCollection("Transaction");
//        DateTimeFormatter isoFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
//
//        Map<LocalDate, Map<String, List<Transaction>>> transactionByDate = new HashMap<>();
//
//        for (Document doc : transactionCol.find()) {
//            Transaction tx = mapper.readValue(doc.toJson(), Transaction.class);
//            LocalDate date = LocalDateTime.parse(tx.timestamp(), isoFormatter).toLocalDate();
//
//            transactionByDate
//                .computeIfAbsent(date, d -> new HashMap<>())
//                .computeIfAbsent(tx.CustomerMMID(), c -> new ArrayList<>())
//                .add(tx);
//        }
//
//        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
//
//        // For each date, write a single file with all data from all collections for customers with transactions on that date
//        for (LocalDate date : transactionByDate.keySet()) {
//            String fileName = outputFormatter.format(date) + ".txt";
//
//            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
//                Map<String, List<Transaction>> custTxMap = transactionByDate.get(date);
//
//                for (String customerId : custTxMap.keySet()) {
//                    // Write Customer info first (assuming one Customer per customerId)
//                    // You might want to load customers similarly like other collections if needed
//                    // For now, if you want customer, you should load it similarly to below maps.
//
//                    // Write Addresses
//                    List<Address> addresses = addressMap.get(customerId);
//                    if (addresses != null && !addresses.isEmpty()) {
//                        writer.write("Address");
//                       writer.newLine();
//                        writer.write(Address.header());
//                      writer.newLine();
//                        for (Address addr : addresses) {
//                            writer.write(addr.toString());
//                           writer.newLine();
//                        }
//                       writer.newLine();
//                    }
//
//                    // Write Accounts
//                    List<Account> accounts = accountMap.get(customerId);
//                    if (accounts != null && !accounts.isEmpty()) {
//                        writer.write("Accounts");
//                      writer.newLine();
//                        writer.write(Account.header());
//                       writer.newLine();
//                        for (Account acc : accounts) {
//                            writer.write(acc.toString());
//                            writer.newLine();
//                        }
//                        writer.newLine();
//                    }
//
//                    // Write Banks
//                    List<Bank> banks = bankMap.get(customerId);
//                    if (banks != null && !banks.isEmpty()) {
//                        writer.write("Banks:");
//                        writer.newLine();
//                        writer.write(Bank.header());
//                        writer.newLine();
//                        for (Bank bank : banks) {
//                            writer.write(bank.toString());
//                            writer.newLine();
//                        }
//                       writer.newLine();
//                    }
//
//                    // Write CreditCards
//                    List<CreditCard> creditCards = creditCardMap.get(customerId);
//                    if (creditCards != null && !creditCards.isEmpty()) {
//                        writer.write("Credit Cards:");
//                        writer.newLine();
//                        writer.write(CreditCard.header());
//                        writer.newLine();
//                        for (CreditCard cc : creditCards) {
//                            writer.write(cc.toString());
//                            writer.newLine();
//                        }
//                        writer.newLine();
//                    }
//
//                    // Write DebitCards
//                    List<DebitCard> debitCards = debitCardMap.get(customerId);
//                    if (debitCards != null && !debitCards.isEmpty()) {
//                        writer.write("Debit Cards:");
//                        writer.newLine();
//                        writer.write(DebitCard.header());
//                        writer.newLine();
//                        for (DebitCard dc : debitCards) {
//                            writer.write(dc.toString());
//                            writer.newLine();
//                        }
//                        writer.newLine();
//                    }
//
//                    // Write Statuses
//                    List<Status> statuses = statusMap.get(customerId);
//                    if (statuses != null && !statuses.isEmpty()) {
//                        writer.write("Statuses:");
//                        writer.newLine();
//                        writer.write(Status.header());
//                        writer.newLine();
//                        for (Status st : statuses) {
//                            writer.write(st.toString());
//                            writer.newLine();
//                        }
//                        writer.newLine();
//                    }
//
//                    // Write Loans
//                    List<Loan> loans = loanMap.get(customerId);
//                    if (loans != null && !loans.isEmpty()) {
//                        writer.write("Loans:");
//                        writer.newLine();
//                        writer.write(Loan.header());
//                        writer.newLine();
//                        for (Loan loan : loans) {
//                            writer.write(loan.toString());
//                            writer.newLine();
//                        }
//                        writer.newLine();
//                    }
//
//                    // Write UPIs
//                    List<UPI> upis = upiMap.get(customerId);
//                    if (upis != null && !upis.isEmpty()) {
//                        writer.write("UPI Details:");
//                        writer.newLine();
//                        writer.write(UPI.header());
//                        writer.newLine();
//                        for (UPI upi : upis) {
//                            writer.write(upi.toString());
//                            writer.newLine();
//                        }
//                        writer.newLine();
//                    }
//
//                    // Finally write Transactions for this customer on this date
//                    List<Transaction> transactions = custTxMap.get(customerId);
//                    if (transactions != null && !transactions.isEmpty()) {
//                        writer.write("Transactions:");
//                        writer.newLine();
//                        writer.write(Transaction.header());
//                        writer.newLine();
//                        for (Transaction tx : transactions) {
//                            writer.write(tx.toString());
//                            writer.newLine();
//                        }
//                        writer.newLine();
//                    }
//
//                    // Separate customers with a blank line
//                    writer.write("--------------------------------------------------");
//                    writer.newLine();
//                }
//            }
//        }
//
//        System.out.println("All data written to date-based files successfully.");
//    }
//
//    // Utility method to load any collection by CustomerMMID as key
//    private static <T> Map<String, List<T>> loadCollection(MongoDatabase db, String collectionName, Class<T> clazz, ObjectMapper mapper) throws Exception {
//        MongoCollection<Document> collection = db.getCollection(collectionName);
//        Map<String, List<T>> map = new HashMap<>();
//        for (Document doc : collection.find()) {
//            T obj = mapper.readValue(doc.toJson(), clazz);
//            String customerMMID = (String) doc.get("CustomerMMID");
//            if (customerMMID == null) continue; // skip if no CustomerMMID
//            map.computeIfAbsent(customerMMID, k -> new ArrayList<>()).add(obj);
//        }
//        return map;
//    }
//}
//
//


package MongoToPojo;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import org.bson.Document;
import project.*;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

public class MongoToPojo {

    public static void main(String[] args) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongoClient.getDatabase("New_Transaction");

        // Load collections into maps
        Map<String, List<Address>> addressMap = loadListMap(db.getCollection("Address"), Address.class, mapper);
        Map<String, List<Account>> accountMap = loadListMap(db.getCollection("Account"), Account.class, mapper);
        Map<String, List<Bank>> bankMap = loadListMap(db.getCollection("Bank"), Bank.class, mapper);
        Map<String, List<CreditCard>> creditCardMap = loadListMap(db.getCollection("CreditCard"), CreditCard.class, mapper);
        Map<String, List<DebitCard>> debitCardMap = loadListMap(db.getCollection("DebitCard"), DebitCard.class, mapper);
        Map<String, List<Status>> statusMap = loadListMap(db.getCollection("Status"), Status.class, mapper);
        Map<String, List<Loan>> loanMap = loadListMap(db.getCollection("Loan"), Loan.class, mapper);
        Map<String, List<UPI>> upiMap = loadListMap(db.getCollection("UPI"), UPI.class, mapper);

        Map<String, Customer> customerMap = new HashMap<>();
        for (Document doc : db.getCollection("Customer").find()) {
            Customer c = mapper.readValue(doc.toJson(), Customer.class);
            customerMap.put(c.CustomerMMID(), c);
        }

        // Group transactions by date and customerMMID
        MongoCollection<Document> transactionCol = db.getCollection("Transaction");
        Map<LocalDate, Map<String, List<Transaction>>> groupedData = new HashMap<>();
        for (Document doc : transactionCol.find()) {
            Transaction tx = mapper.readValue(doc.toJson(), Transaction.class);
            LocalDateTime ldt = LocalDateTime.parse(tx.timestamp().trim());
            LocalDate date = ldt.toLocalDate();
            groupedData
                .computeIfAbsent(date, d -> new HashMap<>())
                .computeIfAbsent(tx.CustomerMMID(), m -> new ArrayList<>())
                .add(tx);
        }

        // Write files grouped by date
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        for (Map.Entry<LocalDate, Map<String, List<Transaction>>> dateEntry : groupedData.entrySet()) {
            String fileName = outputFormatter.format(dateEntry.getKey()) + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                writer.write(
                        Customer.header() + " | " +
                        Address.header() + " | " +
                        Account.header() + " | " +
                        Bank.header() + " | " +
                        CreditCard.header() + " | " +
                        DebitCard.header() + " | " +
                        Status.header() + " | " +
                        Loan.header() + " | " +
                        UPI.header() + " | " +
                        Transaction.header());
                writer.newLine();

                for (Map.Entry<String, List<Transaction>> custEntry : dateEntry.getValue().entrySet()) {
                    String customerMMID = custEntry.getKey();
                    Customer customer = customerMap.get(customerMMID);
                    if (customer == null) continue;

                    List<Address> addresses = addressMap.get(customerMMID);
                    List<Account> accounts = accountMap.get(customerMMID);
                    List<Bank> banks = bankMap.get(customerMMID);
                    List<CreditCard> creditCards = creditCardMap.get(customerMMID);
                    List<DebitCard> debitCards = debitCardMap.get(customerMMID);
                    List<Status> statuses = statusMap.get(customerMMID);
                    List<Loan> loans = loanMap.get(customerMMID);
                    List<UPI> upis = upiMap.get(customerMMID);

                    for (Transaction tx : custEntry.getValue()) {
                        String line = format(customer) + " | " +
                                formatList(addresses) + " | " +
                                formatList(accounts) + " | " +
                                formatList(banks) + " | " +
                                formatList(creditCards) + " | " +
                                formatList(debitCards) + " | " +
                                formatList(statuses) + " | " +
                                formatList(loans) + " | " +
                                formatList(upis) + " | " +
                                tx.toString();
                        writer.write(line);
                        writer.newLine();
                    }
                }
            }
        }

        System.out.println("Files written successfully with full flat data.");
    }

    private static <T> Map<String, List<T>> loadListMap(MongoCollection<Document> collection, Class<T> clazz, ObjectMapper mapper) throws Exception {
        Map<String, List<T>> map = new HashMap<>();
        for (Document doc : collection.find()) {
            T obj = mapper.readValue(doc.toJson(), clazz);
            String mmid = (String) clazz.getMethod("CustomerMMID").invoke(obj);
            map.computeIfAbsent(mmid, k -> new ArrayList<>()).add(obj);
        }
        return map;
    }

    private static String format(Object obj) {
        return obj != null ? obj.toString() : blankRecord();
    }

    private static String formatList(List<?> list) {
        if (list == null || list.isEmpty()) return blankRecord();
        return list.stream().map(Object::toString).collect(Collectors.joining(" || "));
    }

    private static String blankRecord() {
        return " ".repeat(250);
    }
}
