package controllers2;
import Views.MainView;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
        
public class MainController {
    private static final MainView view=new MainView();

    public MainController() {
        addListenners();
    }
    
    
    public static void show(){
        view.setVisible(true);
        
    }
    
    public static void hide(){
        view.setVisible(false);
    }
    
    public void addListenners(){
        view.getJbtnRegister().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToRegister();
            }
        });
        
        view.getJbtnLogIn().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToLogIn();
            }
        });
        
        view.getJbtnUsers().addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                goToList();
            }
        });
        
    }
    
    public void goToRegister(){
        this.hide();
        RegisterController.show();
    }
    
    public void goToLogIn(){
        this.hide();
        RegisterController.show();
    }
    
    public void goToList(){
         this.hide();
        RegisterController.show();
    }
    
    public static void main(String[] args) {
        MainController m = new MainController();
        m.show();
    }
    
}
