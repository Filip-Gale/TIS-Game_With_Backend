package hr.tis.academy.file;

import org.springframework.stereotype.Component;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Component
public class LogWriter {
    public static final String LOG_DIRECTORY = "gameLog";

    public void writeLogToFile(String message, String fileName) {
        Path logDirPath = Paths.get(LOG_DIRECTORY);

        try {
            if (!Files.exists(logDirPath)) {
                Files.createDirectories(logDirPath);
            }

            try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true))) {
                String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                writer.write(timestamp + " - " + message);
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
