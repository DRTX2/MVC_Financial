package Services.transaction;

import Models.Transaction;
import Models.TransactionManager;
import Views.TransactionTableModel;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DAO.TransactionDAO;
import services.exceptions.ServiceException;

public class TransactionService {

    private final TransactionDAO transactionDAO;
    private final TransactionManager transactionManager;
    // Constructor con inyección de dependencia
    public TransactionService(TransactionDAO transactionDAO,TransactionManager transactionManager) throws ServiceException {
        this.transactionDAO = transactionDAO;
        this.transactionManager = transactionManager;
        this.transactionManager.setTransactions(getAllTransactions());
    }

    public double calculateBalance() {
        return transactionManager.getBalance();
    }
    
    public List<Transaction> getTransactions() {
        return transactionManager.getTransactions();
    }
    public void refreshTransactions() {
        transactionManager.clearTransactions();
        loadTransactionsFromDatabase();
    }
    
    private void loadTransactionsFromDatabase() {
        List<Transaction> transactions=null;
        try {
            transactions = transactionDAO.getAllTransactions();
        } catch (SQLException ex) {
            Logger.getLogger(TransactionService.class.getName()).log(Level.SEVERE, null, ex);
        }
        transactionManager.setTransactions(transactions);
    }
    
    public void addTransaction(Transaction transaction) throws ServiceException, SQLException {
        try {
            TransactionValidationService.validateTransaction(transaction);
            Integer transactionId =transactionDAO.addTransaction(transaction);
            transaction.setId(transactionId);
            transactionManager.addTransaction(transaction);
        } catch (SQLException e) {
            throw new ServiceException("Error adding transaction", e);
        }
    }
    
    
    public List<Transaction> getAllTransactions() throws ServiceException {
        try {
            return transactionDAO.getAllTransactions();
        } catch (SQLException e) {
            throw new ServiceException("Error retrieving transactions", e);
        }
    }

    public void editTransaction(Transaction transaction) throws ServiceException {
        try {
            TransactionValidationService.validateTransaction(transaction);
            transactionDAO.editTransaction(transaction);
        } catch (SQLException e) {
            throw new ServiceException("Error editing transaction", e);
        }
    }

    public void deleteTransaction(Transaction transaction) throws ServiceException {
        try {
            transactionDAO.deleteTransaction(transaction);
        } catch (SQLException e) {
            throw new ServiceException("Error deleting transaction", e);
        }
    }
}