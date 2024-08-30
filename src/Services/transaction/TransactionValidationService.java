package Services.transaction;

import Models.Transaction;

public class TransactionValidationService {

    public static void validateTransaction(Transaction transaction) {
        if (transaction == null)
            throw new IllegalArgumentException("Transaction cannot be null");
        if (transaction.getType() == null)
            throw new IllegalArgumentException("Transaction type cannot be null");
        if (transaction.getAmount() <= 0) 
            throw new IllegalArgumentException("Transaction amount must be positive");
        if (transaction.getDescription() == null || transaction.getDescription().trim().isEmpty())
            throw new IllegalArgumentException("Transaction description cannot be empty");
    }
}