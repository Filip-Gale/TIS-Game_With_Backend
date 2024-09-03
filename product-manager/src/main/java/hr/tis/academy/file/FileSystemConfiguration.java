package hr.tis.academy.file;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
public class FileSystemConfiguration {
    @Value("${file.configuration.path}")
    private String filePath;
    @Bean("getPath")
    public Path getPath() {
        return Path.of(filePath);
    }
}
