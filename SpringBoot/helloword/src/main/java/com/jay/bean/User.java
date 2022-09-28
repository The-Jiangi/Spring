package com.jay.bean;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Administrator
 */

@Data
@NoArgsConstructor  // 无参构造器
public class User {
    private String uname;
    private Integer uage;
    private Pet pet;

    public User(String uname, Integer uage) {
        this.uname = uname;
        this.uage = uage;
    }

}
