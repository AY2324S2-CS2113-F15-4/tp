package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetailsmodifier.BookMark;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserMark {
    //@@author joshuahoky
    static void parseMark(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length >= 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The mark " +
                "Command requires a book index");
        index = Integer.parseInt(inputArray[1]);
        assert index >= 0 : "Index should be non-negative";
        BookMark.markDoneByIndex(books, index);
    }

    //@@author
    public static void executeParseMark (BookList books, String[] inputArray) {
        parseMark(books, inputArray);
    }
}
