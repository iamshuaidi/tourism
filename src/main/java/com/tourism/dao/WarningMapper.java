package com.tourism.dao;

import com.tourism.model.Warning;
import com.tourism.model.WarningExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarningMapper {
    long countByExample(WarningExample example);

    int deleteByExample(WarningExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Warning record);

    int insertSelective(Warning record);

    List<Warning> selectByExampleWithBLOBs(WarningExample example);

    List<Warning> selectByExample(WarningExample example);

    Warning selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Warning record, @Param("example") WarningExample example);

    int updateByExampleWithBLOBs(@Param("record") Warning record, @Param("example") WarningExample example);

    int updateByExample(@Param("record") Warning record, @Param("example") WarningExample example);

    int updateByPrimaryKeySelective(Warning record);

    int updateByPrimaryKeyWithBLOBs(Warning record);

    int updateByPrimaryKey(Warning record);
}