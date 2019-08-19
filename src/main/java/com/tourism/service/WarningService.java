package com.tourism.service;

import com.tourism.model.Warning;

import java.util.List;

public interface WarningService {

    public List<Warning> sendWarning();

    public void createWarning(Warning warning);

    public void stopWarning(Integer warningID);
}
