package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class StoreTest {
    public static void main(String[] args) {
        // Create a new store
        Store store = new Store();

        // Hardcoded DVDs to test
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99);

        // Test adding DVDs
        System.out.println("Adding DVDs to the store...");
        store.addDVD(dvd1); // Add first DVD
        store.addDVD(dvd2); // Add second DVD
        store.addDVD(dvd3); // Add third DVD

        // Test displaying DVDs in the store
        System.out.println("\nDisplaying store inventory:");
        store.displayStore();

        // Test removing a DVD
        System.out.println("\nRemoving 'Star Wars' from the store...");
        store.removeDVD(dvd2);

        // Test displaying DVDs in the store after removal
        System.out.println("\nDisplaying updated store inventory:");
        store.displayStore();
    }
}
