package project;

public record Account(
	    String AccountHolderNumber,
	    String AccountScheme,
	    String AccountSchemeCode,
	    String AccountBranch,
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
	) {}