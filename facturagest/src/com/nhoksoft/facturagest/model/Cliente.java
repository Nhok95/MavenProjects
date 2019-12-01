package com.nhoksoft.facturagest.model;


public class Cliente {
	
	private String codigo;
	private String nombre;
	private String direccion;
	private String codigoPostal;
	private String ciudad;
	private String pais;
	
	public Cliente() {}
	
	public Cliente(String codigo, String nombre, String direccion,
			String codigoPostal, String ciudad, String pais) {
		this.codigo = codigo;
		this.nombre = nombre;
		this.direccion = direccion;
		this.codigoPostal = codigoPostal;
		this.ciudad = ciudad;
		this.pais = pais;
	}

	public String getCodigo() {
		return codigo;
	}
	
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	public String getCodigoPostal() {
		return codigoPostal;
	}
	
	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}
	
	public String getCiudad() {
		return ciudad;
	}
	
	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}
	
	public String getPais() {
		return pais;
	}
	
	public void setPais(String pais) {
		this.pais = pais;
	}
	
	@Override
	public String toString() {
		return "Cliente [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", codigoPostal="
				+ codigoPostal + ", ciudad=" + ciudad + ", pais=" + pais + "]";
	}
	
	

}
