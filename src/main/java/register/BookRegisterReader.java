package register;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class BookRegisterReader {
    private File file;

    public BookRegisterReader(File file) {
        this.file = file;
    }

    public BookRegister loadBookRegister() throws FileNotFoundException {
        Scanner scanner = new Scanner(file);

        ArrayList<Book> books = new ArrayList<>();

        while(scanner.hasNext()) {
            String isbn = scanner.nextLine();
            String title = scanner.nextLine();
            String author = scanner.nextLine();
            String numberOfPagesStr = scanner.nextLine();
            String genre = scanner.nextLine();
            scanner.nextLine(); // Read ---- line

            books.add(new Book(
                    isbn,
                    title,
                    author,
                    Integer.parseInt(numberOfPagesStr),
                    genre
            ));
        }

        return new BookRegister(books);
    }
}
