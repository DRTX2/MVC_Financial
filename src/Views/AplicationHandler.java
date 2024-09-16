package Views;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class AplicationHandler extends JFrame {
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public AplicationHandler() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        configurateView();
        setPanels();
    }
    
    public void configurateView(){
        this.setTitle("Financial Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(800, 700);
        this.setLocationRelativeTo(null); // Centrar la ventana en la pantalla
        this.add(cardPanel); // Añadir el cardPanel al JFrame
    }

    public void setPanels(){
        cardPanel.add(Login.getPanel(), "login");
        cardPanel.add(Register.getPanel(), "register");
        cardPanel.add(FinanceView.getPanel(), "financial");
    }
    
    public void showCard(String cardName) {
        cardLayout.show(cardPanel, cardName);
    }
    
    public JPanel getPanel(String cardName) {
        // Muestra el panel que corresponde con el nombre dado
        cardLayout.show(cardPanel, cardName);
        return cardPanel; // Devuelve el panel actual (este es el contenedor principal)
    }
    
    
    public static void start() {
        SwingUtilities.invokeLater(() -> {
            new AplicationHandler().setVisible(true);
        });
    }
    
}