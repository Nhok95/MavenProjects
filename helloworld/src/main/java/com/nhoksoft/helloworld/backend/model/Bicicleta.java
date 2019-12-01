package com.nhoksoft.helloworld.backend.model;

public class Bicicleta {
	
	private Integer codigo; 
	private String modelo;
	
	private Double precio;
	private  Boolean electrica;
	
	public Bicicleta() {}

	public Bicicleta(Integer codigo, String modelo, double precio, boolean electrica) {
		this.codigo = codigo;
		this.modelo = modelo;
		this.precio = precio;
		this.electrica = electrica;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isElectrica() {
		return electrica;
	}

	public void setElectrica(boolean electrica) {
		this.electrica = electrica;
	}

	@Override
	public String toString() {
		return "Bicicleta [codigo=" + codigo + ", modelo=" + modelo + ", precio=" + precio + ", electrica=" + electrica
				+ "]";
	}
	
}
