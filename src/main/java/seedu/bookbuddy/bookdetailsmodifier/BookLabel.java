package seedu.bookbuddy.bookdetailsmodifier;

import seedu.bookbuddy.book.Label;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.Ui;

public class BookLabel {
    /**
     * Sets the label of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param label The label to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookLabelByIndex(int index, String label, BookList books) throws IndexOutOfBoundsException {
        // Check for valid index
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index. nows");
        }

        // Set the label for the book at the specified index
        Label.setLabel(books.getBook(index), label);
        String title = Title.getTitle(books.getBook(index));
        Ui.labelBookMessage(title, label);
    }
}
