package faker;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.javafaker.Faker;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Transaction details with nested fields
class TransactionDetails {
    private double amount;
    private String timestamp;
    private String receiverName;

    public TransactionDetails(double amount, String timestamp, String receiverName) {
        this.amount = amount;
        this.timestamp = timestamp;
        this.receiverName = receiverName;
    }

    public double getAmount() {
        return amount;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String getReceiverName() {
        return receiverName;
    }
}

// Customer details with nested fields
class CustomerDetails {
    private String customerName;
    private String email;
    private String phone;

    public CustomerDetails(String customerName, String email, String phone) {
        this.customerName = customerName;
        this.email = email;
        this.phone = phone;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }
}

// Address details with nested fields
class AddressDetails {
    private String doorNo;
    private String street;
    private String city;
    private String state;
    private String pincode;

    public AddressDetails(String doorNo, String street, String city, String state, String pincode) {
        this.doorNo = doorNo;
        this.street = street;
        this.city = city;
        this.state = state;
        this.pincode = pincode;
    }

    public String getDoorNo() {
        return doorNo;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPincode() {
        return pincode;
    }
}

// Bank details with nested fields
class BankDetails {
    private String bankName;
    private String branch;
    private String ifscCode;
    private String bankType;

    public BankDetails(String bankName, String branch, String ifscCode, String bankType) {
        this.bankName = bankName;
        this.branch = branch;
        this.ifscCode = ifscCode;
        this.bankType = bankType;
    }

    public String getBankName() {
        return bankName;
    }

    public String getBranch() {
        return branch;
    }

    public String getIfscCode() {
        return ifscCode;
    }

    public String getBankType() {
        return bankType;
    }
}

// Status details with nested fields
class StatusDetails {
    private String status;
    private String description;

    public StatusDetails(String status, String description) {
        this.status = status;
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public String getDescription() {
        return description;
    }
}

// Transaction type details with nested fields
class TransactionTypeDetails {
    private String type;
    private String senderId;
    private String receiverId;

    public TransactionTypeDetails(String type, String senderId, String receiverId) {
        this.type = type;
        this.senderId = senderId;
        this.receiverId = receiverId;
    }

    public String getType() {
        return type;
    }

    public String getSenderId() {
        return senderId;
    }

    public String getReceiverId() {
        return receiverId;
    }
}

// Account details with nested fields
class AccountDetails {
    private String accType;
    private double balance;
    private String accountNumber;

    public AccountDetails(String accType, double balance, String accountNumber) {
        this.accType = accType;
        this.balance = balance;
        this.accountNumber = accountNumber;
    }

    public String getAccType() {
        return accType;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

// Main class to generate 25 records and write them to JSON
public class FakerClass {

    public static void main(String[] args) {
        Faker faker = new Faker();
        Random random = new Random();
        List<Object> records = new ArrayList<>();

        // Generate 25 records
        for (int i = 0; i < 25; i++) {
            int transactionId = random.nextInt(1000000); // Random transaction ID

            // Generate Transaction details
            TransactionDetails transactionDetails = new TransactionDetails(
                    random.nextDouble() * 1000000, // Random amount
                    faker.date().past(365, java.util.concurrent.TimeUnit.DAYS).toString(), // Random past timestamp
                    faker.name().fullName() // Random receiver name
            );

            // Generate Customer details
            CustomerDetails customerDetails = new CustomerDetails(
                    faker.name().fullName(), // Random customer name
                    faker.internet().emailAddress(), // Random email
                    faker.phoneNumber().phoneNumber() // Random phone number
            );

            // Generate Address details
            AddressDetails addressDetails = new AddressDetails(
                    faker.address().buildingNumber(), // Random door number
                    faker.address().streetName(), // Random street name
                    faker.address().city(), // Random city
                    faker.address().state(), // Random state
                    faker.address().zipCode() // Random pincode
            );

            // Generate Bank details
            BankDetails bankDetails = new BankDetails(
                    faker.company().name(), // Random bank name
                    faker.address().city(), // Random bank branch
                    faker.finance().bic(), // Random IFSC code
                    "Commercial" // Static bank type for simplicity
            );

            // Generate Status details
            StatusDetails statusDetails = new StatusDetails(
                    "Success", // Static status
                    "Transaction completed successfully" // Static description
            );

            // Generate Transaction Type details
            TransactionTypeDetails transactionTypeDetails = new TransactionTypeDetails(
                    "Credit", // Static type
                    faker.idNumber().valid(), // Random sender ID
                    faker.idNumber().valid() // Random receiver ID
            );

            // Generate Account details
            AccountDetails accountDetails = new AccountDetails(
                    "Savings", // Static account type
                    random.nextDouble() * 1000000, // Random balance
                    faker.number().digits(12) // Random account number
            );

            // Create the full record with nested collections
            records.add(new Object() {
                public final int TransactionId = transactionId;
                public final TransactionDetails transaction = transactionDetails;
                public final CustomerDetails customer = customerDetails;
                public final AddressDetails address = addressDetails;
                public final BankDetails bank = bankDetails;
                public final StatusDetails status = statusDetails;
                public final TransactionTypeDetails type = transactionTypeDetails;
                public final AccountDetails account = accountDetails;
            });
        }

        // Write the records to a JSON file
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("transactions.json"), records);
            System.out.println("Data has been written to transactions.json");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
