package com.nhoksoft.helloworld.backend.services.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.nhoksoft.helloworld.backend.services.WordGeneratorService;
import org.springframework.stereotype.Service;

@Service
public class WordGeneratorServiceImpl implements WordGeneratorService {

	private static final Map<Integer,List<String>> mapaDePalabras = new HashMap<>();
	
	public WordGeneratorServiceImpl() {
		mapaDePalabras.put(1, Arrays.asList("a", "b", "c", "d", "e"));
		mapaDePalabras.put(2, Arrays.asList("la", "es", "un", "de", "el"));
		mapaDePalabras.put(3, Arrays.asList("ala", "ven", "con", "del", "dia"));
		mapaDePalabras.put(4, Arrays.asList("pata", "pelo", "cosa", "dedo", "esto","caca"));
		mapaDePalabras.put(5, Arrays.asList("patas", "pelos", "cosas", "dedos", "estos"));
	}
	
	@Override
	public String getWord(int numberOfLetters) {
		List<String> lista = mapaDePalabras.get(numberOfLetters);
			
		return lista.get(new Random().nextInt(lista.size()));
	}

}
