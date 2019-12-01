package com.nhoksoft.infragest.modelos;

import java.util.Date;

public class Multa {
	
	private Integer codigo;
	private Date fecha;
	private String nombreAgente;
	private String matricula;
	private double importe;
	private String motivo;
	private double latitud;
	private double longitud;
	
	public Multa() {}
	
	public Multa(Integer codigo,Date fecha, String nombreAgente, String matricula,
				 double importe, String motivo, double latitud, double altitud) {
		
		this.codigo = codigo;
		this.fecha = fecha;
		this.nombreAgente = nombreAgente;
		this.matricula = matricula;
		this.importe = importe;
		this.motivo = motivo;
		this.latitud = latitud;
		this.longitud = altitud;
		
	}

	public Integer getCodigo() {
		return codigo;
	}
	
	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	
	public String getNombreAgente() {
		return nombreAgente;
	}
	
	public void setNombreAgente(String nombreAgente) {
		this.nombreAgente = nombreAgente;
	}
	
	public String getMatricula() {
		return matricula;
	}
	
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	
	public Double getImporte() {
		return importe;
	}
	
	public void setImporte(Double importe) {
		this.importe = importe;
	}
	
	public String getMotivo() {
		return motivo;
	}
	
	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public double getAltitud() {
		return longitud;
	}
	
	public void setAltitud(double altitud) {
		this.longitud = altitud;
	}
	
	public double getLatitud() {
		return latitud;
	}
	
	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}
	
	@Override
	public String toString() {
		return "Multa [codigo=" + codigo + ", fecha=" + fecha + ", nombreAgente=" + nombreAgente + ", matricula="
				+ matricula + ", importe=" + importe + ", motivo=" + motivo + ", latitud=" + latitud + ", altitud="
				+ longitud + "]";
	}
	
}
