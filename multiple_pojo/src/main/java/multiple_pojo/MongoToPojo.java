package multiple_pojo;

import com.mongodb.client.*;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoToPojo {

    public static List<MongoTransaction> fetchTransactionsFromMongo() {
        String connectionString = "mongodb://localhost:27017"; // Your MongoDB URI
        String databaseName = "Example1";
        String collectionName = "data4"; // MongoDB collection

        List<MongoTransaction> transactions = new ArrayList<>();

        try (MongoClient mongoClient = MongoClients.create(connectionString)) {
            MongoDatabase database = mongoClient.getDatabase(databaseName);
            MongoCollection<Document> collection = database.getCollection(collectionName);

            // Fetch documents from MongoDB
            for (Document doc : collection.find()) {
                // Extract fields from MongoDB document and convert to POJOs
                int transactionId = doc.getInteger("transaction_id");
                
                // Transaction
                Document transactionDoc = (Document) doc.get("transaction_id");
                double amount = transactionDoc.getDouble("amount");
                String timestamp = transactionDoc.getString("timestamp");
                String receiverName = transactionDoc.getString("receiver_name");
                Transaction transaction = new Transaction(amount, timestamp, receiverName);

                // Customer
                Document customerDoc = (Document) doc.get("customer_id");
                String customerName = customerDoc.getString("customer_name");
                String email = customerDoc.getString("email");
                String phone = customerDoc.getString("phone");
                Customer customer = new Customer(customerName, email, phone);

                // Address
                Document addressDoc = (Document) doc.get("address");
                String doorNo = addressDoc.getString("door_no");
                String street = addressDoc.getString("street");
                String city = addressDoc.getString("city");
                String state = addressDoc.getString("state");
                String pincode = addressDoc.getString("pincode");
                Address address = new Address(doorNo, street, city, state, pincode);

                // Bank
                Document bankDoc = (Document) doc.get("bank_id");
                String bankName = bankDoc.getString("bankname");
                String branch = bankDoc.getString("branch");
                String ifscCode = bankDoc.getString("ifsc_code");
                String bankType = bankDoc.getString("bank_type");
                Bank bank = new Bank(bankName, branch, ifscCode, bankType);

                // Status
                Document statusDoc = (Document) doc.get("status");
                String status = statusDoc.getString("status");
                String description = statusDoc.getString("description");
                Status statusObj = new Status(status, description);

                // Type
                Document typeDoc = (Document) doc.get("type");
                String type = typeDoc.getString("type");
                String senderId = typeDoc.getString("sender_id");
                String receiverId = typeDoc.getString("receiver_id");
                TransactionType typeObj = new TransactionType(type, senderId, receiverId);

                // Account
                Document accountDoc = (Document) doc.get("account_number");
                String accType = accountDoc.getString("acc_type");
                double balance = accountDoc.getDouble("balance");
                String accountNumber = accountDoc.getString("account_number");
                Account account = new Account(accType, balance, accountNumber);

                // Create MongoTransaction object and add it to the list
                MongoTransaction mongoTransaction = new MongoTransaction(
                        transactionId, 
                        transaction, 
                        customer, 
                        address, 
                        bank, 
                        statusObj, 
                        typeObj, 
                        account
                );

                transactions.add(mongoTransaction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return transactions;
    }

    public static void main(String[] args) {
        List<MongoTransaction> transactions = fetchTransactionsFromMongo();
        
        // Optionally, print the fetched transactions
        transactions.forEach(System.out::println);
    }
}
