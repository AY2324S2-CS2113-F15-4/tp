package seedu.bookbuddy.parser.parsercommands.parsegenre;

import exceptions.InvalidCommandArgumentException;
import seedu.bookbuddy.Ui;
import seedu.bookbuddy.bookdetailsmodifier.BookGenre;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

import java.io.IOException;
import java.util.Scanner;

public class ParserGenre {
    static void parseSetGenre(BookList books, String[] inputArray) throws IOException {
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

    private static void singleStepSetGenre(BookList books, String[] parts, int index) {
        String genreInput = parts[1].trim();
        genreInput = NewGenreModifier.duplicateChecker(genreInput, books);
        BookGenre.setBookGenreByIndex(index, genreInput, books);
    }


    public static void executeParseSetGenre (BookList books, String[] inputArray) throws IOException {
        parseSetGenre(books, inputArray);
    }
}
