package persistence.DAOImplementations;

import Models.transaction.TypeTransaction;
import persistence.DAO.TypeTransactionDAO;
import persistence.exceptions.DAOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import utils.DatabaseConnection;

public class TypeTransactionDAOImpl implements TypeTransactionDAO {

    private final Connection connection;

    public TypeTransactionDAOImpl() throws SQLException {
        this.connection = DatabaseConnection.getConnection();
    }

    @Override
    public void addTypeTransaction(TypeTransaction typeTransaction) throws Exception {
        String sql = "INSERT INTO type_transaction (id_type_transaction, name_type_transaction) VALUES (?, ?)";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, typeTransaction.getId());
            stmt.setString(2, typeTransaction.getDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new DAOException("Error adding TypeTransaction", e);
        }
    }

    @Override
    public List<TypeTransaction> getAllTypeTransactions() throws Exception {
        List<TypeTransaction> typeTransactions = new ArrayList<>();
        String sql = "SELECT * FROM type_transaction";

        try (Statement stmt = connection.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                TypeTransaction typeTransaction = TypeTransaction.fromId(rs.getInt("id_type_transaction"));
                typeTransactions.add(typeTransaction);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving TypeTransactions", e);
        }
        return typeTransactions;
    }

    @Override
    public TypeTransaction getTypeTransactionById(int id) throws Exception {
        String sql = "SELECT * FROM type_transaction WHERE id_type_transaction = ?";
        
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return TypeTransaction.fromId(rs.getInt("id_type_transaction"));
                } else {
                    throw new DAOException("TypeTransaction not found with ID: " + id);
                }
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving TypeTransaction by ID", e);
        }
    }

   @Override
    public TypeTransaction findById(int id) {
        String sql = "SELECT * FROM type_transaction WHERE id_type_transaction = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next())
                return TypeTransaction.fromId(id);
        } catch (SQLException e) {
            throw new RuntimeException("Error fetching TypeTransaction with ID " + id, e);
        }
        return null; // Si no se encuentra, devuelve null
    }
}