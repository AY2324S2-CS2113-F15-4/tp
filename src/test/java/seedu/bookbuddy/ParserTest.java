package seedu.bookbuddy;

import exceptions.InvalidCommandArgumentException;
import exceptions.UnsupportedCommandException;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class ParserTest {
    @Test
    void testParser() {
        BookList books = new BookList();
        books.addBook("Don Quixote");
        books.addBook("Gulliver's Travels");
        assertEquals(2, books.getSize());
        books.markDoneByIndex(1);
        assertEquals("[R] Don Quixote", books.getBook(1).toString());
        assertEquals("[U] Gulliver's Travels", books.getBook(2).toString());
        books.deleteBook(1);
        books.markDoneByIndex(1);
        assertTrue(books.getBook(1).isRead);
        assertEquals("[R] Gulliver's Travels", books.getBook(1).toString());
    }

    @Test
    void parseAddCommand() {
        BookList testBookList = new BookList();
        Parser.parseCommand("add The Great Gatsby", testBookList);
        assertEquals(1, testBookList.getSize());
        assertEquals("The Great Gatsby", testBookList.getBook(1).getTitle());
    }

    @Test
    void parseRemoveCommand() {
        BookList books = new BookList();
        books.addBook("The Great Gatsby");
        Parser.parseCommand("remove 1", books);
        assertEquals(0, books.getSize());
    }

    @Test
    void parseMarkCommand() {
        BookList books = new BookList();
        System.out.println(books.getSize());
        books.addBook("The Great Gatsby");
        System.out.println(books);
        Parser.parseCommand("mark 1", books);
        System.out.println(books);
        books.markDoneByIndex(1);
        assertTrue(books.getBook(1).isRead());
    }

    @Test
    void parseUnmarkCommand() {
        BookList books = new BookList();
        books.addBook("The Great Gatsby");
        Parser.parseCommand("mark 1", books);
        Parser.parseCommand("unmark 1", books);
        assertFalse(books.getBook(1).isRead());
    }

    @Test
    void parseLabelCommand() {
        BookList books = new BookList();
        books.addBook("The Great Gatsby");
        Parser.parseCommand("label 1 Great Book", books);
        assertEquals("Great Book", books.getBook(1).getLabel());
    }

    @Test
    void parseGenreCommand() {
        BookList books = new BookList();
        books.addBook("The Great Gatsby");
        Parser.parseCommand("set-genre 1 Classic", books);
        assertEquals("Classic", books.getBook(1).getGenre());
    }

    @Test
    void parseInvalidAddCommandThrowsException() {
        BookList books = new BookList();
        String input = "add"; // No book title provided
        assertThrows(InvalidCommandArgumentException.class,
                () -> Parser.parseCommand(input, books), "The add command requires a book title.");
    }

    @Test
    void parseInvalidRemoveCommandPrintsError() {
        // Set up
        BookList books = new BookList();
        String input = "remove notAnIndex";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent)); // Redirect standard out to capture console output
        // Act
        Parser.parseCommand(input, books);

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
        assertThrows(UnsupportedCommandException.class,
                () -> Parser.parseCommand(input, books), "Sorry but that is not a valid command. Please try again");
    }
}



