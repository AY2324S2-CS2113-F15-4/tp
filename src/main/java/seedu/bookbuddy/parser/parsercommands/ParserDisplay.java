package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.bookdetailsmodifier.BookDisplay;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserDisplay {
    //@@author joshuahoky
    static void parseDisplay(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length >= 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray,2 , "The display " +
                "Command requires a book index");
        index = Integer.parseInt(inputArray[1]);
        BookDisplay.displayDetails(index, books);
    }

    public static void executeParseAdd (BookList books, String[] inputArray) {
        parseDisplay(books, inputArray);
    }
}
