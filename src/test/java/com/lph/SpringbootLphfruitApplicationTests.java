package com.lph;

import com.lph.mapper.GoodsMapper;
import com.lph.mapper.UserMapper;
import com.lph.pojo.Goods;
import com.lph.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Random;
import java.util.UUID;

@SpringBootTest
class SpringbootLphfruitApplicationTests {
    @Autowired
    GoodsMapper goodsMapper;
    @Autowired
    private UserMapper userMapper;

    @Test
    void contextLoads() {
       /* List<Goods> goods = goodsMapper.queryGoodsList();
        for (Goods g : goods) {
            System.out.println(g.toString());
        }*/
        Goods goods = new Goods();
        goods.setS_userName("1");
        goods.setG_name("1");
        goods.setG_class("1");
        goods.setG_price("1");
        goods.setG_imgurl("1");
        int i = goodsMapper.insertGoods(goods);
        if (i == 1) {
            System.out.println("姚立胜贼撒混");
        } else {
            System.out.println("宇宙无敌丑");
        }
    }

    @Test
    void contextLndwoiefoads() {
        //随机生成一位整数
        int random = (int) (Math.random() * 9 + 1);
        String valueOf = String.valueOf(random);
        //生成uuid的hashCode值
        int hashCode = UUID.randomUUID().toString().hashCode();
        //可能为负数
        if (hashCode < 0) {
            hashCode = -hashCode;
        }
        String value = valueOf + String.format("%015d", hashCode);
        System.out.println("宇宙无敌丑" + value);
    }

    //    2000002013367018
    @Test
    void contextLndwoiedddfoads() {
        User user = userMapper.queryUser("123");
        System.out.println("sdhjkplo------------------==================="+user.toString());
    }
}
