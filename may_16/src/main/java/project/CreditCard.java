package project;

public record CreditCard(
	    String CardNumber,
	    String CardHolderName,
	    String CardCVV,
	    String CardType,
	    double CardCreditLimit,
	    double CardAvailableBalance,
	    String CardValidFrom,
	    String CardValidThru,
	    String CardPaymentDueDate,
	    boolean CardIsActive,
	    int CardRewardPoint
	) {}
