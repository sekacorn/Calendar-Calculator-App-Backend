package com.date.calculator;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalendarCalculatorTest {

    private final CalendarCalculator calendarCalculator = new CalendarCalculator();
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

    /**
     * Test for the addDates method.
     */
    @Test
    void testAddDates() {
        String date1 = "2024-01-01";
        String date2 = "0000-00-10"; // Adding 10 days

        LocalDate localDate1 = DateUtil.parseStringToLocalDate(date1);
        LocalDate expectedDate = localDate1.plusDays(10);

        String result = calendarCalculator.addDates(date1, date2);
        assertEquals(DateUtil.parseLocalDateToString(expectedDate), result);
    }

    /**
     * Test for the subtractDates method.
     */
    @Test
    void testSubtractDates() {
        String date1 = "2024-01-10";
        String date2 = "2024-01-01";

        LocalDate localDate1 = DateUtil.parseStringToLocalDate(date1);
        LocalDate localDate2 = DateUtil.parseStringToLocalDate(date2);

        long daysBetween = java.time.temporal.ChronoUnit.DAYS.between(localDate2, localDate1);
        LocalDate expectedDate = localDate1.minusDays(daysBetween);

        String result = calendarCalculator.subtractDates(date1, date2);
        assertEquals(DateUtil.parseLocalDateToString(expectedDate), result);
    }

    /**
     * Test for the getDayOfWeek method.
     */
    @Test
    void testGetDayOfWeek() {
        String date = "2024-01-01";
        LocalDate localDate = DateUtil.parseStringToLocalDate(date);
        String expected = localDate.getDayOfWeek().toString();

        String result = calendarCalculator.getDayOfWeek(date);
        assertEquals(expected, result);
    }

    /**
     * Test for the printMonth method.
     */
    @Test
    void testPrintMonth() {
        String date = "2024-01";
        String expected = "JANUARY 2024\nMON TUE WED THU FRI SAT SUN\n    1  2  3  4  5  6  7\n 8  9 10 11 12 13 14\n15 16 17 18 19 20 21\n22 23 24 25 26 27 28\n29 30 31";
        String result = calendarCalculator.printMonth(date);
        assertEquals(expected, result);
    }

    /**
     * Test for the countBetween method.
     */
    @Test
    void testCountBetween() {
        String startDate = "2024-01-01";
        String endDate = "2024-01-10";
        String unit = "DAYS";

        LocalDate start = DateUtil.parseStringToLocalDate(startDate);
        LocalDate end = DateUtil.parseStringToLocalDate(endDate);

        int expected = (int) java.time.temporal.ChronoUnit.DAYS.between(start, end);

        int result = calendarCalculator.countBetween(startDate, endDate, unit);
        assertEquals(expected, result);
    }
}
