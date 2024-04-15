package seedu.bookbuddy.parser.parsercommands.parsegenre;

import exceptions.InvalidInputException;
import seedu.bookbuddy.BookBuddy;
import seedu.bookbuddy.Ui;

import java.io.IOException;
import java.util.Scanner;

//@@author yeozongyao
public class InputHandler {
    /**
     * Processes exit commands, returning a boolean indicating if an exit command was entered.
     *
     * @param input             The user input to check for an exit command.
     * @param indentationValue  The level of indentation for the printed messages.
     * @return true if an exit command is detected, false otherwise.
     * @throws IOException If an I/O error occurs while printing messages.
     */
    static boolean handleExitCommands(String input, Integer indentationValue) throws IOException {
        if (GenreChecker.isExitCommand(input)) {
            for (int i = 0; i < indentationValue; i++) {
                Ui.printSingleIndentation();
            }
            Ui.exitCommandMessage();
            for (int i = 0; i < indentationValue - 1; i++) {
                Ui.printSingleIndentation();
            }
            if (indentationValue == 2) {
                System.out.println("Enter the number for the desired genre, or add a new one, or 'exit' to go back:");
                Ui.printSingleIndentation();
            }
            return true;
        } else if (GenreChecker.isByeCommand(input)) {
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
    static String handleInitialInput(Scanner scanner) throws InvalidInputException, IOException {
        while (true) {
            String newInput = scanner.nextLine().trim();
            Integer indentationValue = 1;
            if (handleExitCommands(newInput, indentationValue)) {
                return "exit_now";
            }

            String[] parts = newInput.split("\\s+");
            if (parts.length == 1 && GenreChecker.isValidNumber(parts[0])) {
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
    static String handleSecondaryInput(Scanner scanner) throws IOException {
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
}
