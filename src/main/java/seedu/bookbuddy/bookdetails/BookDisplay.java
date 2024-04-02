package seedu.bookbuddy.bookdetails;

import seedu.bookbuddy.Book;
import seedu.bookbuddy.Ui;
import seedu.bookbuddy.booklist.BookList;

import java.util.ArrayList;

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

    /**
     * Prints all books currently in the list.
     * @param bookList
     */
    public static void printAllBooks(BookList bookList) {
        assert bookList.getBooks() != null : "Books list should not be null since it has been initialised.";
        if (!bookList.getBooks().isEmpty()) {
            System.out.println("All books:");
            for (int i = 0; i < bookList.getBooks().size(); i++) {
                Book currentBook = bookList.getBooks().get(i);
                assert currentBook != null : "Book in list should not be null";
                System.out.print((i + 1) + ". ");
                System.out.println(currentBook.toString());
            }
        } else {
            System.out.println("The list is empty. Add books by 'add [book]'");
        }
    }

    //@@author liuzehui03
    public static void findBook(BookList bookList, String title) {
        ArrayList<Book> bookTitles = new ArrayList<>();
        for (Book book : bookList.getBooks()) {
            if (book.getTitle().contains(title)) {
                bookTitles.add(book);
            }
        }
        if (bookTitles.isEmpty()){
            Ui.printNoBookFound();
        } else {
            Ui.printBookFound(bookTitles);
        }
    }
}
