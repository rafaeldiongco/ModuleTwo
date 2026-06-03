// UNDERSTAND: This class models a geometric circle with radius attribute
// DECISION: Created as a standalone class focusing on encapsulation and mathematical constants
// AI-CHECK: Verified UML-to-Java mapping follows standard conventions
// TRACE: Class structure follows UML: attributes (private), methods (public)

public class Circle {

    // Data field (attribute from UML)
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: Used double (not float) for higher precision in geometric calculations
    // TRACE: radius is an instance variable - each Circle object has its own copy
    private double radius;
    // DECISION: Added a private boolean variable to determine if the circle is filled or hollow
    private boolean filled;



    // Constructor (not shown in UML but necessary for usability)
    // UNDERSTAND: Initializes a Circle object with specified radius
    // DECISION: Includes validation (positive radius) to prevent invalid circles
    // AI-CHECK: Confirmed with Java conventions that constructors should validate input
    public Circle(double radius) {
        setRadius(radius);
        this.filled = false; // Default state is hollow
    }


    // Getter for radius
    // UNDERSTAND: Provides controlled read access to private radius field
    // DECISION: No validation needed in getter (only reading, not modifying)
    public double getRadius() {
        return radius;
    }



    // Setter for radius with validation
    // UNDERSTAND: Allows modification of radius with validation (must be positive)
    // DECISION: Uses early return pattern for invalid input (beginner-friendly)
    // TRACE: Validation occurs before assignment - invalid values are rejected
    public void setRadius(double radius) {
        if (radius <= 0) {
            IO.println("Error: Radius must be positive.");
            IO.println("Radius remains unchanged: " + this.radius);
            return; // UNDERSTAND: Early return prevents invalid assignment
        }
        this.radius = radius;
    }
    // Getter for filled
    public boolean getFilled() {
        return filled;
    }

    // Setter for filled
    public void setFilled(boolean filled) {
        this.filled = filled;
    }


    // UNDERSTAND: Calculates area = π × r² (from UML: +calculateArea(): double)
    // DECISION: Uses Math.PI constant for accuracy (more precise than 3.14159)
    // TRACE: For radius=5.0, area = 3.14159 × 25 = 78.53975
    // AI-CHECK: Verified formula with geometry textbook: Area = πr²
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    // UNDERSTAND: Calculates perimeter (circumference) = 2 × π × r (from UML: +calculatePerimeter(): double)
    // DECISION: Called calculatePerimeter() to match UML, though "circumference" is more precise
    // TRACE: For radius=5.0, perimeter = 2 × 3.14159 × 5 = 31.4159
    public double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }


    // Method to calculate diameter (helper for understanding)
    // UNDERSTAND: Returns diameter = 2 × radius
    // DECISION: Added as a non-mutating auxiliary helper behavior
    public double calculateDiameter() {
        return 2 * radius;
    }
    // Method to display circle information
    // UNDERSTAND: Helper method to print current state of the circle
    public void displayInfo() {
        IO.println("Circle - Radius: " + radius);
    }
    // Method to print the circle using ASCII characters
    // TRACE: Loops through a grid bounding box of size (2r + 1) to evaluate the circular equation
    public void printCircle() {
        int r = (int) radius;

        // Prints the type and radius dimension header matching the template
        IO.println("Circle (r=" + r + "):");

        // Loop from -r to +r to place the origin (0,0) directly at the center of the circle
        for (int i = -r; i <= r; i++) {
            for (int j = -r; j <= r; j++) {
                // UNDERSTAND: Equation of a circle is x^2 + y^2 = r^2
                double distanceSq = (j * j) + (i * i);
                double radiusSq = radius * radius;

                if (filled) {
                    // DECISION: For a filled circle, print everything inside or on the boundary
                    if (distanceSq <= radiusSq + 0.5) {
                        IO.print("* ");
                    } else {
                        IO.print("  ");
                    }
                } else {
                    // DECISION: For a hollow circle, print coordinates sitting near the boundary line
                    // A tolerance threshold handles integer coordinate snapping variations
                    if (distanceSq >= radiusSq - r && distanceSq <= radiusSq + r) {
                        IO.print("* ");
                    } else {
                        IO.print("  ");
                    }
                }
            }
            IO.println("");
        }
    }
    // Sample main method for testing
    // UNDERSTAND: Entry point demonstrating Circle class functionality
    // DECISION: Tests multiple scenarios: normal circles, validation, fractional values
    public static void main(String[] args) {
        IO.println("Testing Circle Class: \n");

        // Create a circle with radius 5
        // TRACE: Creates circle1: radius = 5 (valid, positive)
        Circle circle1 = new Circle(5);
        circle1.displayInfo();

        IO.println("\nTesting with valid fractional dimension: ");
        // TRACE: Creates circle2: radius = 3.5 (valid, fractional value)
        Circle circle2 = new Circle(3.5);
        circle2.displayInfo();

        IO.println("\nTesting Setter Validation: ");
        // TRACE: Creates circle3 with valid radius 4
        Circle circle3 = new Circle(4);
        circle3.displayInfo();

        // Try to set invalid radius
        // TRACE: Attempts to set value to negative or zero - validation should reject and keep radius=4
        IO.println("Attempting to set radius to -1.5:");
        circle3.setRadius(-1.5);
        IO.println("Attempting to set radius to 0:");
        circle3.setRadius(0);
        circle3.displayInfo();

        IO.println("\n Testing Calculations ");
        // TRACE: Creates circle4 with a known radius to double-check formulas
        Circle circle4 = new Circle(5.0);
        IO.println("Circle radius: " + circle4.getRadius());
        IO.println("Diameter: " + circle4.calculateDiameter());       // Expected: 10.0
        IO.println("Area: " + circle4.calculateArea()                // Expected: ~78.54
        IO.println("Perimeter: " + circle4.calculatePerimeter());   // Expected: ~31.42
    }
}
