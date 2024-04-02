package seedu.bookbuddy;

import exceptions.BookNotFoundException;
import exceptions.BookReadAlreadyException;
import exceptions.BookUnreadAlreadyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

/**
 * Manages a list of books, allowing for operations such as adding, deleting,
 * and marking book as read or unread.
 */
public class BookList {
    protected static List<String> availableGenres = new ArrayList<>(Arrays.asList("Fiction", "Non-Fiction",
            "Mystery", "Science Fiction", "Fantasy"));
    public static List<String> getAvailableGenres() {
        return availableGenres;
    }
    protected ArrayList<Book> books;

    /**
     * Constructs a new BookList instance with an empty list.
     */
    public BookList() {
        this.books = new ArrayList<Book>(); // Use ArrayList instead of array
    }
    // Public getter method for the books field
    public List<Book> getBooks() {
        return this.books;
    }

    /**
     * Returns the current size of the book list.
     *
     * @return The number of books in the list.
     */
    public int getSize(){
        return books.size();
    }

    /**
     * Retrieves a book from the list based on its index.
     *
     * @param index The index of the book to retrieve.
     * @return The Book at the specified index.
     */
    public Book getBook(int index) throws BookNotFoundException{
        if (index < 0 || index > books.size()) {
            throw new BookNotFoundException("Book index out of range.");
        }
        assert books.get(index - 1) != null : "Retrieved book should not be null";
        assert books.get(index - 1) instanceof Book : "Object at index should be an instance of Book";
        return books.get(index - 1);
    }

    /**
     * Adds a new Book to the list.
     *
     * @param title The title of the book.
     */
    public void addBook(String title) {
        try {
            books.add(new Book(title));
            Ui.addBookMessage(title);
            assert !books.isEmpty() : "Book list should not be empty after adding a book";
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    public void addBookFromFile(String inputArray) {
        String[] bookDetails = inputArray.split(" \\| ");
        String title = bookDetails[0];
        int status = Integer.parseInt(bookDetails[1]);
        String label = bookDetails[2];
        String genre = bookDetails[3];
        int rating = Integer.parseInt(bookDetails[4]);
        String summary = bookDetails[5];
        books.add(new Book(title, status, label, genre, rating, summary));
    }

    public void findBook(String title) {
        ArrayList<Book> bookTitles = new ArrayList<>();
        for (Book book : books) {
            if (book.getTitle().contains(title)) {
                bookTitles.add(book);
            }
        }
        if (bookTitles.isEmpty()){
            Ui.printNoBookFound();
        } else {
            Ui.printBookFound(bookTitles);
        }
    }

    /**
     * Deletes a book from the list by its index.
     *
     * @param index The index of the book to delete.
     */
    public void deleteBook(int index) throws IndexOutOfBoundsException {
        try {
            Ui.removeBookMessage(index, this);
            books.remove(index - 1);
            assert books.size() >= 0 : "Book list size should not be negative after deletion";
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid book index. Please enter a valid index");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    /**
     * Marks a book as read by its index.
     *
     * @param index The index of the book to mark as read.
     */
    public void markDoneByIndex(int index) throws IndexOutOfBoundsException, BookReadAlreadyException{
        try {
            assert index > 0 && index <= books.size() : "Index out of valid range";
            if (books.get(index - 1).isRead()) {
                throw new BookReadAlreadyException("That book is already marked as read!");
            }
            assert !books.get(index - 1).isRead() : "Book is already marked as read";
            books.get(index - 1).markBookAsRead();
            assert books.get(index - 1).isRead() : "Book should be marked as read";
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid book index. Please enter a valid index");
        } catch (BookReadAlreadyException e) {
            System.out.println("That book is already marked as read!");
        } catch (Exception e) {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
            throw e; // Rethrow or handle as needed
        }
    }

    /**
     * Marks a book as unread by its index.
     *
     * @param index The index of the book to mark as unread.
     */
    public void markUndoneByIndex(int index) throws IndexOutOfBoundsException, BookReadAlreadyException{
        try {
            assert index > 0 && index <= books.size() : "Index out of valid range";
            if (!books.get(index - 1).isRead()) {
                throw new BookUnreadAlreadyException("That book is already marked as unread!");
            }
            assert books.get(index - 1).isRead() : "Book is already marked as unread";
            books.get(index - 1).markBookAsUnread();
            assert !books.get(index - 1).isRead() : "Book should be marked as unread";
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Invalid book index. Please enter a valid index");
        } catch (BookUnreadAlreadyException e) {
            System.out.println("That book is already marked as unread!");
        } catch (Exception e) { // Generic catch block for any other exceptions
            System.out.println("An unexpected error occurred. Please contact support.");
        }
    }

    /**
     * Prints all books currently in the list.
     */
    public void printAllBooks() {
        assert books != null : "Books list should not be null since it has been initialised.";
        if (!books.isEmpty()) {
            System.out.println("All books:");
            for (int i = 0; i < books.size(); i++) {
                Book currentBook = books.get(i);
                assert currentBook != null : "Book in list should not be null";
                System.out.print((i + 1) + ". ");
                System.out.println(currentBook.toString());
            }
        } else {
            System.out.println("The list is empty. Add books by 'add [book]'");
        }
    }
}
