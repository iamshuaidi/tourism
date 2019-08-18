package com.tourism.controller;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.tourism.model.Complaint;
import com.tourism.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("")
public class ComplaintController {

    @Autowired
    ComplaintService complaintService;

    //游客提交投诉表单
    @CrossOrigin
    @RequestMapping(value = "doComplaint")
    public void doComplaint(@RequestParam("content") String content,@RequestParam("name") String name,
                            @RequestParam("gender") String gender, @RequestParam("phone") String phone) {
        Complaint complaint = new Complaint();
        Date date = new Date();
      //  System.out.println(date.toString());
        complaint.setNumber("0");//先设为0，在方法后面会进行更新
        complaint.setName(name);
        complaint.setGender(gender);
        complaint.setPhone(phone);
        complaint.setContent(content);
        complaint.setCreateTime(date);
        complaintService.addComplaint(complaint);
        //生成唯一的投诉序号
        int num1 = complaint.getId();//获得刚插入的投诉的自增id,xml对应的方法要加上useGeneratedKeys
        String str1 = String.format("%0" + 6 + "d", num1);//将投诉的自增id转为6位的字符串
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddHHmmss");
        //int num2 = (int)(Math.random() * 9 + 1) * 10000;//生成五位
        String randId = sdf.format(date) + str1;//唯一的流水号
        complaint.setNumber(randId);
        complaintService.updateComplaint(complaint);
    }

    //游客查询自己的投诉
    @CrossOrigin
    @RequestMapping(value = "queryComplaint")
    public List<Complaint> getComplaint(@RequestParam("phone") String phone) {
        List<Complaint> complaintList = new ArrayList<>();
        complaintList = complaintService.queryComplaintByPhone(phone);
        Complaint complaint = new Complaint();
        for(int i = 0; i < complaintList.size(); i++){
            complaint = complaintList.get(i);
            System.out.println(complaint.getCreateTime());
        }
        return complaintList;
    }

    // 根据id进行具体的投诉的查看
    @CrossOrigin
    @RequestMapping(value = "showComplaint")
    public Complaint showComplaint(@RequestParam("id") String _id) {
        Integer id = Integer.parseInt(_id);
        Complaint complaint = complaintService.queryComplaintById(id);
        return complaint;
    }

    // 管理员根据时间段查看投诉
    @CrossOrigin
    @RequestMapping(value = "dealComplaint")
    public List<Complaint> dealComplaint(@RequestParam("start") String start,
                                         @RequestParam("end") String end) throws Exception{
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date startTime = sdf.parse(start);
        Date endTime = sdf.parse(end);
        List<Complaint> complaintList = complaintService.queryComplaintByTime(startTime, endTime);
        return complaintList;
    }

    //管理员提交处理结果
    @CrossOrigin
    @RequestMapping(value = "replyComplaint")
    public void replyComplaint(@RequestParam("result") String result,
    @RequestParam("cid")String id){
        Complaint complaint = complaintService.queryComplaintById(Integer.parseInt(id));
        complaint.setResult(result);
        complaint.setDealTime(new Date());
        complaint.setAdminId(1);//暂时这样处理管理员编号
        complaintService.updateComplaint(complaint);
    }

}
