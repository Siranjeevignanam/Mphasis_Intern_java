package multiple_pojo;

public record Transaction(
	    double amount,
	    String timestamp,
	    String receiverName
	) {}
