package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Loan(
    @FixedLength(20) String CustomerMMID,
    @FixedLength(20) String LoanScheme,
    @FixedLength(15) double LoanAmount,
    @FixedLength(10) double LoanInterest,
    @FixedLength(15) String LoanTenureDuration,
    @FixedLength(15) String LoanDisbursementDate,
    @FixedLength(15) String LoanMaturityDate,
    @FixedLength(15) double LoanOutstandingAmount,
    @FixedLength(15) double LoanEMIAmount,
    @FixedLength(30) String LoanCollateralDetails,
    @FixedLength(10) double LoanPenalty,
    @FixedLength(15) String LoanStatus
) {
    public static String header() {
        return String.format(
            "%-20s %-20s %-15s %-10s %-15s %-15s %-15s %-15s %-15s %-30s %-10s %-15s",
            "CustomerMMID", "LoanScheme", "LoanAmount", "Interest",
            "Tenure", "Disbursement", "Maturity", "Outstanding", "EMI",
            "CollateralDetails", "Penalty", "Status"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
