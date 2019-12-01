package com.nhoksoft.facturagest.model;

public class FacturaProducto {
	
	private Producto producto;
	private int cantidad;
	private double precio;
	
	public FacturaProducto() {}
	
	public FacturaProducto(Producto producto, int cantidad, double precio) {
		super();
		this.producto = producto;
		this.cantidad = cantidad;
		this.precio = precio;
	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getTotal() {
		return precio*cantidad;
	}

	@Override
	public String toString() {
		return "FacturaProducto [producto=" + producto + ", cantidad=" + cantidad + ", precio=" + precio + "]";
	}
	

}
