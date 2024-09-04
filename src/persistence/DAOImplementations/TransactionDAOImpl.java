package persistence.DAOImplementations;

import persistence.DatabaseConnection;
import Models.Transaction;
import Models.TypeTransaction;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import persistence.DAO.TransactionDAO;
import persistence.exceptions.DAOException;

public class TransactionDAOImpl
        implements TransactionDAO {

    private Connection connection;

    public TransactionDAOImpl() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public Integer addTransaction(Transaction transaction) throws SQLException {
        System.out.println("Adding: "+transaction);
        String sql = "INSERT INTO transaction (id_type_transaction, amount_transaction, date_transaction, description_transaction) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setInt(1, transaction.getType().getId());
            stmt.setDouble(2, transaction.getAmount());
            stmt.setTimestamp(3, Timestamp.valueOf(transaction.getDate()));
            stmt.setString(4, transaction.getDescription());
            stmt.executeUpdate();

            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (!generatedKeys.next()) {
                    throw new DAOException("Failed to retrieve ID.");
                }
                return generatedKeys.getInt(1); // Aquí obtienes el ID
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new DAOException("Failed to retrieve ID.", e);
        }
    }

    @Override
    public List<Transaction> getAllTransactions() throws SQLException {
        List<Transaction> transactions = new ArrayList<>();
        String query = "SELECT * FROM transaction";
        try (Statement stmt = connection.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                // Crear y agregar transacciones a la lista
                Transaction transaction = new Transaction(
                        rs.getInt("id_transaction"),
                        TypeTransaction.fromId(rs.getInt("id_type_transaction")),
                        rs.getDouble("amount_transaction"),
                        rs.getTimestamp("date_transaction").toLocalDateTime(),
                        rs.getString("description_transaction")
                );
                transactions.add(transaction);
            }
        } catch (SQLException e) {
            throw new DAOException("Error while retrieving transactions", e);
        }
        return transactions;
    }

    @Override
    public void editTransaction(Transaction transaction) throws SQLException {
        System.out.println("Updating: "+transaction);
        if (transaction.getId() == null) {
            throw new DAOException("Transaction ID must not be null\nTransaction is possibly not registered");
        }
        String query = "UPDATE transaction SET id_type_transaction-transaction = ?, amount-transaction = ?, date-transaction = ?, description-transaction = ? WHERE id-transaction = ?";
        
        try{
            connection.setAutoCommit(false);
            try (PreparedStatement stm = connection.prepareStatement(query)) {
                stm.setInt(1, transaction.getType().getId());
                stm.setDouble(2, transaction.getAmount());
                stm.setTimestamp(3, Timestamp.valueOf(transaction.getDate()));
                stm.setString(4, transaction.getDescription());
                stm.setInt(5, transaction.getId());

                stm.executeUpdate();
            }
        }catch(SQLException e){
            try {
                connection.rollback(); 
            } catch (SQLException ex) {
                throw new DAOException("Error while rolling back transaction", ex);
            }
            throw new DAOException("Error while editing transaction", e);
        }finally{
            try {
                connection.setAutoCommit(true); // Restaurar el auto-commit
            } catch (SQLException e) {
                throw new DAOException("Error while resetting auto-commit", e);
            }
        }
    }

    @Override
    public void deleteTransaction(Transaction transaction) throws SQLException {
        System.out.println("Deleting: "+transaction);
        String sql = "DELETE FROM transaction WHERE id_transaction = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, transaction.getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error while deleting transaction", e);
        }
    }
}