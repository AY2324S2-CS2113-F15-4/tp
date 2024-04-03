package seedu.bookbuddy.bookdetailsmodifier;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.book.BookMain;
import seedu.bookbuddy.book.Genre;
import seedu.bookbuddy.book.Label;
import seedu.bookbuddy.book.Rating;
import seedu.bookbuddy.book.Read;
import seedu.bookbuddy.book.Summary;
import seedu.bookbuddy.book.Title;
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
        System.out.println("Title: " + Title.getTitle(books.getBook(index)));
        System.out.println("Status: " + (Read.getRead(books.getBook(index)) ? "Read" : "Unread"));
        System.out.println("Label: " + Label.getLabel(books.getBook(index)));
        System.out.println("Genre: " + Genre.getGenre(books.getBook(index)));
        System.out.println("Rating: " + Rating.getRating(books.getBook(index)));
        System.out.println("Summary: " + Summary.getSummary(books.getBook(index)));
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
                BookMain currentBook = bookList.getBooks().get(i);
                assert currentBook != null : "Book in list should not be null";
                System.out.print((i + 1) + ". ");
                System.out.println(currentBook.toString());
            }
        } else {
            System.out.println("The list is empty. Add books by 'add [book]'");
        }
    }

    //@@author liuzehui03
    public static void findBookTitle(BookList bookList, String title) {
        ArrayList<BookMain> bookTitles = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            if (Title.getTitle(book).contains(title)) {
                bookTitles.add(book);
            }
        }
        if (bookTitles.isEmpty()){
            Ui.printNoBookFound();
        } else {
            Ui.printBookFound(bookTitles);
        }
    }
    public static void findBookGenre(BookList bookList, String genre) {
        ArrayList<BookMain> bookGenres = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            if (Genre.getGenre(book).contains(genre)) {
                bookGenres.add(book);
            }
        }
        if (bookGenres.isEmpty()){
            Ui.printNoGenresFound();
        } else {
            Ui.printGenresFound(bookGenres);
        }
    }
}
