package com.example.demo.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.services.DemoService;

@RestController
public class TriggerController {
	
	
	@SuppressWarnings("unused")
	@Autowired
	private DemoService demoService;
	
	@Autowired
	//@Qualifier("sdfHora") //nombre del metodo de la clase de configuración
	//@Qualifier("sdfFecha")
	@Qualifier("complet")
	private SimpleDateFormat sdf;
	
	@GetMapping("/trigger")
	public String trigger() {
		return "ok";
	}
	
	@GetMapping("/triggerDate")
	public String trigger2() {
		return sdf.format(new Date());
	}
}
