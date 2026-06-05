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
    // DECISION: Uses standard Math.PI constant to provide high floating-point precision
    // TRACE: If radius is 3.0 -> area calculation is 4 * Math.PI * 3.0 * 3.0
    public double calculateSurfaceArea() {
        return 4 * Math.PI * radius * radius;
    }


    // UNDERSTAND: Volume of sphere = (4/3)πr³
    // DECISION: Written as (4.0 / 3.0) to prevent integer division dropping fractions down to 1.0
    // TRACE: If radius is 3.0 -> volume calculation is (4.0 / 3.0) * Math.PI * 3.0 * 3.0 * 3.0
    public double calculateVolume() {
        return (4.0 / 3.0) * Math.PI * radius * radius * radius;
    }


}
