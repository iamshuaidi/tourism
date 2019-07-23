package com.tourism.dao;

import com.tourism.model.PlanEmer;
import com.tourism.model.PlanEmerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PlanEmerMapper {
    long countByExample(PlanEmerExample example);

    int deleteByExample(PlanEmerExample example);

    int insert(PlanEmer record);

    int insertSelective(PlanEmer record);

    List<PlanEmer> selectByExample(PlanEmerExample example);

    int updateByExampleSelective(@Param("record") PlanEmer record, @Param("example") PlanEmerExample example);

    int updateByExample(@Param("record") PlanEmer record, @Param("example") PlanEmerExample example);
}