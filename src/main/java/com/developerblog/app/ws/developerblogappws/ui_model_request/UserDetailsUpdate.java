package com.developerblog.app.ws.developerblogappws.ui_model_request;

import javax.validation.constraints.NotNull;

public class UserDetailsUpdate {
      @NotNull(message = "first name can't be null")
      private String firstName;
      @NotNull(message = "last name can't be null")
      private String lastName;

      public UserDetailsUpdate() {

      }

      public UserDetailsUpdate(String firstName, String lastName) {
            super();
            this.firstName = firstName;
            this.lastName = lastName;
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

      @Override
      public String toString() {
            return "UserDetailsUpdate [firstName=" + firstName + ", lastName=" + lastName + "]";
      }
}