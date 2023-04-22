import java.awt.Component;
import java.awt.Panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * Controller
 */
public class Controller extends JFrame{
    static JFrame thisJFrame;
    public Controller(){
        thisJFrame = this;
        setSize(1000, 1000);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);
        
        setContentPane(new MainMenuPanel());
        validate();
    }

    public static void setTeamSelectPanel(){
        thisJFrame.setContentPane(new SelectTeamPanel());
        thisJFrame.invalidate();
        thisJFrame.validate();
    }
}