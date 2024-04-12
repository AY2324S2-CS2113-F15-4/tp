package seedu.bookbuddy.booklist;

import seedu.bookbuddy.book.BookMain;
import seedu.bookbuddy.Ui;

import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

public class BookListModifier {

    //@@author joshuahoky
    public static void addBookFromFile(BookList bookList, String inputArray, int lineNumber) {
        try {
            String[] bookDetails = inputArray.split(" \\| ");
            String title = bookDetails[0].trim();
            String author = bookDetails[1].trim();
            int status = Integer.parseInt(bookDetails[2].trim());
            String dateTimeRead = bookDetails[3].trim();
            String label = bookDetails[4].trim();
            String genre = bookDetails[5].trim();
            String summary = bookDetails[6].trim();
            int rating = Integer.parseInt(bookDetails[7].trim());
            bookList.books.add(new BookMain(title, status, label, genre, rating, summary,
                    dateTimeRead, lineNumber, author));
        } catch (Exception e) {
            System.out.println("Unable to load book data from line " + lineNumber + " in books.txt " +
                    "as data is corrupted.");
        }
    }

    /**
     * Deletes a book from the list by its index.
     *
     * @param bookList The bookList arrayList.
     * @param index The index of the book to delete.
     */
    public static void deleteBook(BookList bookList, int index) throws IndexOutOfBoundsException {
        try {
            if (bookList.getBooks().isEmpty()) {
                System.out.println("Unable to remove book as the list is empty.");
            } else {
                Ui.removeBookMessage(index, bookList);
                bookList.books.remove(index - 1);
                assert bookList.books.size() >= 0 : "Book list size should not be negative after deletion";
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid book index. Please enter a valid index");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    //@@author
    /**
     * Adds a new Book to the list.
     *
     * @param bookList The bookList arraylist.
     * @param title The title of the book.
     */
    public static void addBook(BookList bookList, String title) {
        try {
            if (BookList.checkDuplicateBookTitle(bookList, title)) {
                bookList.books.add(new BookMain(title));
                Ui.printDuplicateBookWarning(title);
            } else {
                bookList.books.add(new BookMain(title));
                Ui.addBookMessage(title);
            }
            assert !bookList.books.isEmpty() : "Book list should not be empty after adding a book";
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

}
