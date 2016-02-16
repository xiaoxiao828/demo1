package com.developer.service.business;

import com.developer.model.apiRequest.ReqUserEntity;
import com.developer.model.apiResponse.RespUserHongBaoEntity;
import com.developer.model.response.APIResponse;

import java.util.List;

/**
 * Created by xiao.lai on 15/12/16.
 */
public interface HongBaoWrapper {

    APIResponse<?> shareHongBao(ReqUserEntity reqUserEntity);

    APIResponse<?> getHongBaoByUid(ReqUserEntity reqUserEntity);

    APIResponse<?> showHongBaoUsedList(ReqUserEntity reqUserEntity);
}
