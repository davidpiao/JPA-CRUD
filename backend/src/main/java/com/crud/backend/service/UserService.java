package com.crud.backend.service;

//import com.crud.backend.dto.UserMajorDTO;
import com.crud.backend.model.User;
import com.crud.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

//    public List<UserMajorDTO> getAllUsersMajor(){
//        return userRepository.findAll()
//                .stream()
//                .map(this::convertEntityToDto)
//                .collect(Collectors.toList());
//    }
//
//    private UserMajorDTO convertEntityToDto(User user){
//        UserMajorDTO UserMajorDTO = new UserMajorDTO();
//        UserMajorDTO.setUserid(user.getId());
//        UserMajorDTO.setName(user.getName());
//        UserMajorDTO.setStudentId(user.getStudentId());
////        UserMajorDTO.setMajors(user.getMajor().getMajors());
//        return UserMajorDTO;
//    }
}
