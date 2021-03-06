package com.juliuscerniauskas.visma.translatorjdbi.model;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class User {

    @ColumnName("id")
    private Long id;

    @ColumnName("username")
    private String username;

    @ColumnName("first_name")
    private String firstName;

    @ColumnName("last_name")
    private String lastName;

    @ColumnName("email")
    private String email;

    @ColumnName("password")
    private String password;

    public User(Long id, String username, String firstName, String lastName, String email, String password) {
        this.id = id;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
}
