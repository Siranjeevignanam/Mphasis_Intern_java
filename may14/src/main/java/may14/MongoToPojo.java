package may14;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class MongoToPojo {

    public static List<FullDocument> getPojoList() {
        var client = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase database = client.getDatabase("Example1");
        MongoCollection<Document> collection = database.getCollection("may14");

        ObjectMapper mapper = new ObjectMapper();
        List<FullDocument> pojoList = new ArrayList<>();

        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            try {
                FullDocument fullDoc = mapper.readValue(doc.toJson(), FullDocument.class);
                pojoList.add(fullDoc);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        client.close();
        return pojoList;
    }
}