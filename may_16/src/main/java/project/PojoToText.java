package project;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PojoToText {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void writeGroupedByDate(List<TransactionDetails> docs) {
        // Group documents by date using GroupByDate class
        Map<Object, List<TransactionDetails>> grouped = GroupByDate.groupByDate(docs);

        for (Map.Entry<Object, List<TransactionDetails>> entry : grouped.entrySet()) {
            LocalDateTime date = (LocalDateTime) entry.getKey();
            List<TransactionDetails> documents = entry.getValue();
            String fileName = date + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (TransactionDetails doc : documents) {
                    String valuesOnly = extractValuesOnly(doc);
                    writer.write(valuesOnly);
                    writer.newLine();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private static String extractValuesOnly(Object obj) {
        ObjectMapper mapper = new ObjectMapper();

        // Convert object to a Map (removes field names)
        Map<String, Object> map = mapper.convertValue(obj, Map.class);

        // Extract values only, joining them with spaces
        return map.values().stream()
                .map(String::valueOf)
                .collect(Collectors.joining(" "));
    }

    }

