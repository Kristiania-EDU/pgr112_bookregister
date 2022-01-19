package cli;

import register.BookRegister;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.function.Consumer;
import java.util.function.Function;

import static cli.CLIColorCodes.*;

public abstract class BookRegisterCLIMenu {
    protected BookRegister bookRegister;
    protected ArrayList<BookRegisterMenuCLIOption> options;

    public BookRegisterCLIMenu(BookRegister bookRegister) {
        this.bookRegister = bookRegister;
        this.options = getOptions();
    }

    protected abstract ArrayList<BookRegisterMenuCLIOption> getOptions();

    public boolean execute() {
        for(int i = 0; i < options.size(); i++) {
            BookRegisterMenuCLIOption option = options.get(i);

            System.out.printf("%d. %s\n", i + 1, option.toString());
        }

        return promptAndHandleOption();
    }

    private boolean promptAndHandleOption() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("BookRegister(-1 to quit)> ");
        int optionNumber = inputInteger(scanner);
        int optionArrayIndex = optionNumber - 1;

        if(optionNumber != -1 && optionArrayIndex < options.size()) {
            BookRegisterMenuCLIOption option = options.get(optionArrayIndex);

            if(option != null) {
                printHeaderLine(option.getTitle());
                option.getTask().execute(scanner);
            }
        }

        return optionNumber != -1;
    }

    protected String inputStringFromConsole(String prompt, Scanner scanner) {
        System.out.print(String.format("%s: ", prompt));

        return scanner.nextLine();
    }

    protected int inputIntegerFromConsole(String prompt, Scanner scanner) {
        System.out.print(String.format("%s: ", prompt));

        return inputInteger(scanner);
    }

    private int inputInteger(Scanner scanner) {
        int option = 0;

        try {
            option = Integer.parseInt(scanner.nextLine());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        return option;
    }

    public void printHeaderLine(String text) {
        System.out.printf("%s--------------------%s--------------------\n%s", TEXT_GREEN, text, TEXT_RESET);
    }

    public void colorTextContainer(Runnable method, String color) {
        System.out.print(color);
        method.run();
        System.out.print(TEXT_RESET);
    }
}
