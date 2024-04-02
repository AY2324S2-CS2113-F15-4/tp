package seedu.bookbuddy.bookdetails;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.Ui;

public class BookSummary {
    //@@author lordgareth10
    /**
     * Sets the summary of the book at the specified index.
     *
     * @param index   The index of the book in the list.
     * @param summary The summary to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookSummaryByIndex(int index, String summary, BookList books)
            throws IndexOutOfBoundsException {
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }
        books.getBook(index).setSummary(summary);
        String title = books.getBook(index).getTitle();
        Ui.summaryBookMessage(title, summary);
    }
}
