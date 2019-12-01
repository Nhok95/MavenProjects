package com.nhoksoft.helloworld.backend.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.nhoksoft.helloworld.backend.model.Bicicleta;

@RestController
@RequestMapping("/api")
public class BicicletaController {
	
	//@Autowired
	//private BicicletaService bicicletaService;
	
	// Obtener listado
	
	@GetMapping("/bicicletasXXXXX")
	public List<Bicicleta> getAll() {
		
		List<Bicicleta> bicicletas = 
				
				Arrays.asList(new Bicicleta(100,"Model A",100,true),
							 new Bicicleta(101,"Model B",70,true),
							 new Bicicleta(102,"Model C",15.6,false));
 		return bicicletas;
	}
	
	// Obtener una bicicleta a partir de su codigo
	@GetMapping("/bicicletas/{id}")
	public Bicicleta getById(@PathVariable(value = "id") Integer codigo) {
		
		return new Bicicleta(codigo,"Model CREDO",100,false);
	}
	
	// Vamos a crear una bicicleta en el sistema
	@PostMapping("/bicicletas")
	public Bicicleta create(@RequestBody Bicicleta bicicleta) {
		
		System.out.println("Creado: " + bicicleta);
		
		return bicicleta;
	}
	
	@DeleteMapping("/bicicletas/{codigo}")
	@ResponseStatus(value = HttpStatus.OK)
	public void delete(@PathVariable(value = "codigo") Integer codigo) {
		System.out.println("Bicicleta " + codigo + " eliminada");
	}
	
	
	@PutMapping("/bicicletas")
	public Bicicleta update(@RequestBody Bicicleta bicicleta) {
		System.out.println("Bicicleta actualziada");
		return bicicleta;
	}
	
	// Cuando necesitamos filtrar los datos
	// En este caso se suelen utilizar parámetros del request
	
	// Obtención de bicicletas entre un precio min y un max
	
	@GetMapping("/bicicletas")
	public List<Bicicleta> getFiltered(@RequestParam(value = "minimo", required = false) Double min,
									   @RequestParam(value = "maximo", required = false) Double max) {
		
		if (min == null && max == null) {
			System.out.println("Todas las bicis");
		} else {
			System.out.println("Bicicletas entre " + min + " y " + max);
		}
		
		
		return null;
	}
}