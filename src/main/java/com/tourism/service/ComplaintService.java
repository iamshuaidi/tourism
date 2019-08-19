package com.tourism.service;

import com.tourism.model.Complaint;

import java.util.Date;
import java.util.List;

public interface ComplaintService {
    public void addComplaint(Complaint complaint);

    public Complaint queryComplaintById(Integer id);

    public List<Complaint> queryComplaintByPhone(String phone);

    public void updateComplaint(Complaint complaint);

    public List<Complaint> queryComplaintByTime(Date startTime, Date endTime);
}
