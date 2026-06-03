// UNDERSTAND: This class models a geometric ellipse with semi-major and semi-minor axes
// DECISION: Created as a standalone class following same pattern as Rectangle and Circle
// AI-CHECK: Verified ellipse formulas with geometry textbook: Area = π × a × b
// TRACE: Class structure follows UML: attributes (private), methods (public)

public class Ellipse {

    // Data fields (attributes from UML)
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: Used double (not float) for higher precision in geometric calculations
    // TRACE: semiMajorAxis and semiMinorAxis are instance variables
    // NOTE: semiMajorAxis >= semiMinorAxis by definition, but class allows any positive values
    private double semiMajorAxis;
    private double semiMinorAxis;



    // Constructor (not shown in UML but necessary for usability)
    // UNDERSTAND: Initializes an Ellipse object with specified semi-major and semi-minor axes
    // DECISION: Includes validation (positive axes) to prevent invalid ellipses
    // AI-CHECK: Confirmed with Java conventions that constructors should validate input
    public Ellipse(double semiMajorAxis, double semiMinorAxis) {
        setSemiMajorAxis(semiMajorAxis);
        setSemiMinorAxis(semiMinorAxis);
    }



    // Getter for semiMajorAxis
    // UNDERSTAND: Provides controlled read access to private semiMajorAxis field
    public double getSemiMajorAxis() {
        return semiMajorAxis;
    }


    // Setter for semiMajorAxis with validation
    // UNDERSTAND: Allows modification of semi-major axis with validation (must be positive)
    // DECISION: Uses early return pattern for invalid input (beginner-friendly)
    public void setSemiMajorAxis(double semiMajorAxis) {
        if (semiMajorAxis <= 0) {
            IO.println("Error: Semi-major axis must be positive.");
            IO.println("Semi-major axis remains unchanged: " + this.semiMajorAxis);
            return;
        }
        this.semiMajorAxis = semiMajorAxis;
    }

    // Getter for semiMinorAxis
    // UNDERSTAND: Provides controlled read access to private semiMinorAxis field
    public double getSemiMinorAxis() {
        return semiMinorAxis;
    }

    // Setter for semiMinorAxis with validation
    // UNDERSTAND: Allows modification of semi-minor axis with validation (must be positive)
    // DECISION: Prevents illegal assignments below or equal to zero
    public void setSemiMinorAxis(double semiMinorAxis) {
        if (semiMinorAxis <= 0) {
            IO.println("Error: Semi-minor axis must be positive.");
            IO.println("Semi-minor axis remains unchanged: " + this.semiMinorAxis);
            return;
        }
        this.semiMinorAxis = semiMinorAxis;
    }


    // UNDERSTAND: Calculates area = π × a × b (from UML: +calculateArea(): double)
    // DECISION: Uses Math.PI constant for accuracy (more precise than 3.14159)
    // TRACE: For a=5.0, b=3.0, area = 3.14159 × 5 × 3 = 47.12385
    public double calculateArea() {
        return Math.PI * semiMajorAxis * semiMinorAxis;
    }


    // UNDERSTAND: Calculates perimeter (approximate) using Ramanujan's approximation
    // DECISION: Used Ramanujan's formula (more accurate than simple approximation)
    // TRACE: For a=5.0, b=3.0, h = (5-3)²/(5+3)² = 4/64 = 0.0625
    //       perimeter ≈ π × (5+3) × (1 + 3×0.0625/(10 + √(4 - 3×0.0625))) ≈ 25.527
    public double calculatePerimeter() {
        double a = semiMajorAxis;
        double b = semiMinorAxis;
        double h = Math.pow(a - b, 2) / Math.pow(a + b, 2);
        return Math.PI * (a + b) * (1 + (3 * h) / (10 + Math.sqrt(4 - 3 * h)));
    }



    // Helper method to check if ellipse is actually a circle
    // UNDERSTAND: Returns true if semi-major axis equals semi-minor axis (within tolerance)
    // DECISION: Uses a small floating-point threshold (epsilon) to counter precision drift
    public boolean isCircle() {
        final double EPSILON = 1e-9;
        return Math.abs(semiMajorAxis - semiMinorAxis) < EPSILON;
    }
    // Method to display ellipse information
    // UNDERSTAND: Helper method to print current state of the ellipse
    public void displayInfo() {
        IO.println("Ellipse - Semi-Major Axis: " + semiMajorAxis + ", Semi-Minor Axis: " + semiMinorAxis);
    }

    // Sample main method for testing
    // UNDERSTAND: Entry point demonstrating Ellipse class functionality
    // DECISION: Tests multiple scenarios: normal ellipses, validation, circle detection
    public static void main(String[] args) {
        IO.println("Testing Ellipse Class: \n");

        // Create an ellipse with semi-major axis 5 and semi-minor axis 3
        // TRACE: Creates ellipse1: a = 5, b = 3 (valid, positive, distinct values)
        Ellipse ellipse1 = new Ellipse(5, 3);
        ellipse1.displayInfo();
        IO.println("Is Circle? " + ellipse1.isCircle()); // Expected: false

        IO.println("\nTesting with equal dimensions (Special case: Circle): ");
        // TRACE: Creates ellipse2: a = 4.5, b = 4.5 (valid, should detect as circle)
        Ellipse ellipse2 = new Ellipse(4.5, 4.5);
        ellipse2.displayInfo();
        IO.println("Is Circle? " + ellipse2.isCircle()); // Expected: true

        IO.println("\nTesting Setter Validation: ");
        // TRACE: Creates ellipse3 with valid dimensions
        Ellipse ellipse3 = new Ellipse(6, 2);
        ellipse3.displayInfo();
    
}
