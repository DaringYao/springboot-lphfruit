package com.lph.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


/**
 * <pre>
 *
 * </pre>
 *
 * @author 澜阙
 * @since 2020/5/7 23:51
 */

@Controller
public class SkipController {
   @RequestMapping("/")
    public String test() {
        return "user/shopProduct";
    }
/*
    @RequestMapping("/w")
    public String test1() {
        return "shop/login";
    }

    @RequestMapping("/a")
    public String test11() {
        return "shop/register";
    }

    @RequestMapping("/e")
    public String test2() {
        return "user/login";
    }

    @RequestMapping("/r")
    public String test3() {
        return "user/register";
    }*/
//templates/user/login.htmltemplates/user/register.html
//    @RequestMapping("/index")
//    public String index(){
//        return "shop/tgls/index";
//    }
}

