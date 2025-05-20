package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Account(
    @FixedLength(20) String CustomerMMID,
    @FixedLength(20) String AccountHolderNumber,
    @FixedLength(20) String AccountScheme,
    @FixedLength(10) String AccountSchemeCode,
    @FixedLength(20) String AccountBranch,
    @FixedLength(15) String AccountIFSC,
    @FixedLength(15) double AccountBalance,
    @FixedLength(15) double AccountUnclearedFunds,
    @FixedLength(15) double AccountAmountOnHold,
    @FixedLength(15) double AccountSpendingLimit,
    @FixedLength(20) String AccountBank,
    @FixedLength(20) String AccountCreditCard,
    @FixedLength(20) String AccountDebitCard,
    @FixedLength(20) String AccountLoan,
    @FixedLength(10) String AccountCurrency,
    @FixedLength(15) String AccountOpeningDate,
    @FixedLength(20) String AccountUPI
) {
    public static String header() {
        return String.format(
            "%-20s %-20s %-20s %-10s %-20s %-15s %-15s %-15s %-15s %-15s %-20s %-20s %-20s %-20s %-10s %-15s %-20s",
            "CustomerMMID", "AccountHolderNumber", "AccountScheme", "AccountSchemeCode",
            "AccountBranch", "AccountIFSC", "AccountBalance", "UnclearedFunds",
            "AmountOnHold", "SpendingLimit", "AccountBank", "CreditCard", "DebitCard",
            "Loan", "Currency", "OpeningDate", "UPI"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
