package seedu.bookbuddy.parser.parsercommands;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.book.Rating;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ParserListTest {
    BookList books = new BookList();
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outContent));
        books = new BookList();
        BookListModifier.addBook(books, "Geronimo");
        BookListModifier.addBook(books, "Percy Jackson");

    }

    @AfterEach
    void restoreStreams() {
        System.setOut(originalOut);
    }

    @Test
    void testListAllBooks() {
        String[] inputArray = {"list"};
        ParserList.executeParseList(books, inputArray, "list");
        assertTrue(outContent.toString().contains("Geronimo"));
    }

    @Test
    void testListBooksByRating() {
        String[] inputArray = {"list-rated"};
        // Assuming book ratings are set and expected to be sorted by ratings
        Rating.setRating(books.getBook(2), 5);
        ParserList.executeParseList(books, inputArray, "list-rated");
        String expectedOutput = "_____________\n" +
                "okii added [Geronimo] to the list.\n" +
                "remember to read it soon....\n" +
                "_____________\n" +
                "_____________\n" +
                "okii added [Percy Jackson] to the list.\n" +
                " remember to read it soon....\n" +
                "_____________\n" +
                "Books sorted by rating:\n" +
                "Percy Jackson - 5\n" +
                "Geronimo - Not Rated";

        assertEquals(expectedOutput.trim().replaceAll("\\s+", "|"),
                outContent.toString().trim().replaceAll("\\s+", "|"));
    }
    @Test
    void testListGenres() {
        String[] inputArray = {"list-genre"};
        // Assuming genres are set up
        books.genreList.getAvailableGenres().add("Fiction");
        ParserList.executeParseList(books, inputArray, "list-genre");
        assertTrue(outContent.toString().contains("Fiction"));
    }

}
