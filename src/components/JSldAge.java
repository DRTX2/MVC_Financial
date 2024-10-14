package components;

import javax.swing.JSlider;
import javax.swing.event.ChangeListener;

public class JSldAge extends JSlider{
    public JSldAge(){
        inicializate();
    }
    
    private void inicializate(){
        //his.addChangeListener(new ChangeListener);
        this.setValue(0);
    }
}
