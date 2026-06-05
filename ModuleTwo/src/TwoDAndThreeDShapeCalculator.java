import java.util.Scanner;

public class TwoDAndThreeDShapeCalculator {
    public static void main(String[] args) {
        // [UNDERSTAND] Set up input so we can read from the keyboard
        Scanner scanner = new Scanner(System.in);
        int mainChoice;

        // [TRACE] Start the primary console loop to display the high-level options.
        do {
            IO.println("\n========================================");
            IO.println("      GEOMETRY CALCULATOR MAIN MENU     ");
            IO.println("========================================");
            IO.println("1. 2D Shapes");
            IO.println("2. 3D Solids");
            IO.println("3. Exit");
            IO.print("Enter your choice (1-3): ");

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
                    IO.println("Exiting application. Goodbye!");
                    break;
                default:
                    // [DECISION] Fallback line if user picks an option outside the 1-3 bounds.
                    IO.println("Invalid choice! Please select 1, 2, or 3.");
            }
            // [DECISION] Keep running the main menu as long as the user doesn't pick option 3.
        } while (mainChoice != 3);

        // [UNDERSTAND] Close the scanner link to clean up and prevent any memory leaks.
        scanner.close();
    }
        int choice;
        // [TRACE] Start the menu loop that keeps running until the user wants to quit
        do {
            IO.println("\nWelcome to the 2D Shapes Calculator App!");
            IO.println("========================================");
            IO.println("2D SHAPES CALCULATOR");
            IO.println("========================================");
            IO.println("1. Square");
            IO.println("2. Rectangle");
            IO.println("3. Circle");
            IO.println("4. Ellipse");
            IO.println("5. Triangle");
            IO.println("6. Exit");
            IO.print("Enter your choice (1-6): ");



            // [TRACE] Capture the user's menu selection
            // [DECISION] Input is stored as integer to act as the switch controller
            choice = scanner.nextInt();
            // [DECISION] Determine which shape logic to run based on the user's choice
            switch (choice) {
                case 1:
                    IO.print("\nSQUARE:\nEnter side length: ");
                    double s = scanner.nextDouble();
                    Square sq = new Square(s); // [UNDERSTAND] Create object with user input

                    IO.print("\nDo you want to display the square? (yes/no): ");
                    String displaySq = scanner.next();

                    IO.println("\nRESULTS:");
                    IO.println("Shape: Square");
                    IO.println("Side: " + (int)s);
                    // [TRACE] Accessing class methods to retrieve calculated state
                    IO.printf("Area: %.2f%n", sq.calculateArea());
                    IO.printf("Perimeter: %.2f%n", sq.calculatePerimeter());

                    // [DECISION] Validate user preference to trigger optional visualization method
                    if (displaySq.equalsIgnoreCase("yes") || displaySq.equalsIgnoreCase("y")) {
                        sq.printSquare();
                    }
                    break;
                case 2:
                    IO.println("\nRECTANGLE:");
                    IO.print("Enter width: ");
                    double w = scanner.nextDouble();
                    IO.print("Enter height: ");
                    double h = scanner.nextDouble();
                    Rectangle rect = new Rectangle(w, h); // [UNDERSTAND] Create object with dimensions

                    IO.print("\nDo you want to display the rectangle? (yes/no): ");
                    String displayRect = scanner.next();

                    IO.println("\nRESULTS:");
                    IO.println("Shape: Rectangle");
                    IO.printf("Area: %.2f%n", rect.calculateArea());
                    IO.printf("Perimeter: %.2f%n", rect.calculatePerimeter());

                    // [DECISION] Check if visual representation is requested
                    if (displayRect.equalsIgnoreCase("yes") || displayRect.equalsIgnoreCase("y")) {
                        rect.printRectangle();
                    }
                    break;

                case 3:
                    IO.println("\nCIRCLE:\nEnter radius: ");
                    double rad = scanner.nextDouble();
                    // [UNDERSTAND] Instantiate Circle; radius is the primary state factor
                    Circle circ = new Circle(rad);

                    IO.print("\nDo you want to display the circle? (yes/no): ");
                    String displayCirc = scanner.next();

                    IO.println("\nRESULTS:");
                    IO.println("Shape: Circle");
                    IO.printf("Area: %.2f%n", circ.calculateArea());
                    IO.printf("Perimeter: %.2f%n", circ.calculatePerimeter());

                    // [DECISION] Logic branch for circle visualization

                    if (displayCirc.equalsIgnoreCase("yes") || displayCirc.equalsIgnoreCase("y")) {
                        circ.printCircle();
                    }
                    break;

                case 4:
                    IO.println("\nELLIPSE:\nEnter semi-major axis (a): ");
                    double a = scanner.nextDouble();
                    IO.print("Enter semi-minor axis (b): ");
                    double b = scanner.nextDouble();
                    // [UNDERSTAND] Create Ellipse; requires two radii (a and b) for accurate calculation
                    Ellipse ell = new Ellipse(a, b);

                    IO.print("\nDo you want to display the ellipse? (yes/no): ");
                    String displayEll = scanner.next();

                    IO.println("\nRESULTS:");
                    IO.println("Shape: Ellipse");
                    IO.printf("Area: %.2f%n", ell.calculateArea());
                    IO.printf("Perimeter: %.2f%n", ell.calculatePerimeter());
                    // [DECISION] Check for visualization request specific to Ellipse class
                    if (displayEll.equalsIgnoreCase("yes") || displayEll.equalsIgnoreCase("y")) {
                        ell.printASCII();
                    }
                    break;


                case 5:
                    IO.println("\nTRIANGLE:\nEnter base: ");
                    double ba = scanner.nextDouble();
                    IO.print("Enter height: ");
                    double he = scanner.nextDouble();
                    // [UNDERSTAND] Initialize Triangle; area depends on base and vertical height
                    Triangle tri = new Triangle(ba, he);

                    IO.print("\nDo you want to display the triangle? (yes/no): ");
                    String displayTri = scanner.next();

                    IO.println("\nRESULTS:");
                    IO.println("Shape: Triangle");
                    IO.printf("Area: %.2f%n", tri.calculateArea());
                    IO.printf("Perimeter: %.2f%n", tri.calculatePerimeter());

                    // [DECISION] Trigger drawing method if requested
                    if (displayTri.equalsIgnoreCase("yes") || displayTri.equalsIgnoreCase("y")) {
                        tri.draw();
                    }
                    break;

                case 6:
                    // [TRACE] Exit selected: break breaks the switch, loop condition handles exit
                    IO.println("Exiting...");
                    break;

                default:
                    // [DECISION] Error handling for any integer input outside the 1-6 range
                    IO.println("Invalid choice!");
            }


        } while (choice != 6);// [DECISION] Loop condition: continue as long as the user hasn't chosen 6

        scanner.close();// [UNDERSTAND] Clean up system resources by closing the scanner object

    }
}