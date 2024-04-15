package seedu.bookbuddy.parser.parsercommands.parsegenre;

//@@aauthor yeozongyao
public class GenreChecker {
    /**
     * Validates if the provided string is a numeric value.
     *
     * @param input The string to validate.
     * @return true if the input is a number, false otherwise.
     */
    static boolean isValidNumber(String input) {
        return input.matches("-?\\d+");
    }

    /**
     * Checks if the input string is an 'exit' command.
     *
     * @param input The input string to check.
     * @return true if the input is an 'exit' command, false otherwise.
     */
    static boolean isExitCommand(String input) {
        return "exit".equalsIgnoreCase(input);
    }

    /**
     * Checks if the input string is a 'bye' command.
     *
     * @param input The input string to check.
     * @return true if the input is a 'bye' command, false otherwise.
     */
    static boolean isByeCommand(String input) {
        return "bye".equalsIgnoreCase(input);
    }
}
