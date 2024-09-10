package hr.tis.academy.service.impl;

import hr.tis.academy.model.DuckyUsers;
import hr.tis.academy.model.dto.DuckyUsersDto;
import hr.tis.academy.repository.DuckyUserRepository;
import hr.tis.academy.service.DuckyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DuckyUsersServiceImpl implements DuckyUserService {

    private final DuckyUserRepository duckyUserRepository;

    @Autowired
    public DuckyUsersServiceImpl(DuckyUserRepository duckyUserRepository) {
        this.duckyUserRepository = duckyUserRepository;
    }

    @Override
    public DuckyUsers getDuckyUsersByUsername(String username) {
        return duckyUserRepository.findByUserName(username);
    }

    @Override
    public DuckyUsersDto addDuckyUser(DuckyUsersDto duckyUsersDto) {
        DuckyUsers duckyUsers = new DuckyUsers(duckyUsersDto.getUsername(),true,false);
        duckyUserRepository.save(duckyUsers);
        DuckyUsersDto duckyUsersDto2 = new DuckyUsersDto();
        duckyUsersDto2.setId(duckyUsers.getId());
        duckyUsersDto2.setUsername(duckyUsers.getUserName());
        return duckyUsersDto2;
    }

    @Override
    public DuckyUsersDto checkIfDuckyUserExists(Long id) {
        DuckyUsersDto duckyUsersDto = new DuckyUsersDto();
            duckyUsersDto.setUserExists(duckyUserRepository.existsById(id));
            return duckyUsersDto;
    }
}
