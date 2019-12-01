package com.nhoksoft.helloworld.backend.services.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.nhoksoft.helloworld.backend.services.SaludoService;

@Service
public class SaludoServiceImpl2 implements SaludoService {
	
	private DateFormat dateFormat = new SimpleDateFormat("HH:mm");
	
	@Override
	public String getSaludo() {
		
		return "Hola! Son las " + dateFormat.format(new Date());
	}

}
