package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Existing method: Add a single DVD
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = disc;
            System.out.println("The disc has been added.");
        } else {
            System.out.println("The cart is full.");
        }
    }

    // New method: Add multiple DVDs using varargs
    public void addDigitalVideoDisc(DigitalVideoDisc... dvds) {
        for (DigitalVideoDisc dvd : dvds) {
            this.addDigitalVideoDisc(dvd);
        }
    }

    // New method: Search by title
    public DigitalVideoDisc searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
                return itemsOrdered[i];
            }
        }
        System.out.println("No DVD found with title: " + title);
        return null;
    }
    
    public DigitalVideoDisc searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getId() == id) {
                return itemsOrdered[i];
            }
        }
        System.out.println("No DVD found with ID: " + id);
        return null;
    }
    //detailed cart display
    public void displayCartDetailed() {
        System.out.println("***********************CART DETAILED***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println("ID: " + dvd.getId());
            System.out.println("Title: " + dvd.getTitle());
            System.out.println("Category: " + dvd.getCategory());
            System.out.println("Director: " + dvd.getDirector());
            System.out.println("Length: " + dvd.getLength() + " minutes");
            System.out.println("Cost: $" + dvd.getCost());
            System.out.println();
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("***********************************************************");
    }
    
    // Update displayCart to improve formatting
    public void displayCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            DigitalVideoDisc dvd = itemsOrdered[i];
            System.out.println((i + 1) + ". DVD - " + dvd.getTitle() + " - " + dvd.getCategory() + 
                " - " + dvd.getDirector() + " - " + dvd.getLength() + " mins: $" + dvd.getCost());
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("***************************************************");
    }

    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        boolean found = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[--qtyOrdered] = null;
                System.out.println("The disc has been removed.");
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("The disc was not found in the cart.");
        }
    }

    public double totalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}