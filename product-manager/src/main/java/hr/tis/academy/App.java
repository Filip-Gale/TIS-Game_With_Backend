package hr.tis.academy;

import hr.tis.academy.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

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
}
