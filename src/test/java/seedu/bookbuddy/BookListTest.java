package seedu.bookbuddy;

import org.junit.jupiter.api.Test;
import seedu.bookbuddy.bookdetailsmodifier.BookDisplay;
import seedu.bookbuddy.bookdetailsmodifier.BookMark;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;



class BookListTest {
    @Test
    public void sampleTest() {
        assertTrue(true);
    }


    @Test
    void addBook() {
        BookList testBookList = new BookList();
        BookListModifier.addBook(testBookList, "Harry Potter");
        assertEquals(1, testBookList.getSize());
        assertEquals("[U] Harry Potter", testBookList.getBook(1).toString());
    }

    @Test
    void printAllBooks() {
        BookList testBookList = new BookList();
        BookListModifier.addBook(testBookList, "Harry Potter");

        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        BookDisplay.printAllBooks(testBookList);

        String expectedOutput = "___________________________________\n"+
                                "All books:\n1. [U] Harry Potter\n" +
                                "_____________\n";
        String normalizedActualOutput = outContent.toString().replace("\r\n", "\n");
        assertEquals(expectedOutput.trim(), normalizedActualOutput.trim());

        System.setOut(System.out);
    }

    @Test
    void deleteBook() {
        BookList bookList = new BookList();
        BookListModifier.addBook(bookList, "Harry Potter");
        assertEquals(1, bookList.getSize());
        BookListModifier.deleteBook(bookList, 1);
        assertEquals(0, bookList.getSize());
    }

    @Test
    void getBook() {
        BookList bookList = new BookList();
        BookListModifier.addBook(bookList, "Harry Potter");
        BookListModifier.addBook(bookList, "Geronimo");
        BookListModifier.addBook(bookList, "Cradle");
        assertEquals("[U] Cradle", bookList.getBook(3).toString());
    }

    @Test
    void markDoneByIndex() {
        BookList bookList = new BookList();
        BookListModifier.addBook(bookList, "Harry Potter");
        BookMark.markDoneByIndex(bookList, 1);
        assertEquals("[R] Harry Potter", bookList.getBook(1).toString());
    }

    @Test
    void markUndoneByIndex() {
        BookList bookList = new BookList();
        BookListModifier.addBook(bookList, "Harry Potter");
        BookMark.markDoneByIndex(bookList, 1);
        assertEquals("[R] Harry Potter", bookList.getBook(1).toString());
        BookMark.markUndoneByIndex(bookList, 1);
        assertEquals("[U] Harry Potter", bookList.getBook(1).toString());
    }

    //@lordgareth10
    @Test
    void checkDuplicateBookTitle() {
        BookList bookList = new BookList();
        BookListModifier.addBook(bookList, "Harry Potter");
        assertTrue(BookList.checkDuplicateBookTitle(bookList, "Harry Potter"));
    }

}
