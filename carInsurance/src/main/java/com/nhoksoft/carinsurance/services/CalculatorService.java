package com.nhoksoft.carinsurance.services;

import java.util.Date;
import java.util.List;

import com.nhoksoft.carinsurance.model.Vehicle;

public interface CalculatorService {
	
	public List<Vehicle> getAllCars();
	
	public double getPrice(String marca, String modelo, String color,
			String tipo, Date fechaNacimiento, Date fechaCarnet);
	
	public void addCar(Vehicle car);
	

}
