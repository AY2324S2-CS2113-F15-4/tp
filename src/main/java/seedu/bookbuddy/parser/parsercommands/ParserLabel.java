package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetailsmodifier.BookLabel;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserLabel {
    static void parseSetLabel(BookList books, String[] inputArray) {
        int index = -1;
        assert inputArray.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray,2, "The Label " +
                "Command requires a book index and label");
        String[] labelMessageParts = inputArray[1].trim().split(" ", 2);
        // Split the message into index and label message
        assert labelMessageParts.length == 2 : "Command requires an index and a label message";
        try {
                index = Integer.parseInt(labelMessageParts[0].trim());
                if (index < 0 || index > books.getSize()) {
                    throw new IndexOutOfBoundsException("Invalid book index (out of range). Please enter a valid " +
                            "index.");
                }
                assert index > 0 : "Index should be non-negative";
        } catch (NumberFormatException e) {
            System.out.println(labelMessageParts[0] + " is not a valid index format.");
        } catch (IndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
        Exceptions.validateCommandArguments(labelMessageParts, 2, "You " +
                "need to have a label message");
        String label = labelMessageParts[1].trim();
        BookLabel.setBookLabelByIndex(index, label, books);
    }

    public static void executeParseSetLabel (BookList books, String[] inputArray) {
        parseSetLabel(books, inputArray);
    }
}
