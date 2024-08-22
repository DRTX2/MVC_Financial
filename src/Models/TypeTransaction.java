package Models;

public enum TypeTransaction {
    INCOME("Income"),
    EXPENSE("Expense");

    private final String description;

    TypeTransaction(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
    
}