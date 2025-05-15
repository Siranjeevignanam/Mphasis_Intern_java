package may14;

import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.FindIterable;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.bson.Document;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        // Step 1: Get POJOs from MongoDB
        List<FullDocument> pojoList = MongoToPojo.getPojoList();

        // Step 2: Group POJOs by date
        // Group the documents based on date (using GroupByDate class)
        GroupByDate.groupByDate(pojoList);  // This method already returns a grouped map

        // Step 3: Write grouped POJOs to text files based on date
        // Write the grouped documents into text files (using PojoObjectsToTextFiles class)
        PojoToText.writeGroupedByDate(pojoList);

        System.out.println("Data has been grouped and written to files successfully.");
    }
}
