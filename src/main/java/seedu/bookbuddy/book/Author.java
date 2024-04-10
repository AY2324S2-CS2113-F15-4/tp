package seedu.bookbuddy.book;

public class Author {
    /**
     * Sets the author for this book.
     *
     * @param book
     * @param author The author to set for the book.
     */
    public static void setAuthor(BookMain book, String author) {
        book.author = author;
    }

    /**
     * Returns the author of the book.
     *
     * @param book
     * @return The author of the book.
     */
    public static String getAuthor(BookMain book) {
        return book.author;
    }
}
