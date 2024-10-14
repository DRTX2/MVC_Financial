package Views;

import Models.transaction.Transaction;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class TransactionTableModel extends AbstractTableModel {

    private List<Transaction> transactions;
    private final static String[] columnNames = {"Type", "Amount", "Date", "Description"};

    public TransactionTableModel() {
        this.transactions = new ArrayList<>();
    }

    public TransactionTableModel(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    @Override
    public int getRowCount() {
        return transactions.size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Transaction transaction = transactions.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return transaction.getType();
            case 1:
                return transaction.getAmount();
            case 2:
                return transaction.getDate();
            case 3:
                return transaction.getDescription();
            default: return null;
        }
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }
}
