package seedu.bookbuddy.bookdetailsmodifier;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.book.Label;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.booklist.BookList;

import java.util.Objects;

//@@author yeozongyao
public class BookLabel {

    /**
     * Sets the label of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param label The label to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookLabelByIndex(int index, String label, BookList books) throws IndexOutOfBoundsException {
        // Set the label for the book at the specified index
        if (!Objects.equals(label, Label.getLabel(books.getBook(index)))) {
            Label.setLabel(books.getBook(index), label);
            String title = Title.getTitle(books.getBook(index));
            Ui.labelBookMessage(title, label);
        } else {
            Ui.printLabelAlreadySetWarning();
        }
    }
}
