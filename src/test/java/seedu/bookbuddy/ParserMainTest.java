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
import seedu.bookbuddy.book.Summary;
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
    void parseInvalidListCommandThrowsException() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "Don Quixote");
        String input = "list 2";
        ParserMain.parseCommand(input, books); // Execute the command that should trigger the error message

        String expectedOutput = "ALl the list commands do not require any further arguments, just type `list`, " +
                "`list-rated`, `list-genre` or `list-by-date`";
        assertTrue(outContent.toString().contains(expectedOutput),
                "Expected output message not found in the console output.");
    }

    @Test
    void parseInvalidListByDateCommandThrowsException() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "Don Quixote");
        String input = "list-by-date 2";
        ParserMain.parseCommand(input, books); // Execute the command that should trigger the error message

        String expectedOutput = "ALl the list commands do not require any further arguments, just type `list`, " +
                "`list-rated`, `list-genre` or `list-by-date`";
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
    void parseFindTitleCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "The Great Gareth");
        BookListModifier.addBook(books, "Percy Jackson");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ParserMain.parseCommand("find-title great", books);

        String actualOutput = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "___________________________________\n" +
                "books with [great] in the title: \n" +
                "1. [U] The Great Gatsby\n" +
                "2. [U] The Great Gareth\n" +
                "_____________\n";

        assertEquals(expectedOutput, actualOutput);
    }
    @Test
    void parseFindGenreFictionCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "Nineteen Eighty-Four");
        BookListModifier.addBook(books, "Percy Jackson");
        BookListModifier.addBook(books, "Brave New World");

        // Set genres for the books
        ParserMain.parseCommand("set-genre 1 Fiction", books);
        ParserMain.parseCommand("set-genre 4 Fiction", books);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ParserMain.parseCommand("find-genre Fiction", books);

        String actualOutput = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "___________________________________\n" +
                "fiction books: \n" +
                "1. [U] The Great Gatsby\n" +
                "2. [U] Brave New World\n" +
                "_____________\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void parseFindLabelCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "The Great Gareth");
        BookListModifier.addBook(books, "Percy Jackson");

        ParserMain.parseCommand("label 1 fantastic", books);
        ParserMain.parseCommand("label 3 fantastic", books);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ParserMain.parseCommand("find-label fantastic", books);

        String actualOutput = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "___________________________________\n" +
                "books with [fantastic] in their label:\n" +
                "1. [U] The Great Gatsby\n" +
                "2. [U] Percy Jackson\n" +
                "_____________\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void parseFindAuthorCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "The Great Gareth");
        BookListModifier.addBook(books, "Percy Jackson");

        ParserMain.parseCommand("set-author 1 joy", books);
        ParserMain.parseCommand("set-author 3 joy", books);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ParserMain.parseCommand("find-author joy", books);

        String actualOutput = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "___________________________________\n" +
                "books written by [joy] :\n" +
                "1. [U] The Great Gatsby\n" +
                "2. [U] Percy Jackson\n" +
                "_____________\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void parseFindReadCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "The Great Gareth");
        BookListModifier.addBook(books, "Percy Jackson");

        // Mark the first and third books as read
        ParserMain.parseCommand("mark 1", books);
        ParserMain.parseCommand("mark 3", books);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ParserMain.parseCommand("find-read", books);

        String actualOutput = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "___________________________________\n" +
                "Read books: \n" +
                "1. [R] The Great Gatsby\n" +
                "2. [R] Percy Jackson\n" +
                "gd job! hope u enjoyed these books \n" +
                "_____________\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void parseFindUnreadCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "The Great Gareth");
        BookListModifier.addBook(books, "Percy Jackson");

        // Mark the second book as read to leave the others as unread
        ParserMain.parseCommand("mark 2", books);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ParserMain.parseCommand("find-unread", books);

        String actualOutput = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "___________________________________\n" +
                "Unread books: \n" +
                "1. [U] The Great Gatsby\n" +
                "2. [U] Percy Jackson\n" +
                "do rmb to read these books soon!\n" +
                "_____________\n";

        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    void parseFindRatedCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "The Great Gareth");
        BookListModifier.addBook(books, "Percy Jackson");

        ParserMain.parseCommand("rate 1 5", books);
        ParserMain.parseCommand("rate 3 5", books);

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        ParserMain.parseCommand("find-rate 5", books);

        String actualOutput = outContent.toString().replace("\r\n", "\n");

        String expectedOutput = "___________________________________\n" +
                "books rated [5] :\n" +
                "1. [U] The Great Gatsby\n" +
                "2. [U] Percy Jackson\n" +
                "_____________\n";

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
    void parseMarkCommandWithSpace() {
        BookList books = new BookList();
        System.out.println(books.getSize());
        BookListModifier.addBook(books, "The Great Gatsby");
        System.out.println(books);
        ParserMain.parseCommand("mark         1", books);
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
    void parseUnmarkCommandWithSpace() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        ParserMain.parseCommand("mark 1", books);
        ParserMain.parseCommand("unmark       1", books);
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
    void parseSummaryCommand() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "Geronimo");
        ParserMain.parseCommand("give-summary 1 boring af", books);
        ParserMain.parseCommand("give-summary 2 torture", books);
        assertEquals("boring af", Summary.getSummary(books.getBook(1)));
        assertEquals("torture", Summary.getSummary(books.getBook(2)));
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



