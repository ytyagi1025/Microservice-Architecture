package com.example.demo;

import org.springframework.stereotype.Component;

@Component
public class Utility {

	private Technology[] techAr= {
		new Technology(1001,"Java"),
		new Technology(1002,"C++"),
		new Technology(1003,"Python"),
		new Technology(1004,"Mysql"),
		new Technology(1005,"Angular"),
	};
	
	public Technology getTechnology(int techId) {
		for(Technology t:techAr) {
			if(t.getTechId()==techId) {
				return t;
			}
		}
		return null;
	}
}
