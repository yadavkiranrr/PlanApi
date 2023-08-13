package com.ApplicationRegi.ARModule.service.serviceimpl;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ApplicationRegi.ARModule.payloads.CitizenApp;

@Service
public interface ArService {
	
	public Integer createApplication(CitizenApp app);
 

}
