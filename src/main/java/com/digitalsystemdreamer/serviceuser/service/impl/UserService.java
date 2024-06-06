package com.digitalsystemdreamer.serviceuser.service.impl;

import com.digitalsystemdreamer.serviceuser.dto.UserDTO;
import com.digitalsystemdreamer.serviceuser.entity.User;
import com.digitalsystemdreamer.serviceuser.repository.db.UserRepository;
import com.digitalsystemdreamer.serviceuser.service.IUserService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@AllArgsConstructor
@Data
@Slf4j
public class UserService implements IUserService {

    private UserRepository userRepository;

    @Override
    @ResponseStatus()
    public List<UserDTO> getAllUsers() {

        List<User> users = userRepository.findAll();
        log.info("Total no of users are : {}", users.size());



        return List.of();
    }

    @Override
    public UserDTO getUser(Integer userId) {

        userRepository.findById(userId);
        return null;
    }
}
