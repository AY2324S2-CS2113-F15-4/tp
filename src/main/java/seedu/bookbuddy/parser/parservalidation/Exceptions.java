package seedu.bookbuddy.parser.parservalidation;

import exceptions.InvalidCommandArgumentException;
import exceptions.UnsupportedCommandException;

import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

public class Exceptions {
    public static void validateCommandArguments(String[] inputArray, int requiredArgs, String errorMessage)
            throws InvalidCommandArgumentException {
        if (inputArray.length < requiredArgs) {
            LOGGER.log(Level.WARNING, errorMessage, inputArray);
            throw new InvalidCommandArgumentException(errorMessage);
        }
    }

    public static void handleException(Exception e, String command, String[] inputArray) {
        if (e instanceof UnsupportedCommandException) {
            LOGGER.log(Level.WARNING, "Command is invalid: {0}", e.getMessage());
            System.out.println(e.getMessage());
        } else if (e instanceof NumberFormatException) {
            System.out.println("Invalid input: " + inputArray[1] + " is not a valid number. " +
                    "Please enter a valid numeric index. Type 'list' to view list of books.");
        } else if (e instanceof IndexOutOfBoundsException) {
            System.out.println("Invalid book index. Please enter a valid index.");
        } else if (e instanceof InvalidCommandArgumentException) {
            LOGGER.log(Level.WARNING, "Invalid command argument: {0}", new Object[]{e.getMessage()});
            System.out.println(e.getMessage());
        } else if (e instanceof IllegalArgumentException) {
            System.out.println(e.getMessage());
        } else {
            LOGGER.log(Level.SEVERE, "An unexpected error occurred while executing {0}: {1}",
                    new Object[]{command, e.getMessage()});
            System.out.println("An unexpected error occurred while executing " + command
                    + ". Please contact support.");
        }
    }
}
