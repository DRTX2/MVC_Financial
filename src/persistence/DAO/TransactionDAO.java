package persistence.DAO;

import Models.transaction.Transaction;
import java.util.List;
import java.sql.SQLException;

public interface TransactionDAO {
    Integer addTransaction(Transaction transaction) throws SQLException;
    void editTransaction(Transaction transaction) throws SQLException;
    void deleteTransaction( Transaction transaction) throws SQLException;
    List<Transaction> getAllTransactions() throws SQLException;
}