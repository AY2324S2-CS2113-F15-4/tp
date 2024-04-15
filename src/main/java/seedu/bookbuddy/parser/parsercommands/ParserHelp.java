package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.Ui;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

public class ParserHelp {

    private static void parseHelp(String[] inputArray) {
        Exceptions.validateCommandArguments(inputArray, 1,
                "The help command does not require any further arguments, just type `help` :))))");
        Ui.helpMessage();
    }


    public static void executeParseHelp (String[] inputArray) {
        parseHelp(inputArray);
    }
}
