package seedu.bookbuddy;

import exceptions.InvalidCommandArgumentException;
import exceptions.UnsupportedCommandException;
import seedu.bookbuddy.bookdetails.BookDisplay;
import seedu.bookbuddy.bookdetails.BookGenre;
import seedu.bookbuddy.bookdetails.BookLabel;
import seedu.bookbuddy.bookdetails.BookRating;
import seedu.bookbuddy.bookdetails.BookSummary;

import java.util.Scanner;
import java.util.logging.Level;

import static seedu.bookbuddy.BookBuddy.LOGGER;

/**
 * Parses inputs from the user in order to execute the correct commands.
 */
public class Parser {
    public static final String ADD_COMMAND = "add";
    public static final String REMOVE_COMMAND = "remove";
    public static final String LIST_COMMAND = "list";
    public static final String MARK_COMMAND = "mark";
    public static final String UNMARK_COMMAND = "unmark";
    public static final String HELP_COMMAND = "help";
    public static final String FIND_COMMAND = "find";
    public static final String LABEL_COMMAND = "label";
    public static final String GENRE_COMMAND = "set-genre";
    public static final String SUMMARY_COMMAND = "give-summary";
    public static final String DISPLAY_COMMAND = "display";
    public static final String RATING_COMMAND = "rate";
    public static final String PRINT_ORDERED_COMMAND = "list-rated";
    private static void validateCommandArguments(String[] inputArray, int requiredArgs, String errorMessage)
            throws InvalidCommandArgumentException {
        if (inputArray.length < requiredArgs) {
            LOGGER.log(Level.WARNING, errorMessage, inputArray);
            throw new InvalidCommandArgumentException(errorMessage);
        }
    }

    private static void handleException(Exception e, String command, String[] inputArray) {
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


    /**
     * Scans the user input for valid commands and handles them accordingly.
     * @param input input from the user
     * @param books ArrayList of books
     */
    public static void parseCommand(String input, BookList books) {
        String[] inputArray = input.split(" ", 2);
        String command = inputArray[0].toLowerCase();
        LOGGER.log(Level.FINE, "Parsing command: {0}", command);
        int index;

        try {
            switch (command) {
            case ADD_COMMAND:
                assert inputArray.length >= 2 : "Command requires additional arguments";
                validateCommandArguments(inputArray, 2, "The add " +
                        "Command requires a book title");
                books.addBook(inputArray[1]);
                break;
            case REMOVE_COMMAND:
                assert inputArray.length >= 2 : "Command requires additional arguments";
                validateCommandArguments(inputArray, 2, "The remove " +
                        "Command requires a book index");
                index = Integer.parseInt(inputArray[1]);
                books.deleteBook(index);
                break;
            case LIST_COMMAND:
                books.printAllBooks();
                break;
            case MARK_COMMAND:
                assert inputArray.length >= 2 : "Command requires additional arguments";
                validateCommandArguments(inputArray, 2, "The mark " +
                        "Command requires a book index");
                index = Integer.parseInt(inputArray[1]);
                assert index >= 0 : "Index should be non-negative";
                books.markDoneByIndex(index);
                break;
            case UNMARK_COMMAND:
                assert inputArray.length == 2 : "Command requires additional arguments";
                validateCommandArguments(inputArray, 2, "The unmark " +
                        "Command requires a book index");
                index = Integer.parseInt(inputArray[1]);
                assert index >= 0 : "Index should be non-negative";
                books.markUndoneByIndex(index);
                break;
            case HELP_COMMAND:
                Ui.helpMessage();
                break;
            case FIND_COMMAND:
                books.findBook(inputArray[1]);
                break;
            case LABEL_COMMAND:
                assert inputArray.length == 2 : "Command requires additional arguments";
                validateCommandArguments(inputArray,2, "The Label " +
                        "Command requires a book index and label");
                String[] labelMessageParts = inputArray[1].split(" ", 2);
                // Split the message into index and label message
                assert labelMessageParts.length == 2 : "Command requires an index and a label message";
                validateCommandArguments(labelMessageParts, 2, "You " +
                        "need to have a label message");
                index = Integer.parseInt(labelMessageParts[0]);
                assert index >= 0 : "Index should be non-negative";
                String label = labelMessageParts[1];
                System.out.println(index);
                BookLabel.setBookLabelByIndex(index, label, books);
                break;
            case SUMMARY_COMMAND:
                assert inputArray.length == 2 : "Command requires additional arguments";
                validateCommandArguments(inputArray,2, "The summary " +
                        "Command requires a book index and summary");
                String[] summaryMessageParts = inputArray[1].split(" ", 2);
                assert summaryMessageParts.length == 2 : "Command requires an index and a label message";
                validateCommandArguments(summaryMessageParts,2, "You need " +
                        "to have a summary message");
                index = Integer.parseInt(summaryMessageParts[0]);
                assert index >= 0 : "Index should be non-negative";
                String summary = summaryMessageParts[1];
                BookSummary.setBookSummaryByIndex(index, summary, books);
                break;
            case GENRE_COMMAND:
                validateCommandArguments(inputArray, 2, "The set-genre " +
                        "Command requires a book index.");
                index = Integer.parseInt(inputArray[1]);
                if (index < 0 || index > books.getSize()) {
                    throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index. " +
                            "Type 'list' to view the list of books.");
                }
                System.out.println("Available genres:");
                for (int i = 0; i < BookList.availableGenres.size(); i++) {
                    System.out.println((i + 1) + ". " + BookList.availableGenres.get(i));
                }
                System.out.println((BookList.availableGenres.size() + 1) + ". Add a new genre");

                System.out.println("Enter the number for the desired genre, or add a new one:");
                Scanner scanner = new Scanner(System.in);

                String selectedGenre = null;
                while (selectedGenre == null) {
                    while (!scanner.hasNextInt()) {  // Ensure the next input is an integer
                        String newInput = scanner.nextLine();
                        if ("exit".equalsIgnoreCase(newInput)) {
                            return; // Exit the command if user types 'exit'
                        } else {
                            System.out.println("Invalid input. Please enter a valid number or type 'exit'" +
                                    " to cancel.");
                        }
                    }

                    int genreSelection = scanner.nextInt();
                    scanner.nextLine(); // Consume the newline after the number

                    if (genreSelection == BookList.availableGenres.size() + 1) {
                        System.out.println("Enter the new genre:");
                        selectedGenre = scanner.nextLine();
                        BookList.availableGenres.add(selectedGenre); // Add the new genre to the list
                    } else if (genreSelection > 0 && genreSelection <= BookList.availableGenres.size()) {
                        selectedGenre = BookList.availableGenres.get(genreSelection - 1);
                    } else {
                        System.out.println("Invalid selection. Please enter a valid number " +
                                "or type 'exit' to cancel.");
                        // No need for the nextLine or parsing logic here, the while loop will continue
                    }
                }

                BookGenre.setBookGenreByIndex(index, selectedGenre, books);
                System.out.println("Genre set to " + selectedGenre + " for book at index " + index);

                break;
            case RATING_COMMAND:
                assert inputArray.length >= 2 : "Command requires additional arguments";
                validateCommandArguments(inputArray, 2, "The rating " +
                        "command requires a book index.");
                String[] ratingParts = inputArray[1].split(" ", 2);
                // Split the message into index and label message
                assert ratingParts.length == 2 : "Command requires an index and a rating";
                if (ratingParts.length < 2) {
                    throw new InvalidCommandArgumentException("You need to have a book index and a rating");
                }
                index = Integer.parseInt(ratingParts[0]);
                int rating = Integer.parseInt(ratingParts[1]);
                BookRating.setBookRatingByIndex(index, rating, books);
                break;
            case DISPLAY_COMMAND:
                assert inputArray.length >= 2 : "Command requires additional arguments";
                validateCommandArguments(inputArray,2 , "The display " +
                        "Command requires a book index");
                index = Integer.parseInt(inputArray[1]);
                BookDisplay.displayDetails(index, books);
                break;
            case PRINT_ORDERED_COMMAND:
                BookRating.printBooksByRating(books);
                break;
            default:
                LOGGER.log(Level.WARNING, "Sorry but that is not a valid command. Please try again", command);
                throw new UnsupportedCommandException("Sorry but that is not a valid command. " +
                        "Please try again or type: help");
            }
        } catch (Exception e) {
            handleException(e, command, inputArray);
        }
    }
}
