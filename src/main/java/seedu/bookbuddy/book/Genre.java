package seedu.bookbuddy.book;

public class Genre {
    /**
     * Sets the genre for this book.
     *
     * @param book
     * @param genre The label to set for the book.
     */
    public static void setGenre(BookMain book, String genre) {
        book.genre = genre;  // Set the genre for the book
    }

    /**
     * Returns the genre of the book.
     *
     * @return The genre of the book.
     * @param book
     */
    public static String getGenre(BookMain book) {
        return book.genre;
    }
}
