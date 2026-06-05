// UNDERSTAND: This class models a cube (3D solid with equal sides)
// AI-CHECK: Checked that this matches standard Java class conventions
// TRACE: Private attributes and public methods follow standard UML layout
// DECISION: Follows same pattern as Square class but for 3D
public class Cube {

    // Data field
    // UNDERSTAND: Keeping the field private prevents outside code from breaking the data
    // DECISION: Chosen double instead of int to allow for decimal dimensions
    // TRACE: Every Cube instance gets its own independent copy of the side variable
    private double side;

    // Constructor
    // UNDERSTAND: Creates a new Cube and ensures it starts with a valid side length
    // DECISION: Calls the setter directly so we don't duplicate the validation logic
    // AI-CHECK: Matches best practice of validating input variables during creation
    public Cube(double side) {
        setSide(side);
    }


    // Getter
    // UNDERSTAND: Let's outside code read the private side value safely
    // DECISION: Purely reads the value without changing anything else
    public double getSide() {
        return side;
    }
    // Setter with validation
    // UNDERSTAND: Let's outside code change the side value under strict rules
    // DECISION: Uses an early return if the input is bad to keep the code clean and easy to follow
    public void setSide(double side) {
        if (side <= 0) {
            // TRACE: Stops the assignment immediately if the number is zero or negative
            System.out.println("Error: Side length must be positive.");
            System.out.println("Side remains unchanged: " + this.side);
            return;
        }
        this.side = side;
    }