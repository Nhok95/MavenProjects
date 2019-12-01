package com.nhoksoft.carinsurance.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="COLORES")
public class Color implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	private Long codigo;
	
	private String nombre;
	private double coeff;
	
	public Color() {}

	public Color(Long codigo, String nombre, double coeff) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.coeff = coeff;
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getCoeff() {
		return coeff;
	}

	public void setCoeff(double coeff) {
		this.coeff = coeff;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Color [codigo=" + codigo + ", nombre=" + nombre + ", coeff=" + coeff + "]";
	}

}
