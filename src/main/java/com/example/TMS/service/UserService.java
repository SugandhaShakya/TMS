package com.example.TMS.service;

import com.example.TMS.dto.UserDTO;

import java.util.List;

public interface UserService {
    UserDTO addUser(UserDTO userDTO);
    UserDTO findById(int id);
    List<UserDTO> findAll();
    UserDTO updateUser(UserDTO userDTO);
    Void deleteUser(int id);

}
