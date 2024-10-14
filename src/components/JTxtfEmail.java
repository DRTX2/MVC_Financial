package components;

import javax.swing.JTextField;

public class JTxtfEmail extends JTextField{
    
    public JTxtfEmail(){
        this.setText("");
        inicializate();
    }
    private void inicializate(){
        
    }
    
    
    
    public boolean isTxtValid(){
        
        String content= getText().trim();
        if(content.contains("@gmail.com") && !content.contains(" ") ){
            return true;
        }
        return false;
    }
    
    

}
