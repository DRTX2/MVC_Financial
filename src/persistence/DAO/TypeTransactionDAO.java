package persistence.DAO;

import Models.transaction.TypeTransaction;
import java.util.List;

public interface TypeTransactionDAO {
    void addTypeTransaction(TypeTransaction typeTransaction) throws Exception;
    List<TypeTransaction> getAllTypeTransactions() throws Exception;
    TypeTransaction getTypeTransactionById(int id) throws Exception;
    TypeTransaction findById(int id);
}