package seedu.bookbuddy.parser.parsercommands.parserating;

import exceptions.InvalidCommandArgumentException;

public class RatingChecks {
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

    public static int parseInteger(String input, String errorMessage) {
        if (isNotNumeric(input.trim())) {
            throw new IllegalArgumentException(errorMessage);
        }
        return Integer.parseInt(input.trim());
    }

    // Helper method to check if a string is numeric
    private static boolean isNotNumeric(String strNum) {
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
