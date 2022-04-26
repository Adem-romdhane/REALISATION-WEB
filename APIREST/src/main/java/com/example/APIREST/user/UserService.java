package com.example.APIREST.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.stereotype.Service;

import javax.persistence.metamodel.SingularAttribute;
import java.io.Serializable;
import java.util.Optional;


import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(SingularAttribute<AbstractPersistable, Serializable> id){
        return userRepository.findAll();
    }

    public void addNewUser(User user) {
        userRepository.save(user);
    }

    void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    void update(User user) {
        userRepository.save(user);
    }

    Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }


   void getUsers(User user){
        userRepository.findAll();
   }

    public String getValideCode(String validCode) {

        return validCode;

    }


    public Boolean activeUser(Boolean activate) {
        return activate;
    }

    public Boolean desactiveUser(Boolean desactivate) {
        return desactiveUser(desactivate);
    }


   /* void validCode(User user){
        userRepository.
    }*/

}