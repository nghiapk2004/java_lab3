package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;
import java.util.ArrayList;

public class Store {
    private final ArrayList<DigitalVideoDisc> itemsInStore = new ArrayList<>();

    public void addDVD(DigitalVideoDisc dvd) {
        itemsInStore.add(dvd);
        System.out.println("The disc has been added to the store.");
    }

    public void removeDVD(DigitalVideoDisc dvd) {
        if (itemsInStore.remove(dvd)) {
            System.out.println("The disc has been removed from the store.");
        } else {
            System.out.println("The disc was not found in the store.");
        }
    }

    public void displayStore() {
        System.out.println("Store Inventory:");
        for (DigitalVideoDisc dvd : itemsInStore) {
            dvd.displayInfo();
        }
    }
}