package seedu.bookbuddy.bookdetails;

import seedu.bookbuddy.BookList;

public class BookDisplay {
    //@@author joshuahoky
    /**
     * Prints the details of the book at the specified index.
     *
     * @param index The index of hte book in the list.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void displayDetails(int index, BookList books) throws IndexOutOfBoundsException {
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }

        System.out.println("Here are the details of your book:");
        System.out.println("Title: " + books.getBook(index).getTitle());
        System.out.println("Status: " + (books.getBook(index).isRead() ? "Read" : "Unread"));
        System.out.println("Label: " + books.getBook(index).getLabel());
        System.out.println("Genre: " + books.getBook(index).getGenre());
        System.out.println("Rating: " + books.getBook(index).getRating());
        System.out.println("Summary: " + books.getBook(index).getSummary());
    }
}
