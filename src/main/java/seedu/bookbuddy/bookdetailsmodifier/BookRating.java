package seedu.bookbuddy.bookdetailsmodifier;

import seedu.bookbuddy.book.BookMain;
import seedu.bookbuddy.book.Rating;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.Ui;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookRating {

    /**
     * Prints all books sorted by rating in descending order.
     */
    public static void printBooksByRating(BookList books) {
        if (books.getBooks().isEmpty()) {
            System.out.println("The list is empty. Add books by 'add [book]'");
            return;
        }

        System.out.println("Books sorted by rating:");

        List<BookMain> sortedBooks = books.getBooks().stream()
                .sorted(Comparator.comparingInt(Rating::getRating).reversed())
                .collect(Collectors.toList());

        for (BookMain book : sortedBooks) {
            String rating = Rating.getRating(book) > 0 ? String.valueOf(Rating.getRating(book)) : "Not Rated";
            System.out.println(Title.getTitle(book) + " - " + rating);
        }
    }

    /**
     * Sets the rating of the book at the specified index.
     *
     * @param index  The index of the book in the list.
     * @param rating The rating to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     * @throws IllegalArgumentException  if the rating is not between 1 and 5.
     */
    public static void setBookRatingByIndex(int index, int rating, BookList books)
            throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index selection. Please enter a valid index.");
        }
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        Rating.setRating(books.getBook(index), rating);
        String title = Title.getTitle(books.getBook(index));
        Ui.setRatingBookMessage(title, rating);
    }
}
