package com.developer.model.apiResponse;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by xiao.lai on 15/12/16.
 */
public class RespSmallerHongBaoEntity {
    private Integer id = 0;

    private BigDecimal price = new BigDecimal(0.00);  // 当前红包中所含的金钱数价格

    private Date createTime;

    private RespHongBaoEntity respHongBaoEntitySrc;

    public RespHongBaoEntity getRespHongBaoEntitySrc() {
        return respHongBaoEntitySrc;
    }

    public void setRespHongBaoEntitySrc(RespHongBaoEntity respHongBaoEntitySrc) {
        this.respHongBaoEntitySrc = respHongBaoEntitySrc;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
