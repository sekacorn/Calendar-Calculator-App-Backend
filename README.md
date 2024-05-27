This project is a calendar application with both back-end and front-end components. The back-end is built with Spring Boot, 
providing RESTful services for various calendar operations, while the front-end which is a different repo is developed using Angular to offer a user-friendly interface.

## Back-End Setup
## Prerequisites

Java 11 or higher

Maven

IDE (IntelliJ, Eclipse)


## Project Structure

CalendarCalculator.java: Contains the core logic for calendar calculations.
CalendarController.java: RESTful controller exposing calendar operations.
DateUtil.java: Utility class for date parsing and formatting.
CalendarCalculatorTest.java: Unit tests for the CalendarCalculator class.
Building and Running


```
mvn clean install
mvn spring-boot:run
```
## RESTful Endpoints

GET /app/calendar/add?date1={date1}&date2={date2}: Adds days to a given date.

GET /app/calendar/subtract?date1={date1}&date2={date2}: Subtracts days from a given date.

GET /app/calendar/dayofweek?date={date}: Returns the day of the week for a given date.

GET /app/calendar/printmonth?date={date}: Prints the calendar month for a given year and month.

GET /app/calendar/countbetween?startDate={startDate}&endDate={endDate}&unit={unit}: Counts the number of units between two dates.


## Steps to Build and Deploy

1 Build Docker Image:
Navigate to the root directory of your project (where the Dockerfile is located) and run:

```
docker build -t calendar-calculator 
```

2 Push Docker Image to a Container Registry:
Tag and push your image to Docker Hub (replace your_dockerhub_username with your actual Docker Hub username):


```
docker tag calendar-calculator:latest your_dockerhub_username/calendar-calculator:latest
docker push your_dockerhub_username/calendar-calculator:latest
```

3 Deploy to Kubernetes:


Apply the Kubernetes configuration from the k8s directory:


```
kubectl apply -f k8s/deployment.yaml
```
This setup will help you maintain a clean and organized project structure while ensuring your Docker and Kubernetes configuration files are correctly placed for building and deployment.
