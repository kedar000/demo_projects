import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Transaction {

    private String accountNumber;
    private String type;
    private double amount;
    private double balanceAfterTransaction;
    private String timestamp;

    public Transaction(
            String accountNumber,
            String type,
            double amount,
            double balanceAfterTransaction) {

        this.accountNumber = accountNumber;
        this.type = type;
        this.amount = amount;
        this.balanceAfterTransaction = balanceAfterTransaction;

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        this.timestamp = LocalDateTime.now().format(formatter);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public double getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public String toFileString() {
        return accountNumber + "|" +
                type + "|" +
                amount + "|" +
                balanceAfterTransaction + "|" +
                timestamp;
    }

    public static Transaction fromFileString(String line) {
        String[] parts = line.split("\\|", -1);

        if (parts.length != 5) {
            throw new IllegalArgumentException(
                    "Invalid transaction record: " + line);
        }

        Transaction transaction = new Transaction(
                parts[0],
                parts[1],
                Double.parseDouble(parts[2]),
                Double.parseDouble(parts[3])
        );

        transaction.timestamp = parts[4];

        return transaction;
    }

    @Override
    public String toString() {
        return "Date: " + timestamp +
                " | Type: " + type +
                " | Amount: ₹" + String.format("%.2f", amount) +
                " | Balance After: ₹" +
                String.format("%.2f", balanceAfterTransaction);
    }
}