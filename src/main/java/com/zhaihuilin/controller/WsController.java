package com.zhaihuilin.controller;

import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 此类 和 WebMvcConfig 配置的作用一样 都是跳转到某页面
 * Created by zhaihuilin on 2018/2/8  13:33.
 */
@Controller
@Log4j
public class WsController {


    @RequestMapping(value = "/ws")
    public ModelAndView ws(){
         log.info("WsController------ws------>我进来了！");
         ModelAndView modelAndView = new ModelAndView("ws");
         return modelAndView;
    }

    @RequestMapping(value = "/login")
    public  ModelAndView login(){
        log.info("WsController----login-------->我进来了！");
        ModelAndView modelAndView = new ModelAndView("login");
        return modelAndView;
    }

    @RequestMapping(value = "/chat1")
    public  ModelAndView chat(){
        log.info("WsController--------chat---->我进来了！");
        ModelAndView modelAndView = new ModelAndView("chat");
        return modelAndView;
    }



}
