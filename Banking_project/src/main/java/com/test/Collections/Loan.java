package com.test.Collections;

import com.test.annotation.FieldLength;

public record Loan(
		@FieldLength(length=10)int TransactionId,
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
	) {
	
	public static String header() {
        return String.format(
            "ID", "LoanScheme", "LoanAmount", "Interest",
            "Tenure", "Disbursement", "Maturity", "Outstanding", "EMI",
            "CollateralDetails", "Penalty", "Status"
        );
    }
}
