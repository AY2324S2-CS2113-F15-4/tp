package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Provides utility methods for handling date and time operations.
 * This class includes methods to get the current date and time in a predefined format
 * and to convert a string representation of a date and time back into a {@link LocalDateTime} object.
 *
 * The class is designed to be a utility with static methods, and thus cannot be instantiated.
 */
public class DateTimeUtils {

    /**
     * The formatter used for converting between {@link LocalDateTime} and strings.
     * It follows the pattern "hour.minute AM/PM, day-month-year".
     */
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("h.mm a, dd-MM-yyyy");

    /**
     * Private constructor to prevent instantiation.
     * Throws an exception if an attempt is made to instantiate this utility class.
     *
     * @throws UnsupportedOperationException if this class is attempted to be instantiated.
     */
    private DateTimeUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }

    /**
     * Gets the current date and time formatted as a string.
     *
     * @return A {@link String} representation of the current date and time,
     **** formatted according to the {@link DateTimeUtils#FORMATTER}.
     */
    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(FORMATTER);
    }

    /**
     * Converts a string representation of a date and time into a {@link LocalDateTime} object.
     * The string should be in the format defined by {@link DateTimeUtils#FORMATTER}.
     *
     * @param datetimeString The date and time in string format to be converted.
     * @return A {@link LocalDateTime} that represents the date and time specified in the input string.
     * @throws java.time.format.DateTimeParseException if the text cannot be parsed.
     */
    public static LocalDateTime convertStringToDateTime(String datetimeString) {
        return LocalDateTime.parse(datetimeString, FORMATTER);
    }

}
