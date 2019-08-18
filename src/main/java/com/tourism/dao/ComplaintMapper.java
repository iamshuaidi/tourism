package com.tourism.dao;

import com.tourism.model.Complaint;
import com.tourism.model.ComplaintExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComplaintMapper {
    long countByExample(ComplaintExample example);

    int deleteByExample(ComplaintExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Complaint record);

    int insertSelective(Complaint record);

    List<Complaint> selectByExampleWithBLOBs(ComplaintExample example);

    List<Complaint> selectByExample(ComplaintExample example);

    Complaint selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByExampleWithBLOBs(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByExample(@Param("record") Complaint record, @Param("example") ComplaintExample example);

    int updateByPrimaryKeySelective(Complaint record);

    int updateByPrimaryKeyWithBLOBs(Complaint record);

    int updateByPrimaryKey(Complaint record);
}