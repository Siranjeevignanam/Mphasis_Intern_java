package com.test.Collections;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;



public record CombinedTransactionRecord(
    int transactionid,
    Transaction transaction,
    Customer customer,
    Account account,
    Address address,
    Bank bank,
    CreditCard creditCard,
    DebitCard debitCard,
    Loan loan,
    Status status,
    UPI upi
) {
    public static String header() {
        return Stream.of(
            prefixFields("Transaction", Transaction.header()),
            prefixFields("Customer", Customer.header()),
            prefixFields("Account", Account.header()),
            prefixFields("Address", Address.header()),
            prefixFields("Bank", Bank.header()),
            prefixFields("CreditCard", CreditCard.header()),
            prefixFields("DebitCard", DebitCard.header()),
            prefixFields("Loan", Loan.header()),
            prefixFields("Status", Status.header()),
            prefixFields("UPI", UPI.header())
        ).collect(Collectors.joining("|"));
    }

    @Override
    public String toString() {
        return Stream.of(
            transaction.toString(),
            customer.toString(),
            account.toString(),
            address.toString(),
            bank.toString(),
            creditCard.toString(),
            debitCard.toString(),
            loan.toString(),
            status.toString(),
            upi.toString()
        ).collect(Collectors.joining("|"));
    }

    private static String prefixFields(String prefix, String headerLine) {
        return Arrays.stream(headerLine.split("\\|"))
                     .map(h -> prefix + "_" + h)
                     .collect(Collectors.joining("|"));
    }
}
