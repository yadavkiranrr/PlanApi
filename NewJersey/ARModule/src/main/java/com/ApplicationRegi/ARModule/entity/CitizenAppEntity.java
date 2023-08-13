package com.ApplicationRegi.ARModule.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="CITIZEN_APP")
public class CitizenAppEntity
{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;
	
	private String fullname;
	
	private String email;
	
	private Long phonno;
	
	private Long snn;
	
	private String gender;
	
	private String statename;
	
	private LocalDate createdDate;
	
	private LocalDate updatedDate;
	
	private LocalDate dob;
	
	private String createdBy;
	

}
