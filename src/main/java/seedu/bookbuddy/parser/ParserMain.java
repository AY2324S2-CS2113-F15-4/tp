package seedu.bookbuddy.parser;

import exceptions.UnsupportedCommandException;
import seedu.bookbuddy.bookdetailsmodifier.BookDisplay;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.Ui;
import seedu.bookbuddy.bookdetailsmodifier.BookRating;
import seedu.bookbuddy.parser.parsercommands.ParserFind;
import seedu.bookbuddy.parser.parsercommands.ParserAdd;
import seedu.bookbuddy.parser.parsercommands.ParserRemove;
import seedu.bookbuddy.parser.parsercommands.ParserMark;
import seedu.bookbuddy.parser.parsercommands.ParserGenre;
import seedu.bookbuddy.parser.parsercommands.ParserDisplay;
import seedu.bookbuddy.parser.parsercommands.ParserRating;
import seedu.bookbuddy.parser.parsercommands.ParserUnmark;
import seedu.bookbuddy.parser.parsercommands.ParserLabel;
import seedu.bookbuddy.parser.parsercommands.ParserSummary;
import seedu.bookbuddy.parser.parservalidation.CommandList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

/**
 * Parses inputs from the user in order to execute the correct commands.
 */
public class ParserMain {

    /**
     * Scans the user input for valid commands and handles them accordingly.
     *
     * @param input input from the user
     * @param books ArrayList of books
     */
    public static void parseCommand(String input, BookList books) {
        String[] inputArray = input.split(" ", 2);
        String command = inputArray[0].toLowerCase();
        LOGGER.log(Level.FINE, "Parsing command: {0}", command);
        int index;

        try {
            switch (command) {
            case CommandList.ADD_COMMAND:
                ParserAdd.executeParseAdd(books, inputArray);
                break;
            case CommandList.REMOVE_COMMAND:
                ParserRemove.executeParseRemove(books, inputArray);
                break;
            case CommandList.LIST_COMMAND:
                BookDisplay.printAllBooks(books);
                break;
            case CommandList.MARK_COMMAND:
                ParserMark.executeParseMark(books, inputArray);
                break;
            case CommandList.UNMARK_COMMAND:
                ParserUnmark.executeParseUnmark(books, inputArray);
                break;
            case CommandList.HELP_COMMAND:
                Ui.helpMessage();
                break;
            case CommandList.FIND_TITLE_COMMAND:
                ParserFind.parseTitle(books, inputArray[1]);
                break;
            case CommandList.FIND_GENRE_COMMAND:
                ParserFind.parseFindGenre(books);
                break;
            case CommandList.FIND_READ_COMMAND:
                ParserFind.parseFindRead(books);
                break;
            case CommandList.FIND_UNREAD_COMMAND:
                ParserFind.parseFindUnread(books);
                break;
            case CommandList.LABEL_COMMAND:
                ParserLabel.executeParseSetLabel(books, inputArray);
                break;
            case CommandList.SUMMARY_COMMAND:
                ParserSummary.executeParseSummary(books, inputArray);
                break;
            case CommandList.GENRE_COMMAND:
                // Exit the command if user types 'exit'
                if (ParserGenre.executeParseSetGenre(books, inputArray)) {
                    return;
                }
                break;
            case CommandList.RATING_COMMAND:
                ParserRating.executeParseSetRating(books, inputArray);
                break;
            case CommandList.DISPLAY_COMMAND:
                ParserDisplay.executeParseAdd(books, inputArray);
                break;
            case CommandList.PRINT_ORDERED_COMMAND:
                BookRating.printBooksByRating(books);
                break;
            default:
                LOGGER.log(Level.WARNING, "Sorry but that is not a valid command. Please try again", command);
                throw new UnsupportedCommandException("Sorry but that is not a valid command. " +
                        "Please try again or type: help");
            }
        } catch (Exception e) {
            Exceptions.handleException(e, command, inputArray);
        }
    }

}
