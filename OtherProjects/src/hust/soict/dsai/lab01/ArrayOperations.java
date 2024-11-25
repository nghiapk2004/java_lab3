package hust.soict.dsai.lab01;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperations {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] array;

        System.out.println("Array Operations Program");
        System.out.println("1. Enter array elements manually");
        System.out.println("2. Use a predefined constant array");
        System.out.print("Please select an option (1 or 2): ");

        int option = scanner.nextInt();

        if (option == 1) {
            array = createUserDefinedArray(scanner);
        } else if (option == 2) {
            array = new int[]{5, 3, 8, 1, 2, 9, 4, 7, 6};
            System.out.println("\nUsing predefined array: " + Arrays.toString(array));
        } else {
            System.out.println("Invalid option selected. Exiting program.");
            scanner.close();
            return;
        }

        // Sort the array
        Arrays.sort(array);

        // Calculate sum and average
        int sum = 0;
        for (int num : array) {
            sum += num;
        }
        double average = (double) sum / array.length;

        // Display results
        System.out.println("\nSorted Array: " + Arrays.toString(array));
        System.out.println("Sum of elements: " + sum);
        System.out.printf("Average value: %.2f\n", average);

        scanner.close();
    }

    // Method to create an array based on user input
    public static int[] createUserDefinedArray(Scanner scanner) {
        System.out.print("\nEnter the number of elements in the array: ");
        int n = scanner.nextInt();

        while (n <= 0) {
            System.out.print("Number of elements must be positive. Please enter again: ");
            n = scanner.nextInt();
        }

        int[] array = new int[n];
        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            System.out.printf("Element %d: ", i + 1);
            array[i] = scanner.nextInt();
        }

        return array;
    }
}
