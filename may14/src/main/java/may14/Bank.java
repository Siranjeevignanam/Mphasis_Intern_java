package may14;

import org.example.FixedWidth;

public record Bank(
		  @FixedWidth(size = 10) String id,
		  @FixedWidth(size = 10)String name,
		  @FixedWidth(size = 10) String branch,
		  @FixedWidth(size = 10) String branchCode,
		  @FixedWidth(size = 10) String swiftCode,
		  @FixedWidth(size = 10)String country,
		  @FixedWidth(size = 10) String contact,
		  @FixedWidth(size = 10) String email,
		  @FixedWidth(size = 10) String established,
		  @FixedWidth(size = 10) String license
	) {}