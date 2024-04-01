package seedu.bookbuddy;

import exceptions.InvalidCommandArgumentException;
import exceptions.UnsupportedCommandException;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.logging.SimpleFormatter;
import java.util.logging.Handler;


import static java.util.logging.Logger.getLogger;



public class BookBuddy {
    static final Logger LOGGER = getLogger(BookBuddy.class.getName());

    static {
        try {
            LOGGER.setUseParentHandlers(false);
            // Remove all the default handlers
            Handler[] handlers = LOGGER.getHandlers();
            for (Handler handler : handlers) {
                LOGGER.removeHandler(handler);
            }
            // Add our file handler
            FileHandler fileHandler = new FileHandler("BookBuddy.log", true); // Append to the existing file
            fileHandler.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fileHandler);
            LOGGER.setLevel(Level.INFO);
        } catch (SecurityException | IOException e) {
            LOGGER.log(Level.SEVERE, "FileHandler can not be initialized", e);
        }
    }

    private static BookList books = new BookList();
    public static void main(String[] args) {
        LOGGER.log(Level.INFO, "BookBuddy application started.");
        Ui.printWelcome();
        assert books != null : "BookList not created";
        getUserInput(books);
        LOGGER.log(Level.INFO, "BookBuddy application is shutting down.");
    }


    public static void getUserInput(BookList books) {
        Scanner input = new Scanner(System.in);
        LOGGER.log(Level.INFO, "Starting to get user input.");

        //noinspection InfiniteLoopStatement
        while (true) {
            String userInput = input.nextLine().trim();
            if (userInput.isEmpty()) {
                // If the input is empty, do not call parseCommand and just prompt for input again.
                continue;
            }
            assert !userInput.isEmpty() : "User input should not be empty at this point";
            LOGGER.log(Level.FINE, "Processing user input: {0}", userInput);
            try {
                Parser.parseCommand(userInput, books);
            } catch (UnsupportedCommandException e) {
                LOGGER.log(Level.WARNING, "Unsupported command: {0}", userInput);
                System.out.println(e.getMessage());
            } catch (InvalidCommandArgumentException e) {
                System.out.println(e.getMessage());
            } catch (Exception e) { // Generic catch block for any other exceptions
                LOGGER.log(Level.SEVERE, "An unexpected error occurred: {0}", e.getMessage());
                System.out.println("An unexpected error occurred. Please contact support.");
            }
        }
    }
}
