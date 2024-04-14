package seedu.bookbuddy.parser.parsercommands.parsegenre;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.booklist.BookList;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

class NewGenreModifierTest {
    BookList books = new BookList();
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        books = new BookList();
        books.genreList.setAvailableGenres(new ArrayList<>());
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testGenreSelectionPrinterEmptyList() {
        NewGenreModifier.genreSelectionPrinter(books);
        String expectedOutput = "Available genres:\n1. Add a new genre\n";
        assertEquals(expectedOutput, outContent.toString());
    }

    @Test
    void testDuplicateCheckerWithNewGenre() {
        String newGenre = "Mystery";
        assertEquals(newGenre, NewGenreModifier.duplicateChecker(newGenre, books));
        assertTrue(books.genreList.getAvailableGenres().contains(newGenre));
    }

    @Test
    void testDuplicateCheckerWithExistingGenre() {
        String existingGenre = "Fantasy";
        books.genreList.getAvailableGenres().add(existingGenre);
        assertEquals(existingGenre, NewGenreModifier.duplicateChecker("fantasy", books));
    }

    @Test
    void testDuplicateCheckerWithNullInput() {
        assertNull(NewGenreModifier.duplicateChecker(null, books));
    }
}