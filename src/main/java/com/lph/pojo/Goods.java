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

public class Goods implements Serializable {

    private static final long serialVersionUID=1L;

    private Integer id;

    private String s_userName;

    private String g_imgurl;

    private String g_name;

    private String g_price;

    private String g_class;

    public Goods() {
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", s_userName='" + s_userName + '\'' +
                ", g_imgurl='" + g_imgurl + '\'' +
                ", g_name='" + g_name + '\'' +
                ", g_price='" + g_price + '\'' +
                ", g_class='" + g_class + '\'' +
                '}';
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

    public String getS_userName() {
        return s_userName;
    }

    public void setS_userName(String s_userName) {
        this.s_userName = s_userName;
    }

    public String getG_imgurl() {
        return g_imgurl;
    }

    public void setG_imgurl(String g_imgurl) {
        this.g_imgurl = g_imgurl;
    }

    public String getG_name() {
        return g_name;
    }

    public void setG_name(String g_name) {
        this.g_name = g_name;
    }

    public String getG_price() {
        return g_price;
    }

    public void setG_price(String g_price) {
        this.g_price = g_price;
    }

    public String getG_class() {
        return g_class;
    }

    public void setG_class(String g_class) {
        this.g_class = g_class;
    }
}
