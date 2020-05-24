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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @RequestMapping("/addCart/{id}")
    public String ncsjhdv(Model model, HttpSession session,
                          @PathVariable("id") Integer id) {
        String userphonemsg = (String) session.getAttribute("userphonemsg");
        System.out.println(id);
        System.out.println(userphonemsg);
        Cart cart = new Cart();
        cart.setG_id(id);
        cart.setU_phone(userphonemsg);
        int i = cartMapper.insert(cart);
        if (i == 1) {
            model.addAttribute("msg", "添加成功！");
            return "success";
        } else {
            return "success";
        }
    }
}

