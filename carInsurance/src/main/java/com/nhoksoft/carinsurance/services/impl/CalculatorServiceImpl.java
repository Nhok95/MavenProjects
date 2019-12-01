package com.nhoksoft.carinsurance.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nhoksoft.carinsurance.model.Vehicle;
import com.nhoksoft.carinsurance.services.CalculatorService;

public class CalculatorServiceImpl implements CalculatorService {

	private static final double BASE = 20;
	
	private static final Map<String, Double> modelos = new HashMap<String, Double>();
	private static final Map<String, Double> colores = new HashMap<String, Double>();
	private static final Map<String, Double> precioTipo = new HashMap<String, Double>();
	
	static {
		
		
		
		modelos.put("SeatIbiza", 3.0);
		modelos.put("SeatLeon", 5.0);
		modelos.put("SeatArona", 7.0);
		
		modelos.put("AudiA1",7.0);
		modelos.put("AudiA2",9.0);
		modelos.put("AudiA3",11.0);
		
		modelos.put("FerrariCalifornia", 15.0);
		modelos.put("FerrariFF", 18.0);
		modelos.put("Ferrari612", 23.0);
		
		///////////////////////////////////////
		
		colores.put("Blanco",0.0);
		colores.put("Azul",1.0);
		colores.put("Rojo",2.5);
		colores.put("Rosa",4.0);
		colores.put("Negro",6.0);
		
		///////////////////////////////////////
		
		precioTipo.put("SegundaMano", 4.0);
		precioTipo.put("Km0", 2.0);
		precioTipo.put("Nuevo", 1.0);
		
	}
	
	@Override
	public double getPrice(String marca, String modelo, String color, String tipo, Date fechaNacimiento,
			Date fechaCarnet) {
		
		String codigo = marca+modelo;
		
		if (!modelos.containsKey(codigo)) {
			throw new IllegalArgumentException("El modelo introducido no se encuentra en la base de datos");
		}
		
		double coffModelo = modelos.get(codigo);
		double coffColor = colores.get(color);
		double coffTipo = precioTipo.get(tipo);
		double coffEdad = 0.0;
		double coffAntiguedad = 0.0;
	
		
		LocalDate diaActual = LocalDate.now();
		LocalDate nacimiento = fechaNacimiento.toInstant().
				atZone(ZoneId.systemDefault()).
				toLocalDate();
		LocalDate carnet = fechaCarnet.toInstant().
				atZone(ZoneId.systemDefault()).
				toLocalDate();
		
		long edad = ChronoUnit.YEARS.between(nacimiento, diaActual);
		
		if(edad<18) {
			throw new IllegalArgumentException("edad no valida");
		}else if (edad < 35) {
			coffEdad = 3.0;
			
		} else if (edad <60) {
			coffEdad = 2.0;
			
		} else {
			coffEdad = 3.0;
		}
		
		long antiguedad = ChronoUnit.YEARS.between(carnet, diaActual);
		
		if(antiguedad<0) {
			throw new IllegalArgumentException("antiguedad imposible");
		}else if (antiguedad < 2) {
			coffAntiguedad = 3.0;
			
		} else if (antiguedad <10) {
			coffAntiguedad = 2.0;
			
		} else {
			coffAntiguedad = 3.0;
		}
		
		System.out.println("marca: " + marca + "|" +
						   "modelo: " + modelo + "|" +
						   "color: " + color + "|" +
						   "tipo: " + tipo + "|" +
						   "edad: " + edad + "|" +
						   "antiguedad: " + antiguedad);
		
		System.out.println("coffmodelo: " + coffModelo + "|" +
						   "coffcolor: " + coffColor + "|" +
						   "cofftipo: " + coffTipo + "|" +
						   "coffedad: " + coffEdad + "|" +
						   "coffantiguedad: " + coffAntiguedad);
		
		double precio = BASE + 10*coffModelo + 8*coffColor + 8*coffTipo + 20*coffEdad + 5*coffAntiguedad ; 
		
		return precio;
	}

	@Override
	public void addCar(Vehicle car) {
		String codigo = car.getMarca()+car.getModelo();
		modelos.put(codigo,car.getPrecio());
	}

	@Override
	public List<Vehicle> getAllCars() {
		// TODO Auto-generated method stub
		return null;
	}

}