package com.developerblog.app.ws.developerblogappws.user_service;

import com.developerblog.app.ws.developerblogappws.ui_model_request.UserDetails;
import com.developerblog.app.ws.developerblogappws.ui_model_response.User;

public interface UserService {
    // CREATE USER METHOD
    User creatUser(UserDetails userDetails);
}