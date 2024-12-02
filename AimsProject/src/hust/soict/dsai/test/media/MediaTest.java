package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;

public class MediaTest {
    public static void main(String[] args) {
        Book book = new Book(1, "OOP Principles", "Programming", 50.0f);
        book.addAuthor("Author A");
        book.addAuthor("Author B");

        System.out.println(book.toString());
    }
}
