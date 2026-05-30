// UNDERSTAND: This class models a geometric circle with radius attribute
// DECISION: Created as a standalone class focusing on encapsulation and mathematical constants
// AI-CHECK: Verified UML-to-Java mapping follows standard conventions
// TRACE: Class structure follows UML: attributes (private), methods (public)

public class Circle {

    // Data field (attribute from UML)
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: Used double (not float) for higher precision in geometric calculations
    // TRACE: radius is an instance variable - each Circle object has its own copy



    // Constructor (not shown in UML but necessary for usability)
    // UNDERSTAND: Initializes a Circle object with specified radius
    // DECISION: Includes validation (positive radius) to prevent invalid circles
    // AI-CHECK: Confirmed with Java conventions that constructors should validate input




    // Getter for radius
    // UNDERSTAND: Provides controlled read access to private radius field
    // DECISION: No validation needed in getter (only reading, not modifying)





    // Setter for radius with validation
    // UNDERSTAND: Allows modification of radius with validation (must be positive)
    // DECISION: Uses early return pattern for invalid input (beginner-friendly)
    // TRACE: Validation occurs before assignment - invalid values are rejected






    // UNDERSTAND: Calculates area = π × r² (from UML: +calculateArea(): double)
    // DECISION: Uses Math.PI constant for accuracy (more precise than 3.14159)
    // TRACE: For radius=5.0, area = 3.14159 × 25 = 78.53975
    // AI-CHECK: Verified formula with geometry textbook: Area = πr²



    // UNDERSTAND: Calculates perimeter (circumference) = 2 × π × r (from UML: +calculatePerimeter(): double)
    // DECISION: Called calculatePerimeter() to match UML, though "circumference" is more precise
    // TRACE: For radius=5.0, perimeter = 2 × 3.14159 × 5 = 31.4159



    // Method to calculate diameter (helper for understanding)
    // UNDERSTAND: Returns diameter = 2 × radius



}