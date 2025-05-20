package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(
    @FixedLength(20) String CustomerName,
    @FixedLength(20) String CustomerUsername,
    @FixedLength(12) String CustomerDOB,
    @FixedLength(30) String CustomerEmail,
    @FixedLength(15) String CustomerContactNumber,
    @FixedLength(15) String CustomerAlternateNumber,
    @FixedLength(30) String CustomerMailingAddress,
    @FixedLength(30) String CustomerPermanentAddress,
    @FixedLength(15) String CustomerNationality,
    @FixedLength(20) String CustomerNominee,
    @FixedLength(20) String CustomerMMID,
    @FixedLength(20) String CustomerAadhar,
    @FixedLength(15) String CustomerPANNumber,
    @FixedLength(20) String CustomerAccount
) {
    public static String header() {
        return String.format(
            "%-20s %-20s %-12s %-30s %-15s %-15s %-30s %-30s %-15s %-20s %-20s %-20s %-15s %-20s",
            "Name", "Username", "DOB", "Email", "ContactNumber",
            "AltNumber", "MailingAddress", "PermanentAddress",
            "Nationality", "Nominee", "MMID", "Aadhar", "PAN", "Account"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
