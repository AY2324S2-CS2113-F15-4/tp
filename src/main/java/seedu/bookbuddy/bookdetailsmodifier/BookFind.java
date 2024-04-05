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
            Ui.printBookFound(bookTitles);
        }
    }

    public static void findBookGenre(BookList bookList, String input) {
        ArrayList<BookMain> bookGenres = new ArrayList<>();
        for (BookMain book : bookList.getBooks()) {
            String actualGenre = Genre.getGenre(book).toLowerCase();
            String genre = input.toLowerCase();
            if (actualGenre.contains(genre)) {
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
            Ui.printNoBookFound();
        } else {
            Ui.printLabelFound(bookLabel);
        }
    }
}
