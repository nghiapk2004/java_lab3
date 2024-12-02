package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.*;

public class TestPlayable {
    public static void main(String[] args) {
        // Create DigitalVideoDisc
        DigitalVideoDisc dvd = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95);
        
        // Play DVD
        dvd.play();

        // Create CompactDisc
        CompactDisc cd = new CompactDisc("Greatest Hits", "Music", "Various Artists", "N/A", 15.99);

        // Add Tracks
        cd.addTrack(new Track("Song A", 3));
        cd.addTrack(new Track("Song B", 4));
        cd.addTrack(new Track("Song C", 5));

        // Play CD
        cd.play();
    }
}
