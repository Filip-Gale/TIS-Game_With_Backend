package hr.tis.academy.model.dto;


public class DuckyUsersDto {
    private Long id;
    private String username;
    private Boolean userExists;
    private Boolean isCheater;

    public DuckyUsersDto() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Boolean getUserExists() {
        return userExists;
    }

    public void setUserExists(Boolean userExists) {
        this.userExists = userExists;
    }

    public Boolean getCheater() {
        return isCheater;
    }

    public void setCheater(Boolean cheater) {
        isCheater = cheater;
    }
}
