package lab3;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QTwo extends JFrame implements ActionListener {
    private JTextField nameField;
    private JTextField emailField;

    public QTwo() {
        // Set up the frame
        setTitle("Personal Information");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Load the image icon
        ImageIcon icon = new ImageIcon("path/to/your/image.png"); // Replace with your image path

        // Create components
        JLabel nameLabel = new JLabel("Name:");
        JLabel emailLabel = new JLabel("Email:");
        nameField = new JTextField(20);
        emailField = new JTextField(20);
        JLabel nameIcon = new JLabel(icon);
        JLabel emailIcon = new JLabel(icon);
        JButton submitButton = new JButton("Submit");
        
        // Add action listener to the submit button
        submitButton.addActionListener(this);

        // Set up the grid bag constraints for the components
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(nameLabel, gbc);

        gbc.gridx = 1;
        add(nameField, gbc);

        gbc.gridx = 2;
        add(nameIcon, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        add(emailLabel, gbc);

        gbc.gridx = 1;
        add(emailField, gbc);

        gbc.gridx = 2;
        add(emailIcon, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        add(submitButton, gbc);

        // Make the frame visible
        setVisible(true);
    }

    // Handle button click events
    @Override
    public void actionPerformed(ActionEvent e) {
        String name = nameField.getText();
        String email = emailField.getText();
        JOptionPane.showMessageDialog(this, "Name: " + name + "\nEmail: " + email, "Submitted Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        // Run the GUI on the Event Dispatch Thread
        SwingUtilities.invokeLater(() -> new QTwo());
    }
}
