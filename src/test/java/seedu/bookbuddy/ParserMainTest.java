package seedu.bookbuddy;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.book.Author;
import seedu.bookbuddy.book.Genre;
import seedu.bookbuddy.book.Label;
import seedu.bookbuddy.book.Rating;
import seedu.bookbuddy.book.Read;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.bookdetailsmodifier.BookMark;
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
        assertTrue(Read.getRead(books.getBook(1)));
        assertEquals("[R] Gulliver's Travels", books.getBook(1).toString());
    }

    @Test
    void parseInvalidRemoveCommandThrowsException() {
        BookList books = new BookList();
        String input = "remove 1";
        ParserMain.parseCommand(input, books); // Execute the command that should trigger the error message

        String expectedOutput = "Unable to remove book as the list is empty.";
        assertTrue(outContent.toString().contains(expectedOutput),
                "Expected output message not found in the console output.");
    }

    @Test
    void parseInvalidDisplayCommandThrowsException() {
        BookList books = new BookList();
        String input = "display 1";
        ParserMain.parseCommand(input, books); // Execute the command that should trigger the error message

        String expectedOutput = "Unable to display details as the list is empty.";
        assertTrue(outContent.toString().contains(expectedOutput),
                "Expected output message not found in the console output.");
    }

    @Test
    void parseInvalidRemoveIndexThrowsException() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "Don Quixote");
        String input = "remove 2";
        ParserMain.parseCommand(input, books); // Execute the command that should trigger the error message

        String expectedOutput = "Invalid book index. Please enter a valid index";
        assertTrue(outContent.toString().contains(expectedOutput),
                "Expected output message not found in the console output.");
    }

    @Test
    void parseInvalidDisplayIndexThrowsException() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "Don Quixote");
        String input = "display -1";
        ParserMain.parseCommand(input, books); // Execute the command that should trigger the error message

        String expectedOutput = "Invalid book index. Please enter a valid index";
        assertTrue(outContent.toString().contains(expectedOutput),
                "Expected output message not found in the console output.");
    }

    @Test
    void parseAddCommand() {
        BookList testBookList = new BookList();
        ParserMain.parseCommand("add The Great Gatsby", testBookList);
        assertEquals(1, testBookList.getSize());
        assertEquals("The Great Gatsby", Title.getTitle(testBookList.getBook(1)));
    }

    @Test
    void parseListCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "Geronimo Stilton");
        BookListModifier.addBook(books, "Percy Jackson");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ParserMain.parseCommand("list", books);
        String actualOutput = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "___________________________________\nAll books:\n1. [U] The Great Gatsby\n2. " +
                "[U] Geronimo Stilton\n3. [U] Percy Jackson\n_____________\n";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void parseListRatedCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "Geronimo Stilton");
        BookListModifier.addBook(books, "Percy Jackson");

        ParserMain.parseCommand("rate 1 5", books);
        ParserMain.parseCommand("rate 2 3", books);
        ParserMain.parseCommand("rate 3 1", books);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ParserMain.parseCommand("list-rated", books);

        String actualOutput = outContent.toString().replace("\r\n", "\n");
        String expectedOutput = "Books sorted by rating:\n" +
                "The Great Gatsby - 5\n" +
                "Geronimo Stilton - 3\n" +
                "Percy Jackson - 1\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void parseAuthorCommand() {
        BookList testBookList = new BookList();
        ParserMain.parseCommand("add The Great Gatsby", testBookList);
        ParserMain.parseCommand("set-author 1 gareth", testBookList);
        assertEquals(1, testBookList.getSize());
        assertEquals("gareth", Author.getAuthor(testBookList.getBook(1)));
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
        assertTrue(Read.getRead(books.getBook(1)));
    }

    @Test
    void parseUnmarkCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        ParserMain.parseCommand("mark 1", books);
        ParserMain.parseCommand("unmark 1", books);
        assertFalse(Read.getRead(books.getBook(1)));
    }

    @Test
    void parseLabelCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        ParserMain.parseCommand("label 1 Great Book", books);
        assertEquals("Great Book", Label.getLabel(books.getBook(1)));
    }

    @Test
    void parseGenreCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        // Simulate user input for genre selection "Classic"

        int genreSize = books.genreList.getAvailableGenres().size();
        String simulatedUserInput = genreSize + 1 + "\nClassic\n";
        InputStream savedStandardInputStream = System.in;
        System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        ParserMain.parseCommand("set-genre 1", books); // Changed to fit your updated command-handling logic
        assertEquals("Classic", Genre.getGenre(books.getBook(1)));

        BookListModifier.addBook(books, "Geronimo");
        String nextSimulatedUserInput = "3\n";
        System.setIn(new ByteArrayInputStream(nextSimulatedUserInput.getBytes()));
        ParserMain.parseCommand("set-genre 2", books);
        assertEquals("Mystery", Genre.getGenre(books.getBook(2)));
        System.setIn(savedStandardInputStream);

        BookListModifier.addBook(books, "Tom And Jerry");
        ParserMain.parseCommand("set-genre 3 Fantasy", books);
        assertEquals("Fantasy", Genre.getGenre(books.getBook(3)));
    }

    @Test
    void parseRatingCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "Geronimo");
        ParserMain.parseCommand("rate 1 5", books);
        ParserMain.parseCommand("rate 2 3", books);
        assertEquals(5, Rating.getRating(books.getBook(1)));
        assertEquals(3, Rating.getRating(books.getBook(2)));
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
    
    @Test
    void parseFindTitleCommand() {
        // Setup
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "The Great Wall");
        String input = "find-title Great";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // Redirect standard out to capture console output

        // Act
        ParserMain.parseCommand(input, books);

        // Assert
        String output = outContent.toString();
        assertTrue(output.contains("The Great Gatsby"), "Output should contain 'The Great Gatsby'");
        assertTrue(output.contains("The Great Wall"), "Output should contain 'The Great Wall'");

        // Cleanup
        System.setOut(System.out); // Reset standard out
    }
}



