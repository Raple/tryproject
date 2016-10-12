package com.lyp.easy.trys.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by lyp on 2016/10/9.
 */
@Controller
@RequestMapping("/")
@Api(tags = "HomeAPI",description = "首页")
public class HomeController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index() {

        return "redirect:apidoc.html";
    }
}