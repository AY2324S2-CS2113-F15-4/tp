package seedu.bookbuddy;

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

    /*public static String printInvalidCommand() {
        String message = "The add command requires a book title.";
        System.out.println(message);
        return message;
    } */
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
    public static void removeBookMessage(int index) {
        System.out.println("alright.. i've removed " + BookList.books.get(index).getTitle() + " from the list.");
    }
    public static void helpMessage() {
        System.out.println("Here's a list of commands to get you started!!");
        System.out.println("add (Bookname) -> to add new books to the list");
        System.out.println("list -> to show whole list of added books");
        System.out.println("remove (index) -> to remove the book from the corresponding index");
        System.out.println("mark (index) -> to mark book as read [R]");
        System.out.println("unmark (index) -> to unmark book as unread [U]");
        System.out.println("bye -> to exit BookBuddy software");
    }
}
