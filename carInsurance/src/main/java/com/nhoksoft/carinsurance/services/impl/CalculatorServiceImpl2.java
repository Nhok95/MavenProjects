package com.nhoksoft.carinsurance.services.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nhoksoft.carinsurance.model.Color;
import com.nhoksoft.carinsurance.model.Tipo;
import com.nhoksoft.carinsurance.model.Vehicle;
import com.nhoksoft.carinsurance.services.CalculatorService;
import com.nhoksoft.carinsurance.services.ColorRepository;
import com.nhoksoft.carinsurance.services.TipoRepository;
import com.nhoksoft.carinsurance.services.VehicleRepository;

@Service
public class CalculatorServiceImpl2 implements CalculatorService {

	@Autowired
	private VehicleRepository vehicleRepository;
	
	@Autowired
	private ColorRepository colorRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Override
	public List<Vehicle> getAllCars() {
		return vehicleRepository.findAll();
	}
	
	@Override
	public double getPrice(String marca, String modelo, String color, String tipo, Date fechaNacimiento,
			Date fechaCarnet) {
		return 0;
	}

	@Override
	public void addCar(Vehicle car) {
		// TODO Auto-generated method stub
		
	}

	

}
