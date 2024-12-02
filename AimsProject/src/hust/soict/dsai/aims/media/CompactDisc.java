package hust.soict.dsai.aims.media;

import java.util.ArrayList;

public class CompactDisc extends Disc implements Playable {
    private String artist;
    private ArrayList<Track> tracks;

    // Constructor
    public CompactDisc(String title, String category, String artist, String director, double cost) {
        super(0, title, category, cost, director, 0);
        this.artist = artist;
        this.tracks = new ArrayList<>();
    }

    // Getters
    public String getArtist() {
        return artist;
    }

    // Methods to manage tracks
    public void addTrack(Track track) {
        if (!tracks.contains(track)) {
            tracks.add(track);
        } else {
            System.out.println("Track already exists: " + track.getTitle());
        }
    }

    public void removeTrack(Track track) {
        if (tracks.contains(track)) {
            tracks.remove(track);
        } else {
            System.out.println("Track not found: " + track.getTitle());
        }
    }

    public int getLength() {
        return tracks.stream().mapToInt(Track::getLength).sum();
    }
    
    @Override
    public void displayInfo() {
        System.out.println("CD - Title: " + getTitle());
        System.out.println("Category: " + getCategory());
        System.out.println("Artist: " + getArtist());
        System.out.println("Director: " + getDirector());
        System.out.println("Cost: $" + getCost());
        System.out.println("Tracks:");
        for (Track track : tracks) {
            track.play();
        }
    }
    
    @Override
    public void play() {
        if (tracks.isEmpty()) {
            System.out.println("No tracks to play on CD: " + getTitle());
        } else {
            System.out.println("Playing CD: " + getTitle());
            System.out.println("Artist: " + artist);
            for (Track track : tracks) {
                track.play(); // Call the play() method of each Track
            }
        }
    }

    @Override
    public String toString() {
        return "CD - Title: " + getTitle() +
               ", Category: " + getCategory() +
               ", Artist: " + artist +
               ", Director: " + getDirector() +
               ", Total Length: " + getLength() + " minutes" +
               ", Cost: $" + getCost();
    }
}
