import cli.BookRegisterCLIMainMenu;
import register.BookRegister;
import register.BookRegisterReader;
import java.io.File;
import java.io.FileNotFoundException;

public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        BookRegisterReader bookRegisterReader = new BookRegisterReader(new File("C:\\IdeaProjects\\MyBookRegister\\src\\main\\java\\bookregister.txt"));
        BookRegister bookRegister = bookRegisterReader.loadBookRegister();
        BookRegisterCLIMainMenu cli = new BookRegisterCLIMainMenu(bookRegister);
        boolean shouldRun;

        do {
            shouldRun = cli.execute();
        } while(shouldRun);
    }
}
