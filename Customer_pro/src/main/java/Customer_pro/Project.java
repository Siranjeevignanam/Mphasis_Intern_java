package Customer_pro;

import java.util.List;

public class Project {
    public static void main(String[] args) {
        // Fetch the transactions from MongoDB and convert them to POJOs
        List<Transactions> transactions = MongoToPojo.fetchTransactionsFromMongo();

        // Write the transactions to text files based on the date
        PojoToText.writeTransactionsToText(transactions);
    }
}

