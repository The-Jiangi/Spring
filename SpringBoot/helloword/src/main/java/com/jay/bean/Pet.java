package com.jay.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor // 全参构造器
@NoArgsConstructor
public class Pet {
    private String name;
    private Integer age;

}
