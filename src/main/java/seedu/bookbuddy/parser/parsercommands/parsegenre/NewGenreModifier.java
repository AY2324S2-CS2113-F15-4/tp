package seedu.bookbuddy.parser.parsercommands.parsegenre;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.booklist.BookList;
//@@author yeozongyao
public class NewGenreModifier {

    /**
     * Prints all available genres from the book list to the console and provides an option
     * to add a new genre.
     *
     * @param books The BookList containing the list of genres to print.
     */
    static void genreSelectionPrinter(BookList books) {
        System.out.println("Available genres:");
        for (int i = 0; i < books.genreList.getAvailableGenres().size(); i++) {
            System.out.println((i + 1) + ". " + books.genreList.getAvailableGenres().get(i));
        }
        System.out.println((books.genreList.getAvailableGenres().size() + 1) + ". Add a new genre");
    }

    /**
     * Checks if the given genre already exists in the book list, adds it if it does not,
     * and normalizes the input to match the case of the existing genre.
     *
     * @param input The genre to check or add to the book list.
     * @param books The BookList that contains the genre list to check for the existence of the genre.
     * @return The existing genre if it exists, or the input genre if it was added.
     */
    static String duplicateChecker(String input, BookList books) {
        if (input == null) {
            return null;
        }
        boolean genreExists = false;
        for (String existingGenre : books.genreList.getAvailableGenres()) {
            if (existingGenre.equalsIgnoreCase(input)) {
                genreExists = true;
                input = existingGenre; // Normalize to the existing genre's case
                break;
            }
        }
        if (!genreExists) {
            books.genreList.getAvailableGenres().add(input);
            Ui.printLine();
            System.out.println("Added new genre to the list: " + input);
        } else {
            Ui.printLine();
            System.out.println("[" + input + "] exists in the existing genre list!");
        }
        return input;
    }
}
