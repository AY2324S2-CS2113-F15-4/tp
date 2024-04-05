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
     * @param index The index of the book in the list.
     * @throws IndexOutOfBoundsException if the index is out of range.
     */
    public static void displayDetails(int index, BookList books) throws IndexOutOfBoundsException {
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index.");
        }

        String label = Label.getLabel(books.getBook(index));
        String genre = Genre.getGenre(books.getBook(index));
        int rating = Rating.getRating(books.getBook(index));
        String summary = Summary.getSummary(books.getBook(index));
        System.out.println("Here are the details of your book:");
        System.out.println("Title: " + Title.getTitle(books.getBook(index)));
        System.out.println("Status: " + (Read.getRead(books.getBook(index)) ? "Read" : "Unread"));
        System.out.println("Label: " + (label.isEmpty() ? "No label provided" : label));
        System.out.println("Genre: " + (genre.isEmpty() ? "No genre provided" : genre));
        System.out.println("Rating: " + ((rating == -1) ? "No rating provided" : rating));
        System.out.println("Summary: " + (summary.isEmpty() ? "No summary provided" : summary));
    }

    /**
     * Prints all books currently in the list.
     *
     * @param bookList The bookList array with all the books
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
            if (Title.getTitle(book).toLowerCase().contains(title.toLowerCase())) {
                bookTitles.add(book);
            }
        }

    }

    public static void findBookGenre(BookList bookList, String genre) {
        ArrayList<BookMain> bookGenres = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            String actualGenre = Genre.getGenre(book).toLowerCase();
            if (actualGenre.contains(genre.toLowerCase())) {
                bookGenres.add(book);
            }
        }
        if (bookGenres.isEmpty()){
            Ui.printNoGenresFound();
        } else {
            Ui.printGenresFound(bookGenres);
        }
    }
    public static void findRead(BookList bookList){
        ArrayList<BookMain> bookRead = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            if (Read.getRead(book)) {
                bookRead.add(book);
            }
        }
        if (bookRead.isEmpty()){
            Ui.printNoGenresFound();
        } else {
            Ui.printReadFound(bookRead);
        }
    }
    public static void findUnread(BookList bookList){
        ArrayList<BookMain> bookUnread = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            if (!Read.getRead(book)) {
                bookUnread.add(book);
            }
        }
        if (bookUnread.isEmpty()){
            Ui.printNoGenresFound();
        } else {

            Ui.printUnreadFound(bookUnread);
        }
    }

    public static void findLabel(BookList bookList, String inputArray) {
        ArrayList<BookMain> bookLabel = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            if(!Label.getLabel(book).isEmpty()){
                bookLabel.add(book);
            }
        }
        if (bookLabel.isEmpty()){
            Ui.printNoBookFound();
        } else {
            Ui.printLabelFound(bookLabel);
        }
    }
}
