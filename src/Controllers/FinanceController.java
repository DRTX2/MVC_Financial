package Controllers;

import Models.Transaction;
import Models.TypeTransaction;
import Services.transaction.TransactionService;
import Services.typeTransaction.TypeTransactionService;

import Views.FinanceView;
import Views.TransactionTableModel;

import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import services.exceptions.ServiceException;
import utils.DateUtils;

public class FinanceController {
    private final FinanceView view;
    private final TransactionService transactionService;
    private final TransactionTableModel tableModel;

    public FinanceController(FinanceControllerParams params) throws SQLException {
        this.view = params.getView();
        this.transactionService = params.getTransactionService();
        this.tableModel=TransactionTableModel.getInstance();
    }
    
    public void loadTransactionsToDB(){
        List<Transaction> previousTransactions=new  ArrayList<>();
        try {
            previousTransactions = transactionService.getAllTransactions();
        } catch (ServiceException ex) {
            Logger.getLogger(FinanceController.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.tableModel.setTransactionsInManager(previousTransactions);
    }

    public void start() {
        //añadir algo para ver si los datos iniciales requeridos estan en la bd, como si se subieron los enums
        fillComboBox();
        loadTransactionsToDB();
        updateBalance();
        addListeners();
        view.setVisible(true);
    }

    private void fillComboBox() {
        for (TypeTransaction type : TypeTransaction.values())
            view.getTypeTransaction().addItem(type);
    }

    private void addListeners() {
        view.getAddTransaction().addActionListener(e -> addTransaction());
    }

    private void addTransaction() {
        try {
            Transaction transaction = createTransactionFromView();
            transactionService.addTransaction(transaction);
            tableModel.addTransaction(transaction);
            updateBalance();
        } catch (Exception e) {
            handleTransactionError(e);
        }
    }

    private Transaction createTransactionFromView() {
        TypeTransaction type = (TypeTransaction) view.getTypeTransaction().getSelectedItem();
        LocalDateTime date = view.getCurrentDateTransaction().isSelected()
                ? LocalDateTime.now()
                : parseDateTime(view.getCurrentDateTransaction().getText());
        double amount = parseAmount(view.getAmountTransaction().getText());
        String description = view.getDescriptionTransaction().getText();

        return new Transaction(type, amount, date, description);
    }

    private LocalDateTime parseDateTime(String dateTimeString) {
        System.out.println("dateTime: " + dateTimeString);
        try {
            return LocalDateTime.parse(dateTimeString.trim(), DateUtils.DATE_TIME_FORMATTER );
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha y hora incorrecto. Use 'yyyy-MM-dd HH:mm:ss'.", e);
        }
    }

    private double parseAmount(String amountString) {
        try {
            return Double.parseDouble(amountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Monto inválido. Debe ser un número.");
        }
    }

    private void handleTransactionError(Exception e) {
        JOptionPane.showMessageDialog(view, "Error al agregar la transacción: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void updateBalance() {
        double balance = transactionService.calculateBalance();
        view.getCurrentBalance().setText(String.valueOf(balance));
    }
}
