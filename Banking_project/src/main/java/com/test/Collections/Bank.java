package com.test.Collections ;

import com.test.annotation.FieldLength;

public record Bank(
		@FieldLength(length=10)	int TransactionId,
    String BankName,
    String BankIFSC,
    String BankMICR,
    String BankBranch,
    String BankBranchCode,
    String BankAddress,
    String BankContactNumber,
    String BankContactEmail
) {
	
	 public static String header() {
	        return String.format(
	            
	            "ID", "BankName", "BankIFSC", "BankMICR", "BankBranch",
	            "BranchCode", "BankAddress", "ContactNumber", "ContactEmail"
	        );
	    }
	 
	 
}
