package com.nhoksoft.helloworld.backend.controllers;

import com.nhoksoft.helloworld.backend.services.WordGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WordGeneratorController {
	
	@Autowired
	@Qualifier("wordGeneratorServiceImpl")
	private WordGeneratorService wordGeneratorService;
	
	@GetMapping("/word")
	public String darWord(@RequestParam("length") int numberOfLetters) {
		System.out.println(numberOfLetters);
		return wordGeneratorService.getWord(numberOfLetters);
	}
	
	

}
