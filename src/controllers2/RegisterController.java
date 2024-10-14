package controllers2;

import Views.UserRegister;

public class RegisterController{
    private static final UserRegister view= new UserRegister();
    
    public static void show(){
        view.setVisible(true);
    }
 
    public static void hide(){
        view.setVisible(false);
    }
    
    public static void returnInitialView(){
        hide();
        
    }
            
}
