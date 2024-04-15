package seedu.bookbuddy.parser.parsercommands.parsegenre;

import exceptions.InvalidInputException;
import seedu.bookbuddy.Ui;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parsercommands.parserating.RatingChecks;

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
    public String  inputLooper(String input, Scanner scanner, BookList books) throws IOException {
        while (input == null) {
            try {
                input = InputHandler.handleInitialInput(scanner);
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
        int selection = 0;
        try {
            //int selection = Integer.parseInt(newInput);
            selection = RatingChecks.parseInteger(newInput, newInput + "'s too massive a number.. " +
                    "You're messing with me");
            if (selection == books.genreList.getAvailableGenres().size() + 1) {
                Ui.printDoubleIndentation();
                System.out.print("Enter the new genre, or 'exit' to go back:\n");
                Ui.printDoubleIndentation();
                String genre = InputHandler.handleSecondaryInput(scanner);
                return NewGenreModifier.duplicateChecker(genre, books);
            }
            if (selection > 0 && selection <= books.genreList.getAvailableGenres().size()) {
                return books.genreList.getAvailableGenres().get(selection - 1);
            }
            if (selection > books.genreList.getAvailableGenres().size() + 1 && selection < 999) {
                System.out.println("That's not within the options man... try again.. or 'exit' to go back " +
                        "or 'bye' to close program");
                Ui.printSingleIndentation();
                return null;
            }
            if (selection <= 0) {
                throw new InvalidInputException("Did you not see that the lowest option is 1??");
            }
            throw new InvalidInputException(selection + "'s too big.. You're messing with me");
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            Ui.printSingleIndentation();
            return null;
        }
    }


}
