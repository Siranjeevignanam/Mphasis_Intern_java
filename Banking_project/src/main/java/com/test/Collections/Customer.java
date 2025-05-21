package com.test.Collections;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.text.DateFormatter;

import com.test.annotation.FieldLength;



public record Customer(
		@FieldLength(length=10)int TransactionId,
    String customerName,
    String customerUsername,
    LocalDate customerDOB,
    String customerEmail,
    String customerContactNumber,
    String customerAlternateNumber,
    String customerMailingAddress,
    String customerPermanentAddress,
    String customerNationality,
    String customerNominee,
    String customerMMID,
    String customerAadhar,
    String customerPANNumber,
    String customerAccount
) 	
{
	public Customer(
			int TransactionId,
		    String customerName,
		    String customerUsername,
		    String cust_dob,
		    String customerEmail,
		    String customerContactNumber,
		    String customerAlternateNumber,
		    String customerMailingAddress,
		    String customerPermanentAddress,
		    String customerNationality,
		    String customerNominee,
		    String customerMMID,
		    String customerAadhar,
		    String customerPANNumber,
		    String customerAccount)
		{
		    this(TransactionId,customerName, customerUsername,
		         LocalDate.parse(cust_dob, DateTimeFormatter.ofPattern("yyyy-MM-dd")),
		         customerEmail, customerContactNumber, customerAlternateNumber,
		         customerMailingAddress, customerPermanentAddress, customerNationality,
		         customerNominee, customerMMID, customerAadhar, customerPANNumber, customerAccount);
		}
	
	public static String header() {
        return String.format(
           "ID",
            "Name", "Username", "DOB", "Email", "ContactNumber",
            "AltNumber", "MailingAddress", "PermanentAddress",
            "Nationality", "Nominee", "MMID", "Aadhar", "PAN", "Account"
        );
    }
}
