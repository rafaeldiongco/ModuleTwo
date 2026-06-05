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
    // UNDERSTAND: Creates a new Cylinder and ensures its dimensions are safe right from the start
    // DECISION: Calls the setters directly to reuse the input validation rules
    // AI-CHECK: Matches standard practice of filtering arguments inside constructors
    public Cylinder(double radius, double height) {
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









    // UNDERSTAND: Total Surface Area of cylinder = 2πr(r + h)



    // UNDERSTAND: Volume of cylinder = πr²h



}