package advanceJava;


import java.awt.*;
import java.awt.event.*;

public class QOne extends Frame implements ActionListener {
    Label customerNameLabel, toppingsLabel, sizeLabel;
    TextField customerNameField, toppingsField;
    CheckboxGroup sizeGroup;
    Checkbox smallSize, mediumSize, largeSize;
    Button enterButton, displayButton, searchButton, exitButton;
    TextArea displayArea;

    public QOne() {
        // Set layout manager
        setLayout(new GridLayout(6, 2));
        
        // Initialize components
        customerNameLabel = new Label("Customer name:");
        toppingsLabel = new Label("Number of toppings:");
        sizeLabel = new Label("Size:");
        
        customerNameField = new TextField(20);
        toppingsField = new TextField(5);
        
        sizeGroup = new CheckboxGroup();
        smallSize = new Checkbox("Small", sizeGroup, false);
        mediumSize = new Checkbox("Medium", sizeGroup, false);
        largeSize = new Checkbox("Large", sizeGroup, false);
        
        enterButton = new Button("Enter");
        displayButton = new Button("Display All");
        searchButton = new Button("Search");
        exitButton = new Button("Exit");
        
        displayArea = new TextArea(10, 40);
        
        // Add components to frame
        add(customerNameLabel);
        add(customerNameField);
        add(toppingsLabel);
        add(toppingsField);
        add(sizeLabel);
        
        Panel sizePanel = new Panel();
        sizePanel.add(smallSize);
        sizePanel.add(mediumSize);
        sizePanel.add(largeSize);
        add(sizePanel);
        
        add(enterButton);
        add(displayButton);
        add(searchButton);
        add(exitButton);
        add(displayArea);
        
        // Add action listeners
        enterButton.addActionListener(this);
        displayButton.addActionListener(this);
        searchButton.addActionListener(this);
        exitButton.addActionListener(this);
        
        // Set frame properties
        setTitle("Rocky Woodfired Pizza Management System");
        setSize(600, 400);
        setVisible(true);
        
        // Close the window
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
            }
        });
    }
    
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == enterButton) {
            // Add item to display area
            String customerName = customerNameField.getText();
            int toppings = Integer.parseInt(toppingsField.getText());
            String size = sizeGroup.getSelectedCheckbox().getLabel();
            double charge = calculateCharge(toppings, size);
            
            displayArea.append(customerName + "\t" + toppings + "\t" + size + "\t" + charge + "\n");
            
            // Clear input fields
            customerNameField.setText("");
            toppingsField.setText("");
            sizeGroup.setSelectedCheckbox(null);
        } else if (ae.getSource() == displayButton) {
            // Display all entries (already handled by appending in Enter button)
        } else if (ae.getSource() == searchButton) {
            // Implement search functionality if needed
        } else if (ae.getSource() == exitButton) {
            // Exit the application
            dispose();
        }
    }
    
    private double calculateCharge(int toppings, String size) {
        double basePrice = 10.0; // Base price for a pizza
        double toppingPrice = 1.5 * toppings; // Price per topping
        
        switch (size) {
            case "Small":
                return basePrice + toppingPrice;
            case "Medium":
                return basePrice + toppingPrice + 2.0; // Additional charge for medium
            case "Large":
                return basePrice + toppingPrice + 4.0; // Additional charge for large
            default:
                return basePrice + toppingPrice;
        }
    }
    
    public static void main(String[] args) {
        new QOne();
    }
}
