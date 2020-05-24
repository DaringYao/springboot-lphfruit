package com.lph.controller;

import com.lph.mapper.GoodsMapper;
import com.lph.pojo.Goods;
import com.lph.util.UploadUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;


/**
 * <pre>
 *
 * </pre>
 *
 * @author 澜阙
 * @since 2020/5/9 23:23
 */
@Controller
public class ShopController {
    @Autowired
    private GoodsMapper goodsMapper;
    @RequestMapping("/hom")
    public String hom() {
        return "shop/tgls/index";
    }


    /**
     * 转到商品增加页面
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/agentadd")
    public String agent_add(HttpSession session, Model model) {
        return "shop/tgls/agent/agent_add";
    }
    @RequestMapping("/goodsupload")
    @ResponseBody
    public int  goodsupload(@RequestParam("goodsname") String name,
                                          @RequestParam("imgage") MultipartFile file,
                                          @RequestParam("price") String  price,
                                          @RequestParam("g_class") String g_class,
                                          Model model,HttpSession session){
        System.out.println(name);
        System.out.println(file);
        System.out.println(price);
        System.out.println(g_class);
        UploadUtil uploadUtil = new UploadUtil();
        String fileUpload = uploadUtil.fileUpload(file);
        String shopPhone = (String) session.getAttribute("shopPhone");
        Goods goods = new Goods();
        goods.setS_userName(shopPhone);
        goods.setG_name(name);
        goods.setG_imgurl(fileUpload);
        goods.setG_price(price);
        goods.setG_class(g_class);
        System.out.println(goods.toString());
        int i = goodsMapper.insertGoods(goods);
        if (i==1){
            model.addAttribute("addgoods","商品已添加，继续添加");
        }else{
            model.addAttribute("addgoods","商品添加失败");
        }

        return i;
    }

   @RequestMapping("/agentlist")
    public String agent_list(HttpSession session,Model model) {
       List<Goods> goods = goodsMapper.queryGoodsList();
       //        获取session用户名
       String shopPhone =  (String) session.getAttribute("shopPhone");
//        根据用户名查询对应超市的商品ID
       List<Goods> shoplist = goodsMapper.queryGoodsByShopPhone(shopPhone);
//        建立返回list页面的集合
//        通过商品id查询goods表的商品信息

       model.addAttribute("shoplist",shoplist);
       return "shop/tgls/agent/agent_list";
    }

}
