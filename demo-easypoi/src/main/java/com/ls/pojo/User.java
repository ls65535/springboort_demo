package com.ls.pojo;

import java.io.Serializable;
import lombok.Data;

/**
 * Created by ls on 2019/4/4.
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -3524589746109374437L;
    private String name;
    private String sex;
    private Integer age;
    private String address;
    private String hobby;

    public User() {
        super();
    }

    public User(String name, String sex, Integer age, String address, String hobby) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.address = address;
        this.hobby = hobby;
    }
}
