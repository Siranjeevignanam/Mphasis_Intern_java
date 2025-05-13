package sample3;
import com.mongodb.client.*;
import org.bson.Document;

import java.io.*;
import java.nio.file.*;
import java.text.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Project {

    public static void main(String[] args) {
        String connectionString = "mongodb://localhost:27017"; // Use your Mongo URI
        String databaseName = "Example1";
        String collectionName = "data3";

        // Format for input timestamp
        DateTimeFormatter fileNameFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        // Time format to match the timestamp
        String inputFormat = "EEE MMM dd HH:mm:ss z yyyy";
        SimpleDateFormat dateFormat = new SimpleDateFormat(inputFormat, Locale.ENGLISH);

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            for (Document doc : collection.find()) {

                // Extract timestamp as a string
                String timestampStr = doc.getString("timestamp");

                // Parse the timestamp using SimpleDateFormat
                Date parsedDate = dateFormat.parse(timestampStr);
                Instant instant = parsedDate.toInstant();

                // Convert to LocalDateTime without using ZoneId
                LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneOffset.UTC);

                // Extract only the date (no time) for file name
                LocalDate date = localDateTime.toLocalDate();
                String fileName = fileNameFormatter.format(date) + ".txt";

                // Prepare POJOs
                Customer customer = new Customer(
                    doc.getString("customer_id"),
                    doc.getString("customer_name"),
                    doc.getString("mobile"),
                    doc.getString("email"),
                    doc.getString("address")
                );

                // Get the amount, handle both Integer and Double types
                Object amountObj = doc.get("amount");
                double amount = 0.0;
                if (amountObj instanceof Integer) {
                    amount = ((Integer) amountObj).doubleValue(); // Cast Integer to Double
                } else if (amountObj instanceof Double) {
                    amount = (Double) amountObj; // Directly cast if it's already a Double
                }

                Transaction transaction = new Transaction(
                    doc.getString("transaction_id"),
                    amount,
                    doc.getString("receiver"),
                    timestampStr,
                 
                    doc.getString("status")
                );

                // Prepare content
                String content = String.format(""" 
                        Customer ID: %s
                        Name: %s
                        Mobile: %s
                        Email: %s
                        Address: %s
                        Transaction ID: %s
                        Timestamp: %s
                        Amount: %.2f
                        Receiver: %s
                        Status: %s
                        -----------------------------
                        """,
                        customer.customerId(),
                        customer.customerName(),
                        customer.mobile(),
                        customer.email(),
                        customer.address(),
                        transaction.transactionId(),
                        transaction.timestamp(),
                        transaction.amount(),
                        transaction.receiver(),
                        transaction.status()
                );

                // Write to file named after the date
                Path filePath = Paths.get(fileName);
                Files.writeString(filePath, content, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
            }

            System.out.println("Data written to date-based text files.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // POJO class for Customer
    
}
