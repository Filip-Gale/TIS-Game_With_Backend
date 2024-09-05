package hr.tis.academy.model;

import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESS", schema = "PRODUCT_MANAGER")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String city;
    @Column
    private String country;
    @Column
    private String streetName;
    @Column
    private String houseNumber;
    @OneToOne(mappedBy = "address")
    private Store store;

    public Address() {}

    public Address(Long id, String city, String country, String streetName, String houseNumber, Store store) {
        this.id = id;
        this.city = city;
        this.country = country;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
        this.store = store;
    }

    public Address(String city, String country, String streetName, String houseNumber) {
        this.city = city;
        this.country = country;
        this.streetName = streetName;
        this.houseNumber = houseNumber;
    }
}
