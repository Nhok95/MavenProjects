package com.nhoksoft.infragest.services.impl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.nhoksoft.infragest.modelos.Multa;
import com.nhoksoft.infragest.services.MultaService;

@Service
public class MultaServiceImpl implements MultaService {

	private static final Map<Integer, Multa> MULTAS = new HashMap<Integer, Multa>();
	
	static {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		
		Date f1 = null;
		Date f2 = null;
		Date f3 = null;
		Date f4 = null;
		Date f5 = null;
		Date f6 = null;
		Date f7 = null;
		Date f8 = null;
		Date f9 = null;
		Date f10 = null;
		
		try {
			f1 = sdf.parse("02/10/2019 20:22:00");
			f2 = sdf.parse("15/10/2019 13:18:00");
			f3 = sdf.parse("26/07/2019 23:46:00");
			f4 = sdf.parse("14/08/2019 4:42:00");
			f5 = sdf.parse("15/02/2019 11:46:00");
			f6 = sdf.parse("10/04/2019 15:48:00");
			f7 = sdf.parse("10/10/2019 1:51:00");
			f8 = sdf.parse("08/12/2018 5:38:00");
			f9 = sdf.parse("27/06/2019 9:58:00");
			f10 = sdf.parse("07/04/2019 17:05:00");
		} catch(Exception e) {
			
		}
		
		MULTAS.put(1, new Multa(1, f1,
						"Nan Ketchen", "XW1",
						2500.00, "Conducir ebrio",
						33.82, 46.30));
		MULTAS.put(2, new Multa(2, f2,
						"Waldo Dawbery", "XW1",
						2500.00, "Saltarse un stop",
						61.75, 30.66));
		MULTAS.put(3, new Multa(3, f3,
						"Stevana Wingatt", "XW1",
						5000.00, "Conducir dormido",
						49.94, 14.03));
		MULTAS.put(4, new Multa(4, f4,
						"Jennie Astling", "XW1",
						5000.00, "Aparcar en la playa",
						37.95, 23.70));
		MULTAS.put(5, new Multa(5, f5,
						"Grange Lindeboom", "XW2",
						10000.00, "Pasar frente al hospital escuchando bad bunny",
						14.65, 121.04));
		MULTAS.put(6, new Multa(6, f6,
						"Terri Ingles","XW2",
						5000.00,"Marcarse un toreto",
						14.41, -88.95));
		
		MULTAS.put(7, new Multa(7, f7,
						"Vannie Jakobssen", "XW3",
						3355.54, "Jugar con un tirachinas",
						-2.68, 141.29));
		MULTAS.put(8, new Multa(8, f8,
						"Gaven McGraith", "XW4",
						426.15, "Tirar un platano por la ventana",
						37.89, 21.31));
		MULTAS.put(9, new Multa(9, f9,
						"Laural Hukin", "XW5",
						3162.54, "Llevar al perro en un carrito detras",
						35.35, 111.22));
		MULTAS.put(10, new Multa(10, f10,
						"Lucie Greir","XW6",
						903.57,"Vestirse mientras conduce",
						46.98, 128.03));
		
	}
	
	@Override
	public List<Multa> getAll() {
		return new ArrayList<>(MULTAS.values()); 
	}

	@Override
	public Multa crear(Multa multa) {
		
		int maxCode = 0;
		for (Integer key: MULTAS.keySet()) {
			
			int code = MULTAS.get(key).getCodigo();
			
			if (code > maxCode) {
				maxCode = code;
			}
			
		}
		
		multa.setCodigo(++maxCode);
		
		MULTAS.put(multa.getCodigo(),multa);
		
		return multa;
	}

	@Override
	public void remove(Integer codigo) {
		MULTAS.remove(codigo);

	}

	@Override
	public Multa getByCode(Integer codigo) {
		return MULTAS.get(codigo);
	}

	@Override
	public List<Multa> getByAgent(String nombreAgente) {
		return MULTAS.values().
				stream().
				filter(x -> x.getNombreAgente().equals(nombreAgente)).
				collect(Collectors.toList());
	}

	@Override
	public List<Multa> getByRangePrice(double min, double max) {
		return MULTAS.values().
				stream().
				filter(x -> x.getImporte() >= min).
				filter(x -> x.getImporte() <= max).
				collect(Collectors.toList());
	}

	@Override
	public List<String> getMatriculaMasMultado() {
		Map<String, Integer> contador = new HashMap<String, Integer>();
		
		for(Integer key: MULTAS.keySet()) {
			
			String matricula = MULTAS.get(key).getMatricula();
			
			if (contador.containsKey(matricula)) {
				
				contador.put(matricula, contador.get(matricula)+1);
			} else {
				
				contador.put(matricula, 1);
			}
		}
		
		Integer maxMulta = 0;
		List<String> matriculaResultado = new ArrayList<String>();
		for (String key: contador.keySet()) {
			
			Integer multa = contador.get(key);
			
			if (multa > maxMulta) {
				
				matriculaResultado.clear();
				maxMulta = multa;
				matriculaResultado.add(key);
				
			} else if (multa == maxMulta) {
				
				matriculaResultado.add(key);
			}
			
		}

		return matriculaResultado;
	}

	@Override
	public List<String> getMatriculaImporteMasAlto() {
		Map<String, Double> acumulacion = new HashMap<String, Double>();
		
		for(Integer key: MULTAS.keySet()) {
			
			Multa multa = MULTAS.get(key); 
			String matricula = multa.getMatricula();
			
			if (acumulacion.containsKey(matricula)) {
				
				acumulacion.put(matricula, 
						acumulacion.get(matricula)+multa.getImporte());
				
			} else {
				
				acumulacion.put(matricula, multa.getImporte());
			}
		}
		
		Double maxImporte = 0.0;
		List<String> matriculaResultado = new ArrayList<String>();
		for (String key: acumulacion.keySet()) {
			
			Double importe = acumulacion.get(key);
			
			if (importe > maxImporte) {
				matriculaResultado.clear();
				maxImporte = importe;
				matriculaResultado.add(key);
				
				
			} else if (importe.equals(maxImporte)) {
				
				matriculaResultado.add(key);
			}
			
		}
		
		return matriculaResultado;
	}

}
