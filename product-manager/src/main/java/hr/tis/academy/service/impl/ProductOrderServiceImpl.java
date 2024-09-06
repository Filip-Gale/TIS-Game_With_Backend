package hr.tis.academy.service.impl;

import hr.tis.academy.dto.ProductsOrderDto;
import hr.tis.academy.enums.Level;
import hr.tis.academy.enums.Title;
import hr.tis.academy.model.*;
import hr.tis.academy.repository.*;
import hr.tis.academy.service.ProductOrderService;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProductOrderServiceImpl implements ProductOrderService {

    private final ProducOrderRepository producOrderRepository;
    private final EmployeeRepository employeeRepository;
    private final StoreRepository storeRepository;
    private final ProductsMetadataRepository productsMetadataRepository;
    private final PositionRepository positionRepository;

    @Autowired
    public ProductOrderServiceImpl(ProducOrderRepository producOrderRepository, EmployeeRepository employeeRepository, StoreRepository storeRepository, ProductsMetadataRepository productsMetadataRepository, PositionRepository positionRepository) {
        this.producOrderRepository = producOrderRepository;
        this.employeeRepository = employeeRepository;
        this.storeRepository = storeRepository;
        this.productsMetadataRepository = productsMetadataRepository;
        this.positionRepository = positionRepository;
    }

    /*@PostConstruct
    public void init() {
        WorkingDay monday = new WorkingDay("MONDAY", LocalTime.of(9, 0), LocalTime.of(17, 0));
        WorkingDay tuesday = new WorkingDay("TUESDAY", LocalTime.of(9, 0), LocalTime.of(17, 0));

        Store store = new Store(
                "7-eleven",
                new Address("New York", "USA", "5th Avenue", "101"),
                "01-234-567-8900",
                "info@seveneleven.com",
                List.of(
                        monday, tuesday
                )
        );

        Position position = new Position(Title.DRIVER, Level.SENIOR);

        Employee employee = new Employee(
                "Filip",
                "Gale",
                Date.valueOf(LocalDate.now()),
                "12345678901",
                Date.valueOf(LocalDate.now()),
                5.0,
                0,
                position,
                store
        );

        Product product = new Product(
                "keks",
                BigDecimal.valueOf(1),
                "Eur",
                5
        );

        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product);

        ProductsMetadata productsMetadata = new ProductsMetadata(
                LocalDateTime.now(),
                "lista",
                products
        );

        ProductsOrder productsOrder = new ProductsOrder(
                true,
                LocalDateTime.now(),
                LocalDate.now(),
                store,
                employee,
                productsMetadata
        );



        storeRepository.save(store);
        positionRepository.save(position);
        employeeRepository.save(employee);
        productsMetadataRepository.save(productsMetadata);
        producOrderRepository.save(productsOrder);
    }*/

    @Override
    public List<ProductsOrder> getAllProductOrders() {
        return producOrderRepository.findAll();
    }

    @Override
    public ProductsOrder getProductOrderByUUID(UUID uuid) {
        return producOrderRepository.findByUuid(uuid);
    }


    @Override
    public List<ProductsOrder> getActiveOrders() {
        return producOrderRepository.fetchByIsActive(Boolean.TRUE);
    }

    @Override
    public ProductsOrderDto saveProductOrder(ProductsOrder productsOrder) {
        storeRepository.save(productsOrder.getStore());
        positionRepository.save(productsOrder.getEmployee().getPosition());
        employeeRepository.save(productsOrder.getEmployee());
        productsMetadataRepository.save(productsOrder.getProductMetadata());
        producOrderRepository.save(productsOrder);
        return new ProductsOrderDto(productsOrder.getEmployee().getFirst_name(),
                productsOrder.getEmployee().getId(),
                productsOrder.getUuid(),
                productsOrder.calculateOrderCost(),
                productsOrder.getDeliveryDate());
    }

    @Override
    public Boolean deactivateProductsOrder(UUID productOrderId) {
        if(producOrderRepository.findByUuid(productOrderId) == null) {
            return false;
        }
        ProductsOrder productsOrder = producOrderRepository.findByUuid(productOrderId);
        productsOrder.setActive(false);
        producOrderRepository.save(productsOrder);
        return true;
    }
}
