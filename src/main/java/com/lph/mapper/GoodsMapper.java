package com.lph.mapper;

import com.lph.pojo.Goods;

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
 * @since 2020/3/22 1:27
 */
@Mapper
@Repository
public interface GoodsMapper {
    @Select("select * from goods where id=#{id}")
    List<Goods> queryGoodsListByG_id(Integer id);

    @Select("select * from goods where id=#{id}")
    Goods queryGoodsById(Integer id);

    @Select("select * from goods")
    List<Goods> queryGoodsList();

    @Select("select * from goods where s_userName=#{s_userName}")
    List<Goods> queryGoodsByShopPhone(String s_userName);

    @Insert("insert  goods (s_userName,g_imgurl,g_name,g_price,g_class)values(#{s_userName},#{g_imgurl},#{g_name},#{g_price},#{g_class})")
    int insertGoods(Goods goods);

}
