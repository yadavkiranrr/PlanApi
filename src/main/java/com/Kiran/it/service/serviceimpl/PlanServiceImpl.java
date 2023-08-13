package com.Kiran.it.service.serviceimpl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Kiran.it.entity.Plan;
import com.Kiran.it.entity.PlanCategory;
import com.Kiran.it.repository.PlanCategoryRepository;
import com.Kiran.it.repository.PlanRepository;
import com.Kiran.it.service.PlanService;

@Service
public class PlanServiceImpl implements PlanService {
	
	@Autowired
	private PlanRepository planRepo;
	
	@Autowired
	private PlanCategoryRepository planCategoryRepo;

	@Override
	public Map<Integer, String> getAllPlanCategory() {
		// TODO Auto-generated method stub
		List<PlanCategory> allCategory = planCategoryRepo.findAll();
		
		Map<Integer,String> allPlanCategory=new HashMap<Integer, String>();
		
		allCategory.forEach(category -> {
			
		allPlanCategory.put(category.getCategoryId(),category.getCategoryName());
		
		});
		return allPlanCategory;
	}

	@Override
	public boolean savePlan(Plan plan) {
		// TODO Auto-generated method stub
		Plan saved = planRepo.save(plan);
		return saved.getPlanId()!=null;
	}

	@Override
	public boolean updatePlan(Plan plan) {
		// TODO Auto-generated method stub
		planRepo.save(plan);
		return plan.getPlanId()!=null;
	}

	@Override
	public boolean deletePlan(Integer planId) {
		// TODO Auto-generated method stub
		boolean status=false;
		
		try {
			
			planRepo.deleteById(planId);
			status=true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return status;
	}

	@Override
	public boolean planCheckStatus(Integer planId, String status) {
		// TODO Auto-generated method stub
		Optional<Plan> findById = planRepo.findById(planId);
		
		if (findById.isPresent()) {
			
			Plan plan=findById.get();
			plan.setActiveSw(status);
            planRepo.save(plan);
            return true;
		}
		return false;
	}

	@Override
	public List<Plan> getAllPlans() {
		// TODO Auto-generated method stub
		List<Plan> findAll = planRepo.findAll();
		return findAll;
	}

	@Override
	public Plan getPlanById(Integer planId) {
		// TODO Auto-generated method stub
		Optional<Plan> findById = planRepo.findById(planId);
		if (findById.isPresent()) {
			
			return findById.get();
		}
		return null;
	}
 
}
