package seedu.bookbuddy.parser.parsercommands.parsegenre;

import exceptions.InvalidCommandArgumentException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.book.Genre;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserGenreTest {
    BookList books = new BookList();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        books = new BookList();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testValidSingleStepGenreSetting() throws Exception {
        BookListModifier.addBook(books, "Geronimo");
        String[] inputArray = {"set-genre", "1 Mystery"};
        ParserGenre.executeParseSetGenre(books, inputArray);
        assertEquals("Mystery", Genre.getGenre(books.getBook(1)));
    }

    @Test
    void testInvalidBookIndex() {
        String[] inputArray = {"set-genre", "2 Mystery"};
        Exception exception = assertThrows(InvalidCommandArgumentException.class, () -> {
            ParserGenre.executeParseSetGenre(books, inputArray);
        });
        assertTrue(exception.getMessage().contains("Invalid book index"));
    }

    @Test
    void testInvalidInputFormat() throws IOException {
        String[] inputArray = {"set-genre", "abc Mystery"};
        ParserGenre.executeParseSetGenre(books, inputArray);
        assertTrue(outContent.toString().contains("Invalid book index format"));
    }

    @Test
    void testValidMultiStepGenreSetting() throws Exception {
        BookListModifier.addBook(books, "Geronimo");
        String genreInput = "1\n";
        System.setIn(new ByteArrayInputStream(genreInput.getBytes()));
        String[] inputArray = {"set-genre", "1"};
        ParserGenre.executeParseSetGenre(books, inputArray);
        assertEquals("Fiction", Genre.getGenre(books.getBook(1)));
    }

    @Test
    void testEmptyInputArray() {
        String[] inputArray = {};
        Exception exception = assertThrows(InvalidCommandArgumentException.class, () -> {
            ParserGenre.executeParseSetGenre(books, inputArray);
        });
        assertTrue(exception.getMessage().contains("The set-genre command requires at least a book index."));
    }

    @Test
    void testBoundaryBookIndexZero() {
        String[] inputArray = {"set-genre", "0 Mystery"};
        Exception exception = assertThrows(InvalidCommandArgumentException.class, () -> {
            ParserGenre.executeParseSetGenre(books, inputArray);
        });
        assertTrue(exception.getMessage().contains("Invalid book index"));
    }

    @Test
    void testBoundaryBookIndexMaxPlusOne() {
        BookListModifier.addBook(books, "Geronimo");
        String[] inputArray = {"set-genre", "2 Mystery"};
        Exception exception = assertThrows(InvalidCommandArgumentException.class, () -> {
            ParserGenre.executeParseSetGenre(books, inputArray);
        });
        assertTrue(exception.getMessage().contains("Invalid book index"));
    }

    @Test
    void testExtraSpacesInInput() throws IOException {
        BookListModifier.addBook(books, "Geronimo");
        String[] inputArray = {"set-genre", "  1    Mystery  "};
        ParserGenre.executeParseSetGenre(books, inputArray);
        assertEquals("Mystery", Genre.getGenre(books.getBook(1)));
    }
}
