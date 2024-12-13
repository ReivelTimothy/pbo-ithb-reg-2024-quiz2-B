package view;

import java.awt.Component;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controler.DBController;
import models.classes.Artworks;

public class InsertArtWork {
    static DBController conn = new DBController();
    public static void main(String[] args) {
        CreateGui2 createGui2 = CreateGui2.getInstance();
        JFrame mainFrame = createGui2.createFrame("ArtWork List", 600, 600);
        JButton button = new JButton("Submit");
        JPanel container = new JPanel();
        

        container.add(createGui2.createInputText("TITLE"));
        container.add(createGui2.createInputText("DESC"));
        container.add(createGui2.createInputFileChooser("ArtWork", mainFrame));
        container.add(button);


        button.addActionListener(e -> {
            JTextField comp = (JTextField)((JPanel)((JPanel)((JPanel)container.getComponent(0))).getComponent(0)).getComponent(1);
            String title =  comp.getText();
            comp = (JTextField)((JPanel)((JPanel)((JPanel)container.getComponent(1))).getComponent(0)).getComponent(1);
            String desc = comp.getText();
            String path = (((JLabel)((JPanel)container.getComponent(2)).getComponent(1))).getText();
            Artworks artworks = new Artworks(4, title, desc, path, 0);
            conn.insertNewArt(artworks);
        });

        mainFrame.add(container);
        mainFrame.pack();
        mainFrame.setVisible(true);


    }
}
