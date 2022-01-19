package register;

/**
 * Represents a book.
 * Keeps a serial number for identification in system.
 */
public class Book {
    private static int serialNumberCount = 0;

    private int serialNumber;
    private String isbn;
    private String title;
    private String author;
    private int numberOfPages;
    private String genre;

    public Book(
        String isbn,
        String title,
        String author,
        int numberOfPages,
        String genre) {
        this.serialNumber = ++serialNumberCount;
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.numberOfPages = numberOfPages;
        this.genre = genre;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    @Override
    public String toString() {
        return String.format(
            "Serial number: %d, Title: %s, Author: (%s), Genre: %s, Pages: %d, ISBN: %s",
             getSerialNumber(), getTitle(), getAuthor(), getGenre(), getNumberOfPages(), getIsbn()
        );
    }
}
