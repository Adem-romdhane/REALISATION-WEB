package com.example.APIREST.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;
import java.util.Random;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
public class UserController {


    private final UserService userService;
    private Object User;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public ResponseEntity<Object> newUser(@RequestBody User user) {
        Long validCode = new Random().nextLong();
        user.setValidCode(validCode);
        userService.addNewUser(user);
        //TODO service email pour envoyer le mail avec le code de validation
        System.out.println(validCode);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/user/{id}")
    public User getUser(@PathVariable Long id) {

        Optional<User> userOptional = userService.findById(id);
        if (userOptional.isEmpty())
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "user not found"
            );

        return userOptional.get();

    }

    @PutMapping("/user/{id}")
    public void updateUser(@RequestBody User user, @PathVariable Long id) {
        User userUpdate = userService.findById(id).get();
        userUpdate.setFirstName(user.getFirstName());
        userUpdate.setLastName(user.getLastName());
        userUpdate.setEmail(user.getEmail());
        userUpdate.setPhone(user.getPhone());
        user.setPassword(user.getPassword());

        userService.update(userUpdate);
    }

    @DeleteMapping("/user/{id}")
    public void deleteById(@PathVariable Long id) {
        userService.deleteById(id);
    }

    @PatchMapping("/user/{id}/validate/{validCode}")
    public @ResponseBody
    ResponseEntity<Object> confirmerInscription(@PathVariable Long id, @PathVariable String validCode) {
        String vc = userService.getValideCode(validCode);

        User user;
        if (vc == validCode) {
            user = (User) userService.findById(id).get();
            user.setValid(true);
            ResponseEntity.status(201).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

        return null;
    }

    @PatchMapping("/user/{id}/activate")
    public @ResponseBody
    ResponseEntity<Object> activate(@PathVariable Long id, @PathVariable Boolean activate) {
        Boolean active = userService.activeUser(activate);

        User user = null;
        if (activate == Boolean.TRUE) {
            user = (User) userService.findById(id).get();
            user.setActive(true);
            ResponseEntity.status(201).build();
        }
        else{
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return null;

    }




      @PatchMapping("/user/{id}/desactivate")
      public @ResponseBody
      ResponseEntity<Object> desactivate(@PathVariable Long id, @PathVariable Boolean desactivate) {
          Boolean desactiveUser = userService.desactiveUser(desactivate);

          User user = null;
          if (desactivate == Boolean.TRUE) {
              user = (User) userService.findById(id).get();
              user.setActive(true);
              ResponseEntity.status(201).build();
          }
          else{
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
          }
          return null;

      }

}
