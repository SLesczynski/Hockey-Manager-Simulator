import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectTeamPanel extends JPanel implements ActionListener{
    
    String htmlText;

    Color myGray = new Color(50, 50 , 50);

    public SelectTeamPanel(){

        //SetUp Panel
        setBounds(0, 0, 1000, 1000);
        setLayout(null);
        setBackground(Color.darkGray);

        // Top Text
        JLabel selectTeamText = new JLabel();
        htmlText = new String("<html><center> Select Controlled Team </html>");
        selectTeamText.setText(htmlText);
        selectTeamText.setHorizontalAlignment(JLabel.CENTER);
        selectTeamText.setBounds(50, 30, 900, 110);
        selectTeamText.setForeground(Color.white);
        selectTeamText.setBackground(myGray);
        selectTeamText.setOpaque(true);
        selectTeamText.setFont(new Font("Verdana", Font.PLAIN, 50));
        this.add(selectTeamText);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // TOD
        throw new UnsupportedOperationException("Unimplemented method 'actionPerformed'");
    }
}
