package com.entity;

import tk.mybatis.mapper.annotation.KeySql;

import javax.persistence.Id;

/**
 * @author liuqingwen
 * @date 2019/1/5.
 */
public class UserEntity {

    @Id
    @KeySql(useGeneratedKeys = true)
    private long id;
    private String username;
    private byte sex;

}
