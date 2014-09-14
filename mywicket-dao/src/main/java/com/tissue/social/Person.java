package com.tissue.social;

import java.util.ArrayList;
import java.util.List;

public class Person {
    //private static final long serialVersionUID = 1l;

    private Integer id;
    private String name;
    private String gender;
    private String email;

    private List<String> roles = new ArrayList<>();

    public Person(Integer id, String name, String gender) {
        this.id = id;
        this.name = name;
        this.gender = gender;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the gender
     */
    public String getGender() {
        return gender;
    }

    /**
     * @param gender the gender to set
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    public void addRole(String role) {
        roles.add(role);
    }

    public List<String> getRoles() {
        //todo return unmodifiable
        return roles;
    }
}
