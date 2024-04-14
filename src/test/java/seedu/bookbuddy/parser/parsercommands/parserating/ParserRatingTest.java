package seedu.bookbuddy.parser.parsercommands.parserating;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.book.Rating;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserRatingTest {
    BookList books = new BookList();

    @BeforeEach
    void setUp() {
        books = new BookList();
        BookListModifier.addBook(books, "Geronimo");
    }

    @Test
    void testValidInput() {
        String[] inputArray = {"rate", "1 5"};
        ParserRating.executeParseSetRating(books, inputArray);
        assertEquals(5, Rating.getRating(books.getBook(1))); // Assuming Book has getRating method
    }

    @Test
    void testInvalidIndex() {
        String[] inputArray = {"rate", "5 3"};
        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            ParserRating.executeParseSetRating(books, inputArray);
        });
        assertTrue(exception.getMessage().contains("Invalid book index selection"));
    }

    @Test
    void testInvalidRating() {
        String[] inputArray = {"rate", "1 10"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParserRating.executeParseSetRating(books, inputArray);
        });
        assertTrue(exception.getMessage().contains("Rating must be between 1 and 5"));
    }

    @Test
    void testInsufficientArguments() {
        String[] inputArray = {"rate"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            ParserRating.executeParseSetRating(books, inputArray);
        });
        assertTrue(exception.getMessage().contains("The rating command requires a book index."));
    }
}
