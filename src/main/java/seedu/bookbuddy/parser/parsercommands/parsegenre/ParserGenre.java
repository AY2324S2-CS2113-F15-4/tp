package seedu.bookbuddy.parser.parsercommands.parsegenre;

import exceptions.InvalidCommandArgumentException;
import seedu.bookbuddy.Ui;
import seedu.bookbuddy.bookdetailsmodifier.BookGenre;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

import java.io.IOException;
import java.util.Scanner;
//@@author yeozongyao
public class ParserGenre {

    /**
     * Parses and processes the command to set the genre for a book at a specific index.
     * The command must contain at least a book index and may also directly contain the genre.
     *
     * @param books      The BookList containing the books to be updated.
     * @param inputArray An array of String containing the input command and arguments.
     * @throws IOException If an I/O issue occurs during command processing.
     * @throws InvalidCommandArgumentException If the provided index is not within the valid range of the book list.
     */
    static void parseSetGenre(BookList books, String[] inputArray) throws IOException, InvalidCommandArgumentException {
        Exceptions.validateCommandArguments(inputArray, 2, "The set-genre command requires " +
                "at least a book index.");

        String[] parts = inputArray[1].trim().split(" ", 2); //Attempt to split inputArray[1] into two parts
        int index;
        try {
            index = Integer.parseInt(parts[0].trim()); // The first part should be the index
        } catch (NumberFormatException e) {
            System.out.println("Invalid book index format. Please enter a valid numeric index.");
            return;
        }

        if (index <= 0 || index > books.getSize()) {
            throw new InvalidCommandArgumentException("Invalid book index. Please enter a valid " +
                    "index. Type 'list' to view the list of books.");
        }

        if (parts.length > 1 && !parts[1].isEmpty()) {
            // Single-step process: Set genre directly
            singleStepSetGenre(books, parts, index);
        } else {
            // Multistep process: Follow the existing flow
            multiStepSetGenre(books, index);
        }
    }

    /**
     * Handles the multistep genre setting process which includes prompting the user for a genre.
     *
     * @param books The BookList containing the books.
     * @param index The index of the book for which the genre is to be set.
     * @throws IOException If an I/O issue occurs during input reading.
     */
    private static void multiStepSetGenre(BookList books, int index) throws IOException {
        NewGenreModifier.genreSelectionPrinter(books);
        Ui.printSingleIndentation();
        System.out.print("Enter the number for the desired genre, or add a new one:\n");
        Ui.printSingleIndentation();
        Scanner scanner = new Scanner(System.in);
        InputLooper looper = new InputLooper();
        String selectedGenre = looper.inputLooper(null, scanner, books);
        if (selectedGenre == null) {
            return;
        }
        BookGenre.setBookGenreByIndex(index, selectedGenre, books);
    }

    /**
     * Handles the single-step genre setting process which directly sets the genre for a book.
     *
     * @param books The BookList containing the books.
     * @param parts An array of String containing the book index and the genre.
     * @param index The index of the book for which the genre is to be set.
     */
    private static void singleStepSetGenre(BookList books, String[] parts, int index) {
        String genreInput = parts[1].trim();
        genreInput = NewGenreModifier.duplicateChecker(genreInput, books);
        BookGenre.setBookGenreByIndex(index, genreInput, books);
    }

    /**
     * Initiates the process of parsing and setting a genre for a book based on user input.
     *
     * @param books      The BookList containing the books to be updated.
     * @param inputArray An array of String containing the input command and arguments.
     * @throws IOException If an I/O issue occurs during command processing.
     */
    public static void executeParseSetGenre (BookList books, String[] inputArray) throws IOException {
        parseSetGenre(books, inputArray);
    }
}
