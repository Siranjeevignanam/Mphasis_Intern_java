package may14;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PojoToText {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static void writeGroupedByDate(List<FullDocument> docs) {
        // Group documents by date using GroupByDate class
        Map<String, List<FullDocument>> grouped = GroupByDate.groupByDate(docs);

        for (Map.Entry<String, List<FullDocument>> entry : grouped.entrySet()) {
            String date = entry.getKey();
            List<FullDocument> documents = entry.getValue();
            String fileName = date + ".txt";

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
                for (FullDocument doc : documents) {
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


    

