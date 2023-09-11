package com.mazi.expensetrackerapi.users;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    @Autowired
    UserService userService;

    //Register


    @PostMapping("/register")
    public ResponseEntity<Map<String,String>> registerUser(@RequestBody User user){
        userService.registerUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword());
        Map<String,String> map = new HashMap<>();
        map.put("message", "Registration is successful");
        return  new ResponseEntity<>(map, HttpStatus.CREATED);
    }
    //Login
@PostMapping("/login")
    public ResponseEntity<Map<String,String>> loginUser(@RequestBody User user){
        userService.validateUser(user.getEmail(), user.getPassword());
        Map<String,String> map = new HashMap<>();
        map.put("message","Logged In  successfully");
        return new ResponseEntity<>(map,HttpStatus.OK);
}
//JWT
//    private Map<String,String> generate
    //Logout
}
