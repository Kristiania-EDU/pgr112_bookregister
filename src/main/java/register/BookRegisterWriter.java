package register;

import java.io.*;

public class BookRegisterWriter {
    private File file;

    public BookRegisterWriter(File file) {
        this.file = file;
    }

    public boolean saveBookRegister(BookRegister bookRegister) {
        try {
            PrintWriter printWriter = new PrintWriter(file.getAbsolutePath(), "utf-8");

            for(Book book : bookRegister.all()) {
                printWriter.println(book.getIsbn());
                printWriter.println(book.getTitle());
                printWriter.println(book.getAuthor());
                printWriter.println(book.getNumberOfPages());
                printWriter.println(book.getGenre());
                printWriter.println("---");
            }

            printWriter.flush();
            printWriter.close();

            return true;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return false;
    }
}
