package com.nhoksoft.infragest.services;

import java.util.List;

import com.nhoksoft.infragest.modelos.Multa;

public interface MultaService {
	
	public List<Multa> getAll();
	
	public Multa crear(Multa multa);
	
	public void remove(Integer codigo);
	
	public Multa getByCode(Integer codigo);
	
	public List<Multa> getByAgent(String nombreAgente);
	
	public List<Multa> getByRangePrice(double min, double max);
	
	public List<String> getMatriculaMasMultado();
	
	public List<String> getMatriculaImporteMasAlto();

}
