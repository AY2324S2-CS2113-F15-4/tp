package seedu.bookbuddy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BookDetails {
    protected static List<String> availableGenres = new ArrayList<>(Arrays.asList("Fiction", "Non-Fiction",
            "Mystery", "Science Fiction", "Fantasy"));
    protected String summary;
    
    /**
     * Sets the summary of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param summary The summary to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookSummaryByIndex(int index, String summary, BookList books)
            throws IndexOutOfBoundsException {
        if (index < 0 || index >= books.getSize()) {
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
    }

}
