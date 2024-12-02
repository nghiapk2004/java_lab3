package hust.soict.dsai.aims.cart;

import hust.soict.dsai.aims.media.Media;
import java.util.Arrays;
import java.util.List;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private final Media[] itemsOrdered = new Media[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Add a single media item to the cart
    public void addMedia(Media media) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered++] = media;
            System.out.println("The media item has been added: " + media.getTitle());
        } else {
            System.out.println("The cart is full. Cannot add: " + media.getTitle());
        }
    }
    // Sort items by title (default order)
    public void sortByTitle() {
        Arrays.sort(itemsOrdered, 0, qtyOrdered); // Uses Media's compareTo
        System.out.println("Cart items sorted by title.");
    }

    // Sort items by cost
    public void sortByCost() {
        Arrays.sort(itemsOrdered, 0, qtyOrdered, (media1, media2) -> Double.compare(media1.getCost(), media2.getCost()));
        System.out.println("Cart items sorted by cost.");
    }
    // Add multiple media items using varargs
    public void addMedia(Media... mediaItems) {
        for (Media media : mediaItems) {
            addMedia(media);
        }
    }

    // Search by title
    public Media searchByTitle(String title) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getTitle().equalsIgnoreCase(title)) {
                return itemsOrdered[i];
            }
        }
        System.out.println("No media found with title: " + title);
        return null;
    }

    // Search by ID
    public Media searchById(int id) {
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null && itemsOrdered[i].getId() == id) {
                return itemsOrdered[i];
            }
        }
        System.out.println("No media found with ID: " + id);
        return null;
    }

    // Display detailed cart information
    public void displayCartDetailed() {
        System.out.println("***********************CART DETAILED***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            Media media = itemsOrdered[i];
            media.displayInfo();
            System.out.println();
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("***********************************************************");
    }

    // Display cart summary
    public void displayCart() {
        System.out.println("***********************CART***********************");
        System.out.println("Ordered Items:");
        for (int i = 0; i < qtyOrdered; i++) {
            Media media = itemsOrdered[i];
            System.out.println((i + 1) + ". " + media.toString());
        }
        System.out.println("Total cost: $" + totalCost());
        System.out.println("***************************************************");
    }

    // Remove a media item from the cart
    public void removeMedia(Media media) {
        boolean removed = false;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == media) {
                for (int j = i; j < qtyOrdered - 1; j++) {
                    itemsOrdered[j] = itemsOrdered[j + 1];
                }
                itemsOrdered[--qtyOrdered] = null;
                System.out.println("The media item has been removed: " + media.getTitle());
                removed = true;
                break;
            }
        }
        if (!removed) {
            System.out.println("The media item was not found in the cart.");
        }
    }

    // Filter cart by title
    public void filterByTitle(String title) {
        System.out.println("Filtered items by title:");
        for (Media media : itemsOrdered) {
            if (media != null && media.getTitle().toLowerCase().contains(title.toLowerCase())) {
                System.out.println(media.toString());
            }
        }
    }

    public List<Media> getItems() {
        return Arrays.asList(itemsOrdered).subList(0, qtyOrdered);
    }

    // Filter cart by cost range
    public void filterByCost(double minCost, double maxCost) {
        System.out.println("Filtered items by cost range:");
        for (Media media : itemsOrdered) {
            if (media != null && media.getCost() >= minCost && media.getCost() <= maxCost) {
                System.out.println(media.toString());
            }
        }
    }

    // Clear the cart
    public void clearCart() {
        for (int i = 0; i < qtyOrdered; i++) {
            itemsOrdered[i] = null; // Clear each element
        }
        qtyOrdered = 0; // Reset quantity
        System.out.println("Cart cleared.");
    }
    
      
    // Calculate the total cost of all media items
    public double totalCost() {
        double total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}
