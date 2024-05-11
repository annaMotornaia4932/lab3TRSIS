package com.example.demo.HomeController;

import java.util.List;

import com.example.demo.Entity.MyResponse;
import com.example.demo.UserRepository;
import com.example.demo.Entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class UserController {
    @Autowired
    private UserRepository repository;

    @PostMapping("/addUser")
    public ResponseEntity<Object> addUser(@RequestBody User user) {
        repository.save(user);
        MyResponse<User> response = new MyResponse<>("success", user);
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

    @GetMapping("/getUsers")
    public ResponseEntity<Object> getUsers() {
        MyResponse<List<User>> response = new MyResponse<>("success", repository.findAll());
        return new ResponseEntity<Object>(response, HttpStatus.OK);
    }

}
