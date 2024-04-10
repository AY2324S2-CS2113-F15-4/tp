package seedu.bookbuddy.parser;

import exceptions.UnsupportedCommandException;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.Ui;
import seedu.bookbuddy.parser.parsercommands.*;
import seedu.bookbuddy.parser.parservalidation.CommandList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

//@@author joshuahoky
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
        try {
            if (command.contains("list")) {
                ParserList.executeParseList(books, inputArray, command);
            }
            switch (command) {
            case CommandList.ADD_COMMAND:
                ParserAdd.executeParseAdd(books, inputArray);
                break;
            case CommandList.REMOVE_COMMAND:
                ParserRemove.executeParseRemove(books, inputArray);
                break;
            case CommandList.LIST_COMMAND:
                //Empty case, all list commands handled in if block
                break;
            case CommandList.PRINT_ORDERED_COMMAND:
                //Empty case, all list commands handled in if block
                break;
            case CommandList.PRINT_ORDERED_DATE_COMMAND:
                //Empty case, all list commands handled in if block
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
                if (inputArray.length == 1) { // Check if there is only 'find-genre' without additional parameters
                    ParserFind.parseGenreLong(books);
                } else {
                    ParserFind.parseFindGenre(books, inputArray[1]);
                }
                break;
            case CommandList.FIND_READ_COMMAND:
                ParserFind.parseFindRead(books);
                break;
            case CommandList.FIND_UNREAD_COMMAND:
                ParserFind.parseFindUnread(books);
                break;
            case CommandList.FIND_LABEL_COMMAND:
                ParserFind.parseLabel(books, inputArray[1]);
                break;
            case CommandList.FIND_RATE_COMMAND:
                ParserFind.parseRate(books, inputArray[1]);
                break;
            case CommandList.LABEL_COMMAND:
                ParserLabel.executeParseSetLabel(books, inputArray);
                break;
            case CommandList.SUMMARY_COMMAND:
                ParserSummary.executeParseSummary(books, inputArray);
                break;
            case CommandList.GENRE_COMMAND:
                // Exit the command if user types 'exit'
                ParserGenre.executeParseSetGenre(books, inputArray);
                break;
            case CommandList.RATING_COMMAND:
                ParserRating.executeParseSetRating(books, inputArray);
                break;
            case CommandList.DISPLAY_COMMAND:
                ParserDisplay.executeParseAdd(books, inputArray);
                break;
//            case CommandList.AUTHOR_COMMAND:
//                ParserAuthor.executeParseAuthor(books, inputArray);
//                break;
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
