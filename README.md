This project is a calendar application with both back-end and front-end components. The back-end is built with Spring Boot, 
providing RESTful services for various calendar operations, while the front-end which is a different repo is developed using Angular to offer a user-friendly interface.

Back-End Setup
Prerequisites

Java 11 or higher
Maven
IDE (IntelliJ, Eclipse, etc.)
Project Structure

CalendarCalculator.java: Contains the core logic for calendar calculations.
CalendarController.java: RESTful controller exposing calendar operations.
DateUtil.java: Utility class for date parsing and formatting.
CalendarCalculatorTest.java: Unit tests for the CalendarCalculator class.
Building and Running


```
mvn clean install
mvn spring-boot:run
```
RESTful Endpoints

GET /app/calendar/add?date1={date1}&date2={date2}: Adds days to a given date.
GET /app/calendar/subtract?date1={date1}&date2={date2}: Subtracts days from a given date.
GET /app/calendar/dayofweek?date={date}: Returns the day of the week for a given date.
GET /app/calendar/printmonth?date={date}: Prints the calendar month for a given year and month.
GET /app/calendar/countbetween?startDate={startDate}&endDate={endDate}&unit={unit}: Counts the number of units between two dates.
