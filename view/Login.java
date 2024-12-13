package view;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Login {
    public static void main(String[] args) {
        CreateGui2 createGui2 = CreateGui2.getInstance();
        JFrame mainFrame = createGui2.createFrame("Login", 600, 600);
        JPanel masterPanel = new JPanel();

        masterPanel.setLayout(new BoxLayout(masterPanel, BoxLayout.Y_AXIS));

        masterPanel.add(createGui2.createInputText("Email"));
        masterPanel.add(createGui2.createInputText("Passsword  "));
        masterPanel.add(createGui2.createImage("download.jpg"));    
        JButton button = new JButton("Login");
        
        masterPanel.add(button);

        mainFrame.add(masterPanel);

        // Atur ukuran dan tampilkan frame
        mainFrame.pack();
        mainFrame.setVisible(true);


    }
}
