package com.tourism.service;

import com.tourism.model.PerEmer;
import com.tourism.model.PerPlan;
import com.tourism.model.PlanEmer;

import java.util.List;

public interface EmerService {

    public void addEmerPlan(PlanEmer planEmer);

    public PlanEmer editEmerPlan(PlanEmer planEmer);

    public void deleteEmerPlan(Integer id);

    public List<PlanEmer> showPlans();

    public void addPerson(PerEmer perEmer);

    public void deletePerson(PerEmer perEmer);

    public PerEmer editPerson(PerEmer perEmer);

    public List<PerEmer> showPerson();

    public PerPlan assignPerson(PerPlan perPlan);

    public void deletePersonAssign(PerPlan perPlan);

    public PerEmer showPerInfo(PerEmer perEmer);


}
