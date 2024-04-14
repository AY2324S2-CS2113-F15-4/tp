package seedu.bookbuddy.parser.parsercommands.parserating;

import exceptions.InvalidCommandArgumentException;

//@@author yeozongyao
public class RatingChecks {

    /**
     * Parses the input command arguments to extract parts necessary for rating a book.
     * Specifically, it expects exactly two arguments: a book index and a rating value.
     *
     * @param inputArray  An array of String containing the input arguments.
     * @return An array of two String elements containing the book index and rating.
     * @throws InvalidCommandArgumentException If the arguments do not contain both an index and a rating.
     * @throws IllegalArgumentException If either the book index or the rating is not a valid integer.
     */
    static String[] getRatingParts(String[] inputArray) {
        String[] ratingParts = inputArray[1].trim().split(" ", 2);
        // Split the message into index and label message
        assert ratingParts.length == 2 : "Command requires an index and a rating";
        if (ratingParts.length < 2) {
            throw new InvalidCommandArgumentException("You need to have a book index and a rating");
        }

        if (isNotNumeric(ratingParts[0].trim()) && isNotNumeric(ratingParts[1].trim())) {
            throw new IllegalArgumentException(ratingParts[0] + " and " + ratingParts[1]
                    + " are not valid integers.");
        }
        return ratingParts;
    }

    /**
     * Parses the given String input as an integer.
     *
     * @param input         The String input to parse.
     * @param errorMessage  The error message to include in the exception if parsing fails.
     * @return The parsed integer value.
     * @throws IllegalArgumentException If the input is not a valid integer.
     */
    public static int parseInteger(String input, String errorMessage) throws IllegalArgumentException{
        if (isNotNumeric(input.trim())) {
            throw new IllegalArgumentException(errorMessage);
        }
        return Integer.parseInt(input.trim());
    }

    /**
     * Checks if a given string is not numeric.
     *
     * @param strNum  The String to check.
     * @return true if the string is not a valid representation of a number, false otherwise.
     */
    static boolean isNotNumeric(String strNum) {
        if (strNum == null) {
            return true;
        }
        try {
            int d = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return true;
        }
        return false;
    }
}
