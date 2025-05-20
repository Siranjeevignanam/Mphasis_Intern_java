package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record UPI(
    @FixedLength(20) String CustomerMMID,
    @FixedLength(25) String UPIID,
    @FixedLength(30) String UPIEmail,
    @FixedLength(10) int UPITransactionLimit,
    @FixedLength(5) boolean UPIIsActive,
    @FixedLength(15) String UPILinkedMobileNumber
) {
    public static String header() {
        return String.format(
            "%-20s %-25s %-30s %-10s %-5s %-15s",
            "CustomerMMID", "UPIID", "UPIEmail", "TxnLimit", "Active", "LinkedMobile"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
