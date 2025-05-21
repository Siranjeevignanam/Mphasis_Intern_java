package PojoToText;
import java.io.*;
import java.nio.file.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class PojoToText {
    public static void write(Map<LocalDate, List<Map<String, Object>>> groupedData, String outputDir) throws IOException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        for (LocalDate date : groupedData.keySet()) {
            String fileName = outputDir + "/" + formatter.format(date) + ".txt";
            BufferedWriter writer = Files.newBufferedWriter(Paths.get(fileName));
            
            if (!groupedData.get(date).isEmpty()) {
                // Write headers
                Set<String> orderedCollections = groupedData.get(date).get(0).keySet();
                for (String key : orderedCollections) {
                    Object obj = groupedData.get(date).get(0).get(key);
                    writer.write(obj.getClass().getMethod("header").invoke(obj).toString() + " | ");
                }
                writer.newLine();
            }

            // Write data
            for (Map<String, Object> recordMap : groupedData.get(date)) {
                for (String key : recordMap.keySet()) {
                    Object obj = recordMap.get(key);
                    writer.write(obj.toString() + " | ");
                }
                writer.newLine();
            }
            writer.close();
        }
    }
}
