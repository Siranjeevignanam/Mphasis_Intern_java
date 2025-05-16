package project;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record Transaction(
    LocalDateTime timestamp,
    double TransactionWithdrawalAmount,
    double TransactionDepositAmount,
    String Payer,
    String Payee,
    String TransactionType,
    String TransactionReferenceNumber,
    double TransactionClosingAmount,
    String TransactionStatus
) 
{
	public Transaction(
	String time,
    double TransactionWithdrawalAmount,
    double TransactionDepositAmount,
    String Payer,
    String Payee,
    String TransactionType,
    String TransactionReferenceNumber,
    double TransactionClosingAmount,
    String TransactionStatus)
	{
		this(LocalDateTime.parse(time,DateTimeFormatter.ofPattern("yyyy-mm-dd")),
				TransactionWithdrawalAmount,
			    TransactionDepositAmount,
			    Payer,
			    Payee,
			    TransactionType,
			    TransactionReferenceNumber,
			    TransactionClosingAmount,
			    TransactionStatus);
	}
	
}