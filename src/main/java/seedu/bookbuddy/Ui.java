package seedu.bookbuddy;

import seedu.bookbuddy.book.BookMain;
import seedu.bookbuddy.book.Title;
import seedu.bookbuddy.booklist.BookList;

import java.util.ArrayList;

public class Ui {
    public static void printWelcome() {
        String logo =
                " ____    ____  \n"
                        + "|    \\  |    \\ \n"
                        + "| |_) / | |_) / \n"
                        + "| |_) \\ | |_) \\ \n"
                        + "|____/  |____/ \n";
        printLine();
        System.out.println("Hello from");
        System.out.println("BookBuddy!");
        //System.out.println("Hello! We are BookBuddy!");
        System.out.println("How can I help you today?");
        printShortLine();
    }
    public static void printLine() {
        System.out.println("___________________________________");
    }
    public static void printShortLine() {
        System.out.println("_____________");
    }
    public static void printExitMessage() {
        System.out.println("Thank you for using BookBuddy! Hope to see you again keke :)");
    }

    public static void addBookMessage(String title) {
        System.out.println("okii added [" + title + "] to the list.");
        System.out.println("remember to read it soon....");
    }
    public static void labelBookMessage(String title, String label) {
        System.out.println("okii labeled [" + title + "] as [" + label + "]");
        System.out.println("remember to read it soon....");
    }
    public static void summaryBookMessage(String title, String summary) {
        System.out.println("okii you have written: [" + summary + "] for the book: [" + title + "]");
        System.out.println("remember to read it soon....");
    }
    public static void setGenreBookMessage(String title, String genre) {
        System.out.println("okii categorised [" + title + "] as [" + genre + "]");
        System.out.println("remember to read it soon....");
    }
    public static void setRatingBookMessage(String title, int rating) {
        System.out.println("okii set rating for [" + title + "] as [" + rating +"]");
        System.out.println("remember to read it soon....");
    }
    public static void removeBookMessage(int index, BookList books) {
        System.out.println("alright.. i've removed " + Title.getTitle(books.getBook(index)) + " from the list.");
    }
    public static void helpMessage() {
        System.out.println("Here's a list of commands to get you started!!");
        System.out.println("add [BOOK_TITLE] -> to add new books to the list");
        System.out.println("remove [BOOK_INDEX] -> to remove a book from the list");
        System.out.println("list -> to show whole list of added books");
        System.out.println("mark [BOOK_INDEX] -> to mark book as read [R]");
        System.out.println("unmark [BOOK_INDEX] -> to mark book as unread [U]");
        System.out.println("set-genre [BOOK_INDEX] -> to set a genre for a book");
        System.out.println("label [BOOK_INDEX] [LABEL] -> to set a label for a book");
        System.out.println("give-summary [BOOK_INDEX] [BOOK_SUMMARY] -> to give a book a summary");
        System.out.println("rate [BOOK_INDEX] [BOOK_RATING] -> to rate a book from 1-5");
        System.out.println("list-rated -> to sort books by rating in descending order");
        System.out.println("display [BOOK_INDEX] -> to view more details about a book");
        System.out.println("find-title [KEYWORD] -> to find books with keyword in their title");
        System.out.println("bye -> to exit BookBuddy software");
    }

    public static void printBookFound(ArrayList<BookMain> bookTitles){
        for (int i = 0; i < bookTitles.size(); i++) {
            System.out.println(i + 1 + ". " + bookTitles.get(i));
        }
    }
    public static void printNoBookFound(){
        System.out.println("no such books added...");

    }
    public static void printGenresFound(ArrayList<BookMain> bookGenres){
        for (int i = 0; i < bookGenres.size(); i++) {
            System.out.println(i + 1 + ". " + bookGenres.get(i));
        }
    }
    public static void printNoGenresFound(){
        System.out.println("no such books added...");

    }
}
