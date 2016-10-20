package com.lyp.easy.trys.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lyp.easy.trys.entity.Account;
import com.lyp.easy.trys.service.AccountService;
import io.swagger.annotations.Api;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * Created by lyp on 2016/10/9.
 */
@Controller
@RequestMapping(value="/account")
@Api(tags = "AccoutAPI",description = "帐号相关接口")
public class AccoutController extends BaseController {
    private static Logger logger = LoggerFactory.getLogger(AccoutController.class.getPackage().getName());

    @Autowired
    AccountService accountService;

    /**
     * 根据ID获取信息
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value="/select",method= RequestMethod.GET)
    public Account selectByPrimaryKey(@RequestParam(value="id") int id)
    {
        Account account=accountService.selectByPrimaryKey(id);
        logger.info("controller:",account);
        return account;

    }

}
