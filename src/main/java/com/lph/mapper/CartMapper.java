package com.lph.mapper;

import com.lph.pojo.Cart;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <pre>
 *
 * </pre>
 *
 * @author 澜阙
 * @since 2020/5/19 0:16
 */
@Mapper
@Repository
public interface CartMapper {
    @Select("select * from cart")
    List<Cart> queryCartList();


    @Select("select * from cart where u_phone=#{u_phone}")
    List<Cart> queryCartListByU_phone(String u_phone);

    @Insert("insert cart (g_id,u_phone)values(#{g_id},#{u_phone})")
    int insertCart(Integer g_id,String u_phone);

    @Insert("insert into cart(g_id,u_phone)values(#{g_id},#{u_phone})")
    int insert(Cart cart);
}
