package com.example.demo.configuration;

import java.text.SimpleDateFormat;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.example.demo.services.DemoService;
import com.example.demo.services.impl.DemoServiceImpl;

@Configuration
public class BeansConfiguration {
	
	// Colocamos la implementacion en el AppicationContext,
	// dentro podemos configurar lo que queramos
	@Bean
	public DemoService crearDemoService() {
		// Voy a configurar el bean que necesito
		return new DemoServiceImpl(40);
	}
	
	@Bean
	public SimpleDateFormat sdfFecha() {
		return new SimpleDateFormat("dd/MM/yyyy");
	}
	
	@Bean
	public SimpleDateFormat sdfHora() {
		return new SimpleDateFormat("HH:mm");
	}
	
	@Bean(name = "complet")
	public SimpleDateFormat sdfCompleto() {
		return new SimpleDateFormat("dd/MM/yyyy hh:mm");
	}
}
