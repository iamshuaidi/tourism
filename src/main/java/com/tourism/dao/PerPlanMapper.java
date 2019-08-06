package com.tourism.dao;

import com.tourism.model.PerPlan;
import com.tourism.model.PerPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PerPlanMapper {
    long countByExample(PerPlanExample example);

    int deleteByExample(PerPlanExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PerPlan record);

    int insertSelective(PerPlan record);

    List<PerPlan> selectByExample(PerPlanExample example);

    PerPlan selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PerPlan record, @Param("example") PerPlanExample example);

    int updateByExample(@Param("record") PerPlan record, @Param("example") PerPlanExample example);

    int updateByPrimaryKeySelective(PerPlan record);

    int updateByPrimaryKey(PerPlan record);
}