package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Transaction(
    @FixedLength(20) String CustomerMMID,
    @FixedLength(20) String timestamp,
    @FixedLength(15) double TransactionWithdrawalAmount,
    @FixedLength(15) double TransactionDepositAmount,
    @FixedLength(20) String Payer,
    @FixedLength(20) String Payee,
    @FixedLength(15) String TransactionType,
    @FixedLength(25) String TransactionReferenceNumber,
    @FixedLength(15) double TransactionClosingAmount,
    @FixedLength(15) String TransactionStatus
) {
    public static String header() {
        return String.format(
            "%-20s %-20s %-15s %-15s %-20s %-20s %-15s %-25s %-15s %-15s",
            "CustomerMMID", "Timestamp", "Withdraw", "Deposit",
            "Payer", "Payee", "Type", "ReferenceNo", "ClosingAmt", "Status"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
