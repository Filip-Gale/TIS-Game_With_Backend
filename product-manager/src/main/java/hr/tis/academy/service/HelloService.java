package hr.tis.academy.service;

import hr.tis.academy.command.ImageCommand;
import hr.tis.academy.dto.DaysOfWeekResponse;
import hr.tis.academy.dto.WeekendResponse;

import java.time.DayOfWeek;
import java.util.List;


public interface HelloService {
    DaysOfWeekResponse daysOfWeek();
    String greetings(List<String> names);
    byte[] generateImage(ImageCommand request);
    WeekendResponse isWeekend(DayOfWeek dayOfWeek);
}
