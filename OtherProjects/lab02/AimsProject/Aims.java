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

        // Display the cart's contents
        cart.displayCart();

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
