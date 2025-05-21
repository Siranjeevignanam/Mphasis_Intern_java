package com.test.Collections;

import com.test.annotation.FieldLength;

public record CreditCard(
		@FieldLength(length=10)	int TransactionId,
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
	) {
	
	public static String header() {
        return String.format(
           
         "ID", "CardNumber", "HolderName", "CVV", "Type",
            "CreditLimit", "AvailableBal", "ValidFrom", "ValidThru",
            "PaymentDue", "Active", "RewardPoint"
        );
    }
	
	
}
