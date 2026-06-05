import java.io.File;
import java.util.Scanner;

public class TwoDAndThreeDShapeCalculator {
    public static void main(String[] args) {
        // [UNDERSTAND] Set up input so we can read from the keyboard
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        // [TRACE] Start the primary console loop to display the high-level options.
        do {
            System.out.println("\n========================================");
            System.out.println("      GEOMETRY CALCULATOR MAIN MENU     ");
            System.out.println("========================================");
            System.out.println("1. 2D Shapes");
            System.out.println("2. 3D Solids");
            System.out.println("3. Exit");
            System.out.print("Enter your choice (1-3): ");

            // [TRACE] Grab the menu choice integer entered by the user.
            mainChoice = scanner.nextInt();

            // [DECISION] Choose whether to enter the 2D menu, 3D menu, or close the program.
            switch (mainChoice) {
                case 1:
                    // [TRACE] Option 1 chosen: Jump into the 2D shape loop method.
                    handleTwoDMenu(scanner);
                    break;
                case 2:
                    // [TRACE] Option 2 chosen: Jump into the 3D solid loop method.
                    handleThreeDMenu(scanner);
                    break;
                case 3:
                    // [TRACE] Option 3 chosen: Print a clean exit message.
                    System.out.println("Exiting application. Goodbye!");
                    break;
                default:
                    // [DECISION] Fallback line if user picks an option outside the 1-3 bounds.
                    System.out.println("Invalid choice! Please select 1, 2, or 3.");
            }
            // [DECISION] Keep running the main menu as long as the user doesn't pick option 3.
        } while (mainChoice != 3);

        // [UNDERSTAND] Close the scanner link to clean up and prevent any memory leaks.
        scanner.close();
    }

    //2D Shapes Sub-menu
    private static void handleTwoDMenu(Scanner scanner) {
        int choice;
        // [TRACE] Start the menu loop that keeps running until the user wants to quit
        do {
            System.out.println("\n========================================");
            System.out.println("          2D SHAPES SUB-MENU            ");
            System.out.println("========================================");
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Circle");
            System.out.println("4. Ellipse");
            System.out.println("5. Triangle");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice (1-6): ");

            // [TRACE] Capture the user's menu selection
            // [DECISION] Input is stored as integer to act as the switch controller
            choice = scanner.nextInt();

            // [DECISION] Determine which shape logic to run based on the user's choice
            switch (choice) {
                case 1:
                    System.out.print("\nSQUARE:\nEnter side length: ");
                    double s = scanner.nextDouble();

                    Square sq = new Square(s); //[UNDERSTAND] Create an instance of the Square object using the constructor.

                    System.out.print("\nDo you want to display the square? (yes/no): ");
                    String displaySq = scanner.next();

                    System.out.println("\nRESULTS:");
                    System.out.println("Shape: Square");
                    System.out.println("Side: " + (int)s);
                    // [TRACE] Accessing class methods to retrieve calculated state
                    System.out.printf("Area: %.2f%n", sq.calculateArea());
                    System.out.printf("Perimeter: %.2f%n", sq.calculatePerimeter());

                    // [DECISION] Validate user preference to trigger optional visualization method
                    if (displaySq.equalsIgnoreCase("yes") || displaySq.equalsIgnoreCase("y")) {
                        sq.printSquare();
                    }
                    break;
                case 2:
                    System.out.println("\nRECTANGLE:");
                    System.out.print("Enter width: ");
                    double w = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double h = scanner.nextDouble();
                    Rectangle rect = new Rectangle(w, h); // [UNDERSTAND] Create object with dimensions

                    System.out.print("\nDo you want to display the rectangle? (yes/no): ");
                    String displayRect = scanner.next();

                    System.out.println("\nRESULTS:");
                    System.out.println("Shape: Rectangle");
                    System.out.printf("Area: %.2f%n", rect.calculateArea());
                    System.out.printf("Perimeter: %.2f%n", rect.calculatePerimeter());

                    // [DECISION] Check if visual representation is requested
                    if (displayRect.equalsIgnoreCase("yes") || displayRect.equalsIgnoreCase("y")) {
                        rect.printRectangle();
                    }
                    break;

                case 3:
                    System.out.println("\nCIRCLE:\nEnter radius: ");
                    double rad = scanner.nextDouble();
                    // [UNDERSTAND] Instantiate Circle; radius is the primary state factor
                    Circle circ = new Circle(rad);

                    System.out.print("\nDo you want to display the circle? (yes/no): ");
                    String displayCirc = scanner.next();

                    System.out.println("\nRESULTS:");
                    System.out.println("Shape: Circle");
                    System.out.printf("Area: %.2f%n", circ.calculateArea());
                    System.out.printf("Perimeter: %.2f%n", circ.calculatePerimeter());

                    // [DECISION] Logic branch for circle visualization

                    if (displayCirc.equalsIgnoreCase("yes") || displayCirc.equalsIgnoreCase("y")) {
                        circ.printCircle();
                    }
                    break;

                case 4:
                    System.out.println("\nELLIPSE:\nEnter semi-major axis (a): ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter semi-minor axis (b): ");
                    double b = scanner.nextDouble();
                    // [UNDERSTAND] Create Ellipse; requires two radii (a and b) for accurate calculation
                    Ellipse ell = new Ellipse(a, b);

                    System.out.print("\nDo you want to display the ellipse? (yes/no): ");
                    String displayEll = scanner.next();

                    System.out.println("\nRESULTS:");
                    System.out.println("Shape: Ellipse");
                    System.out.printf("Area: %.2f%n", ell.calculateArea());
                    System.out.printf("Perimeter: %.2f%n", ell.calculatePerimeter());
                    // [DECISION] Check for visualization request specific to Ellipse class
                    if (displayEll.equalsIgnoreCase("yes") || displayEll.equalsIgnoreCase("y")) {
                        ell.printASCII();
                    }
                    break;


                case 5:
                    System.out.println("\nTRIANGLE:\nEnter base: ");
                    double ba = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double he = scanner.nextDouble();
                    // [UNDERSTAND] Initialize Triangle; area depends on base and vertical height
                    Triangle tri = new Triangle(ba, he);

                    System.out.print("\nDo you want to display the triangle? (yes/no): ");
                    String displayTri = scanner.next();

                    System.out.println("\nRESULTS:");
                    System.out.println("Shape: Triangle");
                    System.out.printf("Area: %.2f%n", tri.calculateArea());
                    System.out.printf("Perimeter: %.2f%n", tri.calculatePerimeter());

                    // [DECISION] Trigger drawing method if requested
                    if (displayTri.equalsIgnoreCase("yes") || displayTri.equalsIgnoreCase("y")) {
                        tri.draw();
                    }
                    break;

                case 6:
                    // [TRACE] Exit selected: break breaks the switch, loop condition handles exit
                    System.out.println("Returning to Main menu...");
                    break;

                default:
                    // [DECISION] Error handling for any integer input outside the 1-6 range
                    System.out.println("Invalid choice inside 2D Sub-Menu!");
            }


        } while (choice != 6);// [DECISION] Loop condition: continue as long as the user hasn't chosen 6

    }

    //3D Solids Sub-menu
    private static void handleThreeDMenu(Scanner scanner) {
        int choice;
        // [TRACE] Enter the 3D loop thread to process dimensional calculations.
        do {
            System.out.println("\n========================================");
            System.out.println("          3D SOLIDS SUB-MENU            ");
            System.out.println("========================================");
            System.out.println("1. Cube");
            System.out.println("2. Cuboid");
            System.out.println("3. Sphere");
            System.out.println("4. Right Circular Cone");
            System.out.println("5. Right Circular Cylinder");
            System.out.println("6. Return to Main Menu");
            System.out.print("Enter your choice (1-6): ");

            // [TRACE] Save the current selection inside the choice variable tracker.
            choice = scanner.nextInt();

            // [DECISION] Allocate and execute code blocks based on the chosen 3D solid shape.
            switch (choice) {
                case 1:
                    System.out.print("\nCUBE:\nEnter side: ");
                    double side = scanner.nextDouble();

                    // [UNDERSTAND] Instantiate a Cube object where length, width, and height are identical.
                    Cube cube = new Cube(side);

                    System.out.println("\nRESULTS:");
                    // [TRACE] Extract and show the computed metrics from the object.
                    System.out.printf("Surface Area: %.2f%n", cube.calculateSurfaceArea());
                    System.out.printf("Volume: %.2f%n", cube.calculateVolume());
                    break;
                case 2:
                    System.out.println("\nCUBOID (Rectangular Box):");
                    System.out.print("Enter length: ");
                    double l = scanner.nextDouble();
                    System.out.print("Enter width: ");
                    double w = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double h = scanner.nextDouble();

                    // [UNDERSTAND] Instantiating a Cuboid requires tracking 3 different dimensional states.
                    Cuboid cuboid = new Cuboid(l, w, h);

                    System.out.println("\nRESULTS:");
                    // [TRACE] Print out surface area and volume based on the three values.
                    System.out.printf("Surface Area: %.2f%n", cuboid.calculateSurfaceArea());
                    System.out.printf("Volume: %.2f%n", cuboid.calculateVolume());
                    break;

                case 3:
                    System.out.print("\nSPHERE:\nEnter radius: ");
                    double r = scanner.nextDouble();

                    // [UNDERSTAND] Create a Sphere object; formulas internally multiply radius cubed values.
                    Sphere sphere = new Sphere(r);

                    System.out.println("\nRESULTS:");
                    // [TRACE] Request area and volume parameters from the sphere instance.
                    System.out.printf("Surface Area: %.2f%n", sphere.calculateSurfaceArea());
                    System.out.printf("Volume: %.2f%n", sphere.calculateVolume());
                    break;

                case 4:
                    System.out.println("\nRIGHT CIRCULAR CONE:");
                    System.out.print("Enter base radius: ");
                    double coneR = scanner.nextDouble();
                    System.out.print("Enter height: ");
                    double coneH = scanner.nextDouble();

                    // [UNDERSTAND] Create a Cone instance where slant height is solved using Pythagorean theorem.
                    Cone cone = new Cone(coneR, coneH);

                    System.out.println("\nRESULTS:");
                    // [TRACE] Requirement match: print calculated slant height before the other output data.
                    System.out.printf("Slant Height: %.2f%n", cone.calculateSlantHeight());
                    System.out.printf("Surface Area: %.2f%n", cone.calculateSurfaceArea());
                    System.out.printf("Volume: %.2f%n", cone.calculateVolume());
                    break;





        } while (choice != 6);// [DECISION] Continue looping until choice matches 6 exactly.

    }


}