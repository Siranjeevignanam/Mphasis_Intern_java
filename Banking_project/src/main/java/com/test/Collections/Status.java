package com.test.Collections;

import com.test.annotation.FieldLength;

public record Status(
		@FieldLength(length=10)int TransactionId,
	    String Status,
	    String Description
	) {
	
	public static String header() {
        return String.format(
            "ID", "Status", "Description"
        );
    }
	
	
	
}
