package com.ApplicationRegi.ARModule.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ApplicationRegi.ARModule.entity.CitizenAppEntity;

@Repository
public interface CitizenAppRepo extends JpaRepository<CitizenAppEntity,Serializable>{

}
