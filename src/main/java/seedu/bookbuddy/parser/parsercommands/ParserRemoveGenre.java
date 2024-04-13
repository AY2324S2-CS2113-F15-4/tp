package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserRemoveGenre {
    static void parseRemoveGenre(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The remove " +
                "Command requires a book index");
        try {
            index = Integer.parseInt(inputArray[1].trim());
            String genre = books.genreList.getGenre(index);
            if (index > 5) {
                books.genreList.removeGenre(index);
                Ui.printGenreRemovedMessage(genre);
            } else {
                System.out.println("sorrryy.. you cannot remove the default genres heehee");
            }
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Genre list is out of bounds :( " +
                    "Use [list-genre] to see the genre list");
        } catch (NumberFormatException e) {
            System.out.println(inputArray[1].trim() + " is not a valid index format :( ");
        }

    }

    public static void executeParseRemove (BookList books, String[] inputArray) {
        parseRemoveGenre(books, inputArray);
    }
}
