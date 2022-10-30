package com.example.hotelbooking.Repository;

import com.example.hotelbooking.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("from User where email=?1")
    public User findByEMAIL(String email);
    User findByUsername(String username);
}
