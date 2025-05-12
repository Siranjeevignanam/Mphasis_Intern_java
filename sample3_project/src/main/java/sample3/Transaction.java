package sample3;

public record Transaction(
	    String transactionId,
	    double amount,
	    String receiver,
	    String timestamp,
	    String status
	) {}