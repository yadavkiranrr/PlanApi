package com.Kiran.it.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Kiran.it.config.AppConfiguration;
import com.Kiran.it.constands.AppConstants;
import com.Kiran.it.entity.Plan;
import com.Kiran.it.service.PlanService;

@RestController
public class PlanRestController {

	
	private PlanService planService;
	
	private AppConfiguration appConfig;
	
	private Map<String, String> messages= new HashMap<>();

	PlanRestController(PlanService planService,AppConfiguration appConfig){
		
		this.planService=planService;
		this.appConfig=appConfig;
	    this.messages=appConfig.getMessages();
		
	}

	// getAll Category
	@GetMapping("/categories")
	public ResponseEntity<Map<Integer, String>> planCategories() {

		Map<Integer, String> allPlanCategory = planService.getAllPlanCategory();

		return new ResponseEntity<Map<Integer, String>>(allPlanCategory, HttpStatus.OK);
	}

	// save plan
	@PostMapping("/plan")
	public ResponseEntity<String> savePlan(@RequestBody Plan plan) {

		String responseMsg =AppConstants.EMPTY_STR;
		boolean savePlan = planService.savePlan(plan);
		if (savePlan) {

			responseMsg =messages.get(AppConstants.PLAN_SAVE_SUCC);

		} else {
			responseMsg = messages.get(AppConstants.PLAN_SAVE_FAIL);
		}

		return new ResponseEntity<String>(responseMsg, HttpStatus.ACCEPTED);
	}

	// edit plan
	@GetMapping("plan/{planId}")
	public ResponseEntity<Plan> editPlan(@PathVariable Integer planId) {

		Plan planById = planService.getPlanById(planId);

		return new ResponseEntity<Plan>(planById, HttpStatus.OK);

	}

	// update plan
	@PutMapping("/plan")
	public ResponseEntity<String> updatePlan(@RequestBody Plan plan) {

		boolean isUpdated = planService.updatePlan(plan);
		String msg = AppConstants.EMPTY_STR;
		if (isUpdated) {
			msg =messages.get(AppConstants.PLAN_UPDATE_SUCC);
		} else {
			msg = messages.get(AppConstants.PLAN_UPDATE_FAIL);

		}

		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	// update plan
	@PutMapping("/status-change/{planId}/{status}")
	public ResponseEntity<String> updateStatus(@PathVariable Integer planId, @PathVariable String status) {

		boolean isChanged = planService.planCheckStatus(planId, status);
		String msg = AppConstants.EMPTY_STR;
		if (isChanged) {
			msg = messages.get(AppConstants.PLAN_STATUS_CHANGE);
		} else {
			msg = messages.get(AppConstants.PLAN_STATUS_CHANGE_FAIL);

		}

		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	// delete plan
	@DeleteMapping("/plan/{planId}")
	public ResponseEntity<String> deletePlan(@PathVariable Integer planId) {

		boolean isDeleted = planService.deletePlan(planId);
		String msg =AppConstants.EMPTY_STR;
		if (isDeleted) {
			msg = messages.get(AppConstants.PLAN_DELETE_SUCC);
		} else {
			msg = messages.get(AppConstants.PLAN_DELETE_FAIL);

		}

		return new ResponseEntity<>(msg, HttpStatus.OK);

	}

	// getAll

	@GetMapping("/getAllPlan")
	public ResponseEntity<List<Plan>> getAllPlan() {

		List<Plan> allPlans = planService.getAllPlans();

		return new ResponseEntity<>(allPlans, HttpStatus.OK);
	}

}
