package com.test.Collections;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import com.test.annotation.*;

public record Transaction
		(
				int TransactionId,
		@FieldLength(length = 20) String timestamp,
		@FieldLength(length = 30) Double TransactionWithdrawalAmount,
		@FieldLength(length = 20) Double TransactionDepositAmount,
		@FieldLength(length = 30) String Payer,
		@FieldLength(length = 20) String Payee,
		@FieldLength(length = 30) String TransactionType,
		@FieldLength(length = 20) String TransactionReferenceNumber,
		@FieldLength(length = 30) Double TransactionClosingAmount,
		@FieldLength(length = 20) String TransactionStatus
		) 
{
	
	

	
	public static String header() {
        return String.format(
        	"%s %30s %20s %30s %20s %30s %20s %30s %20s "	,
            "Timestamp",
            "TransactionWithdrawalAmount",
            "TransactionDepositAmount",
            "Payer",
            "Payee",
            "TransactionType",
            "TransactionReferenceNumber",
            "TransactionClosingAmount",
            "TransactionStatus"
        );
    }
	
}
