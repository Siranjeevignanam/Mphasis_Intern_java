package com.test.Collections;

import com.test.annotation.FieldLength;

public record DebitCard(
		@FieldLength(length=10)int TransactionId,
	    String CardNumber,
	    String CardValidFrom,
	    String CardValidThru,
	    String CardHolderName,
	    String CardCVV,
	    String CardType
	) {
	
	public static String header() {
        return String.format(
            
            "ID", "CardNumber", "ValidFrom", "ValidThru",
            "HolderName", "CVV", "Type"
        );
    }
	
	
}
