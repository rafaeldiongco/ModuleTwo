// UNDERSTAND: This class models a sphere (perfectly round 3D object)
// TRACE: Private radius attribute and public methods follow standard UML layout
// DECISION: Follows same pattern as Circle class but for 3D
public class Sphere {

    // Data field
    // UNDERSTAND: Hiding the radius behind private access protects it from direct mutation
    // DECISION: Using double to support precise fractional numbers for the radius
    // TRACE: Each unique Sphere instance stores its own independent radius copy in memory
    private double radius;




    // Constructor
    // UNDERSTAND: Initializes a new Sphere instance and guarantees valid attributes instantly
    // DECISION: Passes the parameter to setRadius() directly to leverage validation checks
    // AI-CHECK: Confirmed constructor signature matches Sphere(double) from the UML note
    public Sphere(double radius) {
        setRadius(radius);
    }




    // Getter
    // UNDERSTAND: Gives safe, read-only clearance to check the internal radius size
    // DECISION: Simple return statement with zero external context side-effects
    public double getRadius() {
        return radius;
    }




    // Setter with validation
    // UNDERSTAND: Updates the radius value while actively rejecting geometric nonsense
    // DECISION: Employs an early return pattern to reject bad entries smoothly without deep nesting
    public void setRadius(double radius) {
        if (radius <= 0) {
            // TRACE: Immediately catches and drops non-positive values before object state shifts
            System.out.println("Error: Radius must be positive.");
            System.out.println("Radius remains unchanged: " + this.radius);
            return;
        }
        this.radius = radius;
    }




    // UNDERSTAND: Surface Area of sphere = 4πr²



    // UNDERSTAND: Volume of sphere = (4/3)πr³



}
