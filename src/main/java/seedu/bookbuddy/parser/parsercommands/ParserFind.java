package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.book.BookMain;
import seedu.bookbuddy.bookdetailsmodifier.BookDisplay;
import seedu.bookbuddy.bookdetailsmodifier.BookFind;
import seedu.bookbuddy.booklist.BookList;

import java.util.Scanner;

//@@ liuzehui03
public class ParserFind {
    public static void parseTitle(BookList books, String inputArray) {
        BookFind.findBookTitle(books, inputArray);
    }

    public static void parseFindGenre(BookList books, String inputArray) {
        BookFind.findBookGenre(books, inputArray);

    }
    public static void parseGenreLong(BookList books) {
        System.out.println("Available genres:");
        for (int i = 0; i < BookList.getAvailableGenres().size(); i++) {
            System.out.println((i + 1) + ". " + BookList.getAvailableGenres().get(i));
        }
        System.out.println("Enter the number for the desired genre:");
        Scanner scanner = new Scanner(System.in);
        String selectedGenre = ParserGenre.invalidInputLooper(null, scanner);
        if (selectedGenre == null) {
            return;
        }
        BookFind.findBookGenreLong(books, selectedGenre);
    }
    public static void parseFindRead(BookList books) {
        BookFind.findRead(books);
    }
    public static void parseFindUnread(BookList books) {
        BookFind.findUnread(books);
    }

    public static void parseLabel(BookList books, String inputArray) {
        BookFind.findLabel(books, inputArray);
    }
}
