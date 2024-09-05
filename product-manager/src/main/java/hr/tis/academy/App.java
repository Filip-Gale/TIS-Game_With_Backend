package hr.tis.academy;

import hr.tis.academy.controller.StoreServiceImpl;
import hr.tis.academy.dto.StoreDto;
import hr.tis.academy.model.*;
import hr.tis.academy.repository.*;
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
import java.util.List;

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
    private  final StoreRepository storeRepository;
    @Autowired
    public App(ProductsMetadataRepository productsMetadataRepository, ProductRepositoryJPA productRepositoryJPA, StoreRepository storeRepository) {
        this.productsMetadataRepository = productsMetadataRepository;
        this.productRepositoryJPA = productRepositoryJPA;
        this.storeRepository = storeRepository;
    }

    @Bean
    public ApplicationRunner applicationRunner() {
        return args -> {
            //1.c)
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
            //1.d)
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
            //1.e)
            productsMetadataRepository.fetchProductsRecord(createdTime.minusMinutes(1), createdTime.minusSeconds(2));

            if (pm != null) {
                System.out.println("Pronaslo: " + pm);
            } else {
                System.out.println("Nije pronaslo.");
            }
            */
           /*
            //1.f)
            var avg = productRepositoryJPA.getAverageScoreJPQL(15L);
            System.out.println("avg  " + avg);

            var lista = productsMetadataRepository.fetchProductsRecords(LocalDate.of(2024,9,5).atStartOfDay(),
                    LocalDate.of(2024,9,5).atTime(LocalTime.MAX));

            for (ProductsMetadata productsMetadata : lista) {
                System.out.println("productsMetadata: " + productsMetadata);
            }
*/
            //2 c)
            StoreServiceImpl storeService = new StoreServiceImpl(storeRepository);

            /*System.out.println("Fetch store by email: " + storeRepository.fetchStoreRecord("info@seveneleven.com").getStoreName());
            Store store = storeRepository.findById(1L).orElseThrow(() -> new RuntimeException("Store not found"));
            System.out.println("Fetch by id: " + store.getStoreName());

            System.out.println("Get store by id: " + storeService.getStorebyId(1L).getStoreName());*/

           /* System.out.println("Add store: " + storeService.addStore(
                    new StoreDto(
                            "MegaMart",
                            new Address("Los Angeles", "USA", "Sunset Boulevard", "202"),
                            "01-345-6789",
                            "info@megamart.com",
                            List.of(
                                    new WorkingDay(3L,"WEDNESDAY", LocalTime.of(10, 0), LocalTime.of(18, 0)),
                                    new WorkingDay(4L,"THURSDAY", LocalTime.of(10, 0), LocalTime.of(18, 0))
                            )
                    )
            ));*/

           /* System.out.println("Update: " + storeService.updateStore(2L,
                    new StoreDto(
                            "MegaMart2",
                            new Address("Los Angeles", "USA", "Sunset Boulevard", "202"),
                            "01-345-6789",
                            "info@megamart.com",
                            List.of(
                                    new WorkingDay(null,"WEDNESDAY", LocalTime.of(10, 0), LocalTime.of(18, 0)),
                                    new WorkingDay(null,"THURSDAY", LocalTime.of(10, 0), LocalTime.of(18, 0))
                            )
                    )
            ));*/

            //storeService.deleteStore(2L);
            //storeService.partialUpdateStore(1L, new StoreDto("9-11", null, null, null, null));
            System.out.println("Get all stores: \n");
            storeService.getAllStores().stream()
                    .map(StoreDto::getStoreName)
                    .forEach(System.out::println);

        };
    }

}
