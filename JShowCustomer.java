package Semester2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JShowCustomer extends JFrame implements ActionListener {
    private JTextField idField, lastNameField, firstNameField, phoneField;
    private JButton previousButton, nextButton;
    private int currentIndex = 0;

    private String[][] customers = {
            {"1", "Chenda", "Sovisal", "092888999"},
            {"2", "Kon", "Lina", "092888999"},
            {"3", "Chan", "Seyha", "092777666"}
    };

    public JShowCustomer() {
        idField = new JTextField(10);
        lastNameField = new JTextField(10);
        firstNameField = new JTextField(10);
        phoneField = new JTextField(10);

        idField.setEditable(false);
        lastNameField.setEditable(false);
        firstNameField.setEditable(false);
        phoneField.setEditable(false);

        previousButton = new JButton("Previous");
        nextButton = new JButton("Next");

        previousButton.addActionListener(this);
        nextButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        panel.add(new JLabel("ID:"));
        panel.add(idField);
        panel.add(new JLabel("Last Name:"));
        panel.add(lastNameField);
        panel.add(new JLabel("First Name:"));
        panel.add(firstNameField);
        panel.add(new JLabel("Phone:"));
        panel.add(phoneField);
        panel.add(previousButton);
        panel.add(nextButton);

        add(panel);

        setTitle("Customer");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        displayCustomer(0);
    }

    private void displayCustomer(int index) {
        if (index >= 0 && index < customers.length) {
            idField.setText(customers[index][0]);
            lastNameField.setText(customers[index][1]);
            firstNameField.setText(customers[index][2]);
            phoneField.setText(customers[index][3]);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == previousButton) {
            if (currentIndex > 0) {
                currentIndex--;
                displayCustomer(currentIndex);
            }
        } else if (e.getSource() == nextButton) {
            if (currentIndex < customers.length - 1) {
                currentIndex++;
                displayCustomer(currentIndex);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JShowCustomer().setVisible(true);
        });
    }
}
