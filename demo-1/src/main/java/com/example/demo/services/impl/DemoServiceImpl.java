package com.example.demo.services.impl;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.example.demo.services.DemoService;

// service, component y repository funcionan igual.
//@Service
//@Component
//@Repository
public class DemoServiceImpl implements DemoService {

	
	public DemoServiceImpl(int numero) {
		
	}
	@Override
	public String saluda() {
		return "hola";
	}

}
