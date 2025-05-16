package project;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByDate {

    
    public static Map<Object, List<TransactionDetails>> groupByDate(List<TransactionDetails> docs) {
        return docs.stream()
                .collect(Collectors.groupingBy(fd -> fd.transaction().timestamp()));
    }

    
    
}

