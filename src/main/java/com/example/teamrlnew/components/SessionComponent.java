package com.example.teamrlnew.components;

import com.example.teamrlnew.User;

//lead auth:JacobFarrow(20007972)
public class SessionComponent {
    //auth:JacobFarrow(20007972)
    private User sessionUser;

    public SessionComponent(){}

    public User getSessionUser() {
        return this.sessionUser;
    }

    public void setSessionUser(User userUser) {
        this.sessionUser = userUser;
    }
}
