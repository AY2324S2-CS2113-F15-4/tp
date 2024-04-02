package seedu.bookbuddy;

import org.junit.jupiter.api.Test;
import seedu.bookbuddy.bookdetails.BookGenre;
import seedu.bookbuddy.bookdetails.BookLabel;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookDetailsTest {
    @Test
    public void testSetBookLabelByIndex() {
        BookList books = new BookList();
        books.addBook("The Great Gatsby");
        books.addBook("Geronimo Stilton");
        BookLabel.setBookLabelByIndex(1, "Great Classic", books);
        assertEquals("Great Classic" ,books.getBook(1).getLabel());
        BookLabel.setBookLabelByIndex(2, "Great Classic", books);
        assertEquals("Great Classic" ,books.getBook(2).getLabel());
    }

    @Test
    public void testSetBookGenreByIndex() {
        BookList books = new BookList();
        books.addBook("The Great Gatsby");
        books.addBook("Geronimo Stilton");
        BookGenre.setBookGenreByIndex(1, "Classic", books);
        assertEquals("Classic" ,books.getBook(1).getGenre());
        BookGenre.setBookGenreByIndex(2, "Fantasy", books);
        assertEquals("Fantasy" ,books.getBook(2).getGenre());
    }
}
