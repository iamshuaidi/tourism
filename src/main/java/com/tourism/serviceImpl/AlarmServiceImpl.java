package com.tourism.serviceImpl;

import com.tourism.dao.AlarmMapper;
import com.tourism.model.Alarm;
import com.tourism.model.AlarmExample;
import com.tourism.model.Complaint;
import com.tourism.model.ComplaintExample;
import com.tourism.service.AlarmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Autowired
    AlarmMapper alarmMapper;

    @Override
    public void addAlarm(Alarm alarm) {
        alarmMapper.insert(alarm);
    }

    @Override
    public Alarm queryAlarmById(Integer id) {
        AlarmExample example = new AlarmExample();
        AlarmExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Alarm> alarmList = alarmMapper.selectByExample(example);
        return alarmList.get(0);
    }

    @Override
    public List<Alarm> queryAlarmByPhone(String phone){
        AlarmExample example = new AlarmExample();
        AlarmExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<Alarm> alarmList = alarmMapper.selectByExample(example);
        return alarmList;
    }

    @Override
    public void updateAlarm(Alarm alarm){
        alarmMapper.updateByPrimaryKey(alarm);
    }

    @Override
    public List<Alarm> queryAlarmByTime(Date startTime, Date endTime){
        AlarmExample example = new AlarmExample();
        AlarmExample.Criteria criteria = example.createCriteria();
        criteria.andCreateTimeBetween(startTime, endTime);
        List<Alarm> alarmList = alarmMapper.selectByExample(example);
        return alarmList;
    }
}
