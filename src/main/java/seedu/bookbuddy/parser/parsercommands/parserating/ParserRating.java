package seedu.bookbuddy.parser.parsercommands.parserating;

import exceptions.InvalidCommandArgumentException;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.bookdetailsmodifier.BookRating;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

//@@author yeozongyao
public class ParserRating {
    /**
     * Parses the input arguments to set a rating for a book within the book list.
     * It expects exactly two additional arguments: a book index and a rating value.
     * The book index should be a valid integer that corresponds to a book within the book list,
     * and the rating should be a valid integer that represents the book's rating.
     *
     * @param books       The BookList containing books.
     * @param inputArray  The command input given by the users.
     * @throws AssertionError               If the inputArray contains fewer than two elements.
     * @throws NumberFormatException        If either the book index or the rating is not a valid integer.
     * @throws IndexOutOfBoundsException    If the book index is out of bounds (less than 1 or greater
     *                                      than the size of the book list).
     * @throws InvalidCommandArgumentException If the validation of the input command fails.
     */
    static void parseSetRating(BookList books, String[] inputArray) throws InvalidCommandArgumentException,
            NumberFormatException, IndexOutOfBoundsException {
        int index;
        int rating;
        assert inputArray.length >= 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The rating " +
                "command requires a book index and a rating.");
        String[] ratingParts = RatingChecks.getRatingParts(inputArray);
        index = RatingChecks.parseInteger(ratingParts[0],  ratingParts[0] + " is not a valid integer");
        rating = RatingChecks.parseInteger(ratingParts[1], ratingParts[1] + " is not a valid integer");
        BookRating.setBookRatingByIndex(index, rating, books);
    }

    /**
     * Executes the parsing and setting of a book rating. This is a convenience method that directly
     * calls the parseSetRating method. It serves as an entry point to initiate the parse
     * and set rating process.
     *
     * @param books       The BookList containing books.
     * @param inputArray  The command input given by the users.
     */
    public static void executeParseSetRating (BookList books, String[] inputArray) {
        parseSetRating(books, inputArray);
    }
}
