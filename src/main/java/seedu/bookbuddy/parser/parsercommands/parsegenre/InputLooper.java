package seedu.bookbuddy.parser.parsercommands.parsegenre;

import exceptions.InvalidInputException;
import seedu.bookbuddy.BookBuddy;
import seedu.bookbuddy.Ui;
import seedu.bookbuddy.booklist.BookList;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

//@@author yeozongyao
public class InputLooper {

    /**
     * Repeatedly prompts the user for input until a valid command or selection is made.
     * Handles exit commands and delegates to specific methods to process initial and secondary input.
     *
     * @param input   The initial user input or null if starting fresh.
     * @param scanner The Scanner object used to read user input.
     * @param books   The BookList object containing the list of books and genres.
     * @return The final valid input from the user.
     * @throws IOException If an I/O error occurs while handling the input.
     */
    public String inputLooper(String input, Scanner scanner, BookList books) throws IOException {
        while (input == null) {
            try {
                input = handleInitialInput(scanner);
                if (Objects.equals(input, "exit_now")) {
                    return null;  // Break out of the loop if input is null (exit command was used)
                }
                if (input == null) {
                    continue;  // If input is empty, continue to the next iteration of the loop
                }
                input = processSelection(input, scanner, books);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    /**
     * Processes exit commands, returning a boolean indicating if an exit command was entered.
     *
     * @param input             The user input to check for an exit command.
     * @param indentationValue  The level of indentation for the printed messages.
     * @return true if an exit command is detected, false otherwise.
     * @throws IOException If an I/O error occurs while printing messages.
     */
    private boolean handleExitCommands(String input, Integer indentationValue) throws IOException {
        if (isExitCommand(input)) {
            for (int i = 0; i < indentationValue; i++) {
                Ui.printSingleIndentation();
            }
            Ui.exitCommandMessage();
            for (int i = 0; i < indentationValue - 1; i++) {
                Ui.printSingleIndentation();
            }
            if (indentationValue == 2) {
                System.out.println("Enter the number for the desired genre, or add a new one:");
                Ui.printSingleIndentation();
            }
            return true;
        } else if (isByeCommand(input)) {
            BookBuddy.performExit();
            return true;
        }
        return false;
    }

    /**
     * Handles the initial input from the user.
     *
     * @param scanner The Scanner object to read user input.
     * @return A string representing the user's initial input.
     * @throws InvalidInputException If the input is not a valid number.
     * @throws IOException If an I/O error occurs while reading the input.
     */
    private String handleInitialInput(Scanner scanner) throws InvalidInputException, IOException {
        while (true) {
            String newInput = scanner.nextLine().trim();
            Integer indentationValue = 1;
            if (handleExitCommands(newInput, indentationValue)) {
                return "exit_now";
            }

            String[] parts = newInput.split("\\s+");
            if (parts.length == 1 && isValidNumber(parts[0])) {
                return newInput;
            }

            try {
                throw new InvalidInputException(newInput+ " is an invalid selection. Please enter a " +
                        "valid number or type 'exit' to go back");
            } catch (InvalidInputException e) {
                System.out.println(newInput + " is not a valid integer man.. try again.. or 'exit' to go back");
                Ui.printSingleIndentation();
                return null;
            }
        }
    }

    /**
     * Processes secondary input from the user, used for further interaction after the initial input.
     *
     * @param scanner The Scanner object to read user input.
     * @return A string representing the user's secondary input.
     * @throws IOException If an I/O error occurs while reading the input.
     */
    private String handleSecondaryInput(Scanner scanner) throws IOException {
        while (true) {
            String newInput = scanner.nextLine().trim();
            Integer indentationValue = 2;
            if (handleExitCommands(newInput, indentationValue)) {
                return null;
            } else {
                return newInput;
            }
        }
    }

    /**
     * Validates if the provided string is a numeric value.
     *
     * @param input The string to validate.
     * @return true if the input is a number, false otherwise.
     */
    private static boolean isValidNumber(String input) {
        return input.matches("-?\\d+");
    }

    /**
     * Checks if the input string is an 'exit' command.
     *
     * @param input The input string to check.
     * @return true if the input is an 'exit' command, false otherwise.
     */
    private static boolean isExitCommand(String input) {
        return "exit".equalsIgnoreCase(input);
    }

    /**
     * Checks if the input string is a 'bye' command.
     *
     * @param input The input string to check.
     * @return true if the input is a 'bye' command, false otherwise.
     */
    private static boolean isByeCommand(String input) {
        return "bye".equalsIgnoreCase(input);
    }

    /**
     * Processes the user's selection for genre-related commands.
     *
     * @param newInput The user's input indicating their selection.
     * @param scanner  The Scanner object to read additional user input if necessary.
     * @param books    The BookList object containing the list of books and genres.
     * @return A string representing the chosen genre or a new genre added by the user.
     * @throws InvalidInputException If the selection is invalid.
     * @throws IOException If an I/O error occurs while handling the input.
     */
    String processSelection(String newInput, Scanner scanner, BookList books)
            throws InvalidInputException, IOException {
        int selection = Integer.parseInt(newInput);
        if (selection == books.genreList.getAvailableGenres().size() + 1) {
            Ui.printDoubleIndentation();
            System.out.print("Enter the new genre:\n");
            Ui.printDoubleIndentation();
            String genre = handleSecondaryInput(scanner);
            return NewGenreModifier.duplicateChecker(genre, books);
        }

        if (selection > 0 && selection <= books.genreList.getAvailableGenres().size()) {
            return books.genreList.getAvailableGenres().get(selection - 1);
        }

        if (selection > books.genreList.getAvailableGenres().size() + 1) {
            System.out.println("That's not within the options man... try again.. or 'exit' to go back " +
                    "or 'bye' to close program");
            Ui.printSingleIndentation();
            return null;
        }
        try {
            throw new InvalidInputException(selection + " is an invalid selection. Please enter a " +
                    "valid number or type 'exit' to go back");
        } catch (InvalidInputException e) {
            System.out.println(selection + " is not a valid integer man.. try again.. or 'exit' to go back");
            Ui.printSingleIndentation();
            return null;
        }
    }


}
