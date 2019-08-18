package com.tourism.serviceImpl;

import com.tourism.dao.ComplaintMapper;
import com.tourism.model.Complaint;
import com.tourism.model.ComplaintExample;
import com.tourism.service.ComplaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ComplaintServiceImpl implements ComplaintService {

    @Autowired
    ComplaintMapper complaintMapper;

    @Override
    public void addComplaint(Complaint complaint) {
        complaintMapper.insert(complaint);
    }

    @Override
    public Complaint queryComplaintById(Integer id) {
        ComplaintExample example = new ComplaintExample();
        ComplaintExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Complaint> complaintList = complaintMapper.selectByExample(example);
        return complaintList.get(0);
    }

    @Override
    public List<Complaint> queryComplaintByPhone(String phone){
        ComplaintExample example = new ComplaintExample();
        ComplaintExample.Criteria criteria = example.createCriteria();
        criteria.andPhoneEqualTo(phone);
        List<Complaint> complaintList = complaintMapper.selectByExample(example);
        return complaintList;
    }

    @Override
    public void updateComplaint(Complaint complaint){
        complaintMapper.updateByPrimaryKey(complaint);
    }

    @Override
    public List<Complaint> queryComplaintByTime(Date startTime, Date endTime){
        ComplaintExample example = new ComplaintExample();
        ComplaintExample.Criteria criteria = example.createCriteria();
        criteria.andCreateTimeBetween(startTime, endTime);
        List<Complaint> complaintList = complaintMapper.selectByExample(example);
        return complaintList;
    }
}
