package project;

public record UPI(
	    String UPIID,
	    String UPIEmail,
	    double UPITransactionLimit,
	    boolean UPIIsActive,
	    String UPILinkedMobileNumber
	) {}
