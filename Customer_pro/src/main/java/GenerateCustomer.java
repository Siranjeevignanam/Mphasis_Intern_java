import com.github.javafaker.Faker;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenerateCustomer{

    public static void main(String[] args) {
        // Initialize Faker instance
        Faker faker = new Faker();

        // Create a list to hold the customer records
        List<CustomerRecord> customerRecords = new ArrayList<>();

        // Random generator for numeric values
        Random random = new Random();

        // Generate 1000 random customer records
        for (int i = 0; i < 1000; i++) {
            String customer_name = faker.name().fullName();
            int transaction_id = generateTransactionId();
            int account_number = generateAccountNumber();
            String email = faker.internet().emailAddress();
            double amount = Math.round((random.nextDouble() * 100000) * 100.0) / 100.0; // Amount up to 8 digits
            String phone = faker.phoneNumber().cellPhone();
            String timestamp = faker.date().past(365, java.util.concurrent.TimeUnit.DAYS).toString();

            CustomerRecord customerRecord = new CustomerRecord(
                    customer_name, transaction_id, account_number, email, amount, phone, timestamp);
            customerRecords.add(customerRecord);
        }

        // Create ObjectMapper instance (for writing JSON)
        ObjectMapper objectMapper = new ObjectMapper();

        // Write the customer records to a JSON file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customer_records.json"))) {
            // Write the customer records to the file in JSON format
            objectMapper.writeValue(writer, customerRecords);
            System.out.println("Customer records written to customer_records.json.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to generate a random transaction ID (integer)
    public static int generateTransactionId() {
        Random random = new Random();
        return 100000000 + random.nextInt(900000000); // Transaction ID between 100000000 and 999999999
    }

    // Method to generate a random account number (integer)
    public static int generateAccountNumber() {
        Random random = new Random();
        return 100000000 + random.nextInt(900000000); // Account number between 100000000 and 999999999
    }

    // POJO class to represent a customer record
    static class CustomerRecord {
        private String customer_name;
        private int transaction_id;
        private int account_number;
        private String email;
        private double amount;
        private String phone;
        private String timestamp;

        public CustomerRecord(String customer_name, int transaction_id, int account_number, String email,
                              double amount, String phone, String timestamp) {
            this.customer_name = customer_name;
            this.transaction_id = transaction_id;
            this.account_number = account_number;
            this.email = email;
            this.amount = amount;
            this.phone = phone;
            this.timestamp = timestamp;
        }

        // Getters and Setters
        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public int getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(int transaction_id) {
            this.transaction_id = transaction_id;
        }

        public int getAccount_number() {
            return account_number;
        }

        public void setAccount_number(int account_number) {
            this.account_number = account_number;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }
    }
}
