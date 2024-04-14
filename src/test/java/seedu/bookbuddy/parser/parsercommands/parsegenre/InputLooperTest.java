package seedu.bookbuddy.parser.parsercommands.parsegenre;

import exceptions.InvalidInputException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;

import java.util.ArrayList;
import java.util.List;


import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;


class InputLooperTest {
    private InputLooper inputLooper;
    BookList books = new BookList();
    Scanner scanner = new Scanner(System.in);

    @BeforeEach
    void setUp() {
        inputLooper = new InputLooper();
        books = new BookList();
        scanner = new Scanner(System.in);
    }

    @Test
    void testValidSelection() throws Exception {
        String input = "1";
        scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));
        String result = inputLooper.processSelection(input, scanner, books);
        assertEquals("Fiction", result);
    }

    @Test
    void testInvalidSelection() {
        String input = "20"; // Beyond available genres size
        scanner = new Scanner(new ByteArrayInputStream(input.getBytes()));

        Exception exception = assertThrows(InvalidInputException.class, () -> {
            inputLooper.processSelection(input, scanner, books);
        });

        assertTrue(exception.getMessage().contains("is an invalid selection"));
    }

    @Test
    void testEmptyInputHandling() throws Exception {
        String input = "\n\n1";
        ByteArrayInputStream bais = new ByteArrayInputStream(input.getBytes());
        Scanner scanner = new Scanner(bais);
        books.genreList.setAvailableGenres(new ArrayList<>(List.of("Fiction")));
        assertEquals("", inputLooper.inputLooper("", scanner, books));
    }

    @Test
    void testExitCommand() throws Exception {
        String input = "exit\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        assertNull(inputLooper.inputLooper(null, scanner, books));
    }

    @Test
    void testByeCommand() throws Exception {
        String input = "bye\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        assertNull(inputLooper.inputLooper(null, scanner, books));
    }

    @Test
    void testSetGenreToFiction() throws Exception {
        String input = "1\n";
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        Scanner scanner = new Scanner(System.in);

        assertEquals("Fiction", inputLooper.inputLooper(null, scanner, books));
    }
    @Test
    void testAddNewGenre() throws Exception {
        String initialInput = "3";
        String genreInput = "Mystery";
        String combinedInput = genreInput + "\n";
        System.setIn(new ByteArrayInputStream(combinedInput.getBytes()));
        Scanner scanner = new Scanner(System.in);
        books.genreList.setAvailableGenres(new ArrayList<>(List.of("Fantasy", "Science Fiction")));
        assertEquals("Mystery", inputLooper.processSelection(initialInput, scanner, books));
        assertTrue(books.genreList.getAvailableGenres().contains("Mystery"));
    }

    @Test
    void setGenreBookSelectIndexOutOfBounds() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "Don Quixote");
        try {
            ParserGenre.executeParseSetGenre(books, new String[]{"set-genre", "1"});
            fail();
        } catch (Exception ignored) {
        }
        try {
            ParserGenre.executeParseSetGenre(books, new String[]{"set-genre", "-1"});
            fail();
        } catch (Exception ignored) {
        }
    }


}

