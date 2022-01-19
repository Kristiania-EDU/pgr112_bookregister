package register;

import java.util.ArrayList;
import java.util.function.Predicate;

public class BookRegister {
    private ArrayList<Book> books;

    public BookRegister(ArrayList<Book> books) {
        this.books = books;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public boolean removeBook(String isbn) {
        for(Book book : books) {
            if(book.getIsbn().equalsIgnoreCase(isbn)) {
                books.remove(book);
                return true;
            }
        }

        return false;
    }

    public ArrayList<Book> findFromGenre(String genre) {
        String lowercaseGenre = genre.toLowerCase();

        return filter(book -> {
            return book.getGenre().toLowerCase().contains(lowercaseGenre);
        });
    }

    public ArrayList<Book> findFromAuthor(String author) {
        String lowercaseAuthor = author.toLowerCase();

        return filter(book -> {
            return book.getGenre().toLowerCase().contains(lowercaseAuthor);
        });
    }

    public Book findSingleFromISBN(String isbn) {
        return books.stream()
            .filter(book ->
                book.getIsbn().equalsIgnoreCase(isbn))
            .findFirst()
            .orElse(null);
    }

    public ArrayList<Book> filter(Predicate<Book> predicate) {
        ArrayList<Book> result = new ArrayList<>();

        for(Book book : books) {
            if(predicate.test(book)) {
                result.add(book);
            }
        }

        return result;
    }


    public void Save() {

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        int bookCount = books.size();

        for(int i = 0; i < bookCount; i++) {
            builder.append(books.get(i).toString());

            // Only append new line if it's not the last book
            if(i != bookCount - 1) {
                builder.append("\n");
            }
        }

        return builder.toString();
    }

    public Book findSingleFromSerialNumber(int serialNumber) {
        return books.stream()
            .filter(book ->
                    book.getSerialNumber() == serialNumber)
            .findFirst()
            .orElse(null);
    }
}
