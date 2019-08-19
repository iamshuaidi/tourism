package com.tourism.dao;

import com.tourism.model.PlanEmer;
import com.tourism.model.PlanEmerExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlanEmerMapper {
    long countByExample(PlanEmerExample example);

    int deleteByExample(PlanEmerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlanEmer record);

    int insertSelective(PlanEmer record);

    List<PlanEmer> selectByExample(PlanEmerExample example);

    PlanEmer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlanEmer record, @Param("example") PlanEmerExample example);

    int updateByExample(@Param("record") PlanEmer record, @Param("example") PlanEmerExample example);

    int updateByPrimaryKeySelective(PlanEmer record);

    int updateByPrimaryKey(PlanEmer record);

    List<PlanEmer> selectAll();
}