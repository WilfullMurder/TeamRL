package com.teamrl.app;

public class SessionComponent {
    private User sessionUser;

    public SessionComponent(){}

    public User getSessionUser() {
        return this.sessionUser;
    }

    public void setSessionUser(User userUser) {
        this.sessionUser = userUser;
    }
}
