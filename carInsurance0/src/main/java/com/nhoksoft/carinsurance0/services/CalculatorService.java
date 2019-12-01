package com.nhoksoft.carinsurance.services;

import java.util.Date;

public interface CalculatorService {
	
	public double getPrice(String marca, String modelo, String color,
			String tipo, Date fechaNacimiento, Date fechaCarnet);

}
