package com.nhoksoft.helloworld.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nhoksoft.helloworld.backend.services.SaludoService;

@RestController
public class SaludoController {
	
	@Autowired
	@Qualifier("saludoServiceImpl2")
	private SaludoService saludoService;
	
	@GetMapping("/saludo")
	public String darSaludo() {
		String saludo = saludoService.getSaludo();
		return saludo;
	}
	
}

//end point que recibira info sobre numero de miembros, nombres de los grupos y miembros como tal. 


