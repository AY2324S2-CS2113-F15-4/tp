package seedu.bookbuddy.book;

public class Read {
    //@@author lordgareth10
    /**
     * Checks if the book is read.
     * @param book
     * @return True if the book is read, false otherwise.
     */
    public static boolean getRead(BookMain book) {
        return book.isRead;
    }

    public static void setRead(BookMain book, boolean read) {
        book.isRead = read;
    }
}
