package com.test.Collections;

import com.test.annotation.FieldLength;

public record Address(
		@FieldLength(length=10)int TransactionId,
	    String DoorNumber,
	    String Street,
	    String City,
	    String District,
	    String State,
	    String Pincode,
	    String Country
	) {
	
	public static String header() {
        return String.format(
         
            "ID", "DoorNo", "Street", "City",
            "District", "State", "Pincode", "Country"
        );
    }
	
	
}

