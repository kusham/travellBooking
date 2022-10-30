package com.example.hotelbooking.services;

import com.example.hotelbooking.Repository.UserRepository;
import com.example.hotelbooking.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@Transactional
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public boolean isUserExists(User user) {
        boolean userExists = false;
        User existingUser = userRepository.findByEMAIL(user.getEmail());
        if(existingUser!=null){
            userExists = true;
        }
        return userExists;
    }

    public List getAllUsers() {
        return userRepository.findAll();
    }

    public User getSingleUsers(Long id) {
        return userRepository.findById(id).get();
    }

    public  void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}
