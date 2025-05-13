package multiple_pojo;

public record MongoTransaction(
	    int transactionId,
	    Transaction transaction,
	    Customer customer,
	    Address address,
	    Bank bank,
	    Status status,
	    TransactionType type,
	    Account account
	) {}
