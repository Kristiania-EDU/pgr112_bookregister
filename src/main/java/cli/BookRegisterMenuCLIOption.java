package cli;

public class BookRegisterMenuCLIOption {
    private String description;
    private IBookRegisterCLIMenuTask task;

    public BookRegisterMenuCLIOption(String description, IBookRegisterCLIMenuTask task) {
        this.description = description;
        this.task = task;
    }

    public IBookRegisterCLIMenuTask getTask() {
        return task;
    }

    @Override
    public String toString() {
        return String.format("%s", description);
    }
}