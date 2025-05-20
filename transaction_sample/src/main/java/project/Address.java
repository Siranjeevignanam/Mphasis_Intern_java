package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Address(
    @FixedLength(20) String CustomerMMID,
    @FixedLength(10) String DoorNumber,
    @FixedLength(20) String Street,
    @FixedLength(15) String City,
    @FixedLength(15) String District,
    @FixedLength(15) String State,
    @FixedLength(10) String Pincode,
    @FixedLength(15) String Country
) {
    public static String header() {
        return String.format(
            "%-20s %-10s %-20s %-15s %-15s %-15s %-10s %-15s",
            "CustomerMMID", "DoorNo", "Street", "City",
            "District", "State", "Pincode", "Country"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
