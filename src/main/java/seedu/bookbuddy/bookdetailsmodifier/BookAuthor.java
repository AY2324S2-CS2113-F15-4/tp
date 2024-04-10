package seedu.bookbuddy.bookdetailsmodifier;

import seedu.bookbuddy.book.Author;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.Ui;

public class BookAuthor {
    /**
     * Sets the author of the book at the specified index.
     *
     * @param index   The index of the book in the list.
     * @param author The author to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookAuthorByIndex(int index, String author, BookList books)
            throws IndexOutOfBoundsException {
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }
        Author.setAuthor(books.getBook(index), author);
        String title = Title.getTitle(books.getBook(index));
        Ui.authorBookMessage(title, author);
    }
}
