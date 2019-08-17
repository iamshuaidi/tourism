package com.tourism.service;

import com.tourism.model.*;

public interface EmerService {

    public void addEmerPlan(PlanEmer planEmer);

    public PlanEmer editEmerPlan(PlanEmer planEmer);

    public void addPerson(PerEmer perEmer);

    public void assignPerson(PerPlan perPlan);

    public void deletePerson(PerEmer perEmer);
}
