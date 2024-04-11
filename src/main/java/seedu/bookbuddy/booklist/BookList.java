package seedu.bookbuddy.booklist;

import exceptions.BookNotFoundException;
import seedu.bookbuddy.book.Author;
import seedu.bookbuddy.book.BookMain;
import seedu.bookbuddy.book.Title;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Manages a list of books, allowing for operations such as adding, deleting,
 * and marking book as read or unread.
 */
public class BookList {
    protected static List<String> availableGenres = new ArrayList<>(Arrays.asList("Fiction", "Non-Fiction",
            "Mystery", "Science Fiction", "Fantasy"));
    protected ArrayList<BookMain> books;
    public BookList() {
        this.books = new ArrayList<BookMain>(); // Use ArrayList instead of array
    }
    public static List<String> getAvailableGenres() {
        return availableGenres;
    }
    public static void setAvailableGenres(List<String> availableGenres) {
        BookList.availableGenres = new ArrayList<>(availableGenres);
    }
    /**
     * Constructs a new BookList instance with an empty list.
     */
    // Public getter method for the books field
    public List<BookMain> getBooks() {
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
    public BookMain getBook(int index) throws BookNotFoundException {
        if (index < 0 || index > books.size()) {
            throw new BookNotFoundException("Book index out of range.");
        }
        assert books.get(index - 1) != null : "Retrieved book should not be null";
        assert books.get(index - 1) instanceof BookMain : "Object at index should be an instance of Book";
        return books.get(index - 1);
    }

    public static String saveGenresFormat() {
        return String.join(",", availableGenres);
    }

    //@@lordgareth10
    /**
     * Checks whether the book title is already inside the list
     *
     * @param bookList The bookList arraylist
     * @param title The title of the book.
     */
    public static boolean checkDuplicateBookTitle(BookList bookList, String title) {
        assert title != null : "title should not be null";
        for (BookMain book : bookList.getBooks()) {
            String actualTitle = Title.getTitle(book).toLowerCase();
            String lowercasetitle = title.toLowerCase();
            if (actualTitle.equals(lowercasetitle)) {
                return true;
            }
        }
        return false;
    }

    /**
     * For books of the same title, checks whether the author is the same as well
     *
     * @param bookList The bookList arraylist
     * @param title The title of the book.
     */
    public static boolean checkDuplicateBookAuthor(BookList bookList, String author, String title) {
        assert author != null : "title should not be null";
        for (BookMain book : bookList.getBooks()) {
            if (title.equals(Title.getTitle(book))) {
                String actualAuthor = Author.getAuthor(book).toLowerCase();
                String lowercaseauthor = author.toLowerCase();
                if (actualAuthor.equals(lowercaseauthor)) {
                    return true;
                }
            }
        }
        return false;
    }
}
