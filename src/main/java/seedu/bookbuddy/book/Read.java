package seedu.bookbuddy.book;
import utils.DateTimeUtils;

public class Read {
    //@@author lordgareth10
    /**
     * Checks if the book is read.
     *
     * @param book The book that is passed to the method.
     * @return True if the book is read, false otherwise.
     */
    public static boolean getRead(BookMain book) {
        return book.isRead;
    }

    /**
     * Returns the date and time read attribute of the book in string form.
     *
     * @param book The book that is passed to the method.
     * @return The date and time read of the book.
     */
    public static String getDateTimeRead(BookMain book) {
        return book.dateTimeRead;
    }

    /**
     * Sets the books read status as unread or read
     *
     * @param book The book that is passed to the method.
     * @param read The status of the book.
     */
    public static void setRead(BookMain book, boolean read) {
        book.isRead = read;
        if (read) {
            book.dateTimeRead = DateTimeUtils.getCurrentDateTime();
        } else {
            book.dateTimeRead = "";
        }

    }
}
