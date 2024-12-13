package view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import controler.DBController;
import models.classes.Artworks;

public class ArtworkList {
    static DBController conn = new DBController();
    public static void main(String[] args) {
        CreateGui2 createGui2 = CreateGui2.getInstance();
        JFrame mainFrame = createGui2.createFrame("ArtWork List", 600, 600);
        JButton button = new JButton("add artwork");
        mainFrame.setLayout(new BorderLayout());
        mainFrame.add(button, BorderLayout.EAST);
        
        
        
        
        ArrayList <Artworks> list = conn.listArtworks();
        System.out.println(list.get(0).getDesc());
        JPanel subPanel = createGui2.showArtWork(list);
        
        button.addActionListener(e -> {
            
        });

        mainFrame.add(subPanel);
        mainFrame.pack();
        mainFrame.setVisible(true);
    }   
}
