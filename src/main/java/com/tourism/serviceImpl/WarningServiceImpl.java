package com.tourism.serviceImpl;

import com.tourism.dao.WarningMapper;
import com.tourism.model.Warning;
import com.tourism.service.WarningService;
import org.springframework.beans.factory.annotation.Autowired;

public class WarningServiceImpl implements WarningService {
    @Autowired
    WarningMapper warningMapper;

    public void sendWarning(Warning warning){
        warningMapper.selectByPrimaryKey(warning.getId());
    }

    public void createWarning(Warning warning) {
        warningMapper.insertSelective(warning);
    }
}
