package seedu.bookbuddy.book;

import java.util.Objects;

public class BookMain {
    protected String title;
    protected boolean isRead;
    protected String label;
    protected String genre;
    protected int rating;
    protected String summary;

    /**
     * Creates a new Book with the specified title.
     *
     * @param title The description of the book.
     */
    public BookMain(String title) {
        this.title = title; // Description of the book
        this.isRead = false; //Completion status of the book (True: Read, False: Unread)
        this.label = "";
        this.genre = "";
        this.rating = -1;
        this.summary = "";
    }

    public BookMain(String title, int status, String label, String genre, int rating, String summary) {
        this.title = title;
        this.isRead = status == 1;
        this.label = (Objects.equals(label, "*")) ? "" : label;
        this.genre = (Objects.equals(genre, "*")) ? "" : genre;
        this.rating = rating;
        this.summary = (Objects.equals(summary, "*")) ? "" : summary;
    }

    //@@author joshuahoky
    @Override
    public String toString() {
        String statusMark = Read.getRead(this) ? "R" : "U"; // Mark with 'R' if read and 'U' if unread
        return "[" + statusMark + "] " + this.title;
    }

    public String saveFormat() {
        String status = isRead ? "1" : "0";
        String label = (this.label.isEmpty()) ? "*" : this.label;
        String genre = (this.genre.isEmpty()) ? "*" : this.genre;
        String summary = (this.summary.isEmpty()) ? "*" : this.summary;
        return this.title + " | " + status + " | " + label + " | " + genre + " | " + this.rating
                + " | " + summary;
    }
}
