package hr.tis.academy.dto;

import hr.tis.academy.model.Address;
import hr.tis.academy.model.WorkingDay;

import java.util.List;

public class StoreDto {
    private  Long id;
    private  String storeName;
    private Address address;
    private  String telephoneNumber;
    private String email;
    private List<WorkingDay> workingDays;

    public StoreDto() {}

    public StoreDto(Long id, String storeName, Address address, String telephoneNumber, String email, List<WorkingDay> workingDays) {
        this.id = id;
        this.storeName = storeName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.workingDays = workingDays;
    }

    public StoreDto(String storeName, Address address, String telephoneNumber, String email, List<WorkingDay> workingDays) {
        this.storeName = storeName;
        this.address = address;
        this.telephoneNumber = telephoneNumber;
        this.email = email;
        this.workingDays = workingDays;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
