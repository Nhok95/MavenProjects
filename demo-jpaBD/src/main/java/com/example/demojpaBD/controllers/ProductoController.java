package com.example.demojpaBD.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demojpaBD.model.Producto;
import com.example.demojpaBD.repositories.ProductoRepository;

@RestController
public class ProductoController {
	
	// aqui tendremos que inyectar algo...
	@Autowired
	private ProductoRepository productoRepository;
	
	@GetMapping("/productos")
	public List<Producto> getAll() {
		return productoRepository.findAll();
	}
}
