
package Services.typeTransaction;

import Models.transaction.TypeTransaction;
import services.exceptions.ServiceException;

public class TypeTransactionValidationService {

    public void validateTypeTransaction(TypeTransaction typeTransaction) throws ServiceException {
        if (typeTransaction.getDescription() == null || typeTransaction.getDescription().isEmpty())
            throw new ServiceException("TypeTransaction description cannot be empty");
    }
}