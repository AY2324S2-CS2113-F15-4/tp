package seedu.bookbuddy.parser.parsercommands;

import seedu.bookbuddy.bookdetailsmodifier.BookDisplay;
import seedu.bookbuddy.booklist.BookList;

import java.util.Scanner;

import static seedu.bookbuddy.parser.parsercommands.ParserGenre.invalidInputLooper;

public class ParserFind {
    public static void parseTitle(BookList books, String inputArray) {
        BookDisplay.findBookTitle(books, inputArray);
    }

    public static void parseFindGenre(BookList books) {
        //BookDisplay.findBookGenre(books, inputArray);
        System.out.println("Available genres:");
        for (int i = 0; i < BookList.getAvailableGenres().size(); i++) {
            System.out.println((i + 1) + ". " + BookList.getAvailableGenres().get(i));
        }
        System.out.println("Enter the number for the desired genre:");
        Scanner scanner = new Scanner(System.in);
        String genre = String.valueOf(scanner);
        String selectedGenre = null;
        selectedGenre = invalidInputLooper(selectedGenre, scanner);
        if (selectedGenre == null) {
            return;
        }
        BookDisplay.findBookGenre(books, selectedGenre);
    }
    public static void parseFindStatus(BookList books, String inputArray) {
        BookDisplay.findMarkStatus(books, inputArray);
    }
}
