package com.Kiran.it.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Data
@Table(name="PLAN_CATEGORY")
public class PlanCategory {
	
	@Id
	@GeneratedValue
	@Column(name="CATEGORY_ID")
	private Integer CategoryId;
	
	@Column(name="CATEGORY_NAME")
	private String CategoryName;
	
	@Column(name="ACTIVESW")
	private String activeSw;
	
	@Column(name="CREATED_BY")
	private String createdBy;
	
	@Column(name="UPDATED_BY")
	private String UpdatedBy;
	
	@Column(name="CRATED_DATE",updatable = false)
	@CreationTimestamp
	private LocalDate createDate;
	
	@Column(name="UPDATED_DATE",insertable = false)
	@UpdateTimestamp
	private LocalDate updateDate;

}
