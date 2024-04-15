package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetailsmodifier.BookLabel;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

//@@author yeozongyao
public class ParserLabel {

    /**
     * Parses the input array to set a label for a specific book in the book list.
     * It requires the input array to have exactly two elements: the command, and a string containing the book index
     * followed by the desired label, separated by a space.
     *
     * @param books      The BookList containing the list of books.
     * @param inputArray An array of String containing the command and the combined index and label string.
     * @throws AssertionError If the input array does not contain two elements or if the index is not positive.
     * @throws IndexOutOfBoundsException if the provided index is out of the valid range for the book list.
     * @throws NumberFormatException if the index is not a valid integer.
     */
    static void parseSetLabel(BookList books, String[] inputArray) {
        int index = -1;
        assert inputArray.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray,2, "The Label " +
                "Command requires a book index and label");
        String[] labelMessageParts = inputArray[1].trim().split("\\s+", 2);
        // Split the message into index and label message
        assert labelMessageParts.length == 2 : "Command requires an index and a label message";
        try {
            index = Integer.parseInt(labelMessageParts[0].trim());
            if (index <= 0 || index > books.getSize()) {
                throw new IndexOutOfBoundsException("Invalid book index selection. Please enter a valid index. " +
                        "Type 'list' to view the list of books.");
            }
            assert index > 0 : "Index should be non-negative";
        } catch (NumberFormatException e) {
            System.out.println(labelMessageParts[0] + " is not a valid index format.");
        }
        Exceptions.validateCommandArguments(labelMessageParts, 2, "You " +
                "need to have a label message");
        String label = labelMessageParts[1].trim();
        BookLabel.setBookLabelByIndex(index, label, books);
    }

    /**
     * Executes the label setting process initiated by the user's input.
     * It calls the parseSetLabel method to handle the logic of parsing the input and updating the book's label.
     *
     * @param books      The BookList containing the list of books.
     * @param inputArray An array of String containing the command and the combined index and label string.
     */
    public static void executeParseSetLabel (BookList books, String[] inputArray) {
        parseSetLabel(books, inputArray);
    }
}
