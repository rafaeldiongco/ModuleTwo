import java.util.Scanner;

public class TwoDShapeCalculator {
    public static void main(String[] args) {
        // [UNDERSTAND] Set up input so we can read from the keyboard
        Scanner scanner = new Scanner(System.in);
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
                    IO.print("Area: %.2f%n", sq.calculateArea());
                    IO.print("Perimeter: %.2f%n", sq.calculatePerimeter());

                    // [DECISION] Validate user preference to trigger optional visualization method
                    if (displaySq.equalsIgnoreCase("yes") || displaySq.equalsIgnoreCase("y")) {
                        sq.printSquare();
                    }
                    break;

            }


        } while (choice != 6);// [DECISION] Loop condition: continue as long as the user hasn't chosen 6

        scanner.close();// [UNDERSTAND] Clean up memory
    }
}