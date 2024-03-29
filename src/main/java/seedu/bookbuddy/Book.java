package seedu.bookbuddy;

public class Book {
    public String title;
    protected boolean isRead;
    protected String label;
    protected String genre;

    protected String summary;

    /**
     * Creates a new Book with the specified title.
     *
     * @param title The description of the book.
     */
    public Book(String title) {
        this.title = title; // Description of the book
        this.isRead = false; //Completion status of the book (True: Read, False: Unread)
        this.label = "";
        this.genre = "";
    }

    /**
     * Sets the genre for this book.
     *
     * @param genre The label to set for the book.
     */
    public void setGenre(String genre) {
        this.genre = genre;  // Set the genre for the book
    }

    /**
     * Returns the genre of the book.
     *
     * @return The genre of the book.
     */
    public String getGenre() {
        return this.genre;
    }

    /**
     * Sets the label for this book.
     *
     * @param label The label to set for the book.
     */
    public void setLabel(String label) {
        this.label = label;  // Set the label for the book
    }

    /**
     * Returns the label of the book.
     *
     * @return The label of the book.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * Sets the summary for this book.
     *
     * @param summary The summary to set for the book.
     */
    public void setSummary(String summary) {
        this.summary = summary;
    }

    /**
     * Returns the summary of the book.
     *
     * @return The summary of the book.
     */
    public String getSummary() {
        return this.summary;
    }

    /**
     * Returns the title of the book.
     *
     * @return The title of the book.
     */
    public String getTitle() {
        return this.title;
    }

    /**
     * Checks if the book is read.
     *
     * @return True if the book is read, false otherwise.
     */
    public boolean isRead() {
        return this.isRead;
    }

    /**
     * Marks the book as read.
     */
    public void markBookAsRead() {
        this.isRead = true;
        System.out.println("Successfully marked " + this.getTitle() + " as read.");
    }

    /**
     * Marks the book as unread.
     */
    public void markBookAsUnread() {
        this.isRead = false;
        System.out.println("Successfully marked " + this.getTitle() + " as unread.");
    }

    public String toString() {
        String statusMark = this.isRead() ? "R" : "U"; // Mark with 'R' if read and 'U' if unread
        return "[" + statusMark + "] " + this.title;
    }
}
