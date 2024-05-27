package com.date.calculator;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.DayOfWeek;

@Service
public class CalendarCalculator {

    // Formatter to parse and format dates in ISO format (yyyy-MM-dd)
    private static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ISO_DATE;

    /**
     * Adds a number of days to a given date.
     * @param date1 The base date as a string.
     * @param date2 The number of days to add as a string (formatted as "0000-00-xx").
     * @return The resulting date as a string.
     */
    public String addDates(String date1, String date2) {
        LocalDate localDate1 = LocalDate.parse(date1, DATE_FORMATTER);
        LocalDate daysToAdd = LocalDate.parse(date2, DATE_FORMATTER);

        // Assuming date2 is the number of days to add
        LocalDate resultDate = localDate1.plusDays(daysToAdd.getDayOfMonth());
        return resultDate.format(DATE_FORMATTER);
    }

    /**
     * Subtracts a number of days from a given date.
     * @param date1 The base date as a string.
     * @param date2 The number of days to subtract as a string (formatted as "yyyy-MM-dd").
     * @return The resulting date as a string.
     */
    public String subtractDates(String date1, String date2) {
        LocalDate localDate1 = LocalDate.parse(date1, DATE_FORMATTER);
        LocalDate localDate2 = LocalDate.parse(date2, DATE_FORMATTER);

        long daysBetween = ChronoUnit.DAYS.between(localDate2, LocalDate.now());
        LocalDate resultDate = localDate1.minusDays(daysBetween);
        return resultDate.format(DATE_FORMATTER);
    }

    /**
     * Gets the day of the week for a given date.
     * @param date The date as a string.
     * @return The day of the week.
     */
    public String getDayOfWeek(String date) {
        LocalDate localDate = LocalDate.parse(date, DATE_FORMATTER);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        return dayOfWeek.toString();
    }

    /**
     * Prints the calendar month for a given year and month.
     * @param date The year and month as a string (formatted as "yyyy-MM").
     * @return The calendar month as a formatted string.
     */
    public String printMonth(String date) {
        YearMonth yearMonth = YearMonth.parse(date, DateTimeFormatter.ofPattern("yyyy-MM"));
        StringBuilder monthCalendar = new StringBuilder();
        monthCalendar.append(yearMonth.getMonth().toString()).append(" ").append(yearMonth.getYear()).append("\n");
        monthCalendar.append("MON TUE WED THU FRI SAT SUN\n");

        LocalDate firstOfMonth = yearMonth.atDay(1);
        DayOfWeek firstDayOfWeek = firstOfMonth.getDayOfWeek();

        int dayOfMonth = 1;
        boolean started = false;
        for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
            if (!started && dayOfWeek == firstDayOfWeek) {
                started = true;
            }
            if (started) {
                monthCalendar.append(String.format("%3d ", dayOfMonth++));
                if (dayOfMonth > yearMonth.lengthOfMonth()) break;
            } else {
                monthCalendar.append("    ");
            }
            if (dayOfWeek == DayOfWeek.SUNDAY) {
                monthCalendar.append("\n");
            }
        }
        return monthCalendar.toString();
    }

    /**
     * Counts the number of units between two dates.
     * @param startDate The start date as a string.
     * @param endDate The end date as a string.
     * @param unit The unit of time to measure ("DAYS", "WEEKS", "MONTHS", "YEARS").
     * @return The number of units between the two dates.
     */
    public int countBetween(String startDate, String endDate, String unit) {
        LocalDate start = LocalDate.parse(startDate, DATE_FORMATTER);
        LocalDate end = LocalDate.parse(endDate, DATE_FORMATTER);
        switch (unit.toUpperCase()) {
            case "DAYS":
                return (int) ChronoUnit.DAYS.between(start, end);
            case "WEEKS":
                return (int) ChronoUnit.WEEKS.between(start, end);
            case "MONTHS":
                return (int) ChronoUnit.MONTHS.between(start, end);
            case "YEARS":
                return (int) ChronoUnit.YEARS.between(start, end);
            default:
                throw new IllegalArgumentException("Invalid unit: " + unit);
        }
    }
}
