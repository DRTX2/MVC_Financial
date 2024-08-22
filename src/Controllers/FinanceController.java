package Controllers;

import Models.Transaction;
import Models.TransactionManager;
import Models.TypeTransaction;

import Views.FinanceView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

public class FinanceController {
    private final TransactionManager model;
    private final FinanceView view;

    public FinanceController(TransactionManager model, FinanceView view) {
        this.model = model;
        this.view = view;
        fillComboBox();
        addListeners();
        updateBalance();
    }

    private void fillComboBox() {
        for (TypeTransaction type : TypeTransaction.values()) {
            view.getTypeTransaction().addItem(type);
        }
    }

    private void addListeners() {
        view.getAddTransaction().addActionListener(e -> addTransaction());
    }

    private void addTransaction() {
        try {
            TypeTransaction type = (TypeTransaction) view.getTypeTransaction().getSelectedItem();
            LocalDateTime date = view.getCurrentDateTransaction().isSelected()
                    ? LocalDateTime.now()
                    : parseDateTime(view.getCurrentDateTransaction().getText());

            double amount = parseAmount(view.getAmountTransaction().getText());
            String description = view.getDescriptionTransaction().getText();

            Transaction transaction = new Transaction(type, amount, date, description);
            model.addTransaction(transaction);
            updateBalance();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(view, "Error al agregar la transacción: " + e.getMessage(), 
                                          "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private LocalDateTime parseDateTime(String dateTimeString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        try {
            return LocalDateTime.parse(dateTimeString, formatter);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Formato de fecha y hora incorrecto. Use 'yyyy-MM-dd HH:mm:ss'.");
        }
    }

    private double parseAmount(String amountString) {
        try {
            return Double.parseDouble(amountString);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Monto inválido. Debe ser un número.");
        }
    }

    private void updateBalance() {
        double balance = model.getBalance();
        view.getCurrentBalance().setText(String.valueOf(balance));
    }
}
