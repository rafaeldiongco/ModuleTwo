// UNDERSTAND: This class models a geometric rectangle with width and height attributes
// AI-CHECK: Verified UML-to-Java mapping follows standard conventions
// TRACE: Class structure follows UML: attributes (private), methods (public)

public class Rectangle {

    // Data fields (attributes from UML)
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: Used double (not int) to support fractional measurements
    // TRACE: width and height are instance variables - each Rectangle object has its own copy
    private double width;
    private double height;

    // Constructor (not shown in UML but necessary for usability)
    // UNDERSTAND: Initializes a Rectangle object with specified dimensions
    // DECISION: Includes validation (positive dimensions) to prevent invalid rectangles
    // AI-CHECK: Confirmed with Java conventions that constructors should validate input
    public Rectangle(double width, double height) {
        setWidth(width);
        setHeight(height);
    }

    // Getter for width
    // UNDERSTAND: Provides controlled read access to private width field
    // DECISION: No validation needed in getter (only reading, not modifying)
    public double getWidth() {
        return width;
    }

    // Setter for width with validation
    // UNDERSTAND: Allows modification of width with validation (must be positive)
    // DECISION: Uses early return pattern for invalid input (beginner-friendly)
    public void setWidth(double width) {
        if (width <= 0) {
            // TRACE: Reject invalid assignments before mutating the object state
            IO.println("Error: Width must be positive.");
            IO.println("Width remains unchanged: " + this.width);
            return;
        }
        this.width = width;
    }

    // Getter for height
    // UNDERSTAND: Provides controlled read access to private height field
    // DECISION: Simple value extraction with zero external dependency modifications
    public double getHeight() {
        return height;
    }

    // Setter for height with validation
    // UNDERSTAND: Allows modification of height with validation (must be positive)
    // DECISION: Keeps mutation logic isolated and prevents illegal zero or negative heights
    public void setHeight(double height) {
        if (height <= 0) {
            // TRACE: Aborts assignments that violate our shape geometry constraints
            IO.println("Error: Height must be positive.");
            IO.println("Height remains unchanged: " + this.height);
            return;
        }
        this.height = height;
    }


    // UNDERSTAND: Calculates area = width × height (from UML: +calculateArea(): double)
    // DECISION: No parameters needed - uses instance fields width and height
    // TRACE: For width=5.0, height=3.0 -> area = 15.0
    public double calculateArea() {
        return width * height;
    }



    // UNDERSTAND: Calculates perimeter = 2 × (width + height) (from UML: +calculatePerimeter(): double)
    // DECISION: Separated from calculateArea() following Single Responsibility Principle
    // TRACE: For width=5.0, height=3.0 -> perimeter = 2 × (5 + 3) = 16.0
    public double calculatePerimeter() {
        return 2 * (width + height);
    }

    // Method to display rectangle information
    // UNDERSTAND: Helper method to print current state of the rectangle
    public void displayInfo() {
        IO.println("Rectangle - Width: " + width + ", Height: " + height);
    }

    // Sample main method for testing
    // UNDERSTAND: Entry point demonstrating Rectangle class functionality
    // DECISION: Tests multiple scenarios: normal rectangles, validation, fractional sides
    public static void main(String[] args) {
        IO.println("Testing Rectangle Class: \n");

        // Create a rectangle with width 5 and height 3
        // TRACE: Creates rect1: width = 5, height = 3 (valid, positive)
        Rectangle rect1 = new Rectangle(5, 3);
        rect1.displayInfo();

        IO.println("\nTesting with valid dimensions: ");
        // TRACE: Creates rect2: width = 6.5, height = 4.2 (valid, fractional values)
        Rectangle rect2 = new Rectangle(6.5, 4.2);
        rect2.displayInfo();

        IO.println("\nTesting Setter Validation: ");
        // TRACE: Creates rect3 with valid width 4 and height 4
        Rectangle rect3 = new Rectangle(4, 4);
        rect3.displayInfo();

        // Try to set invalid width and height
        // TRACE: Attempts to set values to negative numbers - validation should reject and keep width=4, height=4
        IO.println("Attempting to set width to -2:");
        rect3.setWidth(-2);
        IO.println("Attempting to set height to 0:");
        rect3.setHeight(0);
        rect3.displayInfo();

        IO.println("\n Testing Calculations ");
        // TRACE: Creates rect4 with known dimensions to double-check formulas
        Rectangle rect4 = new Rectangle(5.0, 3.0);
        IO.println("Rectangle width: " + rect4.getWidth() + ", height: " + rect4.getHeight());
        IO.println("Area: " + rect4.calculateArea());              // Expected: 15.0
        IO.println("Perimeter: " + rect4.calculatePerimeter());    // Expected: 16.0
    }
}
