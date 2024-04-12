package seedu.bookbuddy.parser.parsercommands.parsegenre;

import exceptions.InvalidInputException;
import seedu.bookbuddy.BookBuddy;
import seedu.bookbuddy.Ui;
import seedu.bookbuddy.booklist.BookList;

import java.io.IOException;
import java.util.Scanner;

public class InputLooper {
    public static String inputLooper(String input, Scanner scanner) throws IOException {
        while (input == null) {
            try {
                input = handleInput(scanner);
                if (input == null || input.isEmpty()) {
                    continue;  // if input is still null or empty, continue to the next iteration of the loop
                }
                input = processSelection(input, scanner);
            } catch (InvalidInputException e) {
                System.out.println(e.getMessage());
            }
        }
        return input;
    }

    private static String handleInput(Scanner scanner) throws InvalidInputException, IOException {
        while (true) {
            String newInput = scanner.nextLine().trim();
            String[] parts = newInput.split("\\s+");
            if (parts.length == 1 && isValidNumber(parts[0])) {
                return newInput;
            }
            if (isExitCommand(newInput)) {
                Ui.exitCommandMessage();
                return null;
            }
            if (isByeCommand(newInput)) {
                BookBuddy.performExit();
                return null;
            }
            throw new InvalidInputException(newInput + " is an invalid input. Please enter a valid " +
                    "number or type 'exit' to cancel or 'bye' to exit the programme.");
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

    private static String processSelection(String newInput, Scanner scanner) throws InvalidInputException {
        int selection = Integer.parseInt(newInput);
        if (selection == BookList.getAvailableGenres().size() + 1) {
            System.out.println("Enter the new genre:");
            String genre = scanner.nextLine().trim();
            return NewGenreModifier.duplicateChecker(genre);
        }
        if (selection > 0 && selection <= BookList.getAvailableGenres().size()) {
            return BookList.getAvailableGenres().get(selection - 1);
        }
        throw new InvalidInputException(selection + " is an invalid selection. Please enter a " +
                "valid number or type 'exit' to cancel or 'bye' to exit the programme.");
    }


}
