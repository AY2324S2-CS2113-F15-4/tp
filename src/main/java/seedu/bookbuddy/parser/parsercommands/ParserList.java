package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetailsmodifier.BookDisplay;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserList {
    private static void parseList(BookList books, String[] inputArray) {
        if (inputArray.length == 1) {
            BookDisplay.printAllBooks(books);
        } else {
            System.out.println("The list command does not require any further arguments, just type `list` ");
        }
    }

    public static void executeParseList (BookList books, String[] inputArray) {
        parseList(books, inputArray);
    }
}
