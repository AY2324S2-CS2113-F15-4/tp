package seedu.bookbuddy;

import org.junit.jupiter.api.Test;
import seedu.bookbuddy.book.Genre;
import seedu.bookbuddy.book.Label;
import seedu.bookbuddy.book.Rating;
import seedu.bookbuddy.bookdetailsmodifier.BookGenre;
import seedu.bookbuddy.bookdetailsmodifier.BookLabel;
import seedu.bookbuddy.bookdetailsmodifier.BookRating;
import seedu.bookbuddy.booklist.BookList;
import seedu.bookbuddy.booklist.BookListModifier;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookDetailsTest {
    @Test
    public void testSetBookLabelByIndex() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "Geronimo Stilton");
        BookLabel.setBookLabelByIndex(1, "Great Classic", books);
        assertEquals("Great Classic" , Label.getLabel(books.getBook(1)));
        BookLabel.setBookLabelByIndex(2, "Great Classic", books);
        assertEquals("Great Classic" , Label.getLabel(books.getBook(2)));
    }

    @Test
    public void testSetBookGenreByIndex() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "Geronimo Stilton");
        BookGenre.setBookGenreByIndex(1, "Classic", books);
        assertEquals("Classic" , Genre.getGenre(books.getBook(1)));
        BookGenre.setBookGenreByIndex(2, "Fantasy", books);
        assertEquals("Fantasy" , Genre.getGenre(books.getBook(2)));
    }

    @Test
    public void testSetBookRatingsByIndex() {
        BookList books = new BookList();
        BookListModifier.addBook(books, "The Great Gatsby");
        BookListModifier.addBook(books, "Geronimo Stilton");
        BookRating.setBookRatingByIndex(1, 5, books);
        assertEquals(5 , Rating.getRating(books.getBook(1)));
        BookRating.setBookRatingByIndex(2, 3, books);
        assertEquals(3 , Rating.getRating(books.getBook(2)));
    }
}
