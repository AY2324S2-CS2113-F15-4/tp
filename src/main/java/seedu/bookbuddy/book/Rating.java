package seedu.bookbuddy.book;

//@@author yeozongyao
public class Rating {
    /**
     * Sets the rating for this book. The rating must be between 1 and 5.
     *
     * @param book
     * @param rating The rating to set for the book.
     * @throws IllegalArgumentException if the rating is not between 1 and 5.
     */
    public static void setRating(BookMain book, int rating) {
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        book.rating = rating;
    }

    /**
     * Returns the rating of the book.
     *
     * @param book
     * @return The rating of the book.
     */
    public static int getRating(BookMain book) {
        return book.rating;
    }
}
