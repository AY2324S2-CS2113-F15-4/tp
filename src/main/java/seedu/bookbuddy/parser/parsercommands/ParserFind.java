package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetailsmodifier.BookFind;
import seedu.bookbuddy.booklist.BookList;
//@@ liuzehui03
public class ParserFind {
    public static void parseTitle(BookList books, String inputArray) {
        BookFind.findBookTitle(books, inputArray);
    }

    public static void parseFindGenre(BookList books, String inputArray) {
        BookFind.findBookGenre(books, inputArray);

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
