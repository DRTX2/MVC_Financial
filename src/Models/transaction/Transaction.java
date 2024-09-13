
package Models.transaction;

import java.time.LocalDateTime;

public class Transaction {
    private Integer id;
    private TypeTransaction type; // "income" or "expense"
    private double amount;
    private LocalDateTime date; // "YYYY-MM-DD" HH:MM:SS
    private String description;

    public Transaction(TypeTransaction type, double amount, LocalDateTime date, String description) {
        this.id=null;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
    
    public Transaction(Integer id,TypeTransaction type, double amount, LocalDateTime date, String description) {
        this.id=id;
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Transaction{" + "id=" + id + ", type=" + type + ", amount=" + amount + ", date=" + date + ", description=" + description + '}';
    }
    
}