package com.tourism.service;

import com.tourism.model.Complaint;

public interface TouristService {
    public void addComplaint(Complaint complaint);

    public Complaint queryComplaint(Integer id);
}
