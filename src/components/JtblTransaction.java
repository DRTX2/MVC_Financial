package components;

import Models.transaction.Transaction;
import Models.transaction.TransactionManager;
import java.util.List;
import javax.swing.JTable;
import utils.DateUtils;

public class JtblTransaction extends JTable{
    private static JtblTransaction instance;
    private final String[] columnNames = {"Type", "Amount", "Date", "Description"};
    private final TransactionManager transactionManager=new TransactionManager();

    private JtblTransaction() {
        //super(new ArrayList<Transaction>, columnNames);
    }

    public static synchronized JtblTransaction getInstance() {
        if (instance == null) {
            instance = new JtblTransaction();
        }
        return instance;
    }
    
    public void setTransactionsInManager(List<Transaction> transactions){
        transactionManager.setTransactions(transactions);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        // Make the table cells non-editable
        return false;
    }

    @Override
    public int getRowCount() {
        return (transactionManager==null)?0:transactionManager.getTransactions().size();
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if (rowIndex < 0 || rowIndex >= getRowCount() || columnIndex < 0 || columnIndex >= getColumnCount())
            return null;
        Transaction transaction = transactionManager.getTransactions().get(rowIndex);
        switch (columnIndex) {
            case 0: return transaction.getType().getDescription();
            case 1: return transaction.getAmount();
            case 2: return transaction.getDate().format(DateUtils.DATE_TIME_FORMATTER ).toString();
            case 3: return transaction.getDescription();
            default: return null;
        }
    }

    public void addTransaction(Transaction transaction) {
        transactionManager.addTransaction(transaction);
        // Notify the table that a new row(or more) has been added
        //fireTableRowsInserted(transactionManager.getTransactions().size() - 1, transactionManager.getTransactions().size() - 1);
    }

    public void addTransactions(List<Transaction> transactions) {
        this.transactionManager.getTransactions().clear();
        this.transactionManager.getTransactions().addAll(transactions);
        // Notify the table that all the data is changed and the model requires a update
        
    }

    public String[] getColumnNames() {
        return columnNames;
    }

    public TransactionManager getTransactionManager() {
        return transactionManager;
    }
    
}
