package com.example.APIREST.user;

import com.example.APIREST.order.Order;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table( uniqueConstraints=
        @UniqueConstraint(columnNames={"email", "phone"}))
public class User {

        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        private Long id;
        private String firstName;
        private String lastName;
        private String phone;
        private String email;
        private String password;
        boolean valid;
        private long validCode;
        boolean active;

    @OneToMany(mappedBy = "user")
    Set<Order> orders;

    public User() {
    }

    public User(String firstName, String lastName, String phone,
                String email,
                String password, boolean valid,
                long validCode, boolean active) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.valid = valid;
        this.validCode = validCode;
        this.active = active;
    }

    public Long getId_User() {
        return id;
    }

    public void setId_User(Long id_User) {
        this.id = id_User;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public long getValidCode() {
        return validCode;
    }

    public void setValidCode(long validCode) {
        this.validCode = validCode;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }


}
