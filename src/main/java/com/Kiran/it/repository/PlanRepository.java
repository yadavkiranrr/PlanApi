package com.Kiran.it.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.Kiran.it.entity.Plan;

public interface PlanRepository extends JpaRepository<Plan, Integer> {

}
