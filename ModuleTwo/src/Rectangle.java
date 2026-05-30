// UNDERSTAND: This class models a geometric rectangle with width and height attributes
// AI-CHECK: Verified UML-to-Java mapping follows standard conventions
// TRACE: Class structure follows UML: attributes (private), methods (public)

public class Rectangle {

    // Data fields (attributes from UML)
    // UNDERSTAND: Private access restricts direct modification from outside the class
    // DECISION: Used double (not int) to support fractional measurements
    // TRACE: width and height are instance variables - each Rectangle object has its own copy


    // Constructor (not shown in UML but necessary for usability)
    // UNDERSTAND: Initializes a Rectangle object with specified dimensions
    // DECISION: Includes validation (positive dimensions) to prevent invalid rectangles
    // AI-CHECK: Confirmed with Java conventions that constructors should validate input


    // Getter for width
    // UNDERSTAND: Provides controlled read access to private width field
    // DECISION: No validation needed in getter (only reading, not modifying)


    // Setter for width with validation
    // UNDERSTAND: Allows modification of width with validation (must be positive)
    // DECISION: Uses early return pattern for invalid input (beginner-friendly)


    // Getter for height
    // UNDERSTAND: Provides controlled read access to private height field


    // Setter for height with validation
    // UNDERSTAND: Allows modification of height with validation (must be positive)




    // UNDERSTAND: Calculates area = width × height (from UML: +calculateArea(): double)
    // DECISION: No parameters needed - uses instance fields width and height
    // TRACE: For width=5.0, height=3.0 -> area = 15.0




    // UNDERSTAND: Calculates perimeter = 2 × (width + height) (from UML: +calculatePerimeter(): double)
    // DECISION: Separated from calculateArea() following Single Responsibility Principle
    // TRACE: For width=5.0, height=3.0 -> perimeter = 2 × (5 + 3) = 16.0


}