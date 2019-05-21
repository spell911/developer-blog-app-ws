package com.developerblog.app.ws.developerblogappws.user_service_implement;

import java.util.HashMap;
import java.util.Map;

import com.developerblog.app.ws.developerblogappws.shared.Utils;
import com.developerblog.app.ws.developerblogappws.ui_model_request.UserDetails;
import com.developerblog.app.ws.developerblogappws.ui_model_response.User;
import com.developerblog.app.ws.developerblogappws.user_service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImp implements UserService {
    // MAP USER
    Map<String, User> users;
    // GET UTILS
    Utils utils;

    public UserServiceImp() {

    }

    @Autowired
    public UserServiceImp(Utils utils) {
        this.utils = utils;
    }

    @Override
    public User creatUser(UserDetails userDetails) {
        User user = new User();
        user.setFirstName(userDetails.getFirstName());
        user.setLastName(userDetails.getLastName());
        user.setEmail(userDetails.getEmail());
        String id = utils.generateUserId();
        user.setId(id);
        if (users == null)
            users = new HashMap<>();
        users.put(id, user);
        return user;
    }

}