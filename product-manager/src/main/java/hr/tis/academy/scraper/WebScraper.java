package hr.tis.academy.scraper;

import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class WebScraper {

    @Value("${webscraper.url.directory}")
    private String directoryUrl;
    @Value("${webscraper.url.settings}")
    private String settingsUrl;
    @Value("${webscraper.max.iterations}")
    private int maxIterations;

    public ProductsMetadata fetchProducts(){
        List<Product> productList = new ArrayList<>();
        String pageTitle = "";
        try{
            Integer countOfItems = 0;
            //Max 3 stranice!
            for (int i = 1; i < maxIterations; i++)
            {
                Document doc = Jsoup.connect(directoryUrl + i + settingsUrl).get();
                pageTitle = doc.title();
                Elements paragraphs = doc.getElementsByClass("product-wrapper");
                for (Element paragraph : paragraphs) {
                    String title = paragraph.getElementsByClass("product-default__title") .first().child(0).text();
                    Long rating = paragraph.getElementsByClass("stars").first().getElementsByClass("is-active").stream().count();
                    String priceEur = paragraph.getElementsByClass("price--kn").first().text();
                    String priceCent = paragraph.getElementsByClass("price--li").first().text();
                    String byPiece = paragraph.getElementsByClass("price--c").first().text();

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