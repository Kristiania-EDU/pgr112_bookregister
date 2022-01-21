package register;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class BookTest {
    @Test
    public void testBook() {
        Book book = new Book("1234", "Test Book", "Sebastian Nordby",
            222, "Programming - iT");

        assertTrue(book.getIsbn().equals("1234"));
    }
}
