package Models.transaction;

public enum TypeTransaction {
    INCOME(1,"Income"),
    EXPENSE(2,"Expense");

    private final Integer id;
    private final String description;

    TypeTransaction(Integer id,String description) {
        this.id=id;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return description;
    }
    public static TypeTransaction fromId(int id) {
        for (TypeTransaction type : values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid ID for TypeTransaction: " + id);
    }
    
}