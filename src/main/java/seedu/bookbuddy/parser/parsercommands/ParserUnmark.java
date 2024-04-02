package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetails.BookMark;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserUnmark {
    static void parseUnmark(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The unmark " +
                "Command requires a book index");
        index = Integer.parseInt(inputArray[1]);
        assert index >= 0 : "Index should be non-negative";
        BookMark.markUndoneByIndex(books, index);
    }

    public static void executeParseUnmark (BookList books, String[] inputArray) {
        parseUnmark(books, inputArray);
    }
}
