package lab4;


import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class QOne extends JFrame {
    private JTextField celsiusField;
    private JTextField fahrenheitField;

    public QOne() {
        // Set up the frame
        setTitle("Celsius to Fahrenheit Converter");
        setSize(400, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(2, 2, 10, 10));

        // Create components
        JLabel celsiusLabel = new JLabel("Celsius:");
        celsiusField = new JTextField();
        JLabel fahrenheitLabel = new JLabel("Fahrenheit:");
        fahrenheitField = new JTextField();
        fahrenheitField.setEditable(false);  // Output field is not editable

        // Add KeyAdapter to handle key events
        celsiusField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                convertTemperature();
            }
        });

        // Add components to the frame
        add(celsiusLabel);
        add(celsiusField);
        add(fahrenheitLabel);
        add(fahrenheitField);

        // Make the frame visible
        setVisible(true);
    }

    private void convertTemperature() {
        try {
            // Get the value from the Celsius text field
            double celsius = Double.parseDouble(celsiusField.getText());
            // Convert to Fahrenheit
            double fahrenheit = celsius * 9 / 5 + 32;
            // Set the value in the Fahrenheit text field
            fahrenheitField.setText(String.format("%.2f", fahrenheit));
        } catch (NumberFormatException e) {
            // If input is not a valid number, clear the output field
            fahrenheitField.setText("");
        }
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new QOne());
    }
}
