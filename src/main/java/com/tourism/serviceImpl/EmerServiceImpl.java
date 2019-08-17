package com.tourism.serviceImpl;

import com.tourism.dao.PerEmerMapper;
import com.tourism.dao.PerPlanMapper;
import com.tourism.dao.PlanEmerMapper;
import com.tourism.model.PerEmer;
import com.tourism.model.PerPlan;
import com.tourism.model.PlanEmer;
import com.tourism.service.EmerService;
import org.springframework.beans.factory.annotation.Autowired;

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
        return planEmerMapper.selectByPrimaryKey(planEmer.getId());
    }

    public void addPerson(PerEmer perEmer){
        perEmerMapper.insert(perEmer);
    }

    public void assignPerson(PerPlan perPlan){
        perPlanMapper.insert(perPlan);
    }

    @Override
    public void deletePerson(PerEmer perEmer) {

    }

}
