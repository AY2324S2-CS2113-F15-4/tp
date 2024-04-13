package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.book.Author;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.bookdetailsmodifier.BookAuthor;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserAuthor {
    static void parseAuthor(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2, "The author " +
                "Command requires a book index and author");
        String[] authorMessageParts = inputArray[1].trim().split(" ", 2);
        assert authorMessageParts.length == 2 : "Command requires an index and a author name";
        Exceptions.validateCommandArguments(authorMessageParts, 2, "You need " +
                "to have an author name");
        index = Integer.parseInt(authorMessageParts[0].trim());
        assert index >= 0 : "Index should be non-negative";
        String author = authorMessageParts[1].trim();
        String title = Title.getTitle(books.getBooks().get(index - 1));
        if (author.equals(Author.getAuthor(books.getBooks().get(index - 1)))) {
            Ui.printAuthorAlreadySet(title, author);
        } else if (BookList.checkDuplicateBookAuthor(books, author, title)){
            Ui.printDuplicateAuthorWarning(title, author);
        } else {
            BookAuthor.setBookAuthorByIndex(index, author, books);
        }
    }

    public static void executeParseAuthor(BookList books, String[] inputArray) {
        parseAuthor(books, inputArray);
    }
}
