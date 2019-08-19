package com.tourism.serviceImpl;

import com.tourism.dao.PerEmerMapper;
import com.tourism.dao.PerPlanMapper;
import com.tourism.dao.PlanEmerMapper;
import com.tourism.model.PerEmer;
import com.tourism.model.PerPlan;
import com.tourism.model.PlanEmer;
import com.tourism.service.EmerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmerServiceImpl implements EmerService {
    @Autowired
    PerPlanMapper perPlanMapper;

    @Autowired
    PlanEmerMapper planEmerMapper;

    @Autowired
    PerEmerMapper perEmerMapper;

    public void addEmerPlan(PlanEmer planEmer){
        planEmerMapper.insert(planEmer);
    }

    public PlanEmer editEmerPlan(PlanEmer planEmer){
        planEmerMapper.updateByPrimaryKey(planEmer);
        return planEmer;
    }

    public void deleteEmerPlan(PlanEmer planEmer) {
        planEmerMapper.deleteByPrimaryKey(planEmer.getId());
    }

    public List<PlanEmer> showPlans(){
        return planEmerMapper.selectAll();
    }

    public void addPerson(PerEmer perEmer){
        perEmerMapper.insert(perEmer);
    }

    public void deletePerson(PerEmer perEmer) {
        perEmerMapper.deleteByPrimaryKey(perEmer.getId());
    }

    public PerEmer editPerson(PerEmer perEmer){
        perEmerMapper.updateByPrimaryKey(perEmer);
        return perEmer;
    }

    public List<PerEmer> showPerson(){
        List<PerEmer> perEmerList = perEmerMapper.selectAll();
        return perEmerList;
    }

    public PerPlan assignPerson(PerPlan perPlan){
        perPlanMapper.insert(perPlan);
        return perPlan;
    }

    public void deletePersonAssign(PerPlan perPlan) {
        perPlanMapper.deleteByPrimaryKey(perPlan.getId());
    }

    public PerEmer showPerInfo(PerEmer perEmer) {
        return perEmerMapper.selectByPrimaryKey(perEmer.getId());
    }



}
