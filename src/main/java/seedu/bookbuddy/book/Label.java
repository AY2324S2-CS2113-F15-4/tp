package seedu.bookbuddy.book;

public class Label {
    /**
     * Sets the label for this book.
     *
     * @param book
     * @param label The label to set for the book.
     */
    public static void setLabel(BookMain book, String label) {
        book.label = label;  // Set the label for the book
    }

    /**
     * Returns the label of the book.
     * @param book
     * @return The label of the book.
     */
    public static String getLabel(BookMain book) {
        return book.label;
    }
}
