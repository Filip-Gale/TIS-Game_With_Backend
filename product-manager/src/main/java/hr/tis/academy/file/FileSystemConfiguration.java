package hr.tis.academy.file;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.nio.file.Path;

@Configuration
public class FileSystemConfiguration {
    //public static final Path PRODUCTS_FILES_FOLDER_PATH = Path.of("products");
    @Value("${file.configuration.path}")
    private String filePath;
    @Bean("getPath")
    public Path getPath() {
        return Path.of(filePath);
    }
}
