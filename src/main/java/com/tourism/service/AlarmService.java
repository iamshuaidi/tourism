package com.tourism.service;

import com.tourism.model.Alarm;

import java.util.Date;
import java.util.List;

public interface AlarmService {
    public void addAlarm(Alarm alarm);

    public Alarm queryAlarmById(Integer id);

    public List<Alarm> queryAlarmByPhone(String phone);

    public void updateAlarm(Alarm alarm);

    public List<Alarm> queryAlarmByTime(Date startTime, Date endTime);
}
