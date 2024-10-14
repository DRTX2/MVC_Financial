package components;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Pattern;
import javax.swing.JPasswordField;


public class JPswdField extends JPasswordField{
    private final Pattern PATTERN= Pattern.compile("^[a-zA-Z]{4,14}$");
    public JPswdField(){
        inicializate();
        this.addKeyListener(new KeyAdapter(){
            @Override
            public void keyPressed(KeyEvent e){
                passwordHandler(e);
            }
        });
        
    }
    
    private void inicializate(){
        this.setText("");
    }
    
    private void passwordHandler(KeyEvent e ){
        char caracter = e.getKeyChar();
        boolean isNotValid=caracter==KeyEvent.VK_SPACE;
        if(caracter==' ' && isNotValid){
            e.consume();
            return;
        }
        if(isValid(getContent())){
            this.setForeground(Color.black);
        }else{
            this.setForeground(Color.red);
        }
    }
    
    private boolean isValid(String content){
        return PATTERN.matcher(content).matches();
    }
    
    private String getContent(){
        StringBuilder s = new StringBuilder();
        char[] sequence= this.getPassword();
        for (char c : sequence) {
            s.append(String.valueOf(c));
        }
        return s.toString();
    }
}
