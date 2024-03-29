package seedu.bookbuddy;

import exceptions.BookNotFoundException;
import exceptions.InvalidBookIndexException;
import exceptions.InvalidCommandArgumentException;
import exceptions.UnsupportedCommandException;

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
    public static final String EXIT_COMMAND = "bye";
    public static final String HELP_COMMAND = "help";
    public static final String LABEL_COMMAND = "label";
    public static final String GENRE_COMMAND = "set-genre";
    public static final String SUMMARY_COMMAND = "give-summary";
    public static final String DISPLAY_COMMAND = "display";

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

                if (inputArray.length < 2) {
                    LOGGER.log(Level.WARNING, "The add Command requires a book title", inputArray);
                    throw new InvalidCommandArgumentException("The add command requires a book title.");
                }
                books.addBook(inputArray[1]);
                break;
            case REMOVE_COMMAND:
                assert inputArray.length >= 2 : "Command requires additional arguments";
                if (inputArray.length < 2) {
                    LOGGER.log(Level.WARNING, "The remove Command requires a book index", inputArray);
                    throw new InvalidCommandArgumentException("The remove command requires a book index.");
                }
                try {
                    index = Integer.parseInt(inputArray[1]);
                    books.deleteBook(index);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + inputArray[1] + " is not a valid number. " +
                            "Please enter a valid numeric index.");
                }
                break;
            case LIST_COMMAND:
                books.printAllBooks();
                break;
            case MARK_COMMAND:
                assert inputArray.length >= 2 : "Command requires additional arguments";
                if (inputArray.length < 2) {
                    LOGGER.log(Level.WARNING, "The mark Command requires a book index", inputArray);
                    throw new InvalidCommandArgumentException("The mark command requires a book index.");
                }
                try {
                    index = Integer.parseInt(inputArray[1]);
                    assert index >= 0 : "Index should be non-negative";
                    books.markDoneByIndex(index);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + inputArray[1] + " is not a valid number. " +
                            "Please enter a valid numeric index.");
                }
                break;
            case UNMARK_COMMAND:
                assert inputArray.length == 2 : "Command requires additional arguments";
                if (inputArray.length < 2) {
                    LOGGER.log(Level.WARNING, "The unmark Command requires a book index", inputArray);
                    throw new InvalidCommandArgumentException("The unmark command requires a book index.");
                }
                try {
                    index = Integer.parseInt(inputArray[1]);
                    assert index >= 0 : "Index should be non-negative";
                    books.markUndoneByIndex(index);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + inputArray[1] + " is not a valid number. " +
                            "Please enter a valid numeric index.");
                }
                break;
            case HELP_COMMAND:
                Ui.helpMessage();
                break;
            case LABEL_COMMAND:
                assert inputArray.length == 2 : "Command requires additional arguments";
                if (inputArray.length < 2) {
                    LOGGER.log(Level.WARNING, "The Label Command requires a book index and label", inputArray);
                    throw new InvalidCommandArgumentException("The label command requires a book index and label.");
                }
                String[] labelMessageParts = inputArray[1].split(" ", 2);
                // Split the message into index and label message
                assert labelMessageParts.length == 2 : "Command requires an index and a label message";
                if (labelMessageParts.length < 2) {
                    throw new InvalidCommandArgumentException("You need to have a label message");
                }
                try {
                    index = Integer.parseInt(labelMessageParts[0]);
                    assert index >= 0 : "Index should be non-negative";
                    String label = labelMessageParts[1];
                    System.out.println(index);
                    BookDetails.setBookLabelByIndex(index, label, books);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + labelMessageParts[0]
                            + " is not a valid number. Please enter a valid numeric index.");
                } catch (InvalidCommandArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid book index. Please enter a valid index");
                } catch (Exception e) {
                    System.out.println("An error occurred while setting the label: " + e.getMessage());
                }
                break;
            case SUMMARY_COMMAND:
                assert inputArray.length == 2 : "Command requires additional arguments";
                if (inputArray.length < 2) {
                    LOGGER.log(Level.WARNING, "The summary Command requires a book index and summary", inputArray);
                    throw new InvalidCommandArgumentException("The summary command requires a book index and summary.");
                }
                String[] summaryMessageParts = inputArray[1].split(" ", 2);
                assert summaryMessageParts.length == 2 : "Command requires an index and a label message";
                if (summaryMessageParts.length < 2) {
                    throw new InvalidCommandArgumentException("You need to have a summary message");
                }
                try {
                    index = Integer.parseInt(summaryMessageParts[0]);
                    assert index >= 0 : "Index should be non-negative";
                    String summary = summaryMessageParts[1];
                    BookDetails.setBookSummaryByIndex(index, summary, books);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + summaryMessageParts[0]
                            + " is not a valid number. Please enter a valid numeric index.");
                } catch (InvalidCommandArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid book index. Please enter a valid index.");
                } catch (Exception e) {
                    System.out.println("An error occurred while setting the label: " + e.getMessage());
                }
                break;
            case GENRE_COMMAND:
                assert inputArray.length >= 2 : "Command requires additional arguments";
                if (inputArray.length < 2) {
                    LOGGER.log(Level.WARNING, "The genre Command requires a book index and genre", inputArray);
                    throw new InvalidCommandArgumentException("The genre command requires a book index and genre.");
                }
                String[] genreMessageParts = inputArray[1].split(" ", 2);

                if (genreMessageParts.length < 2) {
                    throw new InvalidCommandArgumentException("You need to have a genre message");
                }
                // Split the message into index and genre message
                assert genreMessageParts.length == 2 : "Command requires an index and a genre message";

                try {
                    index = Integer.parseInt(genreMessageParts[0]);
                    assert index >= 0 : "Index should be non-negative";
                    String label = genreMessageParts[1];
                    BookDetails.setBookGenreByIndex(index, label, books);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + genreMessageParts[0]
                            + " is not a valid number. Please enter a valid numeric index.");
                } catch (InvalidCommandArgumentException e) {
                    System.out.println(e.getMessage());
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid book index. Please enter a valid index.");
                } catch (Exception e) {
                    System.out.println("An error occurred while setting the genre: " + e.getMessage());
                }
                break;
            case DISPLAY_COMMAND:
                assert inputArray.length >= 2 : "Command requires additional arguments";
                if (inputArray.length < 2) {
                    LOGGER.log(Level.WARNING, "The display Command requires a book index", inputArray);
                    throw new InvalidCommandArgumentException("The display command requires a book index.");
                }
                try {
                    index = Integer.parseInt(inputArray[1]);
                    BookDetails.displayDetails(index, books);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input: " + inputArray[1] + " is not a valid number. " +
                            "Please enter a valid numeric index.");
                } catch (IndexOutOfBoundsException e) {
                    System.out.println("Invalid book index. Please enter a valid index.");
                } catch (InvalidCommandArgumentException e) {
                    System.out.println(e.getMessage());
                }
                break;
            case EXIT_COMMAND:
                Ui.printExitMessage();
                System.exit(0);
                break;
            default:
                LOGGER.log(Level.WARNING, "Sorry but that is not a valid command. Please try again", command);
                throw new UnsupportedCommandException("Sorry but that is not a valid command. " +
                        "Please try again or type: help");
            }
        } catch (NumberFormatException e) {
            throw new InvalidBookIndexException("Book index must be an integer.");
        } catch (IndexOutOfBoundsException e) {
            throw new BookNotFoundException("Book not found at the provided index.");
        } catch (InvalidCommandArgumentException e) {
            LOGGER.log(Level.WARNING, "Invalid command argument: {0}", e.getMessage());
            throw e;
        } catch (UnsupportedCommandException e) {
            LOGGER.log(Level.WARNING, "Command is invalid", e.getMessage());
            throw e;
        } catch (Exception e) { // Generic catch block for any other exceptions
            LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
            System.out.println("An unexpected error occurred. Please contact support.");
        }
    }
}
