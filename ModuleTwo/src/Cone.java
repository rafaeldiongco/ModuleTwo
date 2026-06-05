// UNDERSTAND: This class models a right circular cone
// AI-CHECK: Checked that this matches standard Java class layout rules
// TRACE: Private fields and public methods mirror the provided shape blueprints
// DECISION: Slant height can be calculated from radius and height using Pythagorean theorem
public class Cone {

    // Data fields
    // UNDERSTAND: Private variables prevent outside code from messing with the radius and height values
    // DECISION: Using double to allow for decimal precision in geometric measurements
    // TRACE: Every instance of Cone holds its own separate radius and height values in memory
    private double radius;
    private double height;




    // Constructor
    // UNDERSTAND: Creates a new Cone instance and makes sure it has valid attributes right away
    // DECISION: Calls the setters directly to avoid repeating the positive-number validation code
    // AI-CHECK: Follows the convention of filtering input arguments during object construction
    public Cone(double radius, double height) {
        setRadius(radius);
        setHeight(height);
    }




    // Getters
    // UNDERSTAND: Let outside classes safely read our private measurements
    // DECISION: Purely reads the state without modifying any data or creating side-effects
    public double getRadius() {
        return radius;
    }

    public double getHeight() {
        return height;
    }




    // Setters with validation
    // UNDERSTAND: Lets outside layers change measurements while filtering out illegal dimensions
    // DECISION: Uses early returns to reject bad values quickly, keeping the logic flat and readable
    public void setRadius(double radius) {
        if (radius <= 0) {
            // TRACE: Rejects the assignment immediately if the radius is zero or negative
            System.out.println("Error: Radius must be positive.");
            System.out.println("Radius remains unchanged: " + this.radius);
            return;
        }
        this.radius = radius;
    }

    public void setHeight(double height) {
        if (height <= 0) {
            // TRACE: Rejects the assignment immediately if the height is zero or negative
            System.out.println("Error: Height must be positive.");

            System.out.println("Height remains unchanged: " + this.height);
            return;
        }
        this.height = height;
    }







    // UNDERSTAND: Calculates slant height using Pythagorean theorem: l = √(r² + h²)



    // UNDERSTAND: Total Surface Area of cone = πr(r + l) where l is slant height





    // UNDERSTAND: Volume of cone = (1/3)πr²h



}