import javax.swing.JFrame;

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

    public static void setSelectTwoTeams(){
        thisJFrame.setContentPane(new SelectTwoTeams());
        thisJFrame.invalidate();
        thisJFrame.validate();
    }
}