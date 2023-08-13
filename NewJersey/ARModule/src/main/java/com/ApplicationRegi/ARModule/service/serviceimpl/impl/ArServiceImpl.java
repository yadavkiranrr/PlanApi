package com.ApplicationRegi.ARModule.service.serviceimpl.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.ApplicationRegi.ARModule.entity.CitizenAppEntity;
import com.ApplicationRegi.ARModule.payloads.CitizenApp;
import com.ApplicationRegi.ARModule.repository.CitizenAppRepo;
import com.ApplicationRegi.ARModule.service.serviceimpl.ArService;

@Service
public class ArServiceImpl implements ArService {

	@Autowired
	private CitizenAppRepo appRepo;
	@Override
	public Integer createApplication(CitizenApp app) {
		// TODO Auto-generated method stub
		
		String endPointUrl="http://kiran";
		
		RestTemplate rt= new RestTemplate();
		
		ResponseEntity<String> resEntity= rt.getForEntity(endPointUrl,String.class,app.getSnn());
		
		String stateName=resEntity.getBody();
		
		if ("New Jersey".equals(stateName)) {
			//create application
			
			CitizenAppEntity entity=new CitizenAppEntity();
			
			BeanUtils.copyProperties(app, entity);
			
			entity.setStatename(stateName);
			
			CitizenAppEntity save = appRepo.save(entity);
			
			return save.getAppId();
		}
		return 0;
	}

}
