package hr.tis.academy.service.impl;

import hr.tis.academy.command.ImageCommand;
import hr.tis.academy.configuration.ExceptionHandlerController;
import hr.tis.academy.dto.DaysOfWeekResponse;
import hr.tis.academy.dto.WeekendResponse;
import hr.tis.academy.service.HelloService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.time.DayOfWeek;

@Service
public class HelloServiceImpl implements HelloService {
    private static final Logger LOGGER =
            LoggerFactory.getLogger(HelloServiceImpl.class);


    @Override
    public DaysOfWeekResponse daysOfWeek() {
        LOGGER.info("Nalazim se u metodi daysOfWeek");
        DayOfWeek today = LocalDate.now().getDayOfWeek();
        List<String> oddDays = Stream.of(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.getValue() % 2 != 0)
                .map(DayOfWeek::name)
                .collect(Collectors.toList());

        List<String> evenDays = Stream.of(DayOfWeek.values())
                .filter(dayOfWeek -> dayOfWeek.getValue() % 2 == 0)
                .map(DayOfWeek::name)
                .collect(Collectors.toList());
        return new DaysOfWeekResponse(today.name(), isWeekend(today).isWeekend(), oddDays, evenDays);
    }

    @Override
    public String greetings(List<String> names) {
        String htmlResponse;
        if (names == null || names.isEmpty()) {
            htmlResponse = "<h1>No names received.</h1>";
        } else {
            List<String> greetings = Arrays.asList("Hello", "Hi", "Greetings");
            Random random = new Random();
            htmlResponse = names.stream()
                    .map(name -> "<h1>" + greetings.get(random.nextInt(greetings.size())) + ", " + name + "!</h1>")
                    .collect(Collectors.joining("\n"));
        }
        return htmlResponse;
    }

    @Override
    public byte[] generateImage(ImageCommand request) {
        String text;
        if (request.getText() != null)
            text = request.getText();
        else
            text = "Hello TIS";
        int width = request.getWidth();
        int height = request.getHeight();
        int red = request.getRed();
        int green = request.getGreen();
        int blue = request.getBlue();

        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics2D = bufferedImage.createGraphics();
        graphics2D.setColor(new Color(red, green, blue));
        graphics2D.fillRect(0, 0, width, height);

        graphics2D.setColor(Color.BLACK);
        graphics2D.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        graphics2D.drawString(text, height/2, width / 2);
        graphics2D.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            ImageIO.write(bufferedImage, "png", baos);
        } catch (IOException e) {
            LOGGER.error("Exception occurred: ", e);
            return new byte[0];
        }

        return baos.toByteArray();
    }

    @Override
    public WeekendResponse isWeekend(DayOfWeek dayOfWeek) {
        return new WeekendResponse(dayOfWeek == DayOfWeek.SATURDAY || dayOfWeek == DayOfWeek.SUNDAY);
    }


}
