package com.trippin.entities;
import com.trippin.utilities.PasswordStorage;
import javax.persistence.*;
import java.lang.reflect.Array;
import java.util.ArrayList;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    int id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @Column
    public String hometown;
    @Column
    public String homestate;
    @Column
    public String country;
    @Column
    public String bio;
    @Column
    public ArrayList<User> friends;

    public User() {
    }

    public User( String email, String username, String password) throws PasswordStorage.CannotPerformOperationException {
        this.email = email;
        this.username = username;
        this.password = PasswordStorage.createHash(password);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email  = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String getPasswordHash() {
        return password;
    }

    public void setPassword(String password) throws PasswordStorage.CannotPerformOperationException {
        this.password = PasswordStorage.createHash(password);
    }

    public boolean verifyPassword(String password) throws PasswordStorage.InvalidHashException, PasswordStorage.CannotPerformOperationException {
        return PasswordStorage.verifyPassword(password, this.getPasswordHash());
    }

    public String getPassword() {
        return password;
    }
}

