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