package com.ApplicationRegi.ARModule.payloads;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenApp {
	
   private String fullname;
	
	private String email;
	
	private Long phonno;
	
	private Long snn;
	
	private String gender;
	
	private LocalDate dob;
	

}
