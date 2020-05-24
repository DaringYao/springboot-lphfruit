package com.lph.mapper;

import com.lph.pojo.Shopuser;
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
 * @since 2020/3/28 18:51
 */
@Mapper
@Repository
public interface ShopUserMapper {

    @Select("select address from shopuser where phone=#{phone}")
    Shopuser queryAddressByPhone(String phone);

    @Select("select * from shopuser")
    List<Shopuser> queryShopUserList();

    @Insert("insert into shopuser (phone,nickName,userName,password,address) VALUES (#{phone},#{nickName},#{userName},#{password},#{address})")
    int addShopUser (Shopuser superUser);
}
