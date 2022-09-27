package com.crud.backend.controller;

import com.crud.backend.exception.ResourceNotFoundException;
import com.crud.backend.model.User;
import com.crud.backend.repository.UserRepository;
import com.crud.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*") //사용하여 any client can access rest apis
//@CrossOrigin(origins = {"http://localhost:3000/"})
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    //전체 불러오기
    @GetMapping
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }


    //유저 생성 api
    @PostMapping
    public User createUser(@RequestBody  User user) {
        return userRepository.save(user);
    }

    //id로 유저 정보 불러오기 api GET
    @GetMapping("{id}")
    public ResponseEntity<User> getUserById(@PathVariable  long id){
        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " 아이디를 가진 사용자가 존재하지 않음."));
        return ResponseEntity.ok(user);
    }

    //업데이트 api POST
    @PutMapping("{id}")
    public ResponseEntity<User> updateUser(@PathVariable long id, @RequestBody User userDetails) {
        User updateUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " 아이디를 가진 사용자가 존재하지 않음."));

        updateUser.setName(userDetails.getName());
        updateUser.setStudentId(userDetails.getStudentId());
        updateUser.setEmailId(userDetails.getEmailId());

        userRepository.save(updateUser);

        return ResponseEntity.ok(updateUser);
    }

    //유저 삭제 api
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteUser(@PathVariable long id){

        User user = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(id + " 아이디를 가진 사용자가 존재하지 않음."));

        userRepository.delete(user);

        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}