package advanceJava;



public class QTwo {
    private String customerName;
    private String pizzaSize;
    private int numberOfToppings;
    
    // Constructor
    public QTwo(String customerName, String pizzaSize, int numberOfToppings) {
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
    public void displayPizzaDetails() {
        System.out.println("Customer Name: " + customerName);
        System.out.println("Pizza Size: " + pizzaSize);
        System.out.println("Number of Toppings: " + numberOfToppings);
    }

    public static void main(String[] args) {
        // Create a Pizza object
        QTwo pizza = new QTwo("Santosh", "Medium", 5);
        
        // Display pizza details
        pizza.displayPizzaDetails();
        
        // Modify pizza details using setters
        pizza.setCustomerName("Alisha");
        pizza.setPizzaSize("Large");
        pizza.setNumberOfToppings(3);
        
        // Display updated pizza details
        pizza.displayPizzaDetails();
    }
}
