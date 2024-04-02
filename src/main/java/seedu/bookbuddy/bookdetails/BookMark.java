package seedu.bookbuddy.bookdetails;

import exceptions.BookReadAlreadyException;
import exceptions.BookUnreadAlreadyException;
import seedu.bookbuddy.booklist.BookList;

import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

public class BookMark {

    //@@author lordgareth10
    /**
     * Marks a book as read by its index.
     *
     * @param bookList
     * @param index The index of the book to mark as read.
     */
    public static void markDoneByIndex(BookList bookList, int index) throws IndexOutOfBoundsException, BookReadAlreadyException {
        try {
            assert index > 0 && index <= bookList.getBooks().size() : "Index out of valid range";
            if (bookList.getBooks().get(index - 1).isRead()) {
                throw new BookReadAlreadyException("That book is already marked as read!");
            }
            assert !bookList.getBooks().get(index - 1).isRead() : "Book is already marked as read";
            bookList.getBooks().get(index - 1).markBookAsRead();
            assert bookList.getBooks().get(index - 1).isRead() : "Book should be marked as read";
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid book index. Please enter a valid index");
        } catch (BookReadAlreadyException e) {
            System.out.println("That book is already marked as read!");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    //@@author lordgareth10
    /**
     * Marks a book as unread by its index.
     *
     * @param bookList
     * @param index The index of the book to mark as unread.
     */
    public static void markUndoneByIndex(BookList bookList, int index) throws IndexOutOfBoundsException, BookReadAlreadyException{
        try {
            assert index > 0 && index <= bookList.getBooks().size() : "Index out of valid range";
            if (!bookList.getBooks().get(index - 1).isRead()) {
                throw new BookUnreadAlreadyException("That book is already marked as unread!");
            }
            assert bookList.getBooks().get(index - 1).isRead() : "Book is already marked as unread";
            bookList.getBooks().get(index - 1).markBookAsUnread();
            assert !bookList.getBooks().get(index - 1).isRead() : "Book should be marked as unread";
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid book index. Please enter a valid index");
        } catch (BookUnreadAlreadyException e) {
            System.out.println("That book is already marked as unread!");
        } catch (Exception e) { // Generic catch block for any other exceptions
            System.out.println("An unexpected error occurred. Please contact support.");
        }
    }
}
