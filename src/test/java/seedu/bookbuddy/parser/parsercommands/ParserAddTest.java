package seedu.bookbuddy.parser.parsercommands;

import exceptions.InvalidCommandArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.booklist.BookList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserAddTest {
    BookList books = new BookList();

    @BeforeEach
    void setUp() {
        books = new BookList();
    }

    @Test
    void testValidBookAddition() {
        String[] inputArray = {"add", "1984"};
        ParserAdd.executeParseAdd(books, inputArray);
        assertEquals(1, books.getSize());
        assertEquals("1984", Title.getTitle(books.getBook(1))); // Assuming getBookAt() retrieves the book and getTitle() returns its title
    }

    @Test
    void testInsufficientArguments() {
        String[] inputArray = {"add"};
        Exception exception = assertThrows(InvalidCommandArgumentException.class, () -> {
            ParserAdd.executeParseAdd(books, inputArray);
        });
        assertTrue(exception.getMessage().contains("The add Command requires a book title"));
    }
}
