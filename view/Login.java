package view;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controler.DBController;

public class Login extends DBController {
    static DBController conn = new DBController();
    public static void main(String[] args) {
        
        
        CreateGui2 createGui2 = CreateGui2.getInstance();
        JFrame mainFrame = createGui2.createFrame("Login", 600, 600);
        JPanel masterPanel = new JPanel();

        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));

        masterPanel.add(createGui2.createInputText("Email"));
        masterPanel.add(createGui2.createInputPassword());

      
        JButton button = new JButton("Login");

        masterPanel.add(button);

        mainFrame.add(masterPanel);

        button.addActionListener(e -> {
            JTextField field = (JTextField) ((JPanel) (((JPanel) masterPanel.getComponent(0)).getComponent(0))).getComponent(1);
            
            String pass = String.valueOf(((JPasswordField)((JPanel)((JPanel)masterPanel.getComponent(1)).getComponent(0)).getComponent(1)).getPassword());

            if (conn.Login(field.getText(), pass)) {
                JOptionPane.showMessageDialog(null, "Selamat Datang");
                mainFrame.dispose();
                ArtworkList.main(args);
            } else {
                JOptionPane.showMessageDialog(null, "maaf email atau password anda ada yang salah");
            }

        });
        mainFrame.pack();
        mainFrame.setVisible(true);


    }
}
