package seedu.bookbuddy.parser.parsercommands.parserating;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.bookdetailsmodifier.BookRating;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserRating {
    static void parseSetRating(BookList books, String[] inputArray) {
        int index;
        int rating;
        assert inputArray.length >= 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The rating " +
                "command requires a book index.");
        String[] ratingParts = RatingChecks.getRatingParts(inputArray);
        index = RatingChecks.parseInteger(ratingParts[0],  ratingParts[0] + " is not a valid integer");
        rating = RatingChecks.parseInteger(ratingParts[1], ratingParts[1] + " is not a valid integer");
        BookRating.setBookRatingByIndex(index, rating, books);
    }

    public static void executeParseSetRating (BookList books, String[] inputArray) {
        parseSetRating(books, inputArray);
    }
}
