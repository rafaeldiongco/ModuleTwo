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
            System.out.println("Error: Base must be positive.");
            System.out.println("Base remains: " + this.base);
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
            System.out.println("Error: Height must be positive.");
            System.out.println("Height remains: " + this.height);
            return; // UNDERSTAND: Early return prevents invalid assignment
        }
        this.height = height;
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
}