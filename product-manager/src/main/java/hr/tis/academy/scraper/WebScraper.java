package hr.tis.academy.scraper;

import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class WebScraper {

    public ProductsMetadata fetchProducts(){
        List<Product> productList = new ArrayList<>();
        String pageTitle = "";
        try{
            Integer countOfItems = 0;
            //Max 3 stranice!
            for (int i = 1; i < 4; i++)
            {
                Document doc = Jsoup.connect("https://www.konzum.hr/web/posebne-ponude?page="+i+"&per_page=25&sort%5B%5D=").get();
                pageTitle = doc.title();
                Elements paragraphs = doc.getElementsByClass("product-wrapper");
                for (Element paragraph : paragraphs) {
                    String title = paragraph.getElementsByClass("product-default__title") .getFirst().child(0).text();
                    Long rating = paragraph.getElementsByClass("stars").getFirst().getElementsByClass("is-active").stream().count();
                    String priceEur = paragraph.getElementsByClass("price--kn").getFirst().text();
                    String priceCent = paragraph.getElementsByClass("price--li").getFirst().text();
                    String byPiece = paragraph.getElementsByClass("price--c").getFirst().text();

                    BigDecimal priceEurDecimal = new BigDecimal(priceEur);
                    BigDecimal priceCentDecimal = new BigDecimal(priceCent).divide(new BigDecimal(100));
                    BigDecimal price = priceEurDecimal.add(priceCentDecimal);

                    System.out.println("Proizvod:" + title + "\nRating: " + rating);
                    Product product = new Product(title, price, byPiece, Math.toIntExact(rating));
                    productList.add(product);
                    countOfItems++;
                }
            }

            System.out.println("Broj proizvoda: " + countOfItems);

        } catch (IOException e){
            throw new RuntimeException(e);
        }
        return new ProductsMetadata(null, LocalDateTime.now(), pageTitle, productList);
    }
}