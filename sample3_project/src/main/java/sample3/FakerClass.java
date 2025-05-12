package sample3;

import com.github.javafaker.Faker;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FakerClass {

    public static void main(String[] args) {
        // Initialize Faker instance
        Faker faker = new Faker();

        // Create a list to hold the transactions
        List<Transaction> transactions = new ArrayList<>();

        // Random generator for numeric values
        Random random = new Random();

        // Generate 1000 random transactions
        for (int i = 0; i < 1000; i++) {
            String customer_id = "CUST" + (100000 + random.nextInt(900000));
            String customer_name = faker.name().fullName();
            String mobile = faker.phoneNumber().cellPhone();
            String email = faker.internet().emailAddress();
            String address = faker.address().fullAddress();
            String transaction_id = "TXN" + (100000000 + random.nextInt(900000000));
            String timestamp = faker.date().past(365, java.util.concurrent.TimeUnit.DAYS).toString();
            double amount = Math.round((random.nextDouble() * 10000) * 100.0) / 100.0;
            String receiver = faker.name().fullName();
            String status = random.nextBoolean() ? "Success" : "Failed";

            Transaction transaction = new Transaction(customer_id, customer_name, mobile, email, address,
                    transaction_id, timestamp, amount, receiver, status);
            transactions.add(transaction);
        }

        // Write to JSON file
        ObjectMapper objectMapper = new ObjectMapper();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("customer_transactions.json"))) {
            objectMapper.writeValue(writer, transactions);
            System.out.println("Customer transaction data written to customer_transactions.json.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // POJO class with updated variables
    static class Transaction {
        private String customer_id;
        private String customer_name;
        private String mobile;
        private String email;
        private String address;
        private String transaction_id;
        private String timestamp;
        private double amount;
        private String receiver;
        private String status;

        public Transaction(String customer_id, String customer_name, String mobile, String email,
                           String address, String transaction_id, String timestamp, double amount,
                           String receiver, String status) {
            this.customer_id = customer_id;
            this.customer_name = customer_name;
            this.mobile = mobile;
            this.email = email;
            this.address = address;
            this.transaction_id = transaction_id;
            this.timestamp = timestamp;
            this.amount = amount;
            this.receiver = receiver;
            this.status = status;
        }

        // Getters and setters
        public String getCustomer_id() {
            return customer_id;
        }

        public void setCustomer_id(String customer_id) {
            this.customer_id = customer_id;
        }

        public String getCustomer_name() {
            return customer_name;
        }

        public void setCustomer_name(String customer_name) {
            this.customer_name = customer_name;
        }

        public String getMobile() {
            return mobile;
        }

        public void setMobile(String mobile) {
            this.mobile = mobile;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getTransaction_id() {
            return transaction_id;
        }

        public void setTransaction_id(String transaction_id) {
            this.transaction_id = transaction_id;
        }

        public String getTimestamp() {
            return timestamp;
        }

        public void setTimestamp(String timestamp) {
            this.timestamp = timestamp;
        }

        public double getAmount() {
            return amount;
        }

        public void setAmount(double amount) {
            this.amount = amount;
        }

        public String getReceiver() {
            return receiver;
        }

        public void setReceiver(String receiver) {
            this.receiver = receiver;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }
    }
}

