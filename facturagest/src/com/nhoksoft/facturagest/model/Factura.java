package com.nhoksoft.facturagest.model;

import java.util.Date;
import java.util.List;

public class Factura {
	
	private int codigo;
	private Date fecha;
	private Cliente cliente;
	private List<FacturaProducto> facturaLinia;

	public Factura() {}
	
	public Factura(int codigo, Date fecha, Cliente cliente, List<FacturaProducto> facturaLinia) {
		this.codigo = codigo;
		this.fecha = fecha;
		this.cliente = cliente;
		this.facturaLinia = facturaLinia;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<FacturaProducto> getFacturaLinia() {
		return facturaLinia;
	}

	public void setFacturaLinia(List<FacturaProducto> facturaLinia) {
		this.facturaLinia = facturaLinia;
	}
	
	public double getSubtotal() {
		
		double precio = 0.0;
		for (FacturaProducto linia: facturaLinia) {
			precio += linia.getTotal(); 
		}
		
		return precio; 
	}
	
	public double getIVA() {
		return getSubtotal() *0.21;
	}
	
	public double getTotal() {
		
		double precio = 0.0;
		for (FacturaProducto linia: facturaLinia) {
			precio += linia.getTotal(); 
		}
		
		return precio*1.21;
	}

	@Override
	public String toString() {
		return "Factura [codigo=" + codigo + ", fecha=" + fecha + ", cliente=" + cliente + ", facturaLinia="
				+ facturaLinia + "]";
	}
	
	

}
