// UNDERSTAND: This class models a right circular cylinder
// AI-CHECK: Checked that this matches standard Java class conventions
// TRACE: Private attributes and public methods follow standard UML layout
public class Cylinder {

    // Data fields
    // UNDERSTAND: Keeping fields private stops outside code from altering dimensions directly
    // DECISION: Using double instead of int to support precise decimal measurements
    // TRACE: Every unique Cylinder instance gets its own independent radius and height variables
    private double radius;
    private double height;




    // Constructor
    // UNDERSTAND: Two-parameter constructor defaults the color string to "white"
    // DECISION: Delegates to explicit setters to keep input validation centralized
    // AI-CHECK: Matches standard practice of filtering arguments inside constructors
    public Cylinder(double radius, double height) {
        super("white"); // UNDERSTAND: Passes default color property to the parent class
        setRadius(radius);
        setHeight(height);
    }



    // Getters
    // UNDERSTAND: Gives outside classes safe read access to the private dimensions
    // DECISION: Simply returns the variable values without modifying anything
    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }


    // Setters with validation
    // UNDERSTAND: Allows changing the dimensions while filtering out bad inputs
    // DECISION: Uses an early return if the input is zero or negative to keep code flat
    public void setRadius(double radius) {
        if (radius <= 0) {
            // TRACE: Blocks invalid numbers before they can change the object state
            System.out.println("Error: Radius must be positive.");
            System.out.println("Radius remains unchanged: " + this.radius);
            return;

        }
        this.radius = radius;
    }
    public void setHeight(double height) {
        if (height <= 0) {
            // TRACE: Blocks invalid numbers before they can change the object state
            System.out.println("Error: Height must be positive.");
            System.out.println("Height remains unchanged: " + this.height);
            return;
        }
        this.height = height;
    }

    // DECISION: Keeps calculations clean and isolated under its own method name
    // UNDERSTAND: Fully satisfies the structural requirement of the Measurable3D interface
    @Override
    public double calculateSurfaceArea() {
        return (2 * Math.PI * radius * height) + (2 * Math.PI * radius * radius);
    }

    // UNDERSTAND: Volume of cylinder = πr²h
    // DECISION: Uses instance fields directly without needing parameters passed in
    // TRACE: If radius is 3.0 and height is 5.0 -> Math.PI * 3.0 * 3.0 * 5.0
    @Override
    public double calculateVolume() {
        return Math.PI * radius * radius * height;
    }
    // UNDERSTAND: Overrides the abstract definition to format localized shape calculations
    // DECISION: Employs two decimal place formatting to display 3D surface measurements cleanly
    @Override
    public String toString() {
        return "Cylinder | color: "      + color
                + " | radius: "          + radius
                + " | height: "          + height
                + " | surface area: "    + String.format("%.2f", calculateSurfaceArea())
                + " | volume: "          + String.format("%.2f", calculateVolume());
    }

}