package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

//@@author yeozongyao
public class ParserAdd {

    /**
     * Parses the input array to add a new book to the book list.
     * The input must contain at least one additional argument specifying the book title.
     *
     * @param books      The BookList where the new book will be added.
     * @param inputArray An array containing the command and the arguments. The second element
     *                   should be the title of the book to add.
     * @throws AssertionError If the input array does not have the required number of elements.
     */
    private static void parseAdd(BookList books, String[] inputArray) {
        assert inputArray.length >= 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The add " +
                "Command requires a book title");
        BookListModifier.addBook(books, inputArray[1]);
    }

    /**
     * Executes the process of adding a new book to the book list based on user input.
     * This is the public entry point to initiate the addition of a new book.
     *
     * @param books      The BookList where the new book will be added.
     * @param inputArray An array containing the command and the arguments. The second element
     *                   should be the title of the book to add.
     */
    public static void executeParseAdd (BookList books, String[] inputArray) {
        parseAdd(books, inputArray);
    }
}
