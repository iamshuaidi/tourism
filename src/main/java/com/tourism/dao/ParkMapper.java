package com.tourism.dao;

import com.tourism.model.Park;
import com.tourism.model.ParkExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ParkMapper {
    long countByExample(ParkExample example);

    int deleteByExample(ParkExample example);

    int insert(Park record);

    int insertSelective(Park record);

    List<Park> selectByExample(ParkExample example);

    int updateByExampleSelective(@Param("record") Park record, @Param("example") ParkExample example);

    int updateByExample(@Param("record") Park record, @Param("example") ParkExample example);
}