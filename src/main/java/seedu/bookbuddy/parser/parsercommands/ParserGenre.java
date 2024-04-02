package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.bookdetailsmodifier.BookGenre;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

import java.util.Scanner;

public class ParserGenre {
    static boolean parseSetGenre(BookList books, String[] inputArray) {
        int index;
        Exceptions.validateCommandArguments(inputArray, 2, "The set-genre " +
                "Command requires a book index.");
        index = Integer.parseInt(inputArray[1]);
        if (index < 0 || index > books.getSize()) {
            throw new IndexOutOfBoundsException("Invalid book index. Please enter a valid index. " +
                    "Type 'list' to view the list of books.");
        }
        genreSelectionPrinter();

        System.out.println("Enter the number for the desired genre, or add a new one:");
        Scanner scanner = new Scanner(System.in);

        String selectedGenre = null;
        selectedGenre = invalidInputLooper(selectedGenre, scanner);
        if (selectedGenre == null) return true;

        BookGenre.setBookGenreByIndex(index, selectedGenre, books);
        System.out.println("Genre set to " + selectedGenre + " for book at index " + index);
        return false;
    }

    private static void genreSelectionPrinter() {
        System.out.println("Available genres:");
        for (int i = 0; i < BookList.getAvailableGenres().size(); i++) {
            System.out.println((i + 1) + ". " + BookList.getAvailableGenres().get(i));
        }
        System.out.println((BookList.getAvailableGenres().size() + 1) + ". Add a new genre");
    }

    private static String invalidInputLooper(String selectedGenre, Scanner scanner) {
        while (selectedGenre == null) {
            while (!scanner.hasNextInt()) {  // Ensure the next input is an integer
                String newInput = scanner.nextLine();
                if ("exit".equalsIgnoreCase(newInput)) {
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
                selectedGenre = scanner.nextLine();
                BookList.getAvailableGenres().add(selectedGenre); // Add the new genre to the list
            } else if (genreSelection > 0 && genreSelection <= BookList.getAvailableGenres().size()) {
                selectedGenre = BookList.getAvailableGenres().get(genreSelection - 1);
            } else {
                System.out.println("Invalid selection. Please enter a valid number " +
                        "or type 'exit' to cancel.");
                // No need for the nextLine or parsing logic here, the while loop will continue
            }
        }
        return selectedGenre;
    }

    public static boolean executeParseSetGenre (BookList books, String[] inputArray) {
        parseSetGenre(books, inputArray);
        return false;
    }
}
