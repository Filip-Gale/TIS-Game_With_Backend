package hr.tis.academy.file;

import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Component
public class ProductReader {
    /* private final Path filePath;

    @Autowired
    public ProductReader(@Qualifier("getPath") Path filePath) {
        this.filePath = filePath;
    }
    public  ProductsMetadata read(String fileName) {*/
    @Autowired
    @Qualifier("getPath")
    private static Path filePath;

    public static ProductsMetadata read(String fileName) {
        try (BufferedReader reader =
                     Files.newBufferedReader(filePath.resolve(fileName)))
        {

            List<Product> products = new ArrayList<>();

            String line;
            while ((line = reader.readLine()) != null) {
                String name = line.substring(0, 100).trim();
                String pricePart = line.substring(100, 110).trim();
                String currency = line.substring(110, 120).trim();
                String score = line.substring(120).trim();

                Product product = new Product(name, new BigDecimal(pricePart), currency, Integer.parseInt(score));
                products.add(product);
            }

            String fileWithoutExtension = fileName.substring(0, fileName.lastIndexOf('.'));

            String[] parts = fileWithoutExtension.split("_");

            Long id = Long.parseLong(parts[0]);
            String creationDateTimeString = parts[1].replace("$", ":");
            String title = parts[2];

            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
            LocalDateTime creationDateTime = LocalDateTime.parse(creationDateTimeString, formatter);

            return new ProductsMetadata(id, creationDateTime, title, products);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
