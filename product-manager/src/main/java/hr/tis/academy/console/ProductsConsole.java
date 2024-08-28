package hr.tis.academy.console;

import java.util.Scanner;

public class ProductsConsole {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Welcome to TIS Java/Spring Academy 2024 product-manager app!\nStart with 'help' command to see the list of commands.");

        while (true)
        {
            String command = sc.nextLine().trim();

            try{
                switch (command)
                {
                    case "help":
                        System.out.println("Choose how to save the products from commands: (file, in-memory,db)\n" +
                        "Fetch products from web: fetch-products\n" +
                                "Fetch products for date in format yyyy-MM-dd: fetch-products {date}\n" +
                                "Fetch and save products: save-products\n" +
                                "Exit console: exit");

                }
            }catch (Exception e){
                System.out.println(e.getMessage());
            }
        }
    }
}
