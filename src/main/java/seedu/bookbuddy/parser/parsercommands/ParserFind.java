package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetailsmodifier.BookDisplay;
import seedu.bookbuddy.booklist.BookList;

import java.util.Scanner;

import static seedu.bookbuddy.parser.parsercommands.ParserGenre.invalidInputLooper;

public class ParserFind {
    public static void parseTitle(BookList books, String inputArray) {
        BookDisplay.findBookTitle(books, inputArray);
    }

    public static void parseFindGenre(BookList books, String inputArray) {
        BookDisplay.findBookGenre(books, inputArray);

    }
    public static void parseFindRead(BookList books) {
        BookDisplay.findRead(books);
    }
    public static void parseFindUnread(BookList books) {
        BookDisplay.findUnread(books);
    }
}
