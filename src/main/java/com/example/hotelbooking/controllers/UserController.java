package com.example.hotelbooking.controllers;

import com.example.hotelbooking.entity.User;
import com.example.hotelbooking.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@CrossOrigin
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;



    @RequestMapping(value = "/createUser", method = RequestMethod.POST)
    public ResponseEntity<Map> userCreate(@RequestBody User user) {

        HashMap<String, Object> response = new HashMap<>();
        if (userService.isUserExists(user)) {
            response.put("success", "false");
            response.put("message", "This email has already registered");
            return ResponseEntity.status(400).body(response);
        }
        userService.createUser(user);
        response.put("success", "true");
        response.put("message", "User successfully created");
        return ResponseEntity.ok().body(response);
    }

    @PutMapping( "/updateUser/{id}")
    public ResponseEntity<Map> userCreate(@RequestBody User user, @PathVariable int id) {

        System.out.println(user);
        System.out.println(id);
        HashMap<String, Object> response = new HashMap<>();

        userService.createUser(user);

        response.put("success", "true");
        response.put("message", "User successfully updated");
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<Map> getAllUsers() {

        HashMap<String, Object> response = new HashMap<>();

       List users = userService.getAllUsers();
        response.put("success", "true");
        response.put("message", "Users successfully fetched");
        response.put("users", users);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/getUser/{id}", method = RequestMethod.GET)
    public ResponseEntity<Map> getSingleUser(@PathVariable Long id) {

        HashMap<String, Object> response = new HashMap<>();

        User user = userService.getSingleUsers(id);
        response.put("success", "true");
        response.put("message", "User successfully fetched");
        response.put("users", user);
        return ResponseEntity.ok().body(response);
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Map> deleteUser(@PathVariable Long id) {

        HashMap<String, Object> response = new HashMap<>();

         userService.deleteUser(id);
        response.put("success", "true");
        response.put("message", "User successfully deleted");
        return ResponseEntity.ok().body(response);
    }
}
