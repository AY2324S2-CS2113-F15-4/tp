package seedu.bookbuddy.book;

public class Summary {

    //@@author lordgareth10
    /**
     * Sets the summary for this book.
     *
     * @param book
     * @param summary The summary to set for the book.
     */
    public static void setSummary(BookMain book, String summary) {
        book.summary = summary;
    }

    /**
     * Returns the summary of the book.
     *
     * @param book
     * @return The summary of the book.
     */
    public static String getSummary(BookMain book) {
        return book.summary;
    }
}
