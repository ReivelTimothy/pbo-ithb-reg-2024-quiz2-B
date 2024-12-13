package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class MenuBookList {
    public static void main(String[] args) {
        CreateGui2 createGui2 = CreateGui2.getInstance();
        JFrame mainFrame = createGui2.createFrame("Login", 600, 600);
        JPanel masterPanel = new JPanel();
        JLabel label = new JLabel("Menu");
        mainFrame.add(label);
        masterPanel.setLayout(new GridLayout());
        masterPanel.add(new JButton("transaction"));
        
        masterPanel.add(createGui2.createImage("donload.jpg"));

        mainFrame.add(masterPanel);
    }
}
