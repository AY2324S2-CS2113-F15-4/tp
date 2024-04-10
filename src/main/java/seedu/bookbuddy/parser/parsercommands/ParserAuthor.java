package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.bookdetailsmodifier.BookAuthor;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserAuthor {
    static void parseAuthor(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The author " +
                "Command requires a book index and author");
        String[] authorMessageParts = inputArray[1].split(" ", 2);
        assert authorMessageParts.length == 2 : "Command requires an index and a author name";
        Exceptions.validateCommandArguments(authorMessageParts, 2, "You need " +
                "to have an author name");
        index = Integer.parseInt(authorMessageParts[0]);
        assert index >= 0 : "Index should be non-negative";
        String author = authorMessageParts[1];
        BookAuthor.setBookAuthorByIndex(index, author, books);
    }

    public static void executeParseAuthor(BookList books, String[] inputArray) {
        parseAuthor(books, inputArray);
    }
}
