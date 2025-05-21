package com.test.Collections;

import com.test.annotation.FieldLength;

public record UPI(
		@FieldLength(length=10) int TransactionId,
	    String UPIID,
	    String UPIEmail,
	    double UPITransactionLimit,
	    boolean UPIIsActive,
	    String UPILinkedMobileNumber
	) {
	
	public static String header() {
        return String.format(
            "ID", "UPIID", "UPIEmail", "TxnLimit", "Active", "LinkedMobile"
        );
    }
	
	
}
