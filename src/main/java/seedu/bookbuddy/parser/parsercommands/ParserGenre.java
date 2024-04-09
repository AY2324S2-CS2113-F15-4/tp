package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.bookdetailsmodifier.BookGenre;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

import java.util.Scanner;

public class ParserGenre {
    static void parseSetGenre(BookList books, String[] inputArray) {
        Exceptions.validateCommandArguments(inputArray, 2, "The set-genre command requires " +
                "at least a book index.");

        String[] parts = inputArray[1].trim().split(" ", 2); //Attempt to split inputArray[1] into two parts
        int index;
        try {
            index = Integer.parseInt(parts[0]); // The first part should be the index
        } catch (NumberFormatException e) {
            System.out.println("Invalid book index. Please enter a valid numeric index.");
            return;
        }

        if (index <= 0 || index > books.getSize()) {
            System.out.println("Invalid book index. Please enter a valid index. Type 'list' to view the " +
                    "list of books.");
            return;
        }

        if (parts.length > 1 && !parts[1].isEmpty()) {
            // Single-step process: Set genre directly
            singleStepSetGenre(books, parts, index);
        } else {
            // Multistep process: Follow the existing flow
            multiStepSetGenre(books, index);
        }
    }

    private static void multiStepSetGenre(BookList books, int index) {
        genreSelectionPrinter();
        System.out.println("Enter the number for the desired genre, or add a new one:");
        Scanner scanner = new Scanner(System.in);

        String selectedGenre = invalidInputLooper(null, scanner);
        if (selectedGenre == null) {
            return;
        }
        BookGenre.setBookGenreByIndex(index, selectedGenre, books);
    }

    private static void singleStepSetGenre(BookList books, String[] parts, int index) {
        String genreInput = parts[1].trim();
        genreInput = duplicateChecker(genreInput);
        BookGenre.setBookGenreByIndex(index, genreInput, books);
    }

    static void genreSelectionPrinter() {
        System.out.println("Available genres:");
        for (int i = 0; i < BookList.getAvailableGenres().size(); i++) {
            System.out.println((i + 1) + ". " + BookList.getAvailableGenres().get(i));
        }
        System.out.println((BookList.getAvailableGenres().size() + 1) + ". Add a new genre");
    }

    public static String invalidInputLooper(String input, Scanner scanner) {
        while (input == null) {
            while (!scanner.hasNextInt()) {  // Ensure the next input is an integer
                String newInput = scanner.nextLine().trim();
                if ("exit".equalsIgnoreCase(newInput)) {
                    Ui.exitCommandMessage();
                    return null;
                } else {
                    System.out.println("Invalid input. Please enter a valid number or type 'exit'" +
                            " to cancel.");
                }
            }

            int genreSelection = scanner.nextInt();
            scanner.nextLine(); // Consume the newline after the number

            if (genreSelection == BookList.getAvailableGenres().size() + 1) {
                System.out.println("Enter the new genre:");
                input = scanner.nextLine().trim();
                input = duplicateChecker(input);
            } else if (genreSelection > 0 && genreSelection <= BookList.getAvailableGenres().size()) {
                input = BookList.getAvailableGenres().get(genreSelection - 1);
            } else {
                System.out.println("Invalid selection. Please enter a valid number " +
                        "or type 'exit' to cancel.");
                // No need for the nextLine or parsing logic here, the while loop will continue
            }
        }
        return input;
    }

    private static String duplicateChecker(String input) {
        boolean genreExists = false;
        for (String existingGenre : BookList.getAvailableGenres()) {
            if (existingGenre.equalsIgnoreCase(input)) {
                genreExists = true;
                input = existingGenre; // Normalize to the existing genre's case
                break;
            }
        }
        if (!genreExists) {
            BookList.getAvailableGenres().add(input);
            Ui.printLine();
            System.out.println("Added new genre to the list: " + input);
        } else {
            Ui.printLine();
            System.out.println("[" + input + "] exists in the existing genre list!");
        }
        return input;
    }

    public static void executeParseSetGenre (BookList books, String[] inputArray) {
        parseSetGenre(books, inputArray);
    }
}
