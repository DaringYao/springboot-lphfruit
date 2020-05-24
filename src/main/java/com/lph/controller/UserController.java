package com.lph.controller;

import com.lph.mapper.CartMapper;
import com.lph.pojo.Cart;
import com.lph.pojo.Goods;
import com.lph.util.GetDistanceByLatAndLng;
import com.lph.mapper.GoodsMapper;
import com.lph.mapper.ShopUserMapper;
import com.lph.mapper.UserMapper;
import com.lph.pojo.Shopuser;
import com.lph.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author 澜阙
 * @since 2020-05-07
 */
@Controller
public class UserController {
    @Autowired
    private ShopUserMapper shopUserMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private GoodsMapper goodsMapper;
    @Autowired
    private CartMapper cartMapper;

    /**
     * 接收logincontroller重定向请求
     *
     * @param session
     * @param model
     * @return
     * @throws IOException
     */
    @RequestMapping("/userindex")
    public String dnsjv(HttpSession session, Model model) throws IOException {
        String userphonemsg = (String) session.getAttribute("userphonemsg");
        String address = userMapper.queryUserAddress(userphonemsg);


        List<Shopuser> shopusers = shopUserMapper.queryShopUserList();
        List<Shopuser> list = new ArrayList<>();
        for (Shopuser s : shopusers) {
            String address1 = s.getAddress();
            String phone = s.getPhone();
            GetDistanceByLatAndLng getLatAndLngByBaidu = new GetDistanceByLatAndLng();
            String distance = getLatAndLngByBaidu.distance(address, address1);
            Shopuser shopuser = new Shopuser();
            shopuser.setPhone(phone);
            shopuser.setAddress(distance);
            shopuser.setUserName(s.getUserName());
            list.add(shopuser);
        }
        model.addAttribute("distance", list);
        List<Goods> goods = goodsMapper.queryGoodsList();
        model.addAttribute("shopgoods", goods);
        return "user/index";
    }

    /**
     * 加入购物车
     *
     * @param id
     * @param session
     * @return
     */
    @RequestMapping("/aaddCart")
    @ResponseBody
    public int aaddCart(@RequestParam("id") Integer id, HttpSession session) {
//        int i1 = Integer.parseInt(id);
        String userphonemsg = (String) session.getAttribute("userphonemsg");
        System.out.println(id);
        System.out.println(userphonemsg);
        Cart cart = new Cart();
        cart.setG_id(id);
        cart.setU_phone(userphonemsg);
        int i = cartMapper.insert(cart);
        return i;
    }

    @RequestMapping("/turnCart")
    public String turnCart(HttpSession session, Model model) {
        String userphonemsg = (String) session.getAttribute("userphonemsg");

        return "user/cart";
    }
}

