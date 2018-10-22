package com.journey.demo.entity;

/**
 * @author liuqingwen
 * @date 2018/10/9.
 */
public class LoginUserInfo implements java.io.Serializable {

//    `id` int(11) NOT NULL AUTO_INCREMENT,
//  `password` varchar(21) NOT NULL COMMENT '用户密码',
//            `account` varchar(32) DEFAULT NULL COMMENT '用户登录账号',
//            `user_info_id` int(11) NOT NULL COMMENT '用户信息ID',
    private Integer id;
    private String password;
    private String account;
    private Integer user_info_id;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Integer getUser_info_id() {
        return user_info_id;
    }

    public void setUser_info_id(Integer user_info_id) {
        this.user_info_id = user_info_id;
    }

    @Override
    public String toString() {
        return "LoginUserInfo{" +
                "id=" + id +
                ", password='" + password + '\'' +
                ", account='" + account + '\'' +
                ", user_info_id=" + user_info_id +
                '}';
    }
}
