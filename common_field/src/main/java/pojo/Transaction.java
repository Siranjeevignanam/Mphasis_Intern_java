package pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import FixedLength.FixedLength;
import FixedLength.Formatter;
@JsonIgnoreProperties(ignoreUnknown = true)

public record Transaction(@FixedLength(15) String cus_id,
	    @FixedLength(20) String trans_id,
	    @FixedLength(15) Double amount,
	    @FixedLength(25) String timestamp) {
	public static String header()
	{
		return String.format("%-15s %-15s %-10.2s %-20s", "trans_id", "cus_id", "amount", "timestamp");
	}
    @Override
    public String toString() {
    	return Formatter.formatRecord(this);
    }
}
