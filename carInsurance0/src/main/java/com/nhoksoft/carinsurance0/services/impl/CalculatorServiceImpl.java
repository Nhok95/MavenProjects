package com.nhoksoft.carinsurance.services.impl;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nhoksoft.carinsurance.services.CalculatorService;

@Service
public class CalculatorServiceImpl implements CalculatorService {

	private static final double BASE = 20;
	
	private static final Map<String, Double> modelos = new HashMap<String, Double>();
	private static final Map<String, Double> colores = new HashMap<String, Double>();
	private static final Map<String, Double> precioTipo = new HashMap<String, Double>();
	
	static {
		
		modelos.put("SeatIbiza", 2.0);
		modelos.put("SeatLeon", 2.5);
		modelos.put("SeatArona", 4.0);
		
		modelos.put("AudiA1",3.0);
		modelos.put("AudiA2",5.0);
		modelos.put("AudiA3",7.0);
		
		modelos.put("FerrariCalifornia", 10.0);
		modelos.put("FerrariFF", 12.0);
		modelos.put("Ferrari612", 15.0);
		
		///////////////////////////////////////
		
		colores.put("Blanco",0.5);
		colores.put("Azul",0.75);
		colores.put("Rojo",2.0);
		colores.put("Rosa",3.0);
		colores.put("Negro",5.0);
		
		///////////////////////////////////////
		
		precioTipo.put("SegundaMano", 2.5);
		precioTipo.put("Km0", 1.5);
		precioTipo.put("Nuevo", 0.5);
		
	}
	
	@Override
	public double getPrice(String marca, String modelo, String color, String tipo, Date fechaNacimiento,
			Date fechaCarnet) {
		
		String codigo = marca+modelo;
		double coffModelo = modelos.get(codigo);
		double coffColor = colores.get(color);
		double coffTipo = precioTipo.get(tipo);
		double coffEdad = 0.0;
		
		double coffAntiguedad = 0.0;
		if (!modelos.containsKey(codigo)) {
			throw new IllegalArgumentException("El modelo del vehiculo no se encuentra en la base de datos");
		}
		
		if (!colores.containsKey(color)) {
			throw new IllegalArgumentException("El color no se encuentra en la base de datos");
		}
		
		if (!precioTipo.containsKey(tipo)) {
			throw new IllegalArgumentException("El tipo especificado es erroneo");
		}
		
		System.out.println("Date carnet: " + fechaCarnet);
		
		LocalDate diaActual = LocalDate.now();
		LocalDate nacimiento = fechaNacimiento.toInstant().
				atZone(ZoneId.systemDefault()).
				toLocalDate();
		LocalDate carnet = fechaCarnet.toInstant().
				atZone(ZoneId.systemDefault()).
				toLocalDate();
		
		long edad = ChronoUnit.YEARS.between(nacimiento, diaActual);
		
		if(edad<18) {
			throw new IllegalArgumentException("Edad inferior a 18 años");
			
		}else if (edad < 35) {
			coffEdad = 3.0;
			
		} else if (edad <60) {
			coffEdad = 1.0;
			
		} else {
			coffEdad = 3.5;
		}
		
		long antiguedad = ChronoUnit.YEARS.between(carnet, diaActual);
		
		System.out.println(carnet);
		System.out.println(diaActual);
		System.out.println("antiguedad: " + antiguedad);
		
		if(antiguedad<0) {
			throw new IllegalArgumentException("fecha de carnet imposible");
			
		}else if (antiguedad < 2) {
			coffAntiguedad = 4.0;
			
		} else if (antiguedad>=2 && antiguedad <10) {
			coffAntiguedad = 2.5;
			
		} else {
			coffAntiguedad = 1.0;
		}
		
		System.out.println("modelo: " + coffModelo + " " +
						   "color: " + coffColor + " " +
						   "tipo: " + coffTipo + " " +
						   "edad: " + coffEdad + " " +
						   "antiguedad: " + coffAntiguedad);
		
		double precio = BASE + 12*coffModelo + 10*coffColor + 6*coffTipo + 5*coffEdad + 3*coffAntiguedad; 
		
		return precio;
	}
	
	

}