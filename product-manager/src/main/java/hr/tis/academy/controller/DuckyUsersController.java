package hr.tis.academy.controller;

import hr.tis.academy.model.DuckyUsers;
import hr.tis.academy.model.UserExists;
import hr.tis.academy.model.dto.DuckyUsersDto;
import hr.tis.academy.service.DuckyUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class DuckyUsersController {

    private final DuckyUserService duckyUserService;

    @Autowired
    public DuckyUsersController(DuckyUserService duckyUserService) {
        this.duckyUserService = duckyUserService;
    }

    @GetMapping
    DuckyUsersDto getDuckyUsers(@RequestParam String userName) {
        DuckyUsers duckyUsers = duckyUserService.getDuckyUsersByUserName(userName);
        DuckyUsersDto duckyUsersDto = new DuckyUsersDto();
        duckyUsersDto.setId(duckyUsers.getId());
        duckyUsersDto.setUserName(userName);
        return duckyUsersDto;

    }

    @PostMapping
    DuckyUsersDto addDuckyUsers(@RequestBody DuckyUsersDto duckyUsersDto) {
        return duckyUserService.addDuckyUser(duckyUsersDto);
    }

    @GetMapping("user-exists")
    UserExists checkUserExists(@RequestParam String userName) {
        return duckyUserService.checkIfDuckyUserExists(userName);
    }
}
