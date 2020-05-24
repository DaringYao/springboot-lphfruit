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
public class Cart implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private Integer g_id;

    private String u_phone;


    public Cart() {
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

    public Integer getG_id() {
        return g_id;
    }

    public void setG_id(Integer g_id) {
        this.g_id = g_id;
    }

    public String getU_phone() {
        return u_phone;
    }

    public void setU_phone(String u_phone) {
        this.u_phone = u_phone;
    }


}
