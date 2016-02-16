package com.developer.service.log;

/**
 * Created by IntelliJ IDEA
 * user: jihaoyang
 * date: 14-11-10
 * time: 下午4:57
 */
public interface LogService {

    int apiAccessLog(String sessionId, int channelId, int uid, String dsn, String reqMethod, String reqParam,
                     String resp, String remark, Long execTime, boolean success);

}
