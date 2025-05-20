package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DebitCard(
    @FixedLength(20) String CustomerMMID,
    @FixedLength(20) String CardNumber,
    @FixedLength(12) String CardValidFrom,
    @FixedLength(12) String CardValidThru,
    @FixedLength(20) String CardHolderName,
    @FixedLength(5)  String CardCVV,
    @FixedLength(10) String CardType
) {
    public static String header() {
        return String.format(
            "%-20s %-20s %-12s %-12s %-20s %-5s %-10s",
            "CustomerMMID", "CardNumber", "ValidFrom", "ValidThru",
            "HolderName", "CVV", "Type"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
