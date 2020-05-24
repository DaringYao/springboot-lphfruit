package com.lph.pojo;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 澜阙
 * @since 2020-05-07
 */

public class Shopuser implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String phone;

    private String nickName;

    private String userName;

    private String password;


    private String address;

    public Shopuser() {
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
