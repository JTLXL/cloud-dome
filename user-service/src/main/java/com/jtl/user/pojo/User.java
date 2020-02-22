package com.jtl.user.pojo;

import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

/**
 * @author JT.L
 * @date 2020/2/19 11:15:54
 * @description
 */
@Data
@Table(name = "tb_user") //不加注解通用mapper会直接以类名作为表名
public class User {
    /**
     * @KeySql(useGeneratedKeys = true) 主键自增
     */
    @Id
    @KeySql(useGeneratedKeys = true)
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

    /**
     * 不需要持久化到数据库，
     * 不会作为通用mapper sql语句的一个字段
     */
    @Transient
    private String note2;
}
