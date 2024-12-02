package hust.soict.dsai;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.*;
import hust.soict.dsai.aims.store.Store;
import java.util.Scanner;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();

    public static void main(String[] args) {
        initializeStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            showMenu();
            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    storeMenu(scanner);
                    break;
                case 2:
                    updateStore(scanner);
                    break;
                case 3:
                    cartMenu(scanner);
                    break;
                case 0:
                    System.out.println("Exiting the program. Thank you for using AIMS!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void initializeStore() {
        store.addMedia(new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95));
        store.addMedia(new Book(2, "Java Programming", "Education", 45.0f));
        store.addMedia(new CompactDisc("Greatest Hits", "Music", "Various Artists", "N/A", 15.99));
        store.addMedia(new DigitalVideoDisc("Star Wars", "Sci-Fi", "George Lucas", 121, 24.95));
    }

    private static int getChoice(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            return -1; // Invalid input
        }
    }

    private static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    private static void storeMenu(Scanner scanner) {
        while (true) {
            store.displayStore();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See media details");
            System.out.println("2. Add media to cart");
            System.out.println("3. Play media");
            System.out.println("4. See current cart");
            System.out.println("0. Back to main menu");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");
            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    mediaDetailsMenu(scanner);
                    break;
                case 2:
                    addMediaToCart(scanner);
                    break;
                case 3:
                    playMedia(scanner);
                    break;
                case 4:
                    cartMenu(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void updateStore(Scanner scanner) {
        while (true) {
            System.out.println("Update Store: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add media to store");
            System.out.println("2. Remove media from store");
            System.out.println("0. Back to main menu");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    addMediaToStore(scanner);
                    break;
                case 2:
                    removeMediaFromStore(scanner);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
            }
        }
    }

    private static void mediaDetailsMenu(Scanner scanner) {
        System.out.print("Enter the title of the media: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            System.out.println(media.toString());
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            System.out.println("2. Play");
            System.out.println("0. Back to store menu");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2");
            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media cannot be played.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Returning to store menu.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    private static void addMediaToCart(Scanner scanner) {
        System.out.print("Enter the title of the media to add: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null) {
            cart.addMedia(media);
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    private static void playMedia(Scanner scanner) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or was not found.");
        }
    }

    private static void cartMenu(Scanner scanner) {
        while (true) {
            cart.displayCartDetailed();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter cart");
            System.out.println("2. Sort cart by title");
            System.out.println("3. Sort cart by cost");
            System.out.println("4. Remove media from cart");
            System.out.println("5. Play a media");
            System.out.println("6. Checkout");
            System.out.println("0. Back to main menu");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5-6");
            int choice = getChoice(scanner);

            switch (choice) {
                case 1:
                    filterCartMenu(scanner);
                    break;
                case 2:
                    cart.sortByTitle();
                    System.out.println("Cart sorted by title.");
                    break;
                case 3:
                    cart.sortByCost();
                    System.out.println("Cart sorted by cost.");
                    break;
                case 4:
                    removeMediaFromCart(scanner);
                    break;
                case 5:
                    playMediaFromCart(scanner);
                    break;
                case 6:
                    checkout();
                    return;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please choose again.");
            }
        }
    }

    private static void filterCartMenu(Scanner scanner) {
        System.out.println("Filter by:");
        System.out.println("1. ID");
        System.out.println("2. Title");
        System.out.println("0. Cancel");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    
        int filterChoice = getChoice(scanner);
    
        switch (filterChoice) {
            case 1:
                filterCartById(scanner);
                break;
            case 2:
                filterCartByTitle(scanner);
                break;
            case 0:
                System.out.println("Cancelled filtering.");
                break;
            default:
                System.out.println("Invalid choice.");
        }
    }
    
    private static void filterCartByTitle(Scanner scanner) {
        System.out.print("Enter a title to filter by: ");
        String titleFilter = scanner.nextLine();
    
        boolean found = false;
        for (Media media : cart.getItems()) {
            if (media != null && media.getTitle().toLowerCase().contains(titleFilter.toLowerCase())) {
                System.out.println(media.toString());
                found = true;
            }
        }
    
        if (!found) {
            System.out.println("No media found with title containing: " + titleFilter);
        }
    }
    
    private static void filterCartById(Scanner scanner) {
        System.out.print("Enter the ID to filter by: ");
        int idFilter = scanner.nextInt();
        scanner.nextLine(); // Consume newline
    
        boolean found = false;
        for (Media media : cart.getItems()) {
            if (media != null && media.getId() == idFilter) {
                System.out.println(media.toString());
                found = true;
                break;
            }
        }
    
        if (!found) {
            System.out.println("No media found with ID: " + idFilter);
        }
    }
    
    private static void addMediaToStore(Scanner scanner) {
        System.out.println("Choose media type to add: ");
        System.out.println("1. Digital Video Disc (DVD)");
        System.out.println("2. Book");
        System.out.println("3. Compact Disc (CD)");
        System.out.println("0. Cancel");
        System.out.print("Your choice: ");
        int type = getChoice(scanner);
    
        switch (type) {
            case 1: // Add DVD
                System.out.print("Enter title: ");
                String dvdTitle = scanner.nextLine();
                System.out.print("Enter category: ");
                String dvdCategory = scanner.nextLine();
                System.out.print("Enter director: ");
                String dvdDirector = scanner.nextLine();
                System.out.print("Enter length (minutes): ");
                int dvdLength = scanner.nextInt();
                System.out.print("Enter cost: ");
                double dvdCost = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                store.addMedia(new DigitalVideoDisc(dvdTitle, dvdCategory, dvdDirector, dvdLength, dvdCost));
                System.out.println("DVD added successfully.");
                break;
    
            case 2: // Add Book
                System.out.print("Enter title: ");
                String bookTitle = scanner.nextLine();
                System.out.print("Enter category: ");
                String bookCategory = scanner.nextLine();
                System.out.print("Enter cost: ");
                float bookCost = scanner.nextFloat();
                scanner.nextLine(); // Consume newline
                Book book = new Book(store.getNextId(), bookTitle, bookCategory, bookCost);
                while (true) {
                    System.out.print("Enter author (or type 'done' to finish): ");
                    String author = scanner.nextLine();
                    if (author.equalsIgnoreCase("done")) break;
                    book.addAuthor(author);
                }
                store.addMedia(book);
                System.out.println("Book added successfully.");
                break;
    
            case 3: // Add CD
                System.out.print("Enter title: ");
                String cdTitle = scanner.nextLine();
                System.out.print("Enter category: ");
                String cdCategory = scanner.nextLine();
                System.out.print("Enter director: ");
                String cdDirector = scanner.nextLine();
                System.out.print("Enter studio: ");
                String cdStudio = scanner.nextLine();
                System.out.print("Enter cost: ");
                double cdCost = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                CompactDisc cd = new CompactDisc(cdTitle, cdCategory, cdDirector, cdStudio, cdCost);
                while (true) {
                    System.out.print("Enter track title (or type 'done' to finish): ");
                    String trackTitle = scanner.nextLine();
                    if (trackTitle.equalsIgnoreCase("done")) break;
                    System.out.print("Enter track length (minutes): ");
                    int trackLength = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    cd.addTrack(new Track(trackTitle, trackLength));
                }
                store.addMedia(cd);
                System.out.println("CD added successfully.");
                break;
    
            case 0: // Cancel
                System.out.println("Cancelled adding media.");
                break;
    
            default:
                System.out.println("Invalid choice.");
        }
    }

    private static void removeMediaFromStore(Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = store.searchByTitle(title);
        if (media != null) {
            store.removeMedia(media);
            System.out.println("Media removed successfully.");
        } else {
            System.out.println("Media not found in the store.");
        }
    }

    private static void removeMediaFromCart(Scanner scanner) {
        System.out.print("Enter the title of the media to remove: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);

        if (media != null) {
            cart.removeMedia(media);
            System.out.println("Media removed from cart.");
        } else {
            System.out.println("Media not found in the cart.");
        }
    }

    private static void playMediaFromCart(Scanner scanner) {
        System.out.print("Enter the title of the media to play: ");
        String title = scanner.nextLine();
        Media media = cart.searchByTitle(title);

        if (media != null && media instanceof Playable) {
            ((Playable) media).play();
        } else {
            System.out.println("This media cannot be played or was not found in the cart.");
        }
    }

    private static void checkout() {
        System.out.println("Checking out...");
        System.out.println("Total cost: $" + cart.totalCost());
        cart.clearCart();
        System.out.println("Thank you for your purchase!");
    }
}
