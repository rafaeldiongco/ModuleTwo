// UNDERSTAND: This class models a geometric square
// AI-CHECK: Verified class design follows standard JavaBeans patterns (getters/setters)

public class Square extends Rectangle {
    // Data field (attribute)
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: side is stored as double (not int) to support fractional measurements
    private double side;

    // DECISION: Added a private boolean variable to determine if the square is filled or hollow
    private boolean filled;

    // Constructor
    // UNDERSTAND: Single-parameter constructor defaults the color string to "black"
    // DECISION: Passes dimensions up to the super class Rectangle to establish bounds
    public Square(double side) {
        super(side, side, "black");
        setSide(side);  // Using setter for validation
        this.filled = false; // Default state is hollow
    }
    // UNDERSTAND: Multi-parameter constructor maps structural dimensions and custom color
    // DECISION: Propagates side and explicit color parameters directly to the parent class
    public Square(double side, String color) {
        super(side, side, color);
        setSide(side);
        this.filled = false;
    }

    // Getter for side
    public double getSide() {
        return side;
    }

    // Setter for side with integrated legacy validation
    // UNDERSTAND: Guarantees the structural integrity of the square by catching invalid entries early
    // DECISION: Overrides internal properties and pushes changes up to super (Rectangle) to maintain geometric sync
    public void setSide(double side) {
        if (side <= 0) {
            // TRACE: Validation error occurs when side <= 0
            IO.println("Error: Side must be positive.");
            IO.println("Side remains: " + this.side);
            return;  // UNDERSTAND: Early return prevents invalid assignment
        }
        this.side = side;
        // UNDERSTAND: Syncs dimension update with parent class width field
        super.setWidth(side);
        // UNDERSTAND: Syncs dimension update with parent class height field
        super.setHeight(side);
    }

    // Getter for filled
    public boolean getFilled() {
        return filled;
    }

    // Setter for filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }
    // UNDERSTAND: Intercepts Rectangle width changes to enforce equal aspect ratio
    @Override
    public void setWidth(double width) {
        setSide(width);
    }

    // UNDERSTAND: Intercepts Rectangle height changes to enforce equal aspect ratio
    @Override
    public void setHeight(double height) {
        setSide(height);
    }

    // Method to print the square using ASCII characters
    // TRACE: Loops through rows and columns based on the side length
    public void printSquare() {
        int n = (int) side;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // DECISION: If filled is true, print every position.
                // If hollow, print only the border coordinates.
                if (filled || i == 0 || i == n - 1 || j == 0 || j == n - 1) {
                    IO.print("* ");
                } else {
                    IO.print("  ");
                }
            }
            IO.println("");
        }
    }
    // UNDERSTAND: Overrides parent definition to format localized shape calculations
    // DECISION: Employs two decimal place formatting to display inherited measurements
    @Override
    public String toString() {
        return "Square | color: " + color
                + " | side: "       + side
                + " | area: "       + String.format("%.2f", calculateArea())
                + " | perimeter: "  + String.format("%.2f", calculatePerimeter());
    }
}


    // Sample main method for testing
    // UNDERSTAND: Entry point demonstrating Square class functionality
    // DECISION: Tests multiple scenarios: normal squares, validation, fractional sides
    public static void main(String[] args) {
        IO.println("Testing Square Class: \n");

        // Create a square with side 5
        // TRACE: Creates square1: side = 5 (valid, positive)
        Square square1 = new Square(5);
        square1.displayInfo();

        IO.println("\nTesting with side 3: ");
        // TRACE: Creates square2: side = 3 (valid, positive)
        Square square2 = new Square(3);
        square2.displayInfo();

        IO.println("\nTesting Setter Validation: ");
        // TRACE: Creates square3 with valid side 4
        Square square3 = new Square(4);
        square3.displayInfo();

        // Try to set invalid side
        // TRACE: Attempts to set side to -2 - validation should reject and keep side=4
        IO.println("Attempting to set side to -2:");
        square3.setSide(-2);
        square3.displayInfo();

        IO.println("\n Testing Calculations ");
        // TRACE: Creates square4 with fractional side 7.5
        Square square4 = new Square(7.5);
        IO.println("Square with side: " + square4.getSide());
        IO.println("Area: " + square4.calculateArea());      // Expected: 56.25
        IO.println("Perimeter: " + square4.calculatePerimeter()); // Expected: 30.0

        // Testing the new ASCII method
        IO.println("\nTesting ASCII Art Display:");
        Square testSquare = new Square(5);

        IO.println("Hollow Square (filled = false):");
        testSquare.setFilled(false);
        testSquare.printSquare();

        IO.println("\nFilled Square (filled = true):");
        testSquare.setFilled(true);
        testSquare.printSquare();
    }
}