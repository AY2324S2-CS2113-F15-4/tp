package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

//@@author yeozongyao
public class ParserRemoveGenre {

    /**
     * Parses the input command to remove a genre from a book list based on the specified index.
     * The command expects an index that corresponds to the genre to be removed. Genres with an index
     * less than or equal to 5 are considered default genres and cannot be removed.
     *
     * @param books      The BookList containing the genres.
     * @param inputArray An array of String containing the command and the genre index.
     *                   The genre index should be a valid integer and correspond to an existing genre.
     * @throws AssertionError if the input array does not contain exactly two elements.
     * @throws IndexOutOfBoundsException if the provided index is out of the valid range for the genre list.
     * @throws NumberFormatException if the index is not a valid integer.
     */
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

    /**
     * Executes the genre removal process based on the user's input command.
     * This method acts as the public entry point to initiate the removal of a genre.
     *
     * @param books      The BookList containing the genres.
     * @param inputArray An array of String containing the command and the genre index.
     */
    public static void executeParseRemove (BookList books, String[] inputArray) {
        parseRemoveGenre(books, inputArray);
    }
}
