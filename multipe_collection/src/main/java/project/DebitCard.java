package project;

public record DebitCard(
	    String CardNumber,
	    String CardValidFrom,
	    String CardValidThru,
	    String CardHolderName,
	    String CardCVV,
	    String CardType
	) {}
