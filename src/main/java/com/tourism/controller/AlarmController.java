package com.tourism.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.tourism.model.Alarm;
import com.tourism.model.Complaint;
import com.tourism.service.AlarmService;
import com.tourism.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("")
public class AlarmController {

    @Autowired
    AlarmService alarmService;

    //游客提交投诉表单
    @CrossOrigin
    @RequestMapping(value = "doAlarm")
    public void doAlarm(@RequestParam("content") String content,@RequestParam("name") String name,
                            @RequestParam("gender") String gender, @RequestParam("phone") String phone) {
        Alarm alarm = new Alarm();
        Date date = new Date();
        //  System.out.println(date.toString());
        alarm.setNumber("0");//先设为0，在方法后面会进行更新
        alarm.setName(name);
        alarm.setGender(gender);
        alarm.setPhone(phone);
        alarm.setContent(content);
        alarm.setCreateTime(date);
        alarmService.addAlarm(alarm);
        //生成唯一的投诉序号
        int num1 = alarm.getId();//获得刚插入的投诉的自增id
        String str1 = String.format("%0" + 6 + "d", num1 + 1);//将投诉的自增id转为6位的字符串
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        //int num2 = (int)(Math.random() * 9 + 1) * 10000;//生成五位
        String randId = sdf.format(date) + str1;//唯一的流水号
        alarm.setNumber(randId);
        alarmService.updateAlarm(alarm);
    }

    //游客查询自己的投诉
    @CrossOrigin
    @RequestMapping(value = "queryAlarm")
    public List<Alarm> getAlarm(@RequestParam("phone") String phone) {
        List<Alarm> alarmList = new ArrayList<>();
        alarmList = alarmService.queryAlarmByPhone(phone);
        Alarm alarm = new Alarm();
        for(int i = 0; i < alarmList.size(); i++){
            alarm = alarmList.get(i);
            System.out.println(alarm.getCreateTime());
        }
        return alarmList;
    }

    // 根据id进行具体的投诉的查看
    @CrossOrigin
    @RequestMapping(value = "showAlarm")
    public Alarm showAlarm(@RequestParam("id") String _id) {
        Integer id = Integer.parseInt(_id);
        Alarm alarm = alarmService.queryAlarmById(id);
        return alarm;
    }

    // 管理员根据时间段查看投诉
    @CrossOrigin
    @RequestMapping(value = "dealAlarm")
    public List<Alarm> dealAlarm(@RequestParam("start") String start,
                                         @RequestParam("end") String end) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse(start);
        Date endTime = sdf.parse(end);
        List<Alarm> alarmList = alarmService.queryAlarmByTime(startTime, endTime);
        return alarmList;
    }

    //管理员提交处理结果
    @CrossOrigin
    @RequestMapping(value = "replyAlarm")
    public void replyAlarm(@RequestParam("result") String result,
                               @RequestParam("cid")String id, @RequestParam("aid") String aid){
        Alarm alarm = alarmService.queryAlarmById(Integer.parseInt(id));
        alarm.setResult(result);
        alarm.setDealTime(new Date());
        alarm.setAdminId(Integer.parseInt(aid));//暂时这样处理管理员编号
        alarmService.updateAlarm(alarm);
    }
}
