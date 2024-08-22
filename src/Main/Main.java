
package Main;

import Controllers.FinanceController;
import Models.TransactionManager;
import Views.FinanceView;

public class Main {
    public static void main(String[] args) {
        TransactionManager model=new TransactionManager();
        FinanceView view=new FinanceView();
        FinanceController app=new FinanceController(model,view);
    }
}
