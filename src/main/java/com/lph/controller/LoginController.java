package com.lph.controller;


import com.lph.mapper.ShopUserMapper;
import com.lph.mapper.UserMapper;
import com.lph.pojo.Shopuser;
import com.lph.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 澜阙
 * @since 2020/3/16 15:45
 */

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private ShopUserMapper shopUserMapper;

    /**
     * 请求到用户登录页面
     *
     * @return
     */
    @RequestMapping("/login")
    public String userNameLogin() {
        return "user/login";
    }

    /**
     * 用户登录
     *
     * @param phone
     * @param password
     * @param model
     * @param session
     * @return
     */

    @RequestMapping("/userLogin")
    public String login(@RequestParam("phone") String phone,
                        @RequestParam("password") String password,
                        Model model, HttpSession session) {
        for (User user : userMapper.queryUserList()) {
            String phone1 = user.getPhone();
            String password1 = user.getPassword();
            while (phone1.equals(phone) && password.equals(password1)) {
//                session.setAttribute("nickNamemsg", user.getNickName());
                session.setAttribute("userphonemsg", user.getPhone());
                return "redirect:/userindex";
            }
        }
        model.addAttribute("msg", "请输入正确的电话号码或密码");
        return "user/login";
    }

    /**
     * 登录页跳转到注册页
     *
     * @return
     */
    @RequestMapping("/userLoginToRegister")
    public String userLiginToRegister() {
        return "user/register";
    }


    /**
     * 用户注册
     *
     * @param phone
     * @param nickName
     * @param password
     * @param address
     * @param model
     * @return
     */
    @RequestMapping("/userregister")
    public String userRegister(@RequestParam("phone") String phone,
                               @RequestParam("nickName") String nickName,
                               @RequestParam("password") String password,
                               @RequestParam("address") String address,
                               Model model
    ) {
        System.out.println(phone + "" + nickName);
        User user = new User();
        user.setPhone(phone);
        user.setNickName(nickName);
        user.setPassword(password);
        user.setAddress(address);
        int i;
        try {
            i = userMapper.addUser(user);
            System.out.println(i);
            if (i==1) {
                model.addAttribute("msg", "注册成功，请登录");
                return "user/login";
            }
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "您的电话已经被注册");
            return "user/register";
        }

        return "";

    }

    @RequestMapping("/shoplogin")
    public String shopLogin() {
        return "shop/login";
    }

    //    shoplogintoregister
    @RequestMapping("shoplogintoregister")
    public String shoplogintoregister() {
        return "shop/register";
    }

    @RequestMapping("/superlogin")
    public String shopLoginSubmit(
            @RequestParam("phone") String phone,
            @RequestParam("password") String password,
            Model m, HttpSession session) {
        for (Shopuser shopuser : shopUserMapper.queryShopUserList()) {
            String phone1 = shopuser.getPhone();
            String password1 = shopuser.getPassword();
            while (phone.equals(phone1) && password.equals(password1)) {
                session.setAttribute("shopPhone", phone1);
                session.setAttribute("shopname", shopuser.getUserName());
                return "shop/index";
            }
        }
        m.addAttribute("msg", "请输入正确的用户名或密码");
        return "shop/login";


    }


    /**
     * @param phone
     * @param nickName
     * @param username
     * @param password
     * @param address
     * @param model
     * @return
     */

    @RequestMapping("/shopregister")
    public String super_register(@RequestParam("phone") String phone,
                                 @RequestParam("nickName") String nickName,
                                 @RequestParam("userName") String username,
                                 @RequestParam("password") String password,
                                 @RequestParam("address") String address,
                                 Model model) {
        Shopuser superUser = new Shopuser();
        superUser.setPhone(phone);
        superUser.setNickName(nickName);
        superUser.setUserName(username);
        superUser.setPassword(password);
        superUser.setAddress(address);
        int i = shopUserMapper.addShopUser(superUser);
        if (i==1) {
            model.addAttribute("msg", "注册成功，请登录！");
            return "shop/login";
        }
        return "shop/register";
    }
}

