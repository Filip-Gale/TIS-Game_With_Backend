package hr.tis.academy.model.dto;


public class DuckyUsersDto {
    private Long id;
    private String userName;
    private Boolean isCheater;

    public DuckyUsersDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String username) {
        this.userName = username;
    }

    public Boolean getCheater() {
        return isCheater;
    }

    public void setCheater(Boolean cheater) {
        isCheater = cheater;
    }
}
