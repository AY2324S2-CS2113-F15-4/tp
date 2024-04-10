package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetailsmodifier.BookDisplay;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserList {
    private static void parseList(BookList books, String[] inputArray) {
        Exceptions.validateCommandArguments(inputArray,1,
                "The list command does not require any further arguments, just type `list` u absolute donut ");
        BookDisplay.printAllBooks(books);
    }

    public static void executeParseList (BookList books, String[] inputArray) {
        parseList(books, inputArray);
    }
}
