package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record CreditCard(
    @FixedLength(20) String CustomerMMID,
    @FixedLength(20) String CardNumber,
    @FixedLength(20) String CardHolderName,
    @FixedLength(5)  String CardCVV,
    @FixedLength(10) String CardType,
    @FixedLength(15) double CardCreditLimit,
    @FixedLength(15) double CardAvailableBalance,
    @FixedLength(12) String CardValidFrom,
    @FixedLength(12) String CardValidThru,
    @FixedLength(15) String CardPaymentDueDate,
    @FixedLength(5)  boolean CardIsActive,
    @FixedLength(10) int CardRewardPoint
) {
    public static String header() {
        return String.format(
            "%-20s %-20s %-20s %-5s %-10s %-15s %-15s %-12s %-12s %-15s %-5s %-10s",
            "CustomerMMID", "CardNumber", "HolderName", "CVV", "Type",
            "CreditLimit", "AvailableBal", "ValidFrom", "ValidThru",
            "PaymentDue", "Active", "RewardPoint"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
