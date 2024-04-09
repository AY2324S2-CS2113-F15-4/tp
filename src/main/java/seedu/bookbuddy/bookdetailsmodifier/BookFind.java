package seedu.bookbuddy.bookdetailsmodifier;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.book.Label;
import seedu.bookbuddy.book.BookMain;
import seedu.bookbuddy.book.Genre;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.book.Read;
import seedu.bookbuddy.booklist.BookList;

import java.util.ArrayList;


//@@author liuzehui03

public class BookFind {
    public static void findBookTitle(BookList bookList, String input) {
        assert input != null : "input should not be null";
        ArrayList<BookMain> bookTitles = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            String actualTitle = Title.getTitle(book).toLowerCase();
            String title = input.toLowerCase();
            if (actualTitle.contains(title)) {
                bookTitles.add(book);
            }
        }
        if (bookTitles.isEmpty()){
            Ui.printNoBookFound();
        } else {
            Ui.printLine();
            System.out.println("books with [" + input.toLowerCase() + "] in the title: ");
            Ui.printBookFound(bookTitles);
            Ui.printShortLine();
        }
    }

    public static void findBookGenre(BookList bookList, String input) {
        assert input != null : "input should not be null";
        ArrayList<BookMain> bookGenres = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            String actualGenre = Genre.getGenre(book).toLowerCase();
            String genre = input.toLowerCase();
            if (actualGenre.equals(genre)) {
                bookGenres.add(book);
            }
        }
        if (bookGenres.isEmpty()){
            Ui.printNoGenresFound();
        } else {
            Ui.printLine();
            System.out.println(input.toLowerCase() + " books: ");
            Ui.printGenresFound(bookGenres);
            Ui.printShortLine();
        }
    }
    public static void findBookGenreLong(BookList bookList, String input) {
        assert input != null : "input should not be null";
        ArrayList<BookMain> bookGenres = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            if (Genre.getGenre(book).contains(input)) {
                bookGenres.add(book);
            }
        }
        if (bookGenres.isEmpty()){
            Ui.printNoGenresFound();
        } else {
            Ui.printLine();
            System.out.println(input.toLowerCase() + " books: ");
            Ui.printGenresFound(bookGenres);
            Ui.printShortLine();
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
            Ui.printNoReadFound();
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
            Ui.printNoUnreadFound();
        } else {

            Ui.printUnreadFound(bookUnread);
        }
    }

    public static void findLabel(BookList bookList, String input) {
        ArrayList<BookMain> bookLabel = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            String actualLabel = Label.getLabel(book).toLowerCase();
            String label = input.toLowerCase();
            if(actualLabel.contains(label)){
                bookLabel.add(book);
            }
        }
        if (bookLabel.isEmpty()){
            Ui.printNoLabelFound();
        } else {
            Ui.printLine();
            System.out.println("books with [" + input.toLowerCase() + "] in their label:");
            Ui.printLabelFound(bookLabel);
            Ui.printShortLine();
        }
    }

    public static void findRate(BookList bookList, String input) {
        ArrayList<BookMain> bookRate = new ArrayList<>();
        int inputRating = Integer.parseInt(input);
        for (BookMain book : bookList.getBooks()) {

            if(Rating.getRating(book) == inputRating){
                bookRate.add(book);
            }
        }
        if (inputRating <= 5 && inputRating >= 1) {
            if (bookRate.isEmpty()) {
                Ui.printNoRateFound();
            } else {
                Ui.printLine();
                System.out.println("books rated [" + input + "] :");
                Ui.printRateFound(bookRate);
                Ui.printShortLine();
            }
        } else {
            System.out.println("pls enter a rating from 1-5");
        }
    }
}
