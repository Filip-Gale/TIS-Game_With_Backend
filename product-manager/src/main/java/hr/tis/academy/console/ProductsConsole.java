package hr.tis.academy.console;

import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.repository.ProductRepositoryInMemory;
import hr.tis.academy.service.ProductService;
import hr.tis.academy.service.impl.ProductServiceImpl;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class ProductsConsole {
    private static ProductService productService = new ProductServiceImpl(new ProductRepositoryInMemory());

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
                    System.out.println(productService.fetchProductsFromWeb());
                }

                else if (command.startsWith("fetch-products")) {
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
                        ProductsMetadata productsMetadata = productService.getProductsForDate(date);
                        if (productsMetadata == null)
                        {
                            System.out.println("Product not found for specified date!");
                        }else{
                            for(Product product : productsMetadata.getProducts())
                            {
                                System.out.println(product.getName());
                            }
                        }
                    }
                }

                else if (command.equals("save-products")) {
                    System.out.println(productService.saveProductsFromWeb());
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
}
