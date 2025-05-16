
package may14;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties (ignoreUnknown = true)
public record FullDocument(
	    Customer customer,
	    Transaction transaction,
	    Bank bank
	) {}
