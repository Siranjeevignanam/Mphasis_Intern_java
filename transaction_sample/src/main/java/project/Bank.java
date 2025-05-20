package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Bank(
    @FixedLength(20) String CustomerMMID,
    @FixedLength(20) String BankName,
    @FixedLength(15) String BankIFSC,
    @FixedLength(15) String BankMICR,
    @FixedLength(20) String BankBranch,
    @FixedLength(10) String BankBranchCode,
    @FixedLength(30) String BankAddress,
    @FixedLength(15) String BankContactNumber,
    @FixedLength(30) String BankContactEmail
) {
    public static String header() {
        return String.format(
            "%-20s %-20s %-15s %-15s %-20s %-10s %-30s %-15s %-30s",
            "CustomerMMID", "BankName", "BankIFSC", "BankMICR", "BankBranch",
            "BranchCode", "BankAddress", "ContactNumber", "ContactEmail"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
