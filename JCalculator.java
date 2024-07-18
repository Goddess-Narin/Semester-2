package Semester2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JCalculator extends JFrame implements ActionListener {
    private JTextField textField1, textField2, resultField;
    private JButton addButton, subtractButton, multiplyButton, divideButton, modulusButton, clearButton;

    public JCalculator() {
        textField1 = new JTextField(10);
        textField2 = new JTextField(10);
        resultField = new JTextField(10);
        resultField.setEditable(false);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("*");
        divideButton = new JButton("/");
        modulusButton = new JButton("%");
        clearButton = new JButton("Clear");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        modulusButton.addActionListener(this);
        clearButton.addActionListener(this);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));
        panel.add(new JLabel("First Number:"));
        panel.add(textField1);
        panel.add(new JLabel("Second Number:"));
        panel.add(textField2);
        panel.add(new JLabel("Result:"));
        panel.add(resultField);
        panel.add(addButton);
        panel.add(subtractButton);
        panel.add(multiplyButton);
        panel.add(divideButton);
        panel.add(modulusButton);
        panel.add(clearButton);

        add(panel);

        setTitle("Calculator");
        setSize(300, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double result = 0;

            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                result = num1 / num2;
            } else if (e.getSource() == modulusButton) {
                result = num1 % num2;
            } else if (e.getSource() == clearButton) {
                textField1.setText("");
                textField2.setText("");
                resultField.setText("");
                return;
            }

            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JCalculator().setVisible(true);
        });
    }
}
