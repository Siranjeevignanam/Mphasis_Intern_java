package Customer_pro;



import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.HashMap;

public class PojoToText {

    // Method to write POJOs to text files based on date
    public static void writeTransactionsToText(List<Transactions> transactions) {
        // Date format for file naming and timestamp parsing
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        DateTimeFormatter timestampFormatter = DateTimeFormatter.ofPattern("EEE MMM dd HH:mm:ss zzz yyyy");  // Custom format

        // Group transactions by date
        Map<String, List<Transactions>> transactionsByDate = new HashMap<>();

        // Group transactions by the formatted date
        for (Transactions transaction : transactions) {
            String timestampStr = transaction.timestamp();
            LocalDate date = LocalDate.parse(timestampStr, timestampFormatter);  // Parse using the custom format
            String formattedDate = dateFormatter.format(date);  // Format the date as dd-MM-yyyy

            // Add transaction to the list for that date
            transactionsByDate.computeIfAbsent(formattedDate, k -> new ArrayList<>()).add(transaction);
        }

        // Write transactions to files based on the date
        for (Map.Entry<String, List<Transactions>> entry : transactionsByDate.entrySet()) {
            String date = entry.getKey();
            List<Transactions> transactionsForDate = entry.getValue();

            // Prepare the file path based on the date
            Path filePath = Paths.get(date + ".txt");

            // Prepare content to write in the file
            StringBuilder content = new StringBuilder();
            for (Transactions transaction : transactionsForDate) {
                content.append(String.format(""" 
                        Customer Name: %s
                        Transaction ID: %d
                        Account Number: %d
                        Email: %s
                        Amount: %.2f
                        Phone: %s
                        Timestamp: %s
                        -----------------------------
                        """,
                        transaction.customerName(),
                        transaction.transactionId(),
                        transaction.accountNumber(),
                        transaction.email(),
                        transaction.amount(),
                        transaction.phone(),
                        transaction.timestamp()
                ));
            }

            // Write content to the file
            try {
                Files.writeString(filePath, content.toString(), StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                System.out.println("Data written to " + filePath.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
