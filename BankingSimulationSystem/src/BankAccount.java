import java.util.ArrayList;
import java.util.List;

public class BankAccount {

    private String accountNumber;
    private String customerName;
    private int age;
    private double balance;

    private List<Transaction> transactions;

    public BankAccount(
            String accountNumber,
            String customerName,
            int age,
            double balance) {

        this.accountNumber = accountNumber;
        this.customerName = customerName;
        this.age = age;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public int getAge() {
        return age;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return new ArrayList<>(transactions);
    }

    public boolean deposit(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        double newBalance = balance + amount;

        if (!Double.isFinite(newBalance)) {
            return false;
        }

        balance = newBalance;

        transactions.add(
                new Transaction(
                        accountNumber,
                        "DEPOSIT",
                        amount,
                        balance
                )
        );

        return true;
    }

    public boolean withdraw(double amount) {
        if (!Double.isFinite(amount) || amount <= 0) {
            return false;
        }

        if (amount > balance) {
            return false;
        }

        balance -= amount;

        transactions.add(
                new Transaction(
                        accountNumber,
                        "WITHDRAWAL",
                        amount,
                        balance
                )
        );

        return true;
    }

    public String toFileString() {
        return accountNumber + "|" +
                customerName + "|" +
                age + "|" +
                balance;
    }

    public static BankAccount fromFileString(String line) {
        String[] parts = line.split("\\|", -1);

        if (parts.length != 4) {
            throw new IllegalArgumentException(
                    "Invalid account record: " + line);
        }

        String accountNumber = parts[0];
        String customerName = parts[1];
        int age = Integer.parseInt(parts[2]);
        double balance = Double.parseDouble(parts[3]);

        if (accountNumber.isBlank()
                || customerName.isBlank()
                || age < 18
                || !Double.isFinite(balance)
                || balance < 0) {

            throw new IllegalArgumentException(
                    "Invalid account data: " + line);
        }

        return new BankAccount(
                accountNumber,
                customerName,
                age,
                balance
        );
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber +
                " | Name: " + customerName +
                " | Age: " + age +
                " | Balance: ₹" + String.format("%.2f", balance);
    }
}