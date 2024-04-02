package seedu.bookbuddy.bookdetails;

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
        books.getBook(index).setLabel(label);
        String title = books.getBook(index).getTitle();
        Ui.labelBookMessage(title, label);
    }
}
