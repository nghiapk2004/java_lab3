package hust.soict.dsai.lab01;
import java.lang.Math;
import java.util.Scanner;

public class EquationSolver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Present menu
        System.out.println("Select the equation to solve:");
        System.out.println("1. First-degree equation with one variable (ax + b = 0)");
        System.out.println("2. System of first-degree equations with two variables");
        System.out.println("3. Second-degree equation with one variable (ax^2 + bx + c = 0)");

        System.out.print("Enter your choice (1-3): ");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                solveLinearEquation(scanner);
                break;
            case 2:
                solveSystemOfEquations(scanner);
                break;
            case 3:
                solveQuadraticEquation(scanner);
                break;
            default:
                System.out.println("Invalid choice.");
        }

        scanner.close();
    }

    // Method to solve ax + b = 0
    public static void solveLinearEquation(Scanner scanner) {
        System.out.println("\nSolving the first-degree equation (ax + b = 0).");

        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        if (a == 0) {
            if (b == 0) {
                System.out.println("The equation has infinitely many solutions.");
            } else {
                System.out.println("The equation has no solution.");
            }
        } else {
            double x = -b / a;
            System.out.println("The solution is x = " + x);
        }
    }

    // Method to solve a system of first-degree equations with two variables
    public static void solveSystemOfEquations(Scanner scanner) {
        System.out.println("\nSolving the system of first-degree equations:");
        System.out.println("a11 * x1 + a12 * x2 = b1");
        System.out.println("a21 * x1 + a22 * x2 = b2");

        System.out.print("Enter coefficient a11: ");
        double a11 = scanner.nextDouble();

        System.out.print("Enter coefficient a12: ");
        double a12 = scanner.nextDouble();

        System.out.print("Enter coefficient b1: ");
        double b1 = scanner.nextDouble();

        System.out.print("Enter coefficient a21: ");
        double a21 = scanner.nextDouble();

        System.out.print("Enter coefficient a22: ");
        double a22 = scanner.nextDouble();

        System.out.print("Enter coefficient b2: ");
        double b2 = scanner.nextDouble();

        // Compute determinants
        double D = a11 * a22 - a21 * a12;
        double D1 = b1 * a22 - b2 * a12;
        double D2 = a11 * b2 - a21 * b1;

        if (D != 0) {
            double x1 = D1 / D;
            double x2 = D2 / D;
            System.out.println("The system has a unique solution:");
            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        } else {
            if (D1 == 0 && D2 == 0) {
                System.out.println("The system has infinitely many solutions.");
            } else {
                System.out.println("The system has no solution.");
            }
        }
    }

    // Method to solve ax^2 + bx + c = 0
    public static void solveQuadraticEquation(Scanner scanner) {
        System.out.println("\nSolving the second-degree equation (ax^2 + bx + c = 0).");

        System.out.print("Enter coefficient a: ");
        double a = scanner.nextDouble();

        System.out.print("Enter coefficient b: ");
        double b = scanner.nextDouble();

        System.out.print("Enter coefficient c: ");
        double c = scanner.nextDouble();

        if (a == 0) {
            System.out.println("Coefficient a is zero. This reduces to a linear equation.");
            // Handle as linear equation bx + c = 0
            if (b == 0) {
                if (c == 0) {
                    System.out.println("The equation has infinitely many solutions.");
                } else {
                    System.out.println("The equation has no solution.");
                }
            } else {
                double x = -c / b;
                System.out.println("The solution is x = " + x);
            }
        } else {
            double delta = b * b - 4 * a * c;
            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("The equation has two distinct real roots:");
                System.out.println("x1 = " + x1);
                System.out.println("x2 = " + x2);
            } else if (delta == 0) {
                double x = -b / (2 * a);
                System.out.println("The equation has a double root:");
                System.out.println("x = " + x);
            } else {
                System.out.println("The equation has no real roots.");
            }
        }
    }
}
