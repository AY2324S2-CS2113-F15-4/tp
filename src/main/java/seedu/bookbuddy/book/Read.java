package seedu.bookbuddy.book;
import utils.DateTimeUtils;

public class Read {
    //@@author lordgareth10
    /**
     * Checks if the book is read.
     *
     * @param book
     * @return True if the book is read, false otherwise.
     */
    public static boolean getRead(BookMain book) {
        return book.isRead;
    }

    public static String getDateTimeRead(BookMain book) {
        return book.datetimeread;
    }

    public static void setRead(BookMain book, boolean read) {
        book.isRead = read;
        if (read) {
            book.datetimeread = DateTimeUtils.getCurrentDateTime();
        } else {
            book.datetimeread = "";
        }

    }
}
