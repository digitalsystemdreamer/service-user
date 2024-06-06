package com.digitalsystemdreamer.serviceuser.service;

import com.digitalsystemdreamer.serviceuser.dto.UserDTO;

import java.util.List;

public interface IUserService {

    List<UserDTO> getAllUsers();

    UserDTO getUser(Integer userId);

}
