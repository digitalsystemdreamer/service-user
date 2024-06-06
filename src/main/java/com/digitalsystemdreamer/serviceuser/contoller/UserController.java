package com.digitalsystemdreamer.serviceuser.contoller;


import com.digitalsystemdreamer.serviceuser.dto.UserDTO;
import com.digitalsystemdreamer.serviceuser.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Slf4j
@AllArgsConstructor
public class UserController {

    private IUserService userService;

    @GetMapping(path = "/users")
    public List<UserDTO> getUsers() {
        log.info("Getting all users info..");
        return userService.getAllUsers();

    }

    @GetMapping(path = "/user/{id}")
    public UserDTO getUser(@PathVariable Integer id) {
        log.info("Getting info for user id : {}" , id);

        return userService.getUser(id);

    }


    @PostMapping(path = "")
    public UserDTO saveUser(){
        return  null;
    }


}
