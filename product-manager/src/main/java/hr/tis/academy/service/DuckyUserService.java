package hr.tis.academy.service;

import hr.tis.academy.model.DuckyUsers;
import hr.tis.academy.model.dto.DuckyUsersDto;

public interface DuckyUserService{
    DuckyUsers getDuckyUsersByUsername(String username);
    DuckyUsersDto addDuckyUser(DuckyUsersDto duckyUsersDto);
    DuckyUsersDto checkIfDuckyUserExists(Long id);
}
