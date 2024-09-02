package hr.tis.academy.dto;

import java.time.LocalTime;

public record WorkingDayDto(
        String dayOfWeek,
        LocalTime startTime,
        LocalTime endTime)
{ }
