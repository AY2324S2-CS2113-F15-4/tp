package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserRemove {
    static void parseRemove(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length >= 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The remove " +
                "Command requires a book index");
        index = Integer.parseInt(inputArray[1].trim());
        BookListModifier.deleteBook(books, index);
    }

    public static void executeParseRemove (BookList books, String[] inputArray) {
        parseRemove(books, inputArray);
    }
}
