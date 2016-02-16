package com.developer.model.apiResponse;

import java.util.Date;

/**
 * Created by xiao.lai on 15/12/16.
 */
public class RespUserHongBaoEntity {

    private Integer id = 0;

    private RespSmallerHongBaoEntity respSmallerHongBaoEntity;

    private Date createTime;

    private Integer leftTimes;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public RespSmallerHongBaoEntity getRespSmallerHongBaoEntity() {
        return respSmallerHongBaoEntity;
    }

    public void setRespSmallerHongBaoEntity(RespSmallerHongBaoEntity respSmallerHongBaoEntity) {
        this.respSmallerHongBaoEntity = respSmallerHongBaoEntity;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getLeftTimes() {
        return leftTimes;
    }

    public void setLeftTimes(Integer leftTimes) {
        this.leftTimes = leftTimes;
    }
}
