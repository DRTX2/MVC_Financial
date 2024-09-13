package Services.initialization;

import Services.typeTransaction.TypeTransactionService;
import Models.transaction.TypeTransaction;
import services.exceptions.ServiceException;

public class DatabaseInitializer {

    private final TypeTransactionService typeTransactionService;

    public DatabaseInitializer(TypeTransactionService typeTransactionService) {
        this.typeTransactionService = typeTransactionService;
    }

    public void initialize() throws ServiceException {
        for (TypeTransaction type : TypeTransaction.values()) {
            if (!typeTransactionService.exists(type))
                typeTransactionService.addTypeTransaction(type);
        }
    }
}
