package com.nhoksoft.carinsurance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VEHICULOS")
public class Vehicle implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	private String marca;
	private String modelo;
	private double coeff;
	
	public Vehicle() {}

	public Vehicle(Long codigo, String marca, String modelo, double precio) {
		super();
		this.codigo = codigo;
		this.marca = marca;
		this.modelo = modelo;
		this.coeff = precio;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return coeff;
	}

	public void setPrecio(double precio) {
		this.coeff = precio;
	}

	@Override
	public String toString() {
		return "Vehicle [codigo=" + codigo + ", marca=" + marca + ", modelo=" + modelo + ", precio=" + coeff + "]";
	}

	
	
	
}
