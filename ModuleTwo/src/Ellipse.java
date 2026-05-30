// UNDERSTAND: This class models a geometric ellipse with semi-major and semi-minor axes
// DECISION: Created as a standalone class following same pattern as Rectangle and Circle
// AI-CHECK: Verified ellipse formulas with geometry textbook: Area = π × a × b
// TRACE: Class structure follows UML: attributes (private), methods (public)

public class Ellipse {

    // Data fields (attributes from UML)
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: Used double (not float) for higher precision in geometric calculations
    // TRACE: semiMajorAxis and semiMinorAxis are instance variables
    // NOTE: semiMajorAxis >= semiMinorAxis by definition, but class allows any positive values




    // Constructor (not shown in UML but necessary for usability)
    // UNDERSTAND: Initializes an Ellipse object with specified semi-major and semi-minor axes
    // DECISION: Includes validation (positive axes) to prevent invalid ellipses
    // AI-CHECK: Confirmed with Java conventions that constructors should validate input





    // Getter for semiMajorAxis
    // UNDERSTAND: Provides controlled read access to private semiMajorAxis field




    // Setter for semiMajorAxis with validation
    // UNDERSTAND: Allows modification of semi-major axis with validation (must be positive)
    // DECISION: Uses early return pattern for invalid input (beginner-friendly)






    // Getter for semiMinorAxis
    // UNDERSTAND: Provides controlled read access to private semiMinorAxis field




    // Setter for semiMinorAxis with validation
    // UNDERSTAND: Allows modification of semi-minor axis with validation (must be positive)





    // UNDERSTAND: Calculates area = π × a × b (from UML: +calculateArea(): double)
    // DECISION: Uses Math.PI constant for accuracy (more precise than 3.14159)
    // TRACE: For a=5.0, b=3.0, area = 3.14159 × 5 × 3 = 47.12385




    // UNDERSTAND: Calculates perimeter (approximate) using Ramanujan's approximation
    // DECISION: Used Ramanujan's formula (more accurate than simple approximation)
    // TRACE: For a=5.0, b=3.0, h = (5-3)²/(5+3)² = 4/64 = 0.0625
    //       perimeter ≈ π × (5+3) × (1 + 3×0.0625/(10 + √(4 - 3×0.0625))) ≈ 25.527








    // Helper method to check if ellipse is actually a circle
    // UNDERSTAND: Returns true if semi-major axis equals semi-minor axis (within tolerance)





}