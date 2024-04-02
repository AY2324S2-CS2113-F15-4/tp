package seedu.bookbuddy;

import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileWriter;

/**
 * The FileStorage class handles file operations such as creating directories,
 * reading and writing to files and also loading data from files.
 */
public class FileStorage {
    private static final String FILE_NAME = "books.txt";
    private static final String FILE_DIRECTORY = "./data";
    private static final String FILE_PATH = FILE_DIRECTORY + '/' + FILE_NAME;

    public FileStorage(BookList books) {
        try {
            File directory = new File(FILE_DIRECTORY);
            if (!directory.exists()) {
                directory.mkdir();
            }
            File file = new File(FILE_PATH);
            if (file.exists()) {
                readData(books, file);
            } else {
                file.createNewFile();
            }
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    /**
     * Scans through each line of the file and converts them to books,
     * along with their proper details.
     * @param file the name of the file whose content is to be read
     * @throws FileNotFoundException when the file does not exist
     */
    public void readData(BookList books, File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);

        while (sc.hasNext()) {
            String line = sc.nextLine();
            books.addBookFromFile(line);
        }

        sc.close();
    }

    public void saveData(BookList books) throws IOException {
        File file = new File(FILE_PATH);
        FileWriter fw = new FileWriter(file);
        for (int i = 1; i <= books.getSize(); i += 1) {
            fw.write(books.getBook(i).saveFormat());
        }

        fw.close();
        System.out.println("Writing successful. Data has been saved.");
    }
}
