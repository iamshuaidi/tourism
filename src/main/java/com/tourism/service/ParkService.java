package com.tourism.service;

import com.tourism.model.Park;

import java.util.List;

public interface ParkService {

    List<Park> queryAllPark(int flag);
}
