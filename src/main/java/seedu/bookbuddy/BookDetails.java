package seedu.bookbuddy;

import static seedu.bookbuddy.BookList.books;

public class BookDetails {

    protected String summary;

    /**
     * Sets the summary of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param summary The summary to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookSummaryByIndex(int index, String summary) throws IndexOutOfBoundsException {
        if (index < 0 || index >= books.size()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }
        books.get(index).setSummary(summary);
        String title = books.get(index).getTitle();
        Ui.summaryBookMessage(title, summary);
    }

    /**
     * Sets the label of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param label The label to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookLabelByIndex(int index, String label) throws IndexOutOfBoundsException {
        // Check for valid index
        if (index < 0 || index >= books.size()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }

        // Set the label for the book at the specified index
        books.get(index).setLabel(label);
        String title = books.get(index).getTitle();
        Ui.labelBookMessage(title, label);
    }

    /**
     * Sets the genre of the book at the specified index.
     *
     * @param index The index of the book in the list.
     * @param genre The genre to set for the book.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void setBookGenreByIndex(int index, String genre) throws IndexOutOfBoundsException {
        // Check for valid index
        if (index < 0 || index >= books.size()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }

        // Set the genre for the book at the specified index
        books.get(index).setGenre(genre);
        String title = books.get(index).getTitle();
        Ui.setGenreBookMessage(title, genre);
    }

    /**
     * Prints the details of the book at the specified index.
     * @param index The index of hte book in the list.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void displayDetails(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= books.size()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }

        System.out.println("Here are the details of your book:");
        System.out.println("Title: " + books.get(index).getTitle());
        System.out.println("Status: " + (books.get(index).isRead ? "Read" : "Unread"));
        System.out.println("Label: " + books.get(index).getLabel());
        System.out.println("Genre: " + books.get(index).getGenre());
    }

}
