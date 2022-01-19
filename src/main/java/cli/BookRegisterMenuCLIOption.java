package cli;

public class BookRegisterMenuCLIOption {
    private String title;
    private IBookRegisterCLIMenuTask task;

    public BookRegisterMenuCLIOption(String title, IBookRegisterCLIMenuTask task) {
        this.title = title;
        this.task = task;
    }

    public IBookRegisterCLIMenuTask getTask() {
        return task;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return String.format("%s", title);
    }
}