package project;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mongodb.client.*;
import org.bson.Document;

import java.util.*;

public class MongoToPojo {

    private static final String CONNECTION_STRING = "mongodb://localhost:27017";
    private static final String DATABASE_NAME = "transaction_details";
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Map collection names to their POJO record classes
    private static final Map<String, Class<?>> COLLECTION_TO_POJO = Map.ofEntries(
            Map.entry("Customer", Customer.class),
            Map.entry("Address", Address.class),
            Map.entry("Account", Account.class),
            Map.entry("Bank", Bank.class),
            Map.entry("CreditCard", CreditCard.class),
            Map.entry("DebitCard", DebitCard.class),
            Map.entry("Loan", Loan.class),
            Map.entry("Transaction", Transaction.class),
            Map.entry("Status", Status.class),
            Map.entry("UPI", UPI.class)
    );

    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(CONNECTION_STRING)) {
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);

            // Get all collection names
            for (String collectionName : database.listCollectionNames()) {
                System.out.println("\nProcessing Collection: " + collectionName);

                // Check if we have a matching POJO class
                Class<?> clazz = COLLECTION_TO_POJO.get(collectionName);
                if (clazz == null) {
                    System.out.println("No matching POJO found for collection: " + collectionName);
                    continue;
                }

                // Fetch and map to POJO
                List<?> pojoList = fetchCollectionAsPOJO(database, collectionName, clazz);

                // Print or process the POJO list
                pojoList.forEach(obj -> System.out.println(gson.toJson(obj)));
            }
        }
    }

    // Generic fetcher
    public static <T> List<T> fetchCollectionAsPOJO(MongoDatabase database, String collectionName, Class<T> clazz) {
        List<T> resultList = new ArrayList<>();
        MongoCollection<Document> collection = database.getCollection(collectionName);

        for (Document doc : collection.find()) {
            T obj = gson.fromJson(doc.toJson(), clazz);
            resultList.add(obj);
        }

        return resultList;
    }
}
