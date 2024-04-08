package seedu.bookbuddy.booklist;

import seedu.bookbuddy.book.BookMain;
import seedu.bookbuddy.Ui;

import java.util.Arrays;
import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

public class BookListModifier {

    //@@author joshuahoky
    public static void addBookFromFile(BookList bookList, String inputArray) {
        String[] bookDetails = inputArray.split(" \\| ");
        LOGGER.log(Level.INFO, "bookDetails: {0}", Arrays.toString(bookDetails));
        String title = bookDetails[0];
        int status = Integer.parseInt(bookDetails[1]);
        String label = bookDetails[2];
        String genre = bookDetails[3];
        int rating = Integer.parseInt(bookDetails[4]);
        String summary = bookDetails[5];
        String date_time = bookDetails[6];
        bookList.books.add(new BookMain(title, status, label, genre, rating, summary, date_time));
    }

    //@@author
    /**
     * Adds a new Book to the list.
     *
     * @param bookList The bookList arraylist
     * @param title The title of the book.
     */
    public static void addBook(BookList bookList, String title) {
        try {
            bookList.books.add(new BookMain(title));
            Ui.addBookMessage(title);
            assert !bookList.books.isEmpty() : "Book list should not be empty after adding a book";
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    /**
     * Deletes a book from the list by its index.
     *
     * @param bookList
     * @param index The index of the book to delete.
     */
    public static void deleteBook(BookList bookList, int index) throws IndexOutOfBoundsException {
        try {
            Ui.removeBookMessage(index, bookList);
            bookList.books.remove(index - 1);
            assert bookList.books.size() >= 0 : "Book list size should not be negative after deletion";
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid book index. Please enter a valid index");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }
}
