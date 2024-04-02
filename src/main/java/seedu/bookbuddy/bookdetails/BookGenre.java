package seedu.bookbuddy.bookdetails;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.Ui;

public class BookGenre {
    /**
     * Sets the genre of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param genre The genre to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookGenreByIndex(int index, String genre, BookList books) throws IndexOutOfBoundsException {
        // Check for valid index
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }

        // Set the genre for the book at the specified index
        books.getBook(index).setGenre(genre);
        String title = books.getBook(index).getTitle();
        Ui.setGenreBookMessage(title, genre);
    }
}
