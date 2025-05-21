package com.test.Collections;

import com.test.annotation.FieldLength;

public record Account(
		 int  TransactionId,
		@FieldLength(length=20)String AccountHolderNumber,
		@FieldLength(length=10) String AccountScheme,
		@FieldLength(length=10) String AccountSchemeCode,
		@FieldLength(length=10) String AccountBranch,
	    String AccountIFSC,
	    double AccountBalance,
	    double AccountUnclearedFunds,
	    double AccountAmountOnHold,
	    double AccountSpendingLimit,
	    String AccountBank,
	    String AccountCreditCard,
	    String AccountDebitCard,
	    String AccountLoan,
	    String AccountCurrency,
	    String AccountOpeningDate,
	    String AccountUPI
	) {
	
	 public static String header() {
	        return String.format(
	            "ID", "AccountHolderNumber", "AccountScheme", "AccountSchemeCode",
	            "AccountBranch", "AccountIFSC", "AccountBalance", "UnclearedFunds",
	            "AmountOnHold", "SpendingLimit", "AccountBank", "CreditCard", "DebitCard",
	            "Loan", "Currency", "OpeningDate", "UPI"
	        );
	    }

}