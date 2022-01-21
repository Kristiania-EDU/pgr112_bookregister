import cli.BookRegisterCLIMainMenu;
import register.BookRegister;
import register.BookRegisterReader;
import register.BookRegisterWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.Scanner;

/**
* Author: Sebastian Nordby
* Kristiania-class: PGR112 - Object Oriented Programming
*/
public class Program {
    public static void main(String[] args) throws FileNotFoundException {
        File bookRegisterTextFile = new File("src/bookregister.txt");
        BookRegisterReader bookRegisterReader = new BookRegisterReader(bookRegisterTextFile);
        BookRegister bookRegister = bookRegisterReader.loadBookRegister();
        BookRegisterCLIMainMenu cli = new BookRegisterCLIMainMenu(bookRegister);
        boolean shouldRun;

        do {
            shouldRun = cli.execute();
        } while(shouldRun);

        System.out.print("Would you like to save your changes(Yes or No): ");
        String save = new Scanner(System.in).nextLine();

        if(save.toLowerCase().startsWith("y")) {
            BookRegisterWriter bookRegisterWriter = new BookRegisterWriter(bookRegisterTextFile);

            if(bookRegisterWriter.saveBookRegister(bookRegister)) {
                System.out.println("Bookregister successfully saved.");
            }
        }

        System.out.println("---------------------BOOKREGISTER END---------------------");
    }
}
