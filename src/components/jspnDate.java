package components;

import java.util.Date;
import javax.swing.JSpinner;
import javax.swing.SpinnerDateModel;

public class jspnDate extends JSpinner{
    public jspnDate(){
        
        inicializate();
    }
    private void inicializate(){
        SpinnerDateModel model = new SpinnerDateModel();
        this.setModel(model);
        JSpinner.DateEditor editor = new JSpinner.DateEditor(this,"yyyy/MM/dd HH/mm/ss");
        this.setEditor(editor);
        this.setValue(new Date());
    }
}
