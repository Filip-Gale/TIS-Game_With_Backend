package hr.tis.academy.file;

import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class ProductWriter {
    public static void writeProducts(ProductsMetadata productsMetadata) {
        String string = "%d_%s_%s.txt";
        String creationTimeRefactored = String.valueOf(productsMetadata.getCreationDateTime()).replace(":", "$");
        String filename = String.format(string, productsMetadata.getId(), creationTimeRefactored,
                productsMetadata.getTitle());

        try (BufferedWriter writer = Files.newBufferedWriter(
                FileSystemConfiguration.PRODUCTS_FILES_FOLDER_PATH.resolve(filename))) {

            productsMetadata.getProducts().forEach(product -> {
                String formattedString = String.format("%-100s%10s%-10s%d",
                        product.getName(),
                        product.getPrice(),
                        product.getCurrency(),
                        product.getScore());

                /*String formattedString = String.format("%-100s%10.2f%-10s%d",
                        product.getName(),
                        product.getPrice(),
                        product.getCurrency(),
                        product.getScore());*/
                try {
                    writer.write(formattedString);
                    writer.newLine();
                } catch (IOException e) {
                    throw new RuntimeException("Error writing product data", e);
                }
            });

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
