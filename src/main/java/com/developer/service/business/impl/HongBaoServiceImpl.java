package com.developer.service.business.impl;

import com.alibaba.fastjson.JSONObject;
import com.developer.model.apiRequest.ReqUserEntity;
import com.developer.model.apiResponse.RespUserHongBaoEntity;
import com.developer.model.response.APIResponse;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;
import com.developer.service.business.HongBaoWrapper;
import com.developer.utils.NormalSchool;

import java.util.List;

/**
 * Created by xiao.lai on 15/12/16.
 */
@Service
public class HongBaoServiceImpl implements HongBaoWrapper{
    private static String host = "127.0.0.1";
    private static int honBaoCount = 100000;
    private static int threadCount = 20;
    private static String hongBaoList = "hongBaoList";   //将大红包拆分成小红包按list存放到redis中
    private static String hongBaoConsumedList = "hongBaoConsumedList"; // 红包消费list集合（list存放）
    private static String hongBaoConsumedMap = "hongBaoConsumedMap";   //用户抢红包list集合（map存放）

    public APIResponse<?> shareHongBao(ReqUserEntity reqUserEntity) {

        return APIResponse.returnFail("sdfdsf");
    }


    public APIResponse<?> getHongBaoByUid(ReqUserEntity reqUserEntity) {
        return null;
    }

    public APIResponse<?> showHongBaoUsedList(ReqUserEntity reqUserEntity) {
        return null;
    }
}
