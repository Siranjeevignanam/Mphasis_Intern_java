package may14;

import org.example.FixedWidth;

public record Transaction(
		  @FixedWidth(size = 10)  String id,
		  @FixedWidth(size = 10)  String type,
		  @FixedWidth(size = 10) double amount,
	    @FixedWidth(size = 10) String currency,
	    @FixedWidth(size = 10) String status,
	    @FixedWidth(size = 10)  String timestamp,
	    @FixedWidth(size = 10) String description,
	    @FixedWidth(size = 10)String method,
	    @FixedWidth(size = 10)String reference,
	    double fee
	) {}