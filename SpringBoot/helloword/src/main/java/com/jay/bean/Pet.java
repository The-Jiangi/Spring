package com.jay.bean;

/**
 * @author Administrator
 */
public class Pet {
    private String pname;

    public Pet() {}

    public Pet(String pname) {
        this.pname =pname;
    }

    public void setpname(String pname) {
        this.pname = pname;
    }

    public String getpname() {
        return pname;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "pname='" + pname + '\'' +
                '}';
    }
}
