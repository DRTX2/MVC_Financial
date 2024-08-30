package Models;

import java.util.ArrayList;
import java.util.List;

public class TransactionManager {
    private List<Transaction> transactions;

    public TransactionManager() {
        transactions = new ArrayList<>();
    }

    // Este método permite inicializar el manager con las transacciones cargadas desde la base de datos
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public double getBalance() {
        double balance = 0;
        for (Transaction t : transactions) {
            if (t.getType().getDescription().equals("Income")) {
                balance += t.getAmount();
            } else {
                balance -= t.getAmount();
            }
        }
        return balance;
    }

    public void clearTransactions() {
        transactions.clear();
    }
}