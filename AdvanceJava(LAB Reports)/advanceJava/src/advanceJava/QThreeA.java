package advanceJava;
 
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class QThreeA extends Frame implements ActionListener {
    
    // Inner Pizza class
    public class Pizza {
        private String customerName;
        private String pizzaSize;
        private int numberOfToppings;
        
        // Constructor
        public Pizza(String customerName, String pizzaSize, int numberOfToppings) {
            this.customerName = customerName;
            this.pizzaSize = pizzaSize;
            this.numberOfToppings = numberOfToppings;
        }

        // Getter and Setter for customerName
        public String getCustomerName() {
            return customerName;
        }

        public void setCustomerName(String customerName) {
            this.customerName = customerName;
        }

        // Getter and Setter for pizzaSize
        public String getPizzaSize() {
            return pizzaSize;
        }

        public void setPizzaSize(String pizzaSize) {
            this.pizzaSize = pizzaSize;
        }

        // Getter and Setter for numberOfToppings
        public int getNumberOfToppings() {
            return numberOfToppings;
        }

        public void setNumberOfToppings(int numberOfToppings) {
            this.numberOfToppings = numberOfToppings;
        }

        // Method to display pizza details
        public String displayPizzaDetails() {
            return customerName + "\t" + numberOfToppings + "\t" + pizzaSize;
        }
    }
    
    Label customerNameLabel, toppingsLabel, sizeLabel;
    TextField customerNameField, toppingsField;
    CheckboxGroup sizeGroup;
    Checkbox smallSize, mediumSize, largeSize;
    Button enterButton, displayButton, searchButton, exitButton;
    TextArea displayArea;
    ArrayList<Pizza> pizzaList; // List to store pizza objects

    public QThreeA() {
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

        // Initialize pizza list
        pizzaList = new ArrayList<>();

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
            // Get input values
            String customerName = customerNameField.getText();
            int toppings = Integer.parseInt(toppingsField.getText());
            String size = sizeGroup.getSelectedCheckbox().getLabel();

            // Create new Pizza object
            Pizza pizza = new Pizza(customerName, size, toppings);

            // Add pizza to the list
            pizzaList.add(pizza);

            // Append pizza details to display area
            displayArea.append(pizza.displayPizzaDetails() + "\n");

            // Clear input fields
            customerNameField.setText("");
            toppingsField.setText("");
            sizeGroup.setSelectedCheckbox(null);
        } else if (ae.getSource() == displayButton) {
            // Display all pizzas (already handled by appending in Enter button)
            displayArea.setText(""); // Clear existing text
            for (Pizza pizza : pizzaList) {
                displayArea.append(pizza.displayPizzaDetails() + "\n");
            }
        } else if (ae.getSource() == searchButton) {
            // Implement search functionality if needed
        } else if (ae.getSource() == exitButton) {
            // Exit the application
            dispose();
        }
    }

    public static void main(String[] args) {
        new QThreeA();
    }
}


