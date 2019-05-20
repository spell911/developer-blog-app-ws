package com.developerblog.app.ws.developerblogappws.ui_model_request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class UserDetail {
    @NotNull(message = "first name can't be null")
    private String firstName;
    @NotNull(message = "last name can't be null")
    private String lastName;
    @NotNull(message = "email name can't be null")
    private String email;
    @NotNull(message = "password name can't be null")
    @Size(min = 8, max = 16, message = "password lenght between 8 and 16")
    private String password;

    public UserDetail() {

    }

    public UserDetail(String firstName, String lastName, String email, String password) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
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

    public void setLastName(String lastNme) {
        this.lastName = lastNme;
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

    @Override
    public String toString() {
        return "UserRequest [email=" + email + ", firstName=" + firstName + ", lastNme=" + lastName + ", password="
                + password + "]";
    }

}