package com.darksideoftherainbow.model.user;

import javax.persistence.*;

@Entity
@Table(name = "APPLICATION_USER")
public class ApplicationUser {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "APPLICATION_USER_ID_SEQ")
    @SequenceGenerator(name = "APPLICATION_USER_ID_SEQ", sequenceName = "APPLICATION_USER_ID_SEQ", allocationSize = 100)
    protected int userID;
    protected String username;
    protected String password;
    protected Boolean isAdmin;

    //Constructors
    public ApplicationUser() {

    }

    public ApplicationUser(String username, String password, Boolean isAdmin) {
        this.username = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }


    //Getters and Setters
    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getIsAdmin() {
        return isAdmin;
    }

    public void setIsAdmin(Boolean isAdmin) {
        this.isAdmin = isAdmin;
    }
}
