package com.tourism.serviceImpl;

import com.tourism.dao.WarningMapper;
import com.tourism.model.Warning;
import com.tourism.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WarningServiceImpl implements WarningService {
    public final static String stopState = "停止预警";

    @Autowired
    WarningMapper warningMapper;

    public List<Warning> sendWarning(){
        List<Warning> warningList = warningMapper.selectAll();
        return warningList;
    }

    public void createWarning(Warning warning) {
        warningMapper.insertSelective(warning);
    }

    public void stopWarning(Integer warningID){
        Warning warning = warningMapper.selectByPrimaryKey(warningID);
        warning.setState(stopState);
        warningMapper.updateByPrimaryKey(warning);
    }

}
