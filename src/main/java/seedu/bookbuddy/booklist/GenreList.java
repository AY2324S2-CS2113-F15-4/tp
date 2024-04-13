package seedu.bookbuddy.booklist;

import exceptions.BookNotFoundException;
import seedu.bookbuddy.Ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenreList {
    protected ArrayList<String> availableGenres = new ArrayList<String>(Arrays.asList(
            "Fiction", "Non-Fiction", "Mystery", "Science Fiction", "Fantasy"
    ));

    public GenreList() {

    }
    public ArrayList<String> getAvailableGenres() {
        return availableGenres;
    }

    public void setAvailableGenres(List<String> newAvailableGenres) {
        // Clear the existing list and add all from the new list to avoid reference issues
        availableGenres.clear();
        availableGenres.addAll(newAvailableGenres);
    }

    public String getGenre(Integer index) {
        if (index < 0 || index > availableGenres.size()) {
            throw new BookNotFoundException("Genre index out of range.");
        }
        return availableGenres.get(index - 1);
    }
    /**
     * Removes a specified genre from the available genres list.
     * @param genreIndexToRemove The genre to remove from the list.
     */
    public void removeGenre(Integer genreIndexToRemove) {
         availableGenres.remove(genreIndexToRemove - 1);
    }

    public void printGenreList() {
        assert availableGenres != null : "Genre list should not be null since it has been initialised.";
        if (!availableGenres.isEmpty()) {
            Ui.printLine();
            System.out.println("All Genres:");
            for (int i = 0; i < availableGenres.size(); i++) {
                String genre = availableGenres.get(i);
                assert genre != null : "Book in list should not be null";
                System.out.print((i + 1) + ". ");
                System.out.println(genre);
            }
            Ui.printShortLine();
        } else {
            System.out.println("The list is empty. Add books by 'add [book]'");
        }
    }

    public String saveGenresFormat() {
        return String.join(",", availableGenres);
    }

}