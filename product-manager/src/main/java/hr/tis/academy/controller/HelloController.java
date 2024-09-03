package hr.tis.academy.controller;

import hr.tis.academy.command.ImageCommand;
import hr.tis.academy.dto.DaysOfWeekResponse;
import hr.tis.academy.dto.HelloResponse;
import hr.tis.academy.dto.WeekendResponse;
import hr.tis.academy.service.HelloService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.DayOfWeek;
import java.util.List;

@RestController
@RequestMapping("/common/")
public class HelloController {
    private final HelloService helloService;

    @Autowired
    public HelloController(HelloService helloService) {
        this.helloService = helloService;
    }

    @GetMapping("hello")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("HELLO");
    }
    @GetMapping("hello-json")
    public HelloResponse helloResponse(@RequestParam(value = "helloString", defaultValue = "HELLO")
                                           String helloString) {
        return new HelloResponse(helloString);
    }
    @GetMapping("days-of-week")
    public ResponseEntity<DaysOfWeekResponse> daysOfWeek() {
        return new ResponseEntity<>(helloService.daysOfWeek(), HttpStatus.OK);
    }
    @GetMapping("names")
    public ResponseEntity<String> greetings(@RequestParam(value = "name", required = false) List<String> names) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "text/html")
                .body(helloService.greetings(names));
    }
    @GetMapping("image")
    public ResponseEntity<byte[]> image(@ModelAttribute @Valid ImageCommand request) {
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_TYPE, "image/png")
                .body(helloService.generateImage(request));
    }
    @GetMapping("is-weekend")
    public ResponseEntity<WeekendResponse> isWeekend(@RequestParam("dayOfWeek") DayOfWeek dayOfWeek) {
        return ResponseEntity.ok().body(helloService.isWeekend(dayOfWeek));
    }
}
