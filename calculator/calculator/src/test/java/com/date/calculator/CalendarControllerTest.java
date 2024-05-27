package com.date.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(CalendarController.class)
class CalendarControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CalendarCalculator calendarCalculator;

    @Test
    void testAddDates() throws Exception {
        when(calendarCalculator.addDates(anyString(), anyString())).thenReturn("Result");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/add")
                        .param("date1", "2024-01-01")
                        .param("date2", "2024-01-02"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result"));
    }

    @Test
    void testSubtractDates() throws Exception {
        when(calendarCalculator.subtractDates(anyString(), anyString())).thenReturn("Result");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/subtract")
                        .param("date1", "2024-01-02")
                        .param("date2", "2024-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string("Result"));
    }

    @Test
    void testGetDayOfWeek() throws Exception {
        when(calendarCalculator.getDayOfWeek(anyString())).thenReturn("Monday");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/dayOfWeek")
                        .param("date", "2024-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().string("Monday"));
    }

    @Test
    void testPrintMonth() throws Exception {
        when(calendarCalculator.printMonth(anyString())).thenReturn("January 2024");

        mockMvc.perform(MockMvcRequestBuilders.get("/api/printMonth")
                        .param("date", "2024-01"))
                .andExpect(status().isOk())
                .andExpect(content().string("January 2024"));
    }

    @Test
    void testCountBetween() throws Exception {
        when(calendarCalculator.countBetween(anyString(), anyString(), anyString())).thenReturn(10);

        mockMvc.perform(MockMvcRequestBuilders.get("/api/countBetween")
                        .param("startDate", "2024-01-01")
                        .param("endDate", "2024-01-10")
                        .param("unit", "DAYS"))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
}
