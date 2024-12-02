package hust.soict.dsai.test.media;

import hust.soict.dsai.aims.media.Book;
    public class BookTest {
        public static void main(String[] args) {
        Book book = new Book(1, "OOP Principles", "Programming", 55.0f);

        // Add authors
        book.addAuthor("Author A");
        book.addAuthor("Author B");
        book.addAuthor("Author A"); // Should print: Author already exists

        // Remove authors
        book.removeAuthor("Author A");
        book.removeAuthor("Author C"); // Should print: Author not found

        // Display authors
        System.out.println("Authors: " + book.getAuthors());
}

}
