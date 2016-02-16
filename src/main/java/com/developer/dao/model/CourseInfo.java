package com.developer.dao.model;

/**
 * Created by xiao.lai on 15/12/22.
 */
public class CourseInfo {
    private Integer id;

    private String cname;

    private String caddress;

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCaddress() {
        return caddress;
    }

    public void setCaddress(String caddress) {
        this.caddress = caddress;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
