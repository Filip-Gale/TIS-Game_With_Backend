package hr.tis.academy.controller;

import hr.tis.academy.model.DuckyUsers;
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
        DuckyUsers duckyUsers = duckyUserService.getDuckyUsersByUsername(userName);
        DuckyUsersDto duckyUsersDto = new DuckyUsersDto();
        duckyUsersDto.setId(duckyUsers.getId());
        duckyUsersDto.setUsername(duckyUsers.getUserName());
        return duckyUsersDto;

    }

    @PostMapping
    DuckyUsersDto addDuckyUsers(@RequestBody DuckyUsersDto duckyUsersDto) {
        duckyUserService.addDuckyUser(duckyUsersDto);
        DuckyUsersDto duckyUsersDto2 = new DuckyUsersDto();
        duckyUsersDto2.setId(duckyUsersDto.getId());
        duckyUsersDto2.setUsername(duckyUsersDto.getUsername());
        return duckyUsersDto2;
    }

    @GetMapping("{id}/user-exists")
    DuckyUsersDto checkUserExists(@PathVariable("id") Long id) {
        return duckyUserService.checkIfDuckyUserExists(id);
    }
}
