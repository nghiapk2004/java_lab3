package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class TestStore {
    public static void main(String[] args) {
        Store store = new Store();

        // Add media to the store
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95));
        store.addMedia(new Book(2, "Java Programming", "Education", 45.0f));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 121, 24.95));
        store.addMedia(new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99));

        // Sort by title and display
        System.out.println("Before sorting by title:");
        store.displayStore();
        store.sortByTitle();
        System.out.println("After sorting by title:");
        store.displayStore();

        // Sort by cost and display
        System.out.println("After sorting by cost:");
        store.sortByCost();
        store.displayStore();
    }
}
