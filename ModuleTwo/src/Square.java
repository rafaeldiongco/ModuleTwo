// UNDERSTAND: This class models a geometric square
// AI-CHECK: Verified class design follows standard JavaBeans patterns (getters/setters)

class Square {
    // Data field (attribute)
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: side is stored as double (not int) to support fractional measurements
    private double side;

    // Constructor
    // UNDERSTAND: Called when a new Square object is created - initializes object state
    // DECISION: Delegates to setter for validation (reuses existing validation logic)
    // AI-CHECK: Confirmed with textbook that setter delegation is a standard pattern
    Square(double side) {
        setSide(side);  // Using setter for validation
    }

    // Getter for side
    // UNDERSTAND: Provides controlled access to private field
    // DECISION: No validation needed in getter (only returning value, not modifying)
    double getSide() {
        return side;
    }

    // Setter for side with validation
    // UNDERSTAND: Allows modification of side with input validation (positive numbers only)
    // DECISION: Used early return pattern for invalid input (instead of throwing exception)
    // because this is designed for beginners learning control flow
    void setSide(double side) {
        if (side <= 0) {
            // TRACE: Validation error occurs when side <= 0
            IO.println("Error: Side must be positive.");
            IO.println("Side remains: " + this.side);
            return;  // UNDERSTAND: Early return prevents invalid assignment
        }
        this.side = side;
    }

    // Method to calculate area
    // UNDERSTAND: Returns area of square = side * side
    // DECISION: No input parameters needed (side already stored in object state)
    // Result is always non-negative
    double calculateArea() {
        return side * side;
    }

    // Method to calculate perimeter
    // UNDERSTAND: Returns perimeter of square = 4 * side
    // DECISION: Separated from calculateArea() to follow Single Responsibility Principle
    double calculatePerimeter() {
        return 4 * side;
    }
}
// Sample main method for testing
// UNDERSTAND: Entry point demonstrating Square class functionality
// DECISION: Tests multiple scenarios: normal squares, validation, fractional sides
static void main() {
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
}

