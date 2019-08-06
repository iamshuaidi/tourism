package com.tourism.dao;

import com.tourism.model.PerEmer;
import com.tourism.model.PerEmerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PerEmerMapper {
    long countByExample(PerEmerExample example);

    int deleteByExample(PerEmerExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PerEmer record);

    int insertSelective(PerEmer record);

    List<PerEmer> selectByExample(PerEmerExample example);

    PerEmer selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PerEmer record, @Param("example") PerEmerExample example);

    int updateByExample(@Param("record") PerEmer record, @Param("example") PerEmerExample example);

    int updateByPrimaryKeySelective(PerEmer record);

    int updateByPrimaryKey(PerEmer record);
}