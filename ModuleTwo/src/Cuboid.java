// UNDERSTAND: This class models a cuboid (rectangular box with length, width, height)
// AI-CHECK: Checked that this matches the provided Cuboid UML diagram specifications
// TRACE: Private attributes (- length, width, height) and public methods (+) follow UML layout
// DECISION: Follows same pattern as Rectangle class but for 3D
public class Cuboid {


    // Data fields
    // UNDERSTAND: Encapsulating the fields prevents outside code from messing up the object's dimensions
    // DECISION: Using double to allow for decimal dimensions for real-world measurements
    // TRACE: Every Cuboid object gets its own separate copy of length, width, and height variables
    private double length;
    private double width;
    private double height;

    // Constructor
    // UNDERSTAND: Initializes a Cuboid and ensures all sides are valid upon creation
    // DECISION: Routes assignments through setters to avoid duplicate validation code
    // AI-CHECK: Verified constructor signature matches Cuboid(double, double, double) from UML
    public Cuboid(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }


    // Getters
    // UNDERSTAND: Provides safe read access to the hidden, private dimension fields
    // DECISION: Purely reads and returns values without introducing side-effects or dependencies
    public double getLength() {
        return length;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    // Setters with validation
    // UNDERSTAND: Provides controlled access for changing dimensions using safety constraints
    // DECISION: Employs early returns for negative/zero inputs to keep the code highly readable
    public void setLength(double length) {
        if (length <= 0) {
            // TRACE: Halts immediate execution if length constraint is violated
            System.out.println("Error: Length must be positive.");
            System.out.println("Length remains unchanged: " + this.length);
            return;
        }
        this.length = length;
    }

    public void setWidth(double width) {
        if (width <= 0) {
            // TRACE: Halts immediate execution if width constraint is violated
            System.out.println("Error: Width must be positive.");
            System.out.println("Width remains unchanged: " + this.width);
            return;
        }
        this.width = width;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            // TRACE: Halts immediate execution if height constraint is violated
            System.out.println("Error: Height must be positive.");
            System.out.println("Height remains unchanged: " + this.height);
            return;
        }
        this.height = height;
    }
    // UNDERSTAND: Total Surface Area of cuboid = 2 * (length*width + width*height + length*height)
    // DECISION: Split out as its own separate calculation method following Single Responsibility
    // TRACE: For length=2.0, width=3.0, height=4.0 -> 2 * (6.0 + 12.0 + 8.0) = 52.0
    public double calculateSurfaceArea() {
        return 2 * ((length * width) + (width * height) + (length * height));
    }

    // UNDERSTAND: Volume of cuboid = length * width * height
    // DECISION: Accesses instance fields directly without needing parameter lists
    // TRACE: For length=2.0, width=3.0, height=4.0 -> 2.0 * 3.0 * 4.0 = 24.0
    public double calculateVolume() {
        return length * width * height;
    }
}