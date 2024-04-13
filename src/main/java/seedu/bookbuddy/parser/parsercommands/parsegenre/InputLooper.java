package seedu.bookbuddy.parser.parsercommands.parsegenre;

import exceptions.InvalidInputException;
import seedu.bookbuddy.BookBuddy;
import seedu.bookbuddy.Ui;
import seedu.bookbuddy.booklist.BookList;

import java.io.IOException;
import java.util.Scanner;

public class InputLooper {
    public String inputLooper(String input, Scanner scanner, BookList books) throws IOException {
        while (input == null) {
            try {
                input = handleInitialInput(scanner);
                if (input == null) {
                    return null;  // Break out of the loop if input is null (exit command was used)
                }
                if (input.isEmpty()) {
                    continue;  // If input is empty, continue to the next iteration of the loop
                }
                input = processSelection(input, scanner, books);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

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
                System.out.print("Enter the number for the desired genre, or add a new one:\n");
                Ui.printSingleIndentation();
            }
            return true;
        } else if (isByeCommand(input)) {
            BookBuddy.performExit();
            return true;
        }
        return false;
    }

    private String handleInitialInput(Scanner scanner) throws InvalidInputException, IOException {
        while (true) {
            String newInput = scanner.nextLine().trim();
            Integer indentationValue = 1;
            if (handleExitCommands(newInput, indentationValue)) {
                return null;
            }

            String[] parts = newInput.split("\\s+");
            if (parts.length == 1 && isValidNumber(parts[0])) {
                return newInput;
            }

            throw new InvalidInputException(newInput + " is an invalid input. Please enter a " +
                    "valid number or type 'exit' to cancel or 'bye' to exit the programme.");
        }
    }

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

    private static boolean isValidNumber(String input) {
        return input.matches("-?\\d+");
    }

    private static boolean isExitCommand(String input) {
        return "exit".equalsIgnoreCase(input);
    }

    private static boolean isByeCommand(String input) {
        return "bye".equalsIgnoreCase(input);
    }

    private String processSelection(String newInput, Scanner scanner, BookList books)
            throws InvalidInputException, IOException {
        int selection = Integer.parseInt(newInput);
        if (selection == books.getAvailableGenres().size() + 1) {
            Ui.printDoubleIndentation();
            System.out.print("Enter the new genre:\n");
            Ui.printDoubleIndentation();
            String genre = handleSecondaryInput(scanner);
            return NewGenreModifier.duplicateChecker(genre, books);
        }
        if (selection > 0 && selection <= books.getAvailableGenres().size()) {
            return books.getAvailableGenres().get(selection - 1);
        }
        throw new InvalidInputException(selection + " is an invalid selection. Please enter a " +
                "valid number or type 'exit' to cancel or 'bye' to exit the programme.");
    }


}
