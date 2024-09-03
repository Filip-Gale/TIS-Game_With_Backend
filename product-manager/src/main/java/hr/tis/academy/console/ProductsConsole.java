package hr.tis.academy.console;

import hr.tis.academy.dto.ProductsMetadataDto;
import hr.tis.academy.file.FileSystemConfiguration;
import hr.tis.academy.file.ProductReader;
import hr.tis.academy.file.ProductWriter;
import hr.tis.academy.mappers.ProductsMetadataMapper;
import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.repository.ProductRepositoryDB;
import hr.tis.academy.repository.ProductRepositoryFile;
import hr.tis.academy.repository.ProductRepositoryInMemory;
import hr.tis.academy.scraper.WebScraper;
import hr.tis.academy.service.ProductService;
import hr.tis.academy.service.impl.ProductServiceImpl;

import java.nio.file.Path;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProductsConsole {
    private static ProductService productService = null;
    private static WebScraper webScraper = new WebScraper();
    private static Path path = new FileSystemConfiguration().getPath("products");
    private static ProductReader productReader = new ProductReader(path);
    private static ProductWriter productWriter = new ProductWriter(path);

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TIS Java/Spring Academy 2024 product-manager app!\nStart with 'help' command to see the list of commands.");

        while (true)
        {
            String command = sc.nextLine().trim();

            try{
                if(command.equals("help"))
                {
                    System.out.println("Choose how to save the products from commands: (file, in-memory,db)\n" +
                            "Fetch products from web: fetch-products\n" +
                            "Fetch products for date in format yyyy-MM-dd: fetch-products {date}\n" +
                            "Fetch and save products: save-products\n" +
                            "Exit console: exit");
                }

                else if (command.equals("fetch-products")) {
                    if(isRepositorySet())
                    {
                        System.out.println(productService.fetchProductsFromWeb());
                    }
                }

                else if (command.startsWith("fetch-products")) {
                    if(isRepositorySet())
                    {
                        String[] inputs = command.split(" ");
                        if(inputs.length == 2) {
                            LocalDate date = null;
                            try {
                                date = LocalDate.parse(inputs[1], DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                            } catch (Exception e) {
                                System.out.println("Invalid date format" + e.getMessage());
                            }

                            if (date == null)
                                continue;
                            ProductsMetadataDto productsMetadata = productService.getProductsForDate(date);
                            if (productsMetadata == null)
                            {
                                System.out.println("Product not found for specified date!");
                            }else{
                                System.out.println(productsMetadata);
                            }
                        }
                    }
                }

                else if (command.equals("save-products")) {
                    if(isRepositorySet())
                    {
                        System.out.println(productService.saveProductsFromWeb());
                    }
                }
                else if (command.equals("file") || command.equals("in-memory") || command.equals("db")) {
                    if(command.equals("file"))
                    {
                        //Promjeniti na ProductRepositoryFile
                        productService = new ProductServiceImpl(new ProductRepositoryFile(path, productReader, productWriter), ProductsMetadataMapper.INSTANCE, webScraper);
                    }else if(command.equals("in-memory"))
                    {
                        productService = new ProductServiceImpl(new ProductRepositoryInMemory(), ProductsMetadataMapper.INSTANCE, webScraper);
                    }else
                    {
                        //Promjeniti na ProductRepositoryDB
                        productService = new ProductServiceImpl(new ProductRepositoryDB(), ProductsMetadataMapper.INSTANCE, webScraper);
                    }
                }

                else if (command.equals("exit")) {
                    break;
                }

                else{
                    System.out.println("Unknown command: " + command);
                }

            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }

    private static boolean isRepositorySet(){
        if(productService == null)
        {
            System.out.println("Product service not initialized. Please set how to save files: file   in-memory   db");
            return false;
        }

        return true;
    }
}
