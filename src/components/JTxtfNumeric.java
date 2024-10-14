package components;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JTextField;

public class JTxtfNumeric extends JTextField{
    public JTxtfNumeric(){
        this.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e){
                char caracter= e.getKeyChar();
                
                boolean isValid=(caracter>='0' && caracter<='9') || caracter==KeyEvent.VK_BACK_SPACE;
                if( !isValid){
                    e.consume();
                    return;
                }
            }
        });
    }
}
