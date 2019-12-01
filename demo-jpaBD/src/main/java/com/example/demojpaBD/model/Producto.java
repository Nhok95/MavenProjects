package com.example.demojpaBD.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="PRODUCTS")
public class Producto {
	
	@Id
	@Column(name= "CODIGO")
	private Long id;
	
	private String nombre;
	private double precio;
	
	@Column(name="FECHA_ALTA")
	@Temporal(TemporalType.DATE)
	private Date fechaDeAlta;
	
	private boolean descatalogado;
	private String familia;
	private String descripcion;
	
	public Producto() {}

	public Producto(Long id, String nombre, double precio, Date fechaDeAlta, boolean descatalogado,
			String familia, String descripcion) {
		this.id = id;
		this.nombre = nombre;
		this.precio = precio;
		this.fechaDeAlta = fechaDeAlta;
		this.descatalogado = descatalogado;
		this.familia = familia;
		this.descripcion = descripcion;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public Date getFechaDeAlta() {
		return fechaDeAlta;
	}

	public void setFechaDeAlta(Date fechaDeAlta) {
		this.fechaDeAlta = fechaDeAlta;
	}

	public boolean isDescatalogado() {
		return descatalogado;
	}

	public void setDescatalogado(boolean descatalogado) {
		this.descatalogado = descatalogado;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}
	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return "Producto [id=" + id + ", nombre=" + nombre + ", precio=" + precio + ", fechaDeAlta=" + fechaDeAlta
				+ ", descatalogado=" + descatalogado + ", familia=" + familia + ", descripcion=" + descripcion + "]";
	}
	
}
