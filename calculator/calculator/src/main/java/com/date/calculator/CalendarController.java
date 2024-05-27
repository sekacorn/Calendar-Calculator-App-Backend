package com.date.calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/app/calendar")
public class CalendarController {

    @Autowired
    private CalendarCalculator calendarCalculator;

    /**
     * Adds a number of days to a given date.
     * @param date1 The base date as a string.
     * @param date2 The number of days to add as a string (formatted as "0000-00-xx").
     * @return The resulting date as a string.
     */
    @GetMapping("/add")
    public String addDates(@RequestParam String date1, @RequestParam String date2) {
        return calendarCalculator.addDates(date1, date2);
    }

    /**
     * Subtracts a number of days from a given date.
     * @param date1 The base date as a string.
     * @param date2 The number of days to subtract as a string (formatted as "yyyy-MM-dd").
     * @return The resulting date as a string.
     */
    @GetMapping("/subtract")
    public String subtractDates(@RequestParam String date1, @RequestParam String date2) {
        return calendarCalculator.subtractDates(date1, date2);
    }

    /**
     * Gets the day of the week for a given date.
     * @param date The date as a string.
     * @return The day of the week.
     */
    @GetMapping("/dayofweek")
    public String getDayOfWeek(@RequestParam String date) {
        return calendarCalculator.getDayOfWeek(date);
    }

    /**
     * Prints the calendar month for a given year and month.
     * @param date The year and month as a string (formatted as "yyyy-MM").
     * @return The calendar month as a formatted string.
     */
    @GetMapping("/printmonth")
    public String printMonth(@RequestParam String date) {
        return calendarCalculator.printMonth(date);
    }

    /**
     * Counts the number of units between two dates.
     * @param startDate The start date as a string.
     * @param endDate The end date as a string.
     * @param unit The unit of time to measure ("DAYS", "WEEKS", "MONTHS", "YEARS").
     * @return The number of units between the two dates.
     */
    @GetMapping("/countbetween")
    public int countBetween(@RequestParam String startDate, @RequestParam String endDate, @RequestParam String unit) {
        return calendarCalculator.countBetween(startDate, endDate, unit);
    }
}
