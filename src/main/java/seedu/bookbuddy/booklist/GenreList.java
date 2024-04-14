package seedu.bookbuddy.booklist;

import exceptions.BookNotFoundException;
import seedu.bookbuddy.Ui;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//@@author yeozongyao
public class GenreList {
    protected ArrayList<String> availableGenres = new ArrayList<String>(Arrays.asList(
            "Fiction", "Non-Fiction", "Mystery", "Science Fiction", "Fantasy"
    ));

    public GenreList() {

    }

    /**
     * Retrieves the list of currently available genres.
     *
     * @return An ArrayList containing all the genres currently stored.
     */
    public ArrayList<String> getAvailableGenres() {
        return availableGenres;
    }

    /**
     * Sets the list of available genres to a new list. This method clears the current list of genres
     * and copies all elements from the provided list to ensure no references to the original list are kept.
     *
     * @param newAvailableGenres A List containing the new list of genres to be set.
     */
    public void setAvailableGenres(List<String> newAvailableGenres) {
        // Clear the existing list and add all from the new list to avoid reference issues
        availableGenres.clear();
        availableGenres.addAll(newAvailableGenres);
    }

    /**
     * Retrieves a genre from the list based on its index.
     *
     * @param index The 1-based index of the genre to retrieve.
     * @return The genre at the specified index.
     * @throws BookNotFoundException If the index is less than 1 or greater than the size of the genre list.
     */
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

    /**
     * Prints the list of all available genres to the standard output.
     */
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

    /**
     * Creates a string representation of the available genres, suitable for saving.
     * The genres are concatenated into a single string, separated by commas.
     *
     * @return A String containing all genres, separated by commas.
     */
    public String saveGenresFormat() {
        return String.join(",", availableGenres);
    }

}
