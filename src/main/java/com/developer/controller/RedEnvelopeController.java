package com.developer.controller;

import com.developer.model.apiRequest.ReqUserEntity;
import com.developer.model.response.APIResponse;
import com.developer.service.business.HongBaoWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;


import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;

/**
 * Created by xiao.lai on 15/12/16.
 */
@Controller("RedEnvelopeController")
@RequestMapping(value = "/api/hongbao/")
public class RedEnvelopeController {
    @Autowired
    private HongBaoWrapper hongBaoWrapper;

    @RequestMapping(value="test.api", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String shareRedEnvelope(HttpServletRequest request) {
        return "index";
        //return hongBaoWrapper.shareHongBao(reqUserEntity);
    }

    @RequestMapping(value="shareRedEnvelope.api",  method = {RequestMethod.GET })
    @ResponseBody
    public APIResponse<?>  shareRedEnvelope(ReqUserEntity reqUserEntity, HttpServletRequest request) {
        return hongBaoWrapper.shareHongBao(reqUserEntity);
    }

    @RequestMapping(value="getRedEnvelope.api", method = {RequestMethod.GET })
    @ResponseBody
    public APIResponse<?>  getRedEnvelope(ReqUserEntity reqUserEntity, HttpServletRequest request) {
       return hongBaoWrapper.getHongBaoByUid(reqUserEntity);
    }

    @RequestMapping(value="RedEnvelopeList.api", method = {RequestMethod.GET })
    @ResponseBody
    public APIResponse<?>  RedEnvelopeList(ReqUserEntity reqUserEntity, HttpServletRequest request) {
       return hongBaoWrapper.showHongBaoUsedList(reqUserEntity);
    }
}
