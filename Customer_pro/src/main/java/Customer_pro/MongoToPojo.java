package Customer_pro;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoToPojo {

    public static List<Transactions> fetchTransactionsFromMongo() {
        String connectionString = "mongodb://localhost:27017"; // Your MongoDB URI
        String databaseName = "Example1";
        String collectionName = "data4"; // MongoDB collection

        List<Transactions> transactions = new ArrayList<>();

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            // Fetch documents from MongoDB
            for (Document doc : collection.find()) {
                // Extract fields from MongoDB document
                String customerName = doc.getString("customer_name");
                int transactionId = doc.getInteger("transaction_id");
                int accountNumber = doc.getInteger("account_number");
                String email = doc.getString("email");
                double amount = doc.get("amount", Number.class).doubleValue();
                String phone = doc.getString("phone");
                String timestamp = doc.getString("timestamp");
                
                if(customerName!="null"&& transactionId!=0 && amount!=0)
                {
                // Convert to POJO (Transaction)
                Transactions transaction = new Transactions(customerName, transactionId, accountNumber,
                        email, amount, phone, timestamp);

                // Add to list
                transactions.add(transaction);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactions;
        
    }
}
