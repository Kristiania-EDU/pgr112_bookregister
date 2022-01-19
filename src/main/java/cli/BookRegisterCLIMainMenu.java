package cli;

import register.Book;
import register.BookRegister;

import java.util.ArrayList;
import java.util.Scanner;

public class BookRegisterCLIMainMenu extends BookRegisterCLIMenu {

    public BookRegisterCLIMainMenu(BookRegister bookRegister) {
        super(bookRegister);
    }

    @Override
    protected ArrayList<BookRegisterMenuCLIOption> getOptions() {
        return new ArrayList<>(){
            {
                add(new BookRegisterMenuCLIOption("Overview of all books. ", new BookOverviewTask()));
                add(new BookRegisterMenuCLIOption( "Add a book. ", new AddBookTask()));
                add(new BookRegisterMenuCLIOption( "Modify a book. ", new ModifyBookTask()));
                add(new BookRegisterMenuCLIOption( "Find a books based on genre. ", new FindBooksByGenreTask()));
                add(new BookRegisterMenuCLIOption( "Find a books based on author.", new FindBooksByAuthorTask()));
                add(new BookRegisterMenuCLIOption( "Find a book based on ISBN. ", new FindBookByISBNTask()));
                add(new BookRegisterMenuCLIOption( "Remove a book. ", new RemoveBookTask()));
            }
        };
    }

    private class BookOverviewTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {
            System.out.println(bookRegister.toString());
        }
    }

    private class AddBookTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {
            String isbn = inputStringFromConsole("ISBN", scanner);
            String title = inputStringFromConsole("Title", scanner);
            String author = inputStringFromConsole("Author", scanner);
            String genre = inputStringFromConsole("Genre", scanner);
            int numberOfPages = inputIntegerFromConsole("Number of pages", scanner);

            bookRegister.addBook(new Book(isbn, title, author, numberOfPages, genre));
        }
    }

    private class ModifyBookTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {
            int serialNumber = inputIntegerFromConsole("Serial number", scanner);
            Book book = bookRegister.findSingleFromSerialNumber(serialNumber);

            if(book != null) {
                new ModifyBookCLIMenu(bookRegister, book).execute();
            }
        }
    }

    private class FindBooksByGenreTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {
            String genre = inputStringFromConsole("Search genre", scanner);

        }
    }

    private class FindBooksByAuthorTask implements IBookRegisterCLIMenuTask {

        @Override
        public void execute(Scanner scanner) {

        }
    }

    private class FindBookByISBNTask implements IBookRegisterCLIMenuTask {

        @Override
        public void execute(Scanner scanner) {

        }
    }

    private class RemoveBookTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {

        }
    }
}
