package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.bookdetailsmodifier.BookLabel;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserLabel {
    static void parseSetLabel(BookList books, String[] inputArray) {
        int index;
        assert inputArray.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray,2, "The Label " +
                "Command requires a book index and label");
        String[] labelMessageParts = inputArray[1].split(" ", 2);
        // Split the message into index and label message
        assert labelMessageParts.length == 2 : "Command requires an index and a label message";
        Exceptions.validateCommandArguments(labelMessageParts, 2, "You " +
                "need to have a label message");
        index = Integer.parseInt(labelMessageParts[0]);
        assert index > 0 : "Index should be non-negative";
        String label = labelMessageParts[1];
        BookLabel.setBookLabelByIndex(index, label, books);
        //test
    }

    public static void executeParseSetLabel (BookList books, String[] inputArray) {
        parseSetLabel(books, inputArray);
    }
}
