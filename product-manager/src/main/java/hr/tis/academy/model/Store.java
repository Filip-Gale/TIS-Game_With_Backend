package hr.tis.academy.model;

import hr.tis.academy.dto.AddressDto;
import hr.tis.academy.dto.WorkingDayDto;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "STORE", schema = "PRODUCT_MANAGER")
public class Store{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private  Long id;
    @Column
    private  String storeName;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @Column
    private  String telephoneNumber;
    @Column
    private String email;
    @OneToMany(mappedBy = "store", fetch = FetchType.EAGER)
    private List<WorkingDay> workingDays = new ArrayList<>();

    public Store(){}

    public Store(String storeName, Address address, String telephoneNumber, String email, List<WorkingDay> workingDays) {
        this.storeName = storeName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.workingDays = workingDays;
    }

    public Long getId() {
        return id;
    }

    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<WorkingDay> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<WorkingDay> workingDays) {
        this.workingDays = workingDays;
    }
}
