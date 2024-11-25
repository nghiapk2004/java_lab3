package hust.soict.dsai;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        // Create a new Cart
        Cart cart = new Cart();

        // Create new DVDs and add them to the cart
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        cart.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95);
        cart.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99);
        cart.addDigitalVideoDisc(dvd3);

        // Display the cart's contents in normal format
        System.out.println("Displaying cart contents (Normal):");
        cart.displayCart();

        // Display the cart's contents in detailed format
        System.out.println("\nDisplaying cart contents (Detailed):");
        cart.displayCartDetailed();
        // Search for DVD by ID
        int searchId = 1; // Hardcoded ID to search
        System.out.println("\nSearching for DVD with ID: " + searchId);
        DigitalVideoDisc foundById = cart.searchById(searchId);
        if (foundById != null) {
            System.out.println("DVD found by ID:");
            foundById.displayInfo();
        }

        // Search for DVD by title
        String searchTitle = "The Lion King"; // Hardcoded title to search
        System.out.println("\nSearching for DVD with title: \"" + searchTitle + "\"");
        DigitalVideoDisc foundByTitle = cart.searchByTitle(searchTitle);
        if (foundByTitle != null) {
            System.out.println("DVD found by title:");
            foundByTitle.displayInfo();
        }
        // Play a DVD demo
        System.out.println("Playing a DVD demo:");
        dvd1.play();

        // Remove a DVD from the cart and display the updated cart
        cart.removeDigitalVideoDisc(dvd2);
        cart.displayCart();

        // Try to play a DVD with invalid length
        DigitalVideoDisc dvd4 = new DigitalVideoDisc("Invalid DVD", "Unknown", "No Director", 0, 0);
        dvd4.play();
    }
}
