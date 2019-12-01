package com.nhoksoft.carinsurance.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhoksoft.carinsurance.model.Color;
import com.nhoksoft.carinsurance.model.Result;
import com.nhoksoft.carinsurance.model.Tipo;
import com.nhoksoft.carinsurance.model.Vehicle;
import com.nhoksoft.carinsurance.services.CalculatorService;

@RestController
@RequestMapping("/insurance")
@Qualifier(value= "CalculatorServiceImpl2")
public class CalculatorServiceController {
	
	@Autowired
	CalculatorService calculatorService;
	
	@GetMapping("/car")
	public List<Vehicle> getAllCars() {
		return calculatorService.getAllCars();
	}
	
	@GetMapping ("/precio")
	public Result getPrice(@RequestParam(value = "marca") String marca,
						   @RequestParam(value="modelo")String modelo,
						   @RequestParam(value="color") String color,
						   @RequestParam(value="tipo") String tipo,
						   @RequestParam(value="fechaNacimiento")@DateTimeFormat(pattern="dd/MM/yyyy") Date fechaNacimiento,
						   @RequestParam(value="fechaCarnet")@DateTimeFormat(pattern="dd/MM/yyyy") Date fechaCarnet) {
		
		
		double price = calculatorService.getPrice(marca, modelo, color, tipo,
					fechaNacimiento, fechaCarnet);
		
		return new Result(Double.toString(price));
	}
	
	@PostMapping("/car")
	public void addCar(@RequestBody Vehicle car) {
		
		calculatorService.addCar(car);
		
	}
	
}
