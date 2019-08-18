package com.tourism.serviceImpl;

import com.tourism.dao.ComplaintMapper;
import com.tourism.model.Complaint;
import com.tourism.model.ComplaintExample;
import com.tourism.service.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TouristServiceImpl implements TouristService {

    @Autowired
    ComplaintMapper complaintMapper;
    @Override
    public void addComplaint(Complaint complaint){
        complaintMapper.insert(complaint);
    }

    @Override
    public Complaint queryComplaint(Integer id){
        ComplaintExample example = new ComplaintExample();
        ComplaintExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(id);
        List<Complaint> complaintList = complaintMapper.selectByExample(example);
        return complaintList.get(0);
    }
}
