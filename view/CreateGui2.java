package view;

import javax.swing.*;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import java.awt.*;
import java.io.File;
import java.util.Properties;

public class CreateGui2 {
    private static CreateGui2 single_instance = null;

    public static CreateGui2 getInstance() {
        if (single_instance == null) {
            single_instance = new CreateGui2();
        }
        return single_instance;
    }

    private CreateGui2() {
    }

    public JFrame createFrame(String title, int width, int height) {
        JFrame frame = new JFrame(title);
        frame.setSize(width, height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setResizable(true);
        return frame;
    }

    public JTextField createTextField(int width, int height) {
        JTextField textField = new JTextField();
        textField.setPreferredSize(new Dimension(width, height));
        return textField;
    }

    public JPanel createImage(String path){
        JPanel container = new JPanel(); // untu container utama
        
        ImageIcon icon = new ImageIcon(path);
        
        JLabel label = new JLabel();
        label.setIcon(icon);
        label.setVisible(true);

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // atas kiri bawah kanan
        container.add(label);

        return container;
    }

    public JPanel createInputText(String labeltxt) { // untuk input textfield
        JPanel container = new JPanel(); // untu container utama
        JPanel subContainer = new JPanel(); // untuk label dan textfield
        
        JLabel label = new JLabel(labeltxt);
        JTextField textField = createTextField(100, 25);

        subContainer.setLayout(new BorderLayout());
        subContainer.add(label, BorderLayout.WEST);
        subContainer.add(textField, BorderLayout.EAST);

        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // atas kiri bawah kanan

        container.add(subContainer);

        return container;

    }

    public JPanel createInputRadioBox(String[] options, String labeltxt) { // buat input radiobox
        JPanel container = new JPanel(); // container utama
        JPanel subContainer = new JPanel(); // container untuk label dan container radio
        JPanel radioContainer = new JPanel(); // container untuk radio

        ButtonGroup group = new ButtonGroup();
        JLabel label = new JLabel(labeltxt);

        if (options.length > 2) { // jika radio dibawah 2 maka akan memkaia 1 1
            radioContainer.setLayout(new GridLayout(3, 2));
        } else {
            radioContainer.setLayout(new GridLayout(1, 1));
        }

        subContainer.setLayout(new BorderLayout());
        subContainer.add(label, BorderLayout.WEST); // label ditaru di kiri

        for (String option : options) {
            JRadioButton jrButton = new JRadioButton(option);
            radioContainer.add(jrButton);
            group.add(jrButton);
        }

        subContainer.add(radioContainer, BorderLayout.EAST); // container radio ditaru dikanan

        container.add(subContainer);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return container;
    }

    public JPanel createInputComboBox(String[] option, String labeltxt) {
        JPanel container = new JPanel();
        JPanel subContainer = new JPanel();

        JComboBox<String> combobox = new JComboBox<>(option);

        subContainer.setLayout(new BorderLayout());
        subContainer.add(new JLabel(labeltxt), BorderLayout.WEST);
        subContainer.add(combobox, BorderLayout.EAST);

        container.add(subContainer);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        return container;
    }

    public JPanel createInputFileChooser(String labeltxt, JFrame frame) {
        JPanel container = new JPanel();
        JPanel subContainer = new JPanel();
        JLabel path = new JLabel();
        

        JButton openButton = new JButton("Open File");
        openButton.addActionListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showOpenDialog(frame);

            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                JOptionPane.showMessageDialog(frame, "Selected File: " + selectedFile.getAbsolutePath());
                path.setText(selectedFile.getAbsolutePath()); // menyimpan path didalam label 
                path.setVisible(false); // supaya label tidak visible 
            } else if (result == JFileChooser.CANCEL_OPTION) {
                JOptionPane.showMessageDialog(frame, "No file selected.");
            }
        });

        subContainer.setLayout(new BorderLayout());
        subContainer.add(new JLabel(labeltxt), BorderLayout.WEST);
        subContainer.add(openButton, BorderLayout.EAST);

        container.add(subContainer);
        container.add(path);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        return container;
    }
    public static String getPath(String path){
        return path;
    }

    public static JDatePickerImpl createJDatePicker() {
        JPanel container = new JPanel();
        JPanel subContainer = new JPanel();
        
        UtilDateModel model = new UtilDateModel();
        Properties p = new Properties();
        

        JDatePanelImpl datePanel = new JDatePanelImpl(model, p);
        JDatePickerImpl datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
        datePicker.setPreferredSize(new Dimension(200, 30));
        
        subContainer.setLayout(new BorderLayout());

        container.add(subContainer);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        
        
        return datePicker;
    }

    public static JPanel CreateDateInput(JDatePickerImpl datePickerImpl, String labeltxt){
        JPanel container = new JPanel();
        JPanel subContainer = new JPanel();


        subContainer.setLayout(new BorderLayout());
        subContainer.add(new JLabel(labeltxt), BorderLayout.WEST);
        subContainer.add(datePickerImpl, BorderLayout.EAST);

        container.add(subContainer);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        return container;

    }

    public JPanel createCheckBox(String [] option, String labeltxt){
        JPanel container = new JPanel();
        JPanel subContainer = new JPanel();

        

        subContainer.setLayout(new BorderLayout());
        subContainer.add(new JLabel(labeltxt), BorderLayout.WEST);


        container.add(subContainer);
        container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
        container.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        return container;



    }
}
