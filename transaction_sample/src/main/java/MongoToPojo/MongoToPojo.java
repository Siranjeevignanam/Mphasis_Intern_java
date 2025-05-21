package main;
import project.*;


import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.client.*;
import org.bson.Document;
import pojos.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class MongoToPojo {

    public static void main(String[] args) throws Exception {
        MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
        MongoDatabase db = mongoClient.getDatabase("Transaction_Details");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        // Load collections
        Map<String, Customer> customerMap = RecordMapper.mapSingle(db, "Customer", Customer.class, mapper);
        Map<String, List<Address>> addressMap = RecordMapper.mapList(db, "Address", Address.class, mapper);
        Map<String, List<Account>> accountMap = RecordMapper.mapList(db, "Account", Account.class, mapper);
        Map<String, List<Bank>> bankMap = RecordMapper.mapList(db, "Bank", Bank.class, mapper);
        Map<String, List<CreditCard>> creditCardMap = RecordMapper.mapList(db, "CreditCard", CreditCard.class, mapper);
        Map<String, List<DebitCard>> debitCardMap = RecordMapper.mapList(db, "DebitCard", DebitCard.class, mapper);
        Map<String, List<Loan>> loanMap = RecordMapper.mapList(db, "Loan", Loan.class, mapper);
        Map<String, List<Status>> statusMap = RecordMapper.mapList(db, "Status", Status.class, mapper);
        Map<String, List<UPI>> upiMap = RecordMapper.mapList(db, "UPI", UPI.class, mapper);
        Map<LocalDate, Map<String, List<Transaction>>> groupedTransactions =
                RecordMapper.groupByDate(db, "Transaction", Transaction.class, mapper);

        PojoToText.writeGroupedByDate(groupedTransactions, customerMap, addressMap, accountMap, bankMap,
                creditCardMap, debitCardMap, loanMap, statusMap, upiMap);

        System.out.println("✅ All files written successfully.");
    }
}
