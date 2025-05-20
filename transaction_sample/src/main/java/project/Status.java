package project;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Status(
    @FixedLength(20) String CustomerMMID,
    @FixedLength(15) String Status,
    @FixedLength(50) String Description
) {
    public static String header() {
        return String.format(
            "%-20s %-15s %-50s",
            "CustomerMMID", "Status", "Description"
        );
    }

    @Override
    public String toString() {
        return Formatter.formatRecord(this);
    }
}
