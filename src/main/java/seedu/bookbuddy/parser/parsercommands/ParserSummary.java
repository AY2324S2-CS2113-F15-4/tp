package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.bookdetailsmodifier.BookSummary;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserSummary {
    //@@author lordgareth10
    static void parseSummary(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray,2, "The summary " +
                "Command requires a book index and summary");
        String[] summaryMessageParts = inputArray[1].split(" ", 2);
        assert summaryMessageParts.length == 2 : "Command requires an index and a summary message";
        Exceptions.validateCommandArguments(summaryMessageParts,2, "You need " +
                "to have a summary message");
        index = Integer.parseInt(summaryMessageParts[0]);
        assert index >= 0 : "Index should be non-negative";
        String summary = summaryMessageParts[1];
        BookSummary.setBookSummaryByIndex(index, summary, books);
    }

    public static void executeParseSummary (BookList books, String[] inputArray) {
        parseSummary(books, inputArray);
    }
}
