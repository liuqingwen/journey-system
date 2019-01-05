package com.journey.clas.bojo;

/**
 * @author liuqingwen
 * @date 2018/9/30.
 */
public class UserBO {

    private Integer id ;

    private UserBO() {

    }

    private UserBO(int id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "UserBO{" +
                "id=" + id +
                '}';
    }
}
