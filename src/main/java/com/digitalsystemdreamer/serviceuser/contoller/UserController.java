package com.digitalsystemdreamer.serviceuser.contoller;


import com.digitalsystemdreamer.serviceuser.cache.CacheType;
import com.digitalsystemdreamer.serviceuser.dto.FacilityDTO;
import com.digitalsystemdreamer.serviceuser.dto.UserDTO;
import com.digitalsystemdreamer.serviceuser.service.IRefDataService;
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

    private IRefDataService refDataService;

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

    @GetMapping(path = "/faciltiy/{facId}")
    public FacilityDTO getFacility(@PathVariable Integer facId) {
        FacilityDTO dtoList =null;
        try {
            dtoList = (FacilityDTO) refDataService.getFromCache(CacheType.FACILITIES, facId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoList;
    }

    @GetMapping(path = "/membership/{membershipId}")
    public FacilityDTO getMembership(@PathVariable Integer membershipId) {
        FacilityDTO dtoList =null;
        try {
            dtoList = (FacilityDTO) refDataService.getFromCache(CacheType.MEMBERSHIP, membershipId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dtoList;
    }

}
