package cli;

import register.Book;
import register.BookRegister;
import java.util.ArrayList;
import java.util.Scanner;

public class ModifyBookCLIMenu extends BookRegisterCLIMenu {
    private final Book bookToModify;

    public ModifyBookCLIMenu(BookRegister bookRegister, Book bookToModify) {
        super(bookRegister);

        if(bookToModify == null) {
            throw new IllegalArgumentException("Cannot execute book modify menu when book is null");
        }

        this.bookToModify = bookToModify;
    }

    @Override
    protected ArrayList<BookRegisterMenuCLIOption> getOptions() {
        return new ArrayList<>(){
            {
                add(new BookRegisterMenuCLIOption("Change ISBN. ", new ChangeISBNTask()));
                add(new BookRegisterMenuCLIOption( "Change title. ", new ChangeTitleTask()));
                add(new BookRegisterMenuCLIOption( "Change author. ", new ChangeAuthorTask()));
                add(new BookRegisterMenuCLIOption( "Change number of pages.", new ChangeNumberOfPagesTask()));
                add(new BookRegisterMenuCLIOption( "Change genre.", new ChangeGenreTask()));
            }
        };
    }

    @Override
    public boolean execute() {
        System.out.println("-------MODIFY BOOK-------");
        System.out.println(bookToModify.toString());
        System.out.println("-------------------------");

        return super.execute();
    }

    private class ChangeISBNTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {
            String newISBN = inputStringFromConsole("New ISBN", scanner);
            bookToModify.setIsbn(newISBN);
        }
    }

    private class ChangeTitleTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {
            String newTitle = inputStringFromConsole("New title", scanner);
            bookToModify.setTitle(newTitle);
        }
    }

    private class ChangeAuthorTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {
            String newAuthor = inputStringFromConsole("New author", scanner);
            bookToModify.setAuthor(newAuthor);
        }
    }

    private class ChangeNumberOfPagesTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {
            int newNumberOfPages = inputIntegerFromConsole("New number of pages", scanner);
            bookToModify.setNumberOfPages(newNumberOfPages);
        }
    }

    private class ChangeGenreTask implements IBookRegisterCLIMenuTask {
        @Override
        public void execute(Scanner scanner) {
            String newGenre = inputStringFromConsole("New genre", scanner);
            bookToModify.setGenre(newGenre);
        }
    }
}
