package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetailsmodifier.BookFind;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.parser.parservalidation.Exceptions;

import java.io.IOException;
import java.util.Scanner;

//@@ liuzehui03
public class ParserFind {
    public static void parseTitle(BookList books, String inputArray) {
        BookFind.findBookTitle(books, inputArray);
    }

    public static void parseFindGenre(BookList books, String inputArray) {
        BookFind.findBookGenre(books, inputArray);

    }
    public static void parseGenreLong(BookList books) throws IOException {
        System.out.println("Available genres:");
        for (int i = 0; i < BookList.getAvailableGenres().size(); i++) {
            System.out.println((i + 1) + ". " + BookList.getAvailableGenres().get(i));
        }
        System.out.println("Enter the number for the desired genre:");
        Scanner scanner = new Scanner(System.in);
        String selectedGenre = ParserGenre.invalidInputLooper(null, scanner);
        if (selectedGenre == null) {
            return;
        }
        BookFind.findBookGenreLong(books, selectedGenre);
    }
    public static void parseFindRead(BookList books, String[] inputArray) {
        assert inputArray.length == 1 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 1,
                "This find command does not require any further arguments, just type `find-read`" +
                        " u absolute donut ");
        BookFind.findRead(books);
    }
    public static void parseFindUnread(BookList books, String[] inputArray) {
        assert inputArray.length == 1 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 1,
                "This find command does not require any further arguments, just type `find-unread`" +
                        " u absolute donut ");
        BookFind.findUnread(books);
    }

    public static void parseLabel(BookList books, String[] inputArray) {
        assert inputArray.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(inputArray, 2,
                "The correct command is `find-label [LABEL]");
        BookFind.findLabel(books, inputArray[1].trim());
    }

    public static void parseRate(BookList books, String[] input) {
        assert input.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(input, 2,
                "The correct command is `find-rated [RATING]");
        BookFind.findRate(books, input[1].trim());
    }

    public static void parseAuthor(BookList books, String[] input) {
        assert input.length == 2 : "Command requires additional arguments";
        Exceptions.validateCommandArguments(input, 2,
                "The correct command is `find-author [AUTHOR]");
        BookFind.findAuthor(books, input[1].trim());
    }
}
