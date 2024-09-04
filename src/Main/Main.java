
package Main;

import Controllers.FinanceController;
import Controllers.FinanceControllerParams;
import Models.TransactionManager;
import Services.initialization.DatabaseInitializer;
import Services.transaction.TransactionService;
import Services.typeTransaction.TypeTransactionService;
import Views.FinanceView;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import persistence.DAOImplementations.TransactionDAOImpl;
import services.exceptions.ServiceException;


public class Main {
    // Bien, ahora quiero que se guarden los enums que tenia desde un inicio antes de continuar
    public static void main(String[] args) throws SQLException, ServiceException {
        FinanceView view=new FinanceView();
        TransactionDAOImpl transactionDao=new TransactionDAOImpl();
        TransactionService transactionService=new TransactionService(transactionDao, new TransactionManager());
        TypeTransactionService typeTransactionService=new TypeTransactionService();
        
        FinanceControllerParams params=new FinanceControllerParams(view, transactionService, typeTransactionService);
        
        DatabaseInitializer dbInitializer=new DatabaseInitializer(typeTransactionService);
        
        try {
            dbInitializer.initialize();
            FinanceController app=new FinanceController(params);
            app.start();
        } catch (SQLException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ServiceException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
