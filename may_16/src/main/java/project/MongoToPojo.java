package project;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoToPojo {

    public static List<TransactionDetails> getPojoList() {
        var client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = client.getDatabase("Example1");
        MongoCollection<Document> collection = database.getCollection("May16");

        ObjectMapper mapper = new ObjectMapper();
        List<TransactionDetails> details = new ArrayList<>();

        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            try {
               TransactionDetails transaction = mapper.readValue(doc.toJson(),TransactionDetails.class);
                details.add(transaction);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        client.close();
        return details;
    }
}
