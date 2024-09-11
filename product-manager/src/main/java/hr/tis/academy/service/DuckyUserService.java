package hr.tis.academy.service;

import hr.tis.academy.model.DuckyUsers;
import hr.tis.academy.model.dto.DuckyUsersDto;
import hr.tis.academy.model.UserExists;

public interface DuckyUserService{
    DuckyUsers getDuckyUsersByUserName(String username);
    DuckyUsersDto addDuckyUser(DuckyUsersDto duckyUsersDto);
    UserExists checkIfDuckyUserExists(Long id);
}
