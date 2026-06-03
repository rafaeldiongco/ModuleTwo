import java.util.Scanner;

public class TwoDShapeCalculator {
    public static void main(String[] args) {
        // [UNDERSTAND] Set up input so we can read from the keyboard
        Scanner scanner = new Scanner(System.in);
        int choice;
        // [TRACE] Start the menu loop that keeps running until the user wants to quit
        do {
            System.out.println("\nWelcome to the 2D Shapes Calculator App!");
            System.out.println("========================================");
            System.out.println("2D SHAPES CALCULATOR");
            System.out.println("========================================");
            System.out.println("1. Square");
            System.out.println("2. Rectangle");
            System.out.println("3. Circle");
            System.out.println("4. Ellipse");
            System.out.println("5. Triangle");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");


            // [TRACE] Capture the user's menu selection
            choice = scanner.nextInt();
            // [DECISION] Determine which shape logic to run based on the user's choice
            switch (choice) {
                case 1:
                    System.out.print("\nSQUARE:\nEnter side length: ");
                    double s = scanner.nextDouble();
                    Square sq = new Square(s); // [UNDERSTAND] Create object with user input

                    System.out.print("\nDo you want to display the square? (yes/no): ");
                    String displaySq = scanner.next();

                    System.out.println("\nRESULTS:");
                    System.out.println("Shape: Square");
                    System.out.println("Side: " + (int)s);
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
                    Circle circ = new Circle(rad);

                    System.out.print("\nDo you want to display the circle? (yes/no): ");
                    String displayCirc = scanner.next();

                    System.out.println("\nRESULTS:");
                    System.out.println("Shape: Circle");
                    System.out.printf("Area: %.2f%n", circ.calculateArea());
                    System.out.printf("Perimeter: %.2f%n", circ.calculatePerimeter());

                    // [DECISION] Conditional display check
                    if (displayCirc.equalsIgnoreCase("yes") || displayCirc.equalsIgnoreCase("y")) {
                        circ.printCircle();
                    }
                    break;

                case 4:
                    System.out.println("\nELLIPSE:\nEnter semi-major axis (a): ");
                    double a = scanner.nextDouble();
                    System.out.print("Enter semi-minor axis (b): ");
                    double b = scanner.nextDouble();
                    Ellipse ell = new Ellipse(a, b);

                    System.out.print("\nDo you want to display the ellipse? (yes/no): ");
                    String displayEll = scanner.next();

                    System.out.println("\nRESULTS:");
                    System.out.println("Shape: Ellipse");
                    System.out.printf("Area: %.2f%n", ell.calculateArea());
                    System.out.printf("Perimeter: %.2f%n", ell.calculatePerimeter());

                    // [DECISION] Check for visualization request
                    if (displayEll.equalsIgnoreCase("yes") || displayEll.equalsIgnoreCase("y")) {
                        ell.printASCII();
                    }
                    break;

            }



        } while (choice != 6);// [DECISION] Loop condition: continue as long as the user hasn't chosen 6

        scanner.close();// [UNDERSTAND] Clean up memory
    }
}