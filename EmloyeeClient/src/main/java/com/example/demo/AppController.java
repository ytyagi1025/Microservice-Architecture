package com.example.demo;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;


@RestController
public class AppController {

	@Autowired
	Utility utility;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@GetMapping("getEmp/{id}/{techId}")
	public ResponseEntity getEmployee(@PathVariable int id, @PathVariable int techId) {
		Employee emp=utility.getEmployee(id);
		List<ServiceInstance> list=discoveryClient.getInstances("TECHNOLOGY");
		ServiceInstance instance=list.get(0);
		URI uri=instance.getUri();
		
		
		try {
			Technology tech=new RestTemplate().getForObject(uri+"/getTech/"+techId, Technology.class);
		emp.setTechnology(tech);
		return new ResponseEntity(emp,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
