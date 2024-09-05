package hr.tis.academy;

import hr.tis.academy.model.Product;
import hr.tis.academy.model.ProductsMetadata;
import hr.tis.academy.repository.ProductRepository;
import hr.tis.academy.repository.ProductRepositoryInMemory;
import hr.tis.academy.repository.ProductRepositoryJPA;
import hr.tis.academy.repository.ProductsMetadataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.Arrays;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

/*    @Autowired
    private ApplicationContext applicationContext;
    @Autowired
    private ProductRepository productRepository;
    @Bean("EJEJEJEJJ")
    public ApplicationRunner applicationRunner() {
        return args -> {
            Arrays.stream(applicationContext.getBeanDefinitionNames())
                    .forEach(System.out::println);


            ProductRepository productRepositoryInMemory = (ProductRepository) applicationContext.getBean("productRepositoryFile");
            System.out.println("productRepository " + productRepository.fetchProductsMetadataCount());

            System.out.println("AAA " + productRepository.fetchProductsMetadataCount());
        };
    }*/

    /*private final Path filePath;

    @Autowired
    public ProductReader(@Qualifier("getPath") Path filePath) {
        this.filePath = filePath;
    }*/

    private final ProductsMetadataRepository productsMetadataRepository;
    private final ProductRepositoryJPA productRepositoryJPA;
    @Autowired
    public App(ProductsMetadataRepository productsMetadataRepository, ProductRepositoryJPA productRepositoryJPA) {
        this.productsMetadataRepository = productsMetadataRepository;
        this.productRepositoryJPA = productRepositoryJPA;
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            //c)
          /*  String title = "Lista 4";
            LocalDateTime createdTime = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
            ProductsMetadata pm = new ProductsMetadata(createdTime, title);
            productsMetadataRepository.save(pm);
            //ProductsMetadata productsMetadata = productsMetadataRepository.findByTitleAndCreationDateTime(title, createdTime);
            //ProductsMetadata productsMetadata = productsMetadataRepository.fetchByTitleAndCreatedTimeJPQL(title, createdTime);
            //ProductsMetadata productsMetadata = productsMetadataRepository.fetchByTitleAndCreatedTimeNative(title, createdTime);

            *//*if (productsMetadata != null) {
                System.out.println("Pronaslo: " + productsMetadata);
            } else {
                System.out.println("Nije pronaslo.");
            }*//*

*/
            /*
            //d)
            String name = "Name 1";
            int score = 5;
            Product p = new Product(name, score, pm);
            productRepositoryJPA.save(p);
            Product product = productRepositoryJPA.findByNameAndScoreNative(name, score);

            if (product != null) {
                System.out.println("Pronaslo: " + product);
            } else {
                System.out.println("Nije pronaslo.");
            }*/

           /*
            //e)
            productsMetadataRepository.fetchProductsRecord(createdTime.minusMinutes(1), createdTime.minusSeconds(2));

            if (pm != null) {
                System.out.println("Pronaslo: " + pm);
            } else {
                System.out.println("Nije pronaslo.");
            }
            */
            //f)
            var avg = productRepositoryJPA.getAverageScoreJPQL(15L);
            System.out.println("avg  " + avg);

            var lista = productsMetadataRepository.fetchProductsRecords(LocalDate.of(2024,9,5).atStartOfDay(),
                    LocalDate.of(2024,9,5).atTime(LocalTime.MAX));

            for (ProductsMetadata productsMetadata : lista) {
                System.out.println("productsMetadata: " + productsMetadata);
            }


        };
    }

}
