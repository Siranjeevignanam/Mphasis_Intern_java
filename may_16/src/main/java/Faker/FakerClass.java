package Faker;
import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import project.TransactionDetails;
public class FakerClass {
	
	static class Account {
        String AccountHolderNumber;
        String AccountScheme;
        String AccountSchemeCode;
        String AccountBranch;
        String AccountIFSC;
        double AccountBalance;
        double AccountUnclearedFunds;
        double AccountAmountOnHold;
        double AccountSpendingLimit;
        String AccountBank;
        String AccountCreditCard;
        String AccountDebitCard;
        String AccountLoan;
        String AccountCurrency;
        String AccountOpeningDate;
        String AccountUPI;

        // Constructor to initialize all fields
        public Account(String AccountHolderNumber, String AccountScheme, String AccountSchemeCode,
                       String AccountBranch, String AccountIFSC, double AccountBalance,
                       double AccountUnclearedFunds, double AccountAmountOnHold, double AccountSpendingLimit,
                       String AccountBank, String AccountCreditCard, String AccountDebitCard,
                       String AccountLoan, String AccountCurrency, String AccountOpeningDate, String AccountUPI) 
        {
            this.AccountHolderNumber = AccountHolderNumber;
            this.AccountScheme = AccountScheme;
            this.AccountSchemeCode = AccountSchemeCode;
            this.AccountBranch = AccountBranch;
            this.AccountIFSC = AccountIFSC;
            this.AccountBalance = AccountBalance;
            this.AccountUnclearedFunds = AccountUnclearedFunds;
            this.AccountAmountOnHold = AccountAmountOnHold;
            this.AccountSpendingLimit = AccountSpendingLimit;
            this.AccountBank = AccountBank;
            this.AccountCreditCard = AccountCreditCard;
            this.AccountDebitCard = AccountDebitCard;
            this.AccountLoan = AccountLoan;
            this.AccountCurrency = AccountCurrency;
            this.AccountOpeningDate = AccountOpeningDate;
            this.AccountUPI = AccountUPI;
        }
	}
	
	
	static class Address {
        String DoorNumber;
        String Street;
        String City;
        String District;
        String State;
        String Pincode;
        String Country;

        // Constructor to initialize all fields
        public Address(String DoorNumber, String Street, String City, String District, String State,
                       String Pincode, String Country) {
            this.DoorNumber = DoorNumber;
            this.Street = Street;
            this.City = City;
            this.District = District;
            this.State = State;
            this.Pincode = Pincode;
            this.Country = Country;
        }
	}
	
	
	static class Bank {
        String BankName;
        String BankIFSC;
        String BankMICR;
        String BankBranch;
        String BankBranchCode;
        String BankAddress;
        String BankContactNumber;
        String BankContactEmail;

        // Constructor to initialize all fields
        public Bank(String BankName, String BankIFSC, String BankMICR, String BankBranch, 
                    String BankBranchCode, String BankAddress, String BankContactNumber, 
                    String BankContactEmail) {
            this.BankName = BankName;
            this.BankIFSC = BankIFSC;
            this.BankMICR = BankMICR;
            this.BankBranch = BankBranch;
            this.BankBranchCode = BankBranchCode;
            this.BankAddress = BankAddress;
            this.BankContactNumber = BankContactNumber;
            this.BankContactEmail = BankContactEmail;
        }

        // Optionally, you can add getters and setters or other methods if required
    }
	static class CreditCard {
        String CardNumber;
        String CardHolderName;
        String CardCVV;
        String CardType;
        double CardCreditLimit;
        double CardAvailableBalance;
        String CardValidFrom;
        String CardValidThru;
        String CardPaymentDueDate;
        boolean CardIsActive;
        int CardRewardPoint;

        // Constructor to initialize all fields
        public CreditCard(String CardNumber, String CardHolderName, String CardCVV, String CardType,
                          double CardCreditLimit, double CardAvailableBalance, String CardValidFrom,
                          String CardValidThru, String CardPaymentDueDate, boolean CardIsActive,
                          int CardRewardPoint) {
            this.CardNumber = CardNumber;
            this.CardHolderName = CardHolderName;
            this.CardCVV = CardCVV;
            this.CardType = CardType;
            this.CardCreditLimit = CardCreditLimit;
            this.CardAvailableBalance = CardAvailableBalance;
            this.CardValidFrom = CardValidFrom;
            this.CardValidThru = CardValidThru;
            this.CardPaymentDueDate = CardPaymentDueDate;
            this.CardIsActive = CardIsActive;
            this.CardRewardPoint = CardRewardPoint;
        }

        // Optionally, you can add getters and setters or other methods if required
    }
	
	
	static class Customer {
        String CustomerName;
        String CustomerUsername;
        String CustomerDOB;
        String CustomerEmail;
        String CustomerContactNumber;
        String CustomerAlternateNumber;
        String CustomerMailingAddress;
        String CustomerPermanentAddress;
        String CustomerNationality;
        String CustomerNominee;
        String CustomerMMID;
        String CustomerAadhar;
        String CustomerPANNumber;
        String CustomerAccount;

        // Constructor to initialize all fields
        public Customer(String CustomerName, String CustomerUsername, String CustomerDOB, String CustomerEmail,
                        String CustomerContactNumber, String CustomerAlternateNumber, String CustomerMailingAddress,
                        String CustomerPermanentAddress, String CustomerNationality, String CustomerNominee,
                        String CustomerMMID, String CustomerAadhar, String CustomerPANNumber, String CustomerAccount) {
            this.CustomerName = CustomerName;
            this.CustomerUsername = CustomerUsername;
            this.CustomerDOB = CustomerDOB;
            this.CustomerEmail = CustomerEmail;
            this.CustomerContactNumber = CustomerContactNumber;
            this.CustomerAlternateNumber = CustomerAlternateNumber;
            this.CustomerMailingAddress = CustomerMailingAddress;
            this.CustomerPermanentAddress = CustomerPermanentAddress;
            this.CustomerNationality = CustomerNationality;
            this.CustomerNominee = CustomerNominee;
            this.CustomerMMID = CustomerMMID;
            this.CustomerAadhar = CustomerAadhar;
            this.CustomerPANNumber = CustomerPANNumber;
            this.CustomerAccount = CustomerAccount;
        }

        // Optionally, you can add getters and setters or other methods if required
    }
	
	
	
	static class DebitCard {
        String CardNumber;
        String CardValidFrom;
        String CardValidThru;
        String CardHolderName;
        String CardCVV;
        String CardType;

        // Constructor to initialize all fields
        public DebitCard(String CardNumber, String CardValidFrom, String CardValidThru, 
                         String CardHolderName, String CardCVV, String CardType) {
            this.CardNumber = CardNumber;
            this.CardValidFrom = CardValidFrom;
            this.CardValidThru = CardValidThru;
            this.CardHolderName = CardHolderName;
            this.CardCVV = CardCVV;
            this.CardType = CardType;
        }

        // Optionally, you can add getters and setters or other methods if required
    }
	
	static class Loan {
        String LoanScheme;
        double LoanAmount;
        double LoanInterest;
        String LoanTenureDuration;
        String LoanDisbursementDate;
        String LoanMaturityDate;
        double LoanOutstandingAmount;
        double LoanEMIAmount;
        String LoanCollateralDetails;
        double LoanPenalty;
        String LoanStatus;

        // Constructor to initialize all fields
        public Loan(String LoanScheme, double LoanAmount, double LoanInterest, 
                    String LoanTenureDuration, String LoanDisbursementDate, String LoanMaturityDate, 
                    double LoanOutstandingAmount, double LoanEMIAmount, 
                    String LoanCollateralDetails, double LoanPenalty, String LoanStatus) {
            this.LoanScheme = LoanScheme;
            this.LoanAmount = LoanAmount;
            this.LoanInterest = LoanInterest;
            this.LoanTenureDuration = LoanTenureDuration;
            this.LoanDisbursementDate = LoanDisbursementDate;
            this.LoanMaturityDate = LoanMaturityDate;
            this.LoanOutstandingAmount = LoanOutstandingAmount;
            this.LoanEMIAmount = LoanEMIAmount;
            this.LoanCollateralDetails = LoanCollateralDetails;
            this.LoanPenalty = LoanPenalty;
            this.LoanStatus = LoanStatus;
        }

        // Optionally, you can add getters and setters or other methods if needed
    }
	
	
	
	static class Status {
        String Status;
        String Description;

        // Constructor to initialize all fields
        public Status(String Status, String Description) {
            this.Status = Status;
            this.Description = Description;
        }

        // Optionally, you can add getters and setters or other methods if needed
    }
	
	
	
	
	
	static class Transaction {
       String timestamp;
        double TransactionWithdrawalAmount;
        double TransactionDepositAmount;
        String Payer;
        String Payee;
        String TransactionType;
        String TransactionReferenceNumber;
        double TransactionClosingAmount;
        String TransactionStatus;

        // Constructor to initialize all fields
        public Transaction(String timestamp, 
                           double TransactionWithdrawalAmount, 
                           double TransactionDepositAmount, 
                           String Payer, 
                           String Payee, 
                           String TransactionType, 
                           String TransactionReferenceNumber, 
                           double TransactionClosingAmount, 
                           String TransactionStatus) {
            this.timestamp = timestamp;
            this.TransactionWithdrawalAmount = TransactionWithdrawalAmount;
            this.TransactionDepositAmount = TransactionDepositAmount;
            this.Payer = Payer;
            this.Payee = Payee;
            this.TransactionType = TransactionType;
            this.TransactionReferenceNumber = TransactionReferenceNumber;
            this.TransactionClosingAmount = TransactionClosingAmount;
            this.TransactionStatus = TransactionStatus;
        }

        // Optionally, you can add getters and setters or other methods if needed
    }
	
	static class UPI {
        String UPIID;
        String UPIEmail;
        double UPITransactionLimit;
        boolean UPIIsActive;
        String UPILinkedMobileNumber;

        // Constructor to initialize all fields
        public UPI(String UPIID, 
                   String UPIEmail, 
                   double UPITransactionLimit, 
                   boolean UPIIsActive, 
                   String UPILinkedMobileNumber) {
            this.UPIID = UPIID;
            this.UPIEmail = UPIEmail;
            this.UPITransactionLimit = UPITransactionLimit;
            this.UPIIsActive = UPIIsActive;
            this.UPILinkedMobileNumber = UPILinkedMobileNumber;
        }

        // Optionally, you can add getters, setters, or other methods if needed
    }
	
	
	static class TransactionDetails {

        // Fields that represent other class objects
        Account account;
        Address address;
        Bank bank;
        CreditCard creditCard;
        Customer customer;
        DebitCard debitCard;
        Loan loan;
        Status status;
        Transaction transaction;
        UPI upi;

        // Constructor to initialize all fields
        public TransactionDetails(
                Account account,
                Address address,
                Bank bank,
                CreditCard creditCard,
                Customer customer,
                DebitCard debitCard,
                Loan loan,
                Status status,
                Transaction transaction,
                UPI upi) {
            this.account = account;
            this.address = address;
            this.bank = bank;
            this.creditCard = creditCard;
            this.customer = customer;
            this.debitCard = debitCard;
            this.loan = loan;
            this.status = status;
            this.transaction = transaction;
            this.upi = upi;
        }

        // Optionally, you can add getters, setters, or other methods if needed
    }
	
	public static void main(String[] args)
	{
		Faker faker = new Faker();
		List<TransactionDetails> details=new ArrayList<>();
		Random random=new Random();
		
		
		   for (int i = 0; i < 50; i++) 
		   {
			   
			   
		   
			   Account account = new Account(
					    UUID.randomUUID().toString(),                         // AccountHolderNumber
					    faker.lorem().word(),                                  // AccountScheme (using a random word)
					    faker.lorem().characters(),                        // AccountSchemeCode (a fixed-length string of 4 characters)
					    faker.address().city(),                                // AccountBranch
					    "IFSC" + faker.number().digits(7),                      // AccountIFSC
					    faker.number().randomDouble(2, 1000, 100000),           // AccountBalance
					    faker.number().randomDouble(2, 0, 5000),                // AccountUnclearedFunds
					    faker.number().randomDouble(2, 0, 5000),                // AccountAmountOnHold
					    faker.number().randomDouble(2, 5000, 50000),            // AccountSpendingLimit
					    faker.company().name(),                                // AccountBank
					    faker.finance().creditCard(),                          // AccountCreditCard
					    faker.finance().creditCard(),                          // AccountDebitCard
					    faker.lorem().word(),                                  // AccountLoan
					    faker.currency().code(),                               // AccountCurrency
					    faker.date().birthday().toString(),                     // AccountOpeningDate
					    faker.internet().emailAddress()                         // AccountUPI
					);

		Address address = new Address(
			    faker.address().buildingNumber(),         // DoorNumber
			    faker.address().streetAddress(),          // Street
			    faker.address().city(),                   // City
			    faker.address().cityName(),               // District
			    faker.address().state(),                  // State
			    faker.address().zipCode(),                // Pincode
			    faker.address().country()                 // Country
			);
		
		Bank bank = new Bank(
			    faker.company().name(),                  // BankName
			    "IFSC" + faker.number().digits(7),        // BankIFSC
			    faker.number().digits(9),                 // BankMICR
			    faker.address().city(),                  // BankBranch
			    faker.lorem().characters(5).toUpperCase(), // BankBranchCode
			    faker.address().fullAddress(),           // BankAddress
			    faker.phoneNumber().cellPhone(),         // BankContactNumber
			    faker.internet().emailAddress()          // BankContactEmail
			);

		CreditCard creditCard = new CreditCard(
			    faker.finance().creditCard(),                              // CardNumber
			    faker.name().fullName(),                                    // CardHolderName
			    String.valueOf(faker.number().numberBetween(100, 999)),      // CardCVV
			    faker.business().creditCardType(),                          // CardType
			    faker.number().randomDouble(2, 1000, 50000),                 // CardCreditLimit
			    faker.number().randomDouble(2, 0, 50000),                   // CardAvailableBalance
			    faker.date().past(1000, java.util.concurrent.TimeUnit.DAYS).toString(), // CardValidFrom
			    faker.date().future(1000, java.util.concurrent.TimeUnit.DAYS).toString(), // CardValidThru
			    faker.date().future(30, java.util.concurrent.TimeUnit.DAYS).toString(),   // CardPaymentDueDate
			    faker.bool().bool(),                                        // CardIsActive
			    faker.number().numberBetween(0, 10000)                      // CardRewardPoint
			);

			System.out.println(creditCard);
			Customer customer = new Customer(
				    faker.name().fullName(),                                     // CustomerName
				    faker.name().username(),                                      // CustomerUsername
				    faker.date().birthday().toString(),                           // CustomerDOB
				    faker.internet().emailAddress(),                              // CustomerEmail
				    faker.phoneNumber().cellPhone(),                              // CustomerContactNumber
				    faker.phoneNumber().cellPhone(),                              // CustomerAlternateNumber
				    faker.address().fullAddress(),                                // CustomerMailingAddress
				    faker.address().fullAddress(),                                // CustomerPermanentAddress
				    faker.country().name(),                                        // CustomerNationality
				    faker.name().fullName(),                                      // CustomerNominee
				    faker.number().digits(7),                                      // CustomerMMID
				    faker.number().digits(12),                                     // CustomerAadhar
				    faker.bothify("?????####?"),                                   // CustomerPANNumber
				    faker.finance().iban()                                        // CustomerAccount
				);

			DebitCard debitCard = new DebitCard(
				    faker.finance().creditCard(),                                 // CardNumber
				    faker.date().birthday().toString(),                            // CardValidFrom
				    faker.date().future(5, java.util.concurrent.TimeUnit.DAYS).toString(), // CardValidThru
				    faker.name().fullName(),                                       // CardHolderName
				    String.valueOf(faker.number().numberBetween(100, 999)),         // CardCVV
				    faker.business().creditCardType()                              // CardType
				);

			Loan loan = new Loan(
				    faker.lorem().word(),                                          // LoanScheme
				    faker.number().randomDouble(2, 10000, 1000000),                 // LoanAmount
				    faker.number().randomDouble(2, 5, 15),                          // LoanInterest
				    faker.number().numberBetween(1, 30) + " Years",                 // LoanTenureDuration
				    faker.date().past(1000, java.util.concurrent.TimeUnit.DAYS).toString(), // LoanDisbursementDate
				    faker.date().future(1000, java.util.concurrent.TimeUnit.DAYS).toString(), // LoanMaturityDate
				    faker.number().randomDouble(2, 1000, 900000),                   // LoanOutstandingAmount
				    faker.number().randomDouble(2, 1000, 50000),                    // LoanEMIAmount
				    faker.lorem().sentence(),                                       // LoanCollateralDetails
				    faker.number().randomDouble(2, 0, 10000),                       // LoanPenalty
				    faker.options().option("Active", "Closed", "Defaulted")         // LoanStatus
				);

			Status status = new Status(
				    faker.options().option("Success", "Failed", "Pending"),  // Status (Randomly chooses between "Success", "Failed", "Pending")
				    faker.lorem().sentence()                                 // Description (Random sentence generated by Faker)
				);

			 Transaction transaction = new Transaction(
					  faker.date().past(300, java.util.concurrent.TimeUnit.DAYS).toInstant().toString(),   // timestamp: Random date within the last 30 days
			            faker.number().randomDouble(2, 0, 10000),            // TransactionWithdrawalAmount: Random amount between 0 and 10,000
			            faker.number().randomDouble(2, 0, 10000),            // TransactionDepositAmount: Random amount between 0 and 10,000
			            faker.name().fullName(),                             // Payer: Random full name
			            faker.name().fullName(),                             // Payee: Random full name
			            faker.options().option("NEFT", "IMPS", "RTGS", "UPI", "Cash"),  // TransactionType: Randomly chosen transaction type
			            faker.number().digits(12),                           // TransactionReferenceNumber: Random 12-digit number
			            faker.number().randomDouble(2, 1000, 50000),         // TransactionClosingAmount: Random closing amount between 1,000 and 50,000
			            faker.options().option("Success", "Failed", "Pending") // TransactionStatus: Random status from "Success", "Failed", or "Pending"
			        );


			 UPI upi = new UPI(
			            faker.name().username() + "@upi",  // UPIID: Random username + @upi
			            faker.internet().emailAddress(),   // UPIEmail: Random email address
			            faker.number().randomDouble(2, 1000, 100000), // UPITransactionLimit: Random value between 1000 and 100000 with 2 decimal places
			            faker.bool().bool(),               // UPIIsActive: Random boolean (true/false)
			            faker.phoneNumber().cellPhone()    // UPILinkedMobileNumber: Random phone number
			        );
			 
			details.add(new TransactionDetails(account, address, bank, creditCard, customer, debitCard, loan, status, transaction, upi));


		   }
		   
		   Gson gson = new GsonBuilder().setPrettyPrinting().create();
	        String jsonOutput = gson.toJson(details);
	        System.out.println(jsonOutput);
	}
	
}

