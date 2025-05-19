package pojo;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
@JsonIgnoreProperties(ignoreUnknown = true)

public record Transaction(String cus_id, String trans_id, double amount, String timestamp) {
	public static String header()
	{
		return String.format("%-15s %-15s %-10.2s %-20s", "trans_id", "cus_id", "amount", "timestamp");
	}
    @Override
    public String toString() {
        return String.format("%-15s %-15s %-10.2f %-20s", trans_id, cus_id, amount, timestamp);
    }
}
