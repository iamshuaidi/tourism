package com.tourism.dao;

import com.tourism.model.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface  UserDao {
    String TABLE_NAME = "user";
    String INSERT_FIELDS = "name, password, salt, head_url, phone";
    String SELECT_FIELDS = "id, name, password, salt, head_url, phone";

    @Insert({"insert into ", TABLE_NAME, " ( ", INSERT_FIELDS," ) ",
            "values(#{name}, #{password}, #{salt}, #{headUrl}, #{phone})"})
    int addUser(User user);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,
    " where name = #{name}"})
    User selectByName(String name);

    @Select({"select ", SELECT_FIELDS, " from ", TABLE_NAME,
            " where phone = #{phone}"})
    User selectByPhone(String phone);
}
