package Controllers;

import Services.transaction.TransactionService;
import Services.typeTransaction.TypeTransactionService;
import Views.FinanceView;

public class FinanceControllerParams {
    private final FinanceView view;
    private final TransactionService transactionService;
    private final TypeTransactionService typeTransactionService;

    public FinanceControllerParams(FinanceView view, TransactionService transactionService, TypeTransactionService typeTransactionService) {
        this.view = view;
        this.transactionService = transactionService;
        this.typeTransactionService = typeTransactionService;
    }

    public FinanceView getView() {
        return view;
    }

    public TransactionService getTransactionService() {
        return transactionService;
    }

    public TypeTransactionService getTypeTransactionService() {
        return typeTransactionService;
    }
}