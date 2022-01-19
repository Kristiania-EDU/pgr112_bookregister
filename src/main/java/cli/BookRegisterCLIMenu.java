package cli;

import register.BookRegister;

import java.util.ArrayList;
import java.util.Scanner;

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
}
