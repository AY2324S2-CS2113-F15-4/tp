package seedu.bookbuddy.book;

import java.util.Objects;

public class BookMain {
    protected String title;
    protected boolean isRead;
    protected String datetimeread;
    protected String label;
    protected String genre;
    protected int rating;
    protected String summary;

    /**
     * Creates a new Book with the specified title.
     *
     * @param title The title of the book.
     */
    public BookMain(String title) {
        this.title = title; // Description of the book
        this.isRead = false; //Completion status of the book (True: Read, False: Unread)
        this.datetimeread = "";
        this.label = "";
        this.genre = "";
        this.rating = -1;
        this.summary = "";
    }

    //@@author joshuahoky
    /**
     * Additional BookMain constructor for reading in books from text file.
     *
     * @param title The title of the book.
     * @param status Whether the book is read or unread.
     * @param label The label assigned to the book.
     * @param genre The genre of the book.
     * @param rating The rating assigned to the book.
     * @param summary The summary of the book.
     */
    public BookMain(String title, int status,String label, String genre, int rating, String summary,
                    String datetimeread) {
        this.title = title;
        this.isRead = status == 1;
        this.datetimeread = (Objects.equals(datetimeread, "*")) ? "" : datetimeread;
        this.label = (Objects.equals(label, "*")) ? "" : label;
        this.genre = (Objects.equals(genre, "*")) ? "" : genre;
        this.rating = rating;
        this.summary = (Objects.equals(summary, "*")) ? "" : summary;
    }

    @Override
    public String toString() {
        String statusMark = Read.getRead(this) ? "R" : "U"; // Mark with 'R' if read and 'U' if unread
        return "[" + statusMark + "] " + this.title;
    }

    /**
     * Method to convert details to the correct string format for writing.
     *
     * @return The string with the details of the book to be written to the text file.
     */
    public String saveFormat() {
        String status = isRead ? "1" : "0";
        String datetimeread = (this.datetimeread.isEmpty()) ? "*" : this.datetimeread;
        String label = (this.label.isEmpty()) ? "*" : this.label;
        String genre = (this.genre.isEmpty()) ? "*" : this.genre;
        String summary = (this.summary.isEmpty()) ? "*" : this.summary;
        return this.title + " | " + status + " | " + label + " | " + genre + " | " + this.rating
                + " | " + summary + " | " + datetimeread;
    }
}
