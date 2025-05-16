package may14;




import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDate {

    public static Map<String, List<FullDocument>> groupByDate(List<FullDocument> docs) {
        return docs.stream()
                .collect(Collectors.groupingBy(fd -> extractDateOnly(fd.transaction().timestamp())));
    }

    // Updated method to extract date from LocalDateTime
    private static String extractDateOnly(LocalDateTime timestamp) {
        if (timestamp != null) {
            return timestamp.toLocalDate().toString();  // Extracts date as a string (YYYY-MM-DD)
        }
        return "UNKNOWN_DATE";  // Default value if the timestamp is null
    }
}


