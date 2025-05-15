package may14;


import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDate {

    
    public static Map<String, List<FullDocument>> groupByDate(List<FullDocument> docs) {
        return docs.stream()
                .collect(Collectors.groupingBy(fd -> extractDateOnly(fd.transaction().timestamp())));
    }

    
    private static String extractDateOnly(String timestamp) {
        try {
            OffsetDateTime odt = OffsetDateTime.parse(timestamp);
            LocalDate date = odt.toLocalDate();
            return date.toString();
        } catch (Exception e) {
            return timestamp.length() >= 10 ? timestamp.substring(0, 10) : "UNKNOWN_DATE";
        }
    }
}

