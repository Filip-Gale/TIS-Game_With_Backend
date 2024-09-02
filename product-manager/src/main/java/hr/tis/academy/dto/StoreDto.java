package hr.tis.academy.dto;

import java.util.List;

public class StoreDto {
    private  Long id;
    private  String storeName;
    private  AddressDto address;
    private  String telephoneNumber;
    private String email;
    private List<WorkingDayDto> workingDays;

    public StoreDto() {}

    public StoreDto(Long id, String storeName, AddressDto address, String telephoneNumber, String email, List<WorkingDayDto> workingDays) {
        this.id = id;
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

    public AddressDto getAddress() {
        return address;
    }

    public void setAddress(AddressDto address) {
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

    public List<WorkingDayDto> getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(List<WorkingDayDto> workingDays) {
        this.workingDays = workingDays;
    }
}
