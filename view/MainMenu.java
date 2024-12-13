package view;

import javax.swing.*;

import org.jdatepicker.impl.JDatePickerImpl;

import java.awt.*;
import java.util.Date;

public class MainMenu {
    public static void main(String[] args) {

        CreateGui2 gui2 = CreateGui2.getInstance();

        // Buat frame utama
        JFrame mainFrame = gui2.createFrame("Sample Form Application", 200, 600);

        // Panel utama untuk menampung form
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        JDatePickerImpl tglLahir = gui2.createJDatePicker();
        JDatePickerImpl tglPembuatan = gui2.createJDatePicker();

        mainPanel.add(gui2.createInputText("Nama Lengkap"));
        mainPanel.add(gui2.createInputText("masukan umur anda "));
        mainPanel.add(gui2.createInputText("masukan alamat anda"));
        JPasswordField passwordField = new JPasswordField();
        passwordField.getPassword();
        mainPanel.add(passwordField);

        // check box

        JCheckBox jCheckBox = new JCheckBox("halo");

        mainPanel.add(jCheckBox);

        JPanel buttonContainer = new JPanel();
        JButton submitButton = new JButton("Submit");
        JButton exitButton = new JButton("Exit");

        submitButton.addActionListener(e -> {

            String pass = String.valueOf(passwordField.getPassword());
            System.out.println(pass);
        });

        buttonContainer.setLayout(new GridLayout());

        buttonContainer.add(submitButton);
        buttonContainer.add(exitButton);
        mainPanel.add(buttonContainer);
        mainFrame.add(mainPanel);

        // Atur ukuran dan tampilkan frame
        mainFrame.pack();
        mainFrame.setVisible(true);
    }
}
