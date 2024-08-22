
package Models;

import java.time.LocalDateTime;

public class Transaction {
    private TypeTransaction type; // "income" or "expense"
    private double amount;
    private LocalDateTime date; // Formato simple como "YYYY-MM-DD"
    private String description;

    public Transaction(TypeTransaction type, double amount, LocalDateTime date, String description) {
        this.type = type;
        this.amount = amount;
        this.date = date;
        this.description = description;
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

    
}