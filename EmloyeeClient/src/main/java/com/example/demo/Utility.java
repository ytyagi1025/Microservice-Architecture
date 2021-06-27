package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Utility {

	private Employee[] empAr= {
		new Employee(1,"abc",null),	
		new Employee(2,"def",null),	
		new Employee(3,"cts",null),	
		new Employee(4,"mno",null),	
		new Employee(5,"xyz",null),	

		
	};
	
	public Employee getEmployee(int id) {
		for(Employee e:empAr) {
			if(e.getId()==id) {
				return e;
			}
		}
		return null;
	}
}
