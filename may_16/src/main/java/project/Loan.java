package project;

public record Loan(
	    String LoanScheme,
	    double LoanAmount,
	    double LoanInterest,
	    String LoanTenureDuration,
	    String LoanDisbursementDate,
	    String LoanMaturityDate,
	    double LoanOutstandingAmount,
	    double LoanEMIAmount,
	    String LoanCollateralDetails,
	    double LoanPenalty,
	    String LoanStatus
	) {}
