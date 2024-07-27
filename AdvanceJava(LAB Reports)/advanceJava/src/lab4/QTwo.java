package lab4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class QTwo extends JFrame {
    private JTextField numField1;
    private JTextField numField2;
    private JLabel resultLabel;

    public QTwo() {
        // Set up the frame
        setTitle("Sum and Difference Calculator");
        setSize(400, 150);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 2, 10, 10));

        // Create components
        JLabel numLabel1 = new JLabel("Number 1:");
        JLabel numLabel2 = new JLabel("Number 2:");
        numField1 = new JTextField();
        numField2 = new JTextField();
        resultLabel = new JLabel("Result:");

        // Add mouse listener to the frame
        addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                calculateSum();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                calculateDifference();
            }
        });

        // Add components to the frame
        add(numLabel1);
        add(numField1);
        add(numLabel2);
        add(numField2);
        add(resultLabel);

        // Make the frame visible
        setVisible(true);
    }

    private void calculateSum() {
        try {
            // Get the values from the text fields
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            // Calculate the sum
            double sum = num1 + num2;
            // Set the result label to display the sum
            resultLabel.setText("Sum: " + sum);
        } catch (NumberFormatException e) {
            // Handle invalid input
            resultLabel.setText("Invalid input");
        }
    }

    private void calculateDifference() {
        try {
            // Get the values from the text fields
            double num1 = Double.parseDouble(numField1.getText());
            double num2 = Double.parseDouble(numField2.getText());
            // Calculate the difference
            double difference = num1 - num2;
            // Set the result label to display the difference
            resultLabel.setText("Difference: " + difference);
        } catch (NumberFormatException e) {
            // Handle invalid input
            resultLabel.setText("Invalid input");
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new QTwo());
    }
}
