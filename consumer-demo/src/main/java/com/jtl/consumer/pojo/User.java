package com.jtl.consumer.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author JT.L
 * @date 2020/2/22 20:20:23
 * @description
 */
@Data
public class User {
    private Long id;

    private String userName;

    private String password;

    private String name;

    private Integer age;

    /**
     * 性别，1男性，2女性
     */
    private Integer sex;

    private Date birthday;

    private String note;

    private Date created;

    private Date updated;

}
