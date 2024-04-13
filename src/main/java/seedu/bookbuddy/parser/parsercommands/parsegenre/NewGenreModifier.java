package seedu.bookbuddy.parser.parsercommands.parsegenre;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.booklist.BookList;

public class NewGenreModifier {
    static void genreSelectionPrinter(BookList books) {
        System.out.println("Available genres:");
        for (int i = 0; i < books.getAvailableGenres().size(); i++) {
            System.out.println((i + 1) + ". " + books.getAvailableGenres().get(i));
        }
        System.out.println((books.getAvailableGenres().size() + 1) + ". Add a new genre");
    }

    static String duplicateChecker(String input, BookList books) {
        if (input == null) {
            return null;
        }
        boolean genreExists = false;
        for (String existingGenre : books.getAvailableGenres()) {
            if (existingGenre.equalsIgnoreCase(input)) {
                genreExists = true;
                input = existingGenre; // Normalize to the existing genre's case
                break;
            }
        }
        if (!genreExists) {
            books.getAvailableGenres().add(input);
            Ui.printLine();
            System.out.println("Added new genre to the list: " + input);
        } else {
            Ui.printLine();
            System.out.println("[" + input + "] exists in the existing genre list!");
        }
        return input;
    }
}
