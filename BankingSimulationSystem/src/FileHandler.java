import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class FileHandler {

    private static final Path DATA_DIRECTORY = Path.of("data");
    private static final Path ACCOUNTS_FILE =
            DATA_DIRECTORY.resolve("accounts.txt");
    private static final Path TRANSACTIONS_FILE =
            DATA_DIRECTORY.resolve("transactions.txt");

    public FileHandler() {
        try {
            Files.createDirectories(DATA_DIRECTORY);

            if (Files.notExists(ACCOUNTS_FILE)) {
                Files.createFile(ACCOUNTS_FILE);
            }

            if (Files.notExists(TRANSACTIONS_FILE)) {
                Files.createFile(TRANSACTIONS_FILE);
            }

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to initialize data files.", e);
        }
    }

    public List<BankAccount> loadAccounts() {
        List<BankAccount> accounts = new ArrayList<>();

        try {
            for (String line : Files.readAllLines(ACCOUNTS_FILE)) {
                if (line.isBlank()) {
                    continue;
                }

                try {
                    accounts.add(BankAccount.fromFileString(line));
                } catch (RuntimeException e) {
                    System.err.println(
                            "Skipping invalid account record: " + line);
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to read accounts.", e);
        }

        return accounts;
    }

    public List<Transaction> loadTransactions() {
        List<Transaction> transactions = new ArrayList<>();

        try {
            for (String line : Files.readAllLines(TRANSACTIONS_FILE)) {
                if (line.isBlank()) {
                    continue;
                }

                try {
                    transactions.add(Transaction.fromFileString(line));
                } catch (RuntimeException e) {
                    System.err.println(
                            "Skipping invalid transaction record: " + line);
                }
            }

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to read transactions.", e);
        }

        return transactions;
    }

    public void saveAccounts(List<BankAccount> accounts) {
        List<String> lines = new ArrayList<>();

        for (BankAccount account : accounts) {
            lines.add(account.toFileString());
        }

        try {
            Files.write(
                    ACCOUNTS_FILE,
                    lines,
                    StandardOpenOption.CREATE,
                    StandardOpenOption.TRUNCATE_EXISTING,
                    StandardOpenOption.WRITE
            );

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to save accounts.", e);
        }
    }

    public void saveTransaction(Transaction transaction) {
        try {
            Files.writeString(
                    TRANSACTIONS_FILE,
                    transaction.toFileString() + System.lineSeparator(),
                    StandardOpenOption.CREATE,
                    StandardOpenOption.APPEND
            );

        } catch (IOException e) {
            throw new IllegalStateException(
                    "Unable to save transaction.", e);
        }
    }
}