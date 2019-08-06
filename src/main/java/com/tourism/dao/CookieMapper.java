package com.tourism.dao;

import com.tourism.model.Cookie;
import com.tourism.model.CookieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CookieMapper {
    long countByExample(CookieExample example);

    int deleteByExample(CookieExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cookie record);

    int insertSelective(Cookie record);

    List<Cookie> selectByExample(CookieExample example);

    Cookie selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cookie record, @Param("example") CookieExample example);

    int updateByExample(@Param("record") Cookie record, @Param("example") CookieExample example);

    int updateByPrimaryKeySelective(Cookie record);

    int updateByPrimaryKey(Cookie record);
}