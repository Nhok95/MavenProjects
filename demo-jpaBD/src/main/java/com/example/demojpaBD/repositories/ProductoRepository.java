package com.example.demojpaBD.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demojpaBD.model.Producto;

@Repository
public interface ProductoRepository extends JpaRepository<Producto, Long>{
	

}