package pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Customer(String cus_id, String name, String email) {
	
	public static String header()
	{
		return String.format("%-30s %-20s %-30s", "cus_id"," name", "email");
		
	}
    @Override
    public String toString() {
        return String.format("%-30s %-20s %-30s", cus_id, name, email);
    }
}
