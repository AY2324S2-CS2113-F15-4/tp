package seedu.bookbuddy.parser.parsercommands;

import exceptions.UnsupportedCommandException;
import seedu.bookbuddy.bookdetailsmodifier.BookDisplay;
import seedu.bookbuddy.bookdetailsmodifier.BookMark;
import seedu.bookbuddy.bookdetailsmodifier.BookRating;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;
import seedu.bookbuddy.parser.parservalidation.CommandList;

import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

public class ParserList {
    private static void parseList(BookList books, String[] inputArray, String command) {
        Exceptions.validateCommandArguments(inputArray, 1,
                "ALl the list commands do not require any further arguments, just type `list`," +
                        " `list-rated` or `list-by-date` u absolute donut ");
        switch (command) {
        case CommandList.LIST_COMMAND:
            BookDisplay.printAllBooks(books);
            break;
        case CommandList.PRINT_ORDERED_COMMAND:
            BookRating.printBooksByRating(books);
            break;
        case CommandList.PRINT_ORDERED_DATE_COMMAND:
            BookMark.printBooksByDateRead(books);
            break;
        default:
            LOGGER.log(Level.WARNING, "Sorry but that is not a valid list command. Please try again", command);
            throw new UnsupportedCommandException("Sorry but that is not a valid list command. " +
                    "Please try again or type: help");
        }
    }


    public static void executeParseList (BookList books, String[] inputArray, String command) {
        parseList(books, inputArray, command);
    }
}
