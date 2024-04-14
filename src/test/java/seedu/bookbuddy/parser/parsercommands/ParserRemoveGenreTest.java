package seedu.bookbuddy.parser.parsercommands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.booklist.BookList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserRemoveGenreTest {
    BookList books = new BookList();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    @BeforeEach
    void setUp() {
        books = new BookList();
        // To add 3 genres to the arraylist in addition to the default
        for (int i = 1; i <= 3; i++) {
            books.genreList.getAvailableGenres().add("Genre " + i);
        }
        System.setOut(new PrintStream(outContent));
    }
    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testValidGenreRemoval() {
        String[] inputArray = {"remove-genre", "6"};
        ParserRemoveGenre.executeParseRemove(books, inputArray);
        assertFalse(books.genreList.getAvailableGenres().contains("Genre 1"));
    }

    @Test
    void testNonNumericIndex() {
        String[] inputArray = {"remove-genre", "abc"};
        ParserRemoveGenre.executeParseRemove(books, inputArray);
        String expectedOutput = "abc is not a valid index format";
        assertTrue(outContent.toString().contains(expectedOutput));
    }
    @Test
    void testIndexOutOfBounds() {
        String[] inputArray = {"remove-genre", "11"};
        ParserRemoveGenre.executeParseRemove(books, inputArray);
        String expectedOutput = "Genre list is out of bounds";
        assertTrue(outContent.toString().contains(expectedOutput));
    }

}
