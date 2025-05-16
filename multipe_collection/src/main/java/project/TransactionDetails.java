package project;

import project.Account;
import project.Address;
import project.Bank;
import project.CreditCard;
import project.Customer;
import project.DebitCard;
import project.Loan;
import project.Status;
import project.Transaction;
import project.UPI;

public record TransactionDetails(
		
		Account account,
		Address address,
		Bank bank,
		CreditCard creditcard,
		Customer customer,
		DebitCard debitcard,
		Loan loan,
		Status status,
		Transaction transaction,
		UPI upi
		
		)

{

}