package com.Kiran.it.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Data;

@EnableConfigurationProperties
@Data
@Configuration
@ConfigurationProperties(prefix = "plan-api")
public class AppConfiguration {
	
	Map<String ,String> messages=new HashMap<>();

}
