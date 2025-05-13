package Customer_pro;

public record Transactions(String customerName,
        int transactionId,
        int accountNumber,
        String email,
        double amount,
        String phone,
        String timestamp) {}
