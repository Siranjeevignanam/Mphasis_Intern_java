package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import FixedLength.FixedLength;
import FixedLength.Formatter;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(
		@FixedLength(15) String cus_id,
	    @FixedLength(10) String name,
	    @FixedLength(10) String email) {
	
	public static String header()
	{
		return String.format("%-30s %-20s %-30s", "cus_id"," name", "email");
		
	}
    @Override
    public String toString() {
    	return Formatter.formatRecord(this);
    }
}
