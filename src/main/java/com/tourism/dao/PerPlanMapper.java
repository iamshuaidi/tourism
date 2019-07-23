package com.tourism.dao;

import com.tourism.model.PerPlan;
import com.tourism.model.PerPlanExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PerPlanMapper {
    long countByExample(PerPlanExample example);

    int deleteByExample(PerPlanExample example);

    int insert(PerPlan record);

    int insertSelective(PerPlan record);

    List<PerPlan> selectByExample(PerPlanExample example);

    int updateByExampleSelective(@Param("record") PerPlan record, @Param("example") PerPlanExample example);

    int updateByExample(@Param("record") PerPlan record, @Param("example") PerPlanExample example);
}