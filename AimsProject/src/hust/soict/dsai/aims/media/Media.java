package hust.soict.dsai.aims.media;

public abstract class Media implements Comparable<Media> {
    private int id;
    private String title;
    private String category;
    private double cost;

    // Constructor
    public Media(int id, String title, String category, double cost) {
        this.id = id;
        this.title = title;
        this.category = category;
        this.cost = cost;
    }

    // Getters
    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public double getCost() {
        return cost;
    }

    // Abstract methods
    public abstract void displayInfo();

    @Override
    public abstract String toString();

    // Implement Comparable
    @Override
    public int compareTo(Media other) {
        return this.title.compareToIgnoreCase(other.title); // Sort by title alphabetically
    }
}
