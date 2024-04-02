package seedu.bookbuddy;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class BookDetails {

    /**
     * Sets the rating of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param rating The rating to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     * @throws IllegalArgumentException if the rating is not between 1 and 5.
     */
    public static void setBookRatingByIndex(int index, int rating, BookList books)
            throws IndexOutOfBoundsException, IllegalArgumentException {
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }
        if (rating < 1 || rating > 5) {
            throw new IllegalArgumentException("Rating must be between 1 and 5.");
        }
        books.getBook(index).setRating(rating);
        String title = books.getBook(index).getTitle();
        Ui.setRatingBookMessage(title, rating);
    }


    /**
     * Prints all books sorted by rating in descending order.
     */
    public static void printBooksByRating(BookList books) {
        if (books.books.isEmpty()) {
            System.out.println("The list is empty. Add books by 'add [book]'");
            return;
        }

        System.out.println("Books sorted by rating:");

        List<Book> sortedBooks = books.books.stream()
                .sorted(Comparator.comparingInt(Book::getRating).reversed())
                .collect(Collectors.toList());

        for (Book book : sortedBooks) {
            String rating = book.getRating() >= 0 ? String.valueOf(book.getRating()) : "Not Rated";
            System.out.println(book.getTitle() + " - " + rating);
        }
    }

    /**
     * Prints the summary of a book given its index.
     */
    public static void printSummaryByIndex(BookList books, int index) throws IndexOutOfBoundsException{
        if (books.books.isEmpty()) {
            System.out.println("The list is empty. Add books by 'add [book]'");
            return;
        }

        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }

        System.out.println("This is the summary that you gave: " + books.getBook(index).getSummary());

    }

    /**
     * Sets the summary of the book at the specified index.
     *
     * @param index The index of the book in the list.
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

    /**
     * Sets the label of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param label The label to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookLabelByIndex(int index, String label, BookList books) throws IndexOutOfBoundsException {
        // Check for valid index
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index. nows");
        }

        // Set the label for the book at the specified index
        books.getBook(index).setLabel(label);
        String title = books.getBook(index).getTitle();
        Ui.labelBookMessage(title, label);
    }

    /**
     * Sets the genre of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param genre The genre to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookGenreByIndex(int index, String genre, BookList books) throws IndexOutOfBoundsException {
        // Check for valid index
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }

        // Set the genre for the book at the specified index
        books.getBook(index).setGenre(genre);
        String title = books.getBook(index).getTitle();
        Ui.setGenreBookMessage(title, genre);
    }

    /**
     * Prints the details of the book at the specified index.
     * @param index The index of hte book in the list.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void displayDetails(int index, BookList books) throws IndexOutOfBoundsException {
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }

        System.out.println("Here are the details of your book:");
        System.out.println("Title: " + books.getBook(index).getTitle());
        System.out.println("Status: " + (books.getBook(index).isRead ? "Read" : "Unread"));
        System.out.println("Label: " + books.getBook(index).getLabel());
        System.out.println("Genre: " + books.getBook(index).getGenre());
        System.out.println("Rating: " + books.getBook(index).getRating());
        System.out.println("Summary: " + books.getBook(index).getSummary());
    }

}
