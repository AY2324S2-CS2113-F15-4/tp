package utils;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeUtils {

    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("HH-mm, dd-MM-yyyy");

    // Private constructor to prevent instantiation
    private DateTimeUtils() {
        throw new UnsupportedOperationException("This is a utility class and cannot be instantiated");
    }
    public static String getCurrentDateTime() {
        LocalDateTime now = LocalDateTime.now();
        return now.format(FORMATTER);
    }

}

