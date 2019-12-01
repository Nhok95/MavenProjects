package com.nhoksoft.carinsurance.controllers;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhoksoft.carinsurance.services.CalculatorService;

@RestController
@RequestMapping("/api/insurance")
public class CalculatorServiceController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@GetMapping("price")
	public double getPrice(@RequestParam(value = "marca") String marca,
							@RequestParam(value = "modelo") String modelo, 
							@RequestParam(value = "color") String color,
							@RequestParam(value = "tipo") String tipo,
							@RequestParam(value = "fechaNacimiento") @DateTimeFormat(pattern="dd/MM/yyyy") Date fechaNacimiento,
							@RequestParam(value = "fechaCarnet") @DateTimeFormat (pattern="dd/MM/yyyy") Date fechaCarnet) {
		
		return calculatorService.getPrice(marca, modelo, color, tipo, fechaNacimiento, fechaCarnet);
	}
	
}
