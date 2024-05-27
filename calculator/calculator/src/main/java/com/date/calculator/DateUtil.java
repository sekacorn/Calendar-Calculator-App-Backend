package com.date.calculator;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtil {
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

    /**
     * Parses a date string to a LocalDate object.
     *
     * @param dateStr The date string.
     * @return The LocalDate object.
     */
    public static LocalDate parseStringToLocalDate(String dateStr) {
        return LocalDate.parse(dateStr, DATE_FORMATTER);
    }

    /**
     * Formats a LocalDate object to a date string.
     *
     * @param date The LocalDate object.
     * @return The formatted date string.
     */
    public static String parseLocalDateToString(LocalDate date) {
        return date.format(DATE_FORMATTER);
    }

    public static void main(String[] args) {
        String dateStr = "2024-01-01";
        LocalDate localDate = parseStringToLocalDate(dateStr);
        System.out.println(localDate); // Output: 2024-01-01

        String formattedDate = parseLocalDateToString(localDate);

    }
}