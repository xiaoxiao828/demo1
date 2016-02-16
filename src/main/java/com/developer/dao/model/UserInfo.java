package com.developer.dao.model;

import java.util.List;

/**
 * Created by xiao.lai on 15/12/22.
 */
public class UserInfo {
    private Integer id;

    private String uname;

    private Integer unumber;

    private List<CourseInfo> courseInfos;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname;
    }

    public Integer getUnumber() {
        return unumber;
    }

    public void setUnumber(Integer unumber) {
        this.unumber = unumber;
    }

    public List<CourseInfo> getCourseInfos() {
        return courseInfos;
    }

    public void setCourseInfos(List<CourseInfo> courseInfos) {
        this.courseInfos = courseInfos;
    }
}
