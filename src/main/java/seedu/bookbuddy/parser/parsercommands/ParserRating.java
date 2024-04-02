package seedu.bookbuddy.parser.parsercommands;

import exceptions.InvalidCommandArgumentException;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.bookdetailsmodifier.BookRating;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserRating {
    static void parseSetRating(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length >= 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The rating " +
                "command requires a book index.");
        String[] ratingParts = inputArray[1].split(" ", 2);
        // Split the message into index and label message
        assert ratingParts.length == 2 : "Command requires an index and a rating";
        if (ratingParts.length < 2) {
            throw new InvalidCommandArgumentException("You need to have a book index and a rating");
        }
        index = Integer.parseInt(ratingParts[0]);
        int rating = Integer.parseInt(ratingParts[1]);
        BookRating.setBookRatingByIndex(index, rating, books);
    }

    public static void executeParseSetRating (BookList books, String[] inputArray) {
        parseSetRating(books, inputArray);
    }
}
