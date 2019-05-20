package com.developerblog.app.ws.developerblogappws.ui_controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.validation.Valid;

import com.developerblog.app.ws.developerblogappws.ui_model.User;
import com.developerblog.app.ws.developerblogappws.ui_model_request.UserDetails;
import com.developerblog.app.ws.developerblogappws.ui_model_request.UserDetailsUpdate;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {

    Map<String, User> users;

    // RETIVE USERS
    @GetMapping
    public ResponseEntity<User> getUsers(@RequestParam(value = "page", defaultValue = "1") int page,
            @RequestParam(value = "limit", defaultValue = "50") int limit,
            @RequestParam(value = "sort", defaultValue = "desc", required = false) String sort) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // RETIVE USER
    @GetMapping(path = "/{id}", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE })
    public ResponseEntity<User> getUser(@PathVariable String id) {
        if (users.containsKey(id)) {
            return new ResponseEntity<>(users.get(id), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    // CREATE USER
    @PostMapping(consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE }, produces = {
            MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XHTML_XML_VALUE })
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDetails userDetails) {
        User user = new User();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        String id = UUID.randomUUID().toString();
        user.setId(id);
        if (users == null)
            users = new HashMap<>();
        users.put(id, user);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    // UPDATE USER
    @PutMapping(path = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XHTML_XML_VALUE }, produces = { MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XHTML_XML_VALUE })
    public User updateUser(@PathVariable String id, @Valid @RequestBody UserDetailsUpdate userDetailsUpdateBody) {
        User userDetailsUpdate = users.get(id);
        userDetailsUpdate.setFirstName(userDetailsUpdateBody.getFirstName());
        userDetailsUpdate.setLastName(userDetailsUpdateBody.getLastName());
        users.put(id, userDetailsUpdate);
        return userDetailsUpdate;
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable String id) {
        users.remove(id);
        return ResponseEntity.noContent().build();
    }

}