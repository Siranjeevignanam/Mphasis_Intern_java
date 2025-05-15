package faker;


import com.github.javafaker.Faker;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

public class FakerClass{

    static class Customer {
        String id;
        String name;
        String email;
        String mobile;
        String address;
        String dob;
        String gender;
        String nationalId;
        String occupation;
        String createdAt;

        public Customer(String id, String name, String email, String mobile, String address,
                        String dob, String gender, String nationalId, String occupation, String createdAt) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.mobile = mobile;
            this.address = address;
            this.dob = dob;
            this.gender = gender;
            this.nationalId = nationalId;
            this.occupation = occupation;
            this.createdAt = createdAt;
        }
    }

    static class Transaction {
        String id;
        String type;
        double amount;
        String currency;
        String status;
        String timestamp;
        String description;
        String method;
        String reference;
        double fee;

        public Transaction(String id, String type, double amount, String currency, String status,
                           String timestamp, String description, String method, String reference, double fee) {
            this.id = id;
            this.type = type;
            this.amount = amount;
            this.currency = currency;
            this.status = status;
            this.timestamp = timestamp;
            this.description = description;
            this.method = method;
            this.reference = reference;
            this.fee = fee;
        }
    }

    static class Bank {
        String id;
        String name;
        String branch;
        String branchCode;
        String swiftCode;
        String country;
        String contact;
        String email;
        String established;
        String license;

        public Bank(String id, String name, String branch, String branchCode, String swiftCode,
                    String country, String contact, String email, String established, String license) {
            this.id = id;
            this.name = name;
            this.branch = branch;
            this.branchCode = branchCode;
            this.swiftCode = swiftCode;
            this.country = country;
            this.contact = contact;
            this.email = email;
            this.established = established;
            this.license = license;
        }
    }

    static class FullDocument {
        Customer customer;
        Transaction transaction;
        Bank bank;

        public FullDocument(Customer customer, Transaction transaction, Bank bank) {
            this.customer = customer;
            this.transaction = transaction;
            this.bank = bank;
        }
    }

    public static void main(String[] args) {
        Faker faker = new Faker();
        List<FullDocument> documents = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < 25; i++) {
            Customer customer = new Customer(
                    UUID.randomUUID().toString(),
                    faker.name().fullName(),
                    faker.internet().emailAddress(),
                    faker.phoneNumber().cellPhone(),
                    faker.address().fullAddress(),
                    faker.date().birthday().toString(),
                    faker.demographic().sex(),
                    faker.idNumber().valid(),
                    faker.job().title(),
                    faker.date().past(1000, java.util.concurrent.TimeUnit.DAYS).toString()
            );

            Transaction transaction = new Transaction(
                    UUID.randomUUID().toString(),
                    faker.options().option("deposit", "withdrawal", "transfer", "payment"),
                    Math.round((50 + random.nextDouble() * 9500) * 100.0) / 100.0,
                    "USD",
                    random.nextBoolean() ? "SUCCESS" : "FAILED",
                    faker.date().past(300, java.util.concurrent.TimeUnit.DAYS).toInstant().toString(),
                    faker.lorem().sentence(),
                    faker.options().option("online", "ATM", "branch"),
                    UUID.randomUUID().toString().substring(0, 8),
                    Math.round(random.nextDouble() * 10 * 100.0) / 100.0
            );

            Bank bank = new Bank(
                    UUID.randomUUID().toString(),
                    faker.company().name(),
                    faker.address().streetName(),
                    faker.number().digits(6),
                    faker.finance().bic(),
                    faker.address().country(),
                    faker.phoneNumber().phoneNumber(),
                    faker.internet().emailAddress(),
                    faker.date().past(10000, java.util.concurrent.TimeUnit.DAYS).toString(),
                    "LIC-" + faker.number().digits(8)
            );

            documents.add(new FullDocument(customer, transaction, bank));
        }

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String jsonOutput = gson.toJson(documents);
        System.out.println(jsonOutput);
    }
}
