// UNDERSTAND: This class models a geometric triangle with base and height attributes
// AI-CHECK: Verified UML-to-Java mapping matches your provided class diagram exactly
// TRACE: Class structure follows UML: attributes (private), methods (public)
class Triangle {

    // Data fields (attributes from UML)
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: Used double to support fractional geometric dimensions accurately
    // TRACE: base and height are instance variables - each Triangle object maintains its own state
    private double base;
    private double height;

    // [DECLARE] New state field to track rendering fill status
    // UNDERSTAND: Encapsulates whether the shape is drawn as an outline or solid block
    private boolean filled;

    // Constructor
    // UNDERSTAND: Initializes a Triangle object with specified base and height dimensions
    // DECISION: Delegates to setters for validation (reuses existing boundary checking logic)
    // AI-CHECK: Confirmed with textbook that setter delegation is a standard secure design pattern
    Triangle(double base, double height) {
        setBase(base);     // Using setter for validation
        setHeight(height); // Using setter for validation
    }

    // Getter for base
    // UNDERSTAND: Provides controlled read access to private base field
    // DECISION: Simple value extraction with zero side effects
    public double getBase() {
        return base;
    }

    // Setter for base with validation
    // UNDERSTAND: Allows modification of base with input validation (positive numbers only)
    // DECISION: Used early return pattern for invalid input (instead of throwing exception)
    // because this is designed for beginners learning control flow
    public void setBase(double base) {
        if (base <= 0) {
            // TRACE: Validation error occurs when base <= 0
            IO.println("Error: Base must be positive.");
            IO.println("Base remains: " + this.base);
            return; // UNDERSTAND: Early return prevents invalid assignment
        }
        this.base = base;
    }

    // Getter for height
    // UNDERSTAND: Provides controlled read access to private height field
    // DECISION: No validation needed in getter (only reading, not modifying)
    public double getHeight() {
        return height;
    }

    // Setter for height with validation
    // UNDERSTAND: Allows modification of height with input validation (positive numbers only)
    // DECISION: Used early return pattern for invalid input to guard internal object state
    public void setHeight(double height) {
        if (height <= 0) {
            // TRACE: Validation error occurs when height <= 0
            IO.println("Error: Height must be positive.");
            IO.println("Height remains: " + this.height);
            return; // UNDERSTAND: Early return prevents invalid assignment
        }
        this.height = height;
    }

    // Getter for filled status
    // UNDERSTAND: Exposes whether the rendering type is outline-only or solid
    public boolean isFilled() {
        return filled;
    }

    // Setter for filled status
    // UNDERSTAND: Permits switching between filled and hollow text drawing modes
    public void setFilled(boolean filled) {
        this.filled = filled;
    }

    // Method to calculate area
    // UNDERSTAND: Calculates area = 0.5 × base × height (from UML: +calculateArea(): double)
    // DECISION: No parameters needed - uses internal instance fields base and height
    // TRACE: For base=6.0, height=4.0 -> area = 0.5 * 6.0 * 4.0 = 12.0
    public double calculateArea() {
        return 0.5 * base * height;
    }

    // Method to calculate perimeter
    // UNDERSTAND: Computes perimeter assuming a right-angled structure where hypotenuse = sqrt(base² + height²)
    // DECISION: Reuses internal attributes without external parameters; uses Math.sqrt() for accuracy
    // TRACE: For base=3.0, height=4.0 -> hypotenuse = sqrt(9 + 16) = 5.0 -> perimeter = 3.0 + 4.0 + 5.0 = 12.0
    public double calculatePerimeter() {
        double hypotenuse = Math.sqrt((base * base) + (height * height));
        return base + height + hypotenuse;
    }
    // Method to render ASCII Triangle
    // UNDERSTAND: Discretizes continuous geometric slopes onto a character coordinate grid.
    // DECISION: Scales dimensions to fit terminal lines and processes grid with an explicit math boundary check.
    public void draw() {
        // Print header string dynamically matching standard formats
        IO.println("Triangle (b=" + base + ", h=" + height + "):");

        // Convert dimensions to integer scale steps for text-matrix iteration
        int maxRows = (int) Math.round(height);
        int maxCols = (int) Math.round(base);

        // Protect against null/degenerate loop execution limits
        if (maxRows <= 0 || maxCols <= 0) {
            IO.println("[Cannot render: dimensions round to zero]");
            return;
        }

        // Loop top-to-bottom across matrix rows
        for (int r = 0; r < maxRows; r++) {
            // Inverse loop index so row 0 prints the peak and the final row prints the flat base
            int currentY = maxRows - 1 - r;

            // Loop left-to-right across matrix columns
            for (int currentX = 0; currentX < maxCols; currentX++) {

                // Calculate position relative to right-triangle hypotenuse slope line
                // Equation: boundaryX = currentY * (maxCols / maxRows)
                double boundaryX = ((double) currentY * maxCols) / maxRows;

                if (filled) {
                    // Solid Mode: fill everything to the right of the slope boundary line
                    if (currentX >= boundaryX) {
                        IO.print("* ");
                    } else {
                        IO.print("  ");
                    }
                } else {
                    // Hollow Mode: draw only on the shape edge perimeters
                    boolean isBaseRow = (r == maxRows - 1);
                    boolean isRightEdge = (currentX == maxCols - 1);

                    // Trace character cells that cross right over the computed slope coordinate line
                    boolean isHypotenuse = (currentX == (int) Math.round(boundaryX));

                    if (isBaseRow || isRightEdge || isHypotenuse) {
                        IO.print("* ");
                    } else {
                        IO.print("  ");
                    }
                }
            }
            // Advance cursor to new terminal window line
            IO.println();
        }
    }
    // Method to display triangle information
    // UNDERSTAND: Helper method to print current state of the triangle
    public void displayInfo() {
        IO.println("Triangle - Base: " + base + ", Height: " + height);
    }

    // Sample main method for testing
    // UNDERSTAND: Entry point demonstrating Triangle class functionality
    // DECISION: Tests multiple scenarios: normal triangles, validation, math assertions
    public static void main(String[] args) {
        IO.println("Testing Triangle Class: \n");

        // Create a triangle with base 6 and height 4
        // TRACE: Creates triangle1: base = 6, height = 4 (valid, positive)
        Triangle triangle1 = new Triangle(6, 4);
        triangle1.displayInfo();
        triangle1.draw();

        IO.println("\nTesting Hollow Layout Configuration: ");
        // TRACE: Creates triangle2: base = 8, height = 6
        Triangle triangle2 = new Triangle(8, 6);
        triangle2.setFilled(false);
        triangle2.displayInfo();
        triangle2.draw();

        IO.println("\nTesting Setter Validation: ");
        // TRACE: Creates triangle3 with valid base 4 and height 4
        Triangle triangle3 = new Triangle(4, 4);
        triangle3.displayInfo();
        // Try to set invalid measurements
        // TRACE: Attempts to set negative/zero values - validation should reject and keep base=4, height=4
        IO.println("Attempting to set base to -5:");
        triangle3.setBase(-5);
        IO.println("Attempting to set height to 0:");
        triangle3.setHeight(0);
        triangle3.displayInfo();

        IO.println("\n Testing Calculations ");
        // TRACE: Creates triangle4 with traditional 3-4-5 right-triangle values to check calculations
        Triangle triangle4 = new Triangle(3.0, 4.0);
        IO.println("Triangle base: " + triangle4.getBase() + ", height: " + triangle4.getHeight());
        IO.println("Area: " + triangle4.calculateArea());              // Expected: 6.0
        IO.println("Perimeter: " + triangle4.calculatePerimeter());    // Expected: 12.0 (3 + 4 + 5)

    }
}