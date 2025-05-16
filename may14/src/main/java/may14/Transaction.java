package may14;



public record Transaction(
		  String id,
		  String type,
		) double amount,
	   String currency,
	    @FixedWidth(size = 10) String status,
	    @FixedWidth(size = 10)  String timestamp,
	    @FixedWidth(size = 10) String description,
	    @FixedWidth(size = 10)String method,
	    @FixedWidth(size = 10)String reference,
	    double fee
	) {}