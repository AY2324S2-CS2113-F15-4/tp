package seedu.bookbuddy.parser.parsercommands.parserating;

import exceptions.InvalidCommandArgumentException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class RatingChecksTest {

    @Test
    void testGetRatingPartsValidInput() {
        String[] inputArray = {"rate", "1 5"};
        String[] parts = RatingChecks.getRatingParts(inputArray);
        assertArrayEquals(new String[]{"1", "5"}, parts);
    }

    @Test
    void testGetRatingPartsInvalidInput() {
        String[] inputArray = {"rate", "one five"};
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RatingChecks.getRatingParts(inputArray);
        });
        assertTrue(exception.getMessage().contains("one and five are not valid integers"));
    }

    @Test
    void testGetRatingPartsIncompleteArguments() {
        String[] inputArray = {"rate", "1"};
        Exception exception = assertThrows(InvalidCommandArgumentException.class, () -> {
            RatingChecks.getRatingParts(inputArray);
        });
        assertTrue(exception.getMessage().contains("You need to have a book index and a rating"));
    }

    @Test
    void testParseIntegerValid() {
        assertEquals(5, RatingChecks.parseInteger("5", "Error parsing integer"));
    }

    @Test
    void testParseIntegerInvalid() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            RatingChecks.parseInteger("abc", "abc is not a valid integer");
        });
        assertTrue(exception.getMessage().contains("abc is not a valid integer"));
    }

    @Test
    void testIsNotNumericFalse() {
        assertFalse(RatingChecks.isNotNumeric("123"));
    }

    @Test
    void testIsNotNumericTrue() {
        assertTrue(RatingChecks.isNotNumeric("abc"));
    }

    @Test
    void testIsNotNumericNull() {
        assertTrue(RatingChecks.isNotNumeric(null));
    }


}
