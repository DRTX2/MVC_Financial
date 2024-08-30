package Services.typeTransaction;

import Models.TypeTransaction;
import java.sql.SQLException;
import java.util.List;
import persistence.DAO.TypeTransactionDAO;
import persistence.DAOImplementations.TypeTransactionDAOImpl;
import services.exceptions.ServiceException;

public class TypeTransactionService {

    private final TypeTransactionDAO typeTransactionDAO;

    public TypeTransactionService() throws SQLException {
        this.typeTransactionDAO = new TypeTransactionDAOImpl();
    }

    public void addTypeTransaction(TypeTransaction typeTransaction) throws ServiceException {
        try {
            typeTransactionDAO.addTypeTransaction(typeTransaction);
        } catch (Exception e) {
            throw new ServiceException("Error adding TypeTransaction", e);
        }
    }

    public List<TypeTransaction> getAllTypeTransactions() throws ServiceException {
        try {
            return typeTransactionDAO.getAllTypeTransactions();
        } catch (Exception e) {
            throw new ServiceException("Error retrieving TypeTransactions", e);
        }
    }

    public TypeTransaction getTypeTransactionById(int id) throws ServiceException {
        try {
            return typeTransactionDAO.getTypeTransactionById(id);
        } catch (Exception e) {
            throw new ServiceException("Error retrieving TypeTransaction by ID", e);
        }
    }
    
    public boolean exists(TypeTransaction type) {
        try{
            return typeTransactionDAO.findById(type.getId())!=null;
        }catch(Exception e){
            return false;
        }
    }

}