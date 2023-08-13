package com.Kiran.it.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.Kiran.it.entity.Plan;

@Service
public interface PlanService {
	
	Map<Integer, String> getAllPlanCategory();
	
	boolean savePlan(Plan plan);
	
	boolean updatePlan(Plan plan);
	
	boolean deletePlan(Integer planId);
	
	boolean planCheckStatus(Integer planId,String status);
	
	List<Plan> getAllPlans();
	
	Plan getPlanById(Integer planId);
	
	
	
	
	

}
