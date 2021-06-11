package com.example.TMS.service.impl;

import com.example.TMS.dto.UserDTO;
import com.example.TMS.model.User;
import com.example.TMS.repository.UserRepository;
import com.example.TMS.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDTO addUser(UserDTO userDTO) {
        User user = new User(userDTO);//copy user dto user
        User savedUser = userRepository.save(user);//save to database
        UserDTO savedUserDTO = new UserDTO(savedUser);//copy user to user dto
        return savedUserDTO;
    }

    @Override
    public UserDTO findById(int id) {
        Optional<User> userOptional = userRepository.findById(id);
        User user = userOptional.orElseThrow(()-> new RuntimeException("User with given id not found"));
        UserDTO userDTO = new UserDTO(user);
        return userDTO;

    }

    @Override
    public List<UserDTO> findAll() {
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOs = new ArrayList<>();

        for(User user : users){
            UserDTO userDTO = new UserDTO(user);//copy user dto
            userDTOs.add(userDTO);//adding user dto to list
        }
        return userDTOs;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO) {
        return null;
    }

    @Override
    public Void deleteUser(int id) {
        return null;
    }
}
