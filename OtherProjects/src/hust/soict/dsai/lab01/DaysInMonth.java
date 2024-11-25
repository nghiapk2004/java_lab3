package hust.soict.dsai.lab01;
import java.util.Scanner;

public class DaysInMonth {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int month = -1;
        int year = -1;

        while (true) {
            // Get valid month
            System.out.print("Enter month: ");
            String monthInput = scanner.nextLine().trim();

            month = parseMonth(monthInput);
            if (month == -1) {
                System.out.println("Invalid month. Please try again.\n");
                continue;
            }

            // Get valid year
            System.out.print("Enter year: ");
            String yearInput = scanner.nextLine().trim();

            year = parseYear(yearInput);
            if (year == -1) {
                System.out.println("Invalid year. Please try again.\n");
                continue;
            }

            // Both month and year are valid
            break;
        }

        int days = getNumberOfDays(month, year);
        System.out.println("\nNumber of days: " + days);

        scanner.close();
    }

    // Method to parse month input and return month number (1-12), or -1 if invalid
    public static int parseMonth(String input) {
        input = input.trim().toLowerCase();

        // Remove trailing period if present
        if (input.endsWith(".")) {
            input = input.substring(0, input.length() - 1);
        }

        // Try to parse input as integer
        try {
            int monthNumber = Integer.parseInt(input);
            if (monthNumber >= 1 && monthNumber <= 12) {
                return monthNumber;
            } else {
                return -1;
            }
        } catch (NumberFormatException e) {
            // Not a number, continue to check names
        }

        // List of full month names and abbreviations
        String[] fullMonthNames = {
            "january", "february", "march", "april", "may", "june",
            "july", "august", "september", "october", "november", "december"
        };

        String[] monthAbbr = {
            "jan", "feb", "mar", "apr", "may", "jun",
            "jul", "aug", "sep", "oct", "nov", "dec"
        };

        // Check if input matches any full month name
        for (int i = 0; i < fullMonthNames.length; i++) {
            if (input.equals(fullMonthNames[i])) {
                return i + 1;
            }
        }

        // Check if input matches any abbreviation
        for (int i = 0; i < monthAbbr.length; i++) {
            if (input.equals(monthAbbr[i])) {
                return i + 1;
            }
        }

        // Invalid month input
        return -1;
    }

    // Method to parse year input and return year as integer, or -1 if invalid
    public static int parseYear(String input) {
        input = input.trim();

        // Check if input contains only digits
        if (!input.matches("\\d+")) {
            return -1;
        }

        // Parse year
        try {
            int year = Integer.parseInt(input);
            if (year >= 0) {
                return year;
            } else {
                return -1;
            }
        } catch (NumberFormatException e) {
            // Should not occur due to regex check, but handle just in case
            return -1;
        }
    }

    // Method to determine if a year is a leap year
    public static boolean isLeapYear(int year) {
        if (year % 4 != 0) {
            return false;
        } else if (year % 100 != 0) {
            return true;
        } else {
            return (year % 400 == 0);
        }
    }

    // Method to get number of days in a month for a given year
    public static int getNumberOfDays(int month, int year) {
        int days;

        switch (month) {
            case 2: // February
                days = isLeapYear(year) ? 29 : 28;
                break;
            case 4: // April
            case 6: // June
            case 9: // September
            case 11: // November
                days = 30;
                break;
            default:
                days = 31;
        }

        return days;
    }
}
