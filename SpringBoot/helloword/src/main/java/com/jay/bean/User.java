package com.jay.bean;

/**
 * @author Administrator
 */
public class User {
    private String uname;
    private Integer uage;
    private Pet pet;

    public User() {}

    public User(String uname, Integer uage) {
        this.uname = uname;
        this.uage = uage;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public String getUname() {
        return uname;
    }

    public void setUage(Integer uage) {
        this.uage = uage;
    }

    public Integer getUage() {
        return uage;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public Pet getPet() {
        return pet;
    }

    @Override
    public String toString() {
        return "User{" +
                "uname='" + uname + '\'' +
                ", uage=" + uage +
                ", pet=" + pet +
                '}';
    }
}
