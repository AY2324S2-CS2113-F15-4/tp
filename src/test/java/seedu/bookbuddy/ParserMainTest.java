package seedu.bookbuddy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.bookdetails.BookMark;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;
import seedu.bookbuddy.parser.ParserMain;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ParserMainTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
    }
    @Test
    void testParser() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "Don Quixote");
        BookListModifier.addBook(books, "Gulliver's Travels");
        assertEquals(2, books.getSize());
        BookMark.markDoneByIndex(books, 1);
        assertEquals("[R] Don Quixote", books.getBook(1).toString());
        assertEquals("[U] Gulliver's Travels", books.getBook(2).toString());
        BookListModifier.deleteBook(books, 1);
        BookMark.markDoneByIndex(books, 1);
        assertTrue(books.getBook(1).isRead);
        assertEquals("[R] Gulliver's Travels", books.getBook(1).toString());
    }

    @Test
    void parseAddCommand() {
        BookList testBookList = new BookList();
        ParserMain.parseCommand("add The Great Gatsby", testBookList);
        assertEquals(1, testBookList.getSize());
        assertEquals("The Great Gatsby", testBookList.getBook(1).getTitle());
    }

    @Test
    void parseRemoveCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        ParserMain.parseCommand("remove 1", books);
        assertEquals(0, books.getSize());
    }

    @Test
    void parseMarkCommand() {
        BookList books = new BookList();
        System.out.println(books.getSize());
        BookListModifier.addBook(books, "The Great Gatsby");
        System.out.println(books);
        ParserMain.parseCommand("mark 1", books);
        System.out.println(books);
        BookMark.markDoneByIndex(books, 1);
        assertTrue(books.getBook(1).isRead());
    }

    @Test
    void parseUnmarkCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        ParserMain.parseCommand("mark 1", books);
        ParserMain.parseCommand("unmark 1", books);
        assertFalse(books.getBook(1).isRead());
    }

    @Test
    void parseLabelCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        ParserMain.parseCommand("label 1 Great Book", books);
        assertEquals("Great Book", books.getBook(1).getLabel());
    }

    @Test
    void parseGenreCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        // Simulate user input for genre selection "Classic"
        String simulatedUserInput = "6\nClassic\n"; // Assuming '3' is the option to add a new genre
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ParserMain.parseCommand("set-genre 1", books); // Changed to fit your updated command-handling logic
        assertEquals("Classic", books.getBook(1).getGenre()); // Indexes are typically 0-based in lists

        BookListModifier.addBook(books, "Geronimo");
        String nextSimulatedUserInput = "3\n";
        System.setIn(new ByteArrayInputStream(nextSimulatedUserInput.getBytes()));
        ParserMain.parseCommand("set-genre 2", books);
        assertEquals("Mystery", books.getBook(2).getGenre());
        System.setIn(savedStandardInputStream);
    }

    @Test
    void parseInvalidAddCommandThrowsException() {
        BookList books = new BookList();
        String input = "add"; // No book title provided
        ParserMain.parseCommand(input, books); // Execute the command that should trigger the error message

        String expectedOutput = "The add Command requires a book title";
        assertTrue(outContent.toString().contains(expectedOutput),
                "Expected output message not found in the console output.");
    }

    @Test
    void parseInvalidRemoveCommandPrintsError() {
        // Set up
        BookList books = new BookList();
        String input = "remove notAnIndex";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // Redirect standard out to capture console output
        // Act
        ParserMain.parseCommand(input, books);

        // Assert
        String output = outContent.toString();
        assertTrue(output.contains("not a valid number"), "Error message should contain 'not a valid number'");

        // Cleanup
        System.setOut(System.out); // Reset standard out
    }

    @Test
    void parseUnsupportedCommandThrowsException() {
        BookList books = new BookList();
        String input = "Geronimo Stilton"; // Completely unsupported command
        ParserMain.parseCommand(input, books); // Execute the command
        String expectedMessage = "Sorry but that is not a valid command. Please try again";
        assertTrue(outContent.toString().contains(expectedMessage),
                "Expected message not found in the console output.");
    }
}



