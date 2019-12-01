package com.nhoksoft.helloworld.backend.services.impl;

import org.springframework.stereotype.Service;

import com.nhoksoft.helloworld.backend.services.SaludoService;

@Service
public class SaludoServiceImpl implements SaludoService {

	@Override
	public String getSaludo() {
		
		return "Hola! Soy un saludo que proviene de un servicio";
	}

}
