package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

public class ParserAdd {
    //@@author joshuahoky
    private static void parseAdd(BookList books, String[] inputArray) {
        assert inputArray.length >= 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The add " +
                "Command requires a book title");
        BookListModifier.addBook(books, inputArray[1]);
    }
    //@@author
    public static void executeParseAdd (BookList books, String[] inputArray) {
        parseAdd(books, inputArray);
    }
}
