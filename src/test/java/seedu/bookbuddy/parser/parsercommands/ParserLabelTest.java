package seedu.bookbuddy.parser.parsercommands;

import exceptions.BookNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.book.Label;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserLabelTest {
    BookList books = new BookList();

    @BeforeEach
    void setUp() {
        books = new BookList();
        BookListModifier.addBook(books, "Geronimo");
    }

    @Test
    void testValidLabelSetting() {
        String[] inputArray = {"label", "1 Good Book"};
        ParserLabel.executeParseSetLabel(books, inputArray);
        assertEquals("Good Book", Label.getLabel(books.getBook(1)));
    }

    @Test
    void testInvalidIndexNonNumeric() {
        String[] inputArray = {"label", "abc haha"};
        Exception exception = assertThrows(BookNotFoundException.class, () -> {
            ParserLabel.executeParseSetLabel(books, inputArray);
        });
        assertTrue(exception.getMessage().contains("Book index out of range."));
    }

    @Test
    void testInvalidIndexOutOfRange() {
        String[] inputArray = {"label", "2 haha"};
        Exception exception = assertThrows(BookNotFoundException.class, () -> {
            ParserLabel.executeParseSetLabel(books, inputArray);        });
        assertTrue(exception.getMessage().contains("Book index out of range"));
    }

}
