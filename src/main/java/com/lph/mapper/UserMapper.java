package com.lph.mapper;


import com.lph.pojo.User;
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
 * @since 2020/3/13 13:41
 */
@Mapper
@Repository
public interface UserMapper {


    @Select("select * from user where phone = #{phone}")
    User queryUser(String phone);

    @Select("select address from user where phone = #{phone}")
    String queryUserAddress(String phone);

    @Select("select * from user")
    List<User> queryUserList();

    @Insert("insert into user (phone,nickName,password,address) values (#{phone},#{nickName},#{password},#{address})")
    int addUser(User user);


}
