package org.example;

import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
        public static void main(String[] args) throws Exception {
            MongoClient client = MongoClients.create("mongodb://localhost:27017");
            MongoDatabase db = client.getDatabase("transactions");
            MongoCollection<Document> collection = db.getCollection("collections");

            Map<String, List<Transaction>> byDate = new HashMap<>();

            for (Document doc : collection.find()) {
                Transaction txn = RecordMapper.map(doc, Transaction.class);
                byDate.computeIfAbsent(txn.date(), d -> new ArrayList<>()).add(txn);
            }

            for (String date : byDate.keySet()) {
                Path path = Path.of(date + ".txt");
                for (Transaction txn : byDate.get(date)) {
                    String fixedLine = FixedWidthFormatter.formatRecord(txn);
                    Files.writeString(path, fixedLine + System.lineSeparator(),
                            StandardOpenOption.CREATE, StandardOpenOption.APPEND);
                }
            }

            System.out.println("Fixed-width files created successfully by date.");
        }
    }
