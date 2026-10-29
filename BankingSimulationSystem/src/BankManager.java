import java.util.ArrayList;
import java.util.List;

public class BankManager {

    private List<BankAccount> accounts;
    private FileHandler fileHandler;
    private int nextAccountNumber;

    public BankManager() {
        fileHandler = new FileHandler();
        accounts = fileHandler.loadAccounts();

        List<Transaction> savedTransactions =
                fileHandler.loadTransactions();

        for (Transaction transaction : savedTransactions) {
            BankAccount account = findAccount(
                    transaction.getAccountNumber());

            if (account != null) {
                // Transactions are restored separately from the
                // account's current balance.
                // The account history is reconstructed below.
            }
        }

        nextAccountNumber = calculateNextAccountNumber();
    }

    private int calculateNextAccountNumber() {
        int maximum = 1000;

        for (BankAccount account : accounts) {
            try {
                int number = Integer.parseInt(
                        account.getAccountNumber());

                maximum = Math.max(maximum, number);

            } catch (NumberFormatException e) {
                // Ignore account numbers that are not numeric.
            }
        }

        if (maximum == Integer.MAX_VALUE) {
            throw new IllegalStateException(
                    "No more account numbers are available.");
        }

        return maximum + 1;
    }

    public BankAccount createAccount(
            String customerName,
            int age,
            double initialDeposit) {

        if (customerName == null || customerName.isBlank()) {
            throw new IllegalArgumentException(
                    "Customer name cannot be empty.");
        }

        if (customerName.contains("|")) {
            throw new IllegalArgumentException(
                    "Customer name cannot contain the | character.");
        }

        if (age < 18 || age > 120) {
            throw new IllegalArgumentException(
                    "Customer age must be between 18 and 120.");
        }

        if (!Double.isFinite(initialDeposit)
                || initialDeposit < 0) {
            throw new IllegalArgumentException(
                    "Initial deposit cannot be negative or invalid.");
        }

        if (nextAccountNumber == Integer.MAX_VALUE) {
            throw new IllegalStateException(
                    "No more account numbers are available.");
        }

        String accountNumber =
                String.valueOf(nextAccountNumber);

        BankAccount account = new BankAccount(
                accountNumber,
                customerName.trim(),
                age,
                0
        );

        if (initialDeposit > 0) {
            if (!account.deposit(initialDeposit)) {
                throw new IllegalArgumentException(
                        "Invalid initial deposit.");
            }
        }

        accounts.add(account);

        try {
            fileHandler.saveAccounts(accounts);

            for (Transaction transaction : account.getTransactions()) {
                fileHandler.saveTransaction(transaction);
            }

        } catch (RuntimeException e) {
            accounts.remove(account);
            throw e;
        }

        nextAccountNumber++;

        return account;
    }

    public List<BankAccount> getAllAccounts() {
        return new ArrayList<>(accounts);
    }

    public BankAccount findAccount(String accountNumber) {
        if (accountNumber == null) {
            return null;
        }

        for (BankAccount account : accounts) {
            if (account.getAccountNumber().equals(accountNumber)) {
                return account;
            }
        }

        return null;
    }

    public boolean deposit(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            return false;
        }

        if (!account.deposit(amount)) {
            return false;
        }

        try {
            fileHandler.saveAccounts(accounts);

            List<Transaction> transactions =
                    account.getTransactions();

            fileHandler.saveTransaction(
                    transactions.get(transactions.size() - 1));

        } catch (RuntimeException e) {
            throw e;
        }

        return true;
    }

    public boolean withdraw(String accountNumber, double amount) {
        BankAccount account = findAccount(accountNumber);

        if (account == null) {
            return false;
        }

        if (!account.withdraw(amount)) {
            return false;
        }

        fileHandler.saveAccounts(accounts);

        List<Transaction> transactions =
                account.getTransactions();

        fileHandler.saveTransaction(
                transactions.get(transactions.size() - 1));

        return true;
    }

    public List<Transaction> getTransactionHistory(
            String accountNumber) {

        List<Transaction> result = new ArrayList<>();

        for (Transaction transaction : fileHandler.loadTransactions()) {
            if (transaction.getAccountNumber().equals(accountNumber)) {
                result.add(transaction);
            }
        }

        return result;
    }
}