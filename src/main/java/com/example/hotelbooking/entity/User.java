package com.example.hotelbooking.entity;


//import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Data

@Entity
@Table(name = "USERS")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Email cannot be empty")
    @Email(message = "Please enter a valid email address")
    @Column(name = "email", unique = true, length = 45)
    private String email;

//    @NotNull(message = "Password cannot be empty")
//    @Length(min = 5, message = "Password should be at least 5 characters long")
//    @Column(name = "password", length = 64)
//    private String password;

    @Column(name = "first_name", length = 20)
    private String firstName;

    @Column(name = "last_name", length = 20)
    private String lastName;

    @Column(name = "username", unique = true, length = 20)
    private String username;

    @Column(name = "NIC", unique = true, length = 20)
    private String nic;

    @Column(name = "contact_Number", length = 20)
    private String contactNumber;

    @Column(name = "address", length = 70)
    private String address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNIC() {
        return nic;
    }

    public void setNIC(String NIC) {
        this.nic = NIC;
    }
}