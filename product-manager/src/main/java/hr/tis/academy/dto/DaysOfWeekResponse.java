package hr.tis.academy.dto;

import java.util.List;

public record DaysOfWeekResponse(String today, boolean isWeekend, List<String> oddDays, List<String> evenDays) {}
