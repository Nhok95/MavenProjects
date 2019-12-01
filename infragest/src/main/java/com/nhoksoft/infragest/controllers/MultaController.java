package com.nhoksoft.infragest.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nhoksoft.infragest.modelos.Multa;
import com.nhoksoft.infragest.services.MultaService;

@RestController
@RequestMapping("/api/multas")
public class MultaController {
	
	@Autowired
	private MultaService multaService;
	
	@GetMapping("")
	public List<Multa> getList(@RequestParam Map<String,String> parametros) {
		
		List<Multa> multas = new ArrayList<Multa>();
		
		if (parametros.containsKey("min") && parametros.containsKey("max")) {
			
			double minimo = Double.parseDouble(parametros.get("min"));
			double maximo = Double.parseDouble(parametros.get("max"));
			
			System.out.println("min: " + minimo +
					   "; max: " + maximo);
			
			multas = multaService.getByRangePrice(minimo, maximo);
		} else if (parametros.containsKey("nombreAgente")) {
			multas = multaService.getByAgent(parametros.get("nombreAgente"));
		} else {
			multas = multaService.getAll();
		}
		
		return multas;
	}
	
	// ********************************************************************
	
	@GetMapping("mas-multado")
	public List<String> getMatriculaMasMultado() {
		return multaService.getMatriculaMasMultado();
	}
	
	@GetMapping("importe-mas-alto")
	public List<String> getMatriculaImporteMasAlto() {
		return multaService.getMatriculaImporteMasAlto();
	}
	
	@PostMapping("")
	public Multa crear(@RequestBody Multa multa) {
		return multaService.crear(multa);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(value = HttpStatus.OK)
	public void remove(@PathVariable(value= "codigo") Integer codigo) {
		multaService.remove(codigo);
	}

	@GetMapping("/{codigo}")
	public Multa getByCode(@PathVariable(value= "codigo") Integer codigo) {
		return multaService.getByCode(codigo);
	}

}
