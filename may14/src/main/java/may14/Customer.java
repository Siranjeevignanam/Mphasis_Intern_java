package may14;

import org.example.FixedWidth;

public record Customer(
		  @FixedWidth(size = 10) String id,
		  @FixedWidth(size = 10)  String name,
		  @FixedWidth(size = 10)String email,
		  @FixedWidth(size = 10)String mobile,
		  @FixedWidth(size = 10)String address,
		  @FixedWidth(size = 10)  String dob,
		  @FixedWidth(size = 10) String gender,
		  @FixedWidth(size = 10)String nationalId,
		  @FixedWidth(size = 10)String occupation,
		  @FixedWidth(size = 10) String createdAt
	) {}