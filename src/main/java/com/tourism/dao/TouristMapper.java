package com.tourism.dao;

import com.tourism.model.Tourist;
import com.tourism.model.TouristExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TouristMapper {
    long countByExample(TouristExample example);

    int deleteByExample(TouristExample example);

    int insert(Tourist record);

    int insertSelective(Tourist record);

    List<Tourist> selectByExample(TouristExample example);

    int updateByExampleSelective(@Param("record") Tourist record, @Param("example") TouristExample example);

    int updateByExample(@Param("record") Tourist record, @Param("example") TouristExample example);
}