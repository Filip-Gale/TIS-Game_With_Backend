package hr.tis.academy.model;

public class UserExists {
    private Boolean userExists;

    public UserExists() {
    }

    public UserExists(Boolean userExists) {
        this.userExists = userExists;
    }

    public Boolean getUserExists() {
        return userExists;
    }

    public void setUserExists(Boolean userExists) {
        this.userExists = userExists;
    }
}
