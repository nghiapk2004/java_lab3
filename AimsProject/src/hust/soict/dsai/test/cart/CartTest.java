package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();
        // Create some DVDs
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Movie 1");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Movie 2");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Movie 3");

        cart.addDigitalVideoDisc(dvd1);
        cart.addDigitalVideoDisc(dvd2);
        cart.addDigitalVideoDisc(dvd3);

        cart.displayCart();

        cart.removeDigitalVideoDisc(dvd1);
        cart.displayCart();
        // Test search by ID
        System.out.println("Searching for DVD with ID 1:");
        DigitalVideoDisc foundById = cart.searchById(1);
        if (foundById != null) {
            foundById.displayInfo();
        }
        // Test search by title
        System.out.println("Searching for DVD with title 'Movie 2':");
        DigitalVideoDisc foundByTitle = cart.searchByTitle("Movie 2");
        if (foundByTitle != null) {
            foundByTitle.displayInfo();
        }
    }
}