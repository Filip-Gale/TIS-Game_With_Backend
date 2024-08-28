package hr.tis.academy.ws;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;

public class WebScraping {
    public static void main(String[] args) {
        try{
            Integer countOfItems = 0;
            for (int i = 1; i < 2; i++)
            {
                Document doc = Jsoup.connect("https://www.konzum.hr/web/posebne-ponude?page="+i+"&per_page=25&sort%5B%5D=").get();

                Elements paragraphs = doc.getElementsByClass("product-wrapper");
                System.out.println(paragraphs.size());



            }

        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
