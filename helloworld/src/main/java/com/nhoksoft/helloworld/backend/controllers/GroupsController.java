package com.nhoksoft.helloworld.backend.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nhoksoft.helloworld.backend.services.GroupsGeneratorService;

@RestController
public class GroupsController {
	
	// Forma de realizar la petición desde Chrome:
	
	// localhost:8080/groups?size=3&name=GRUPO&members=01,02,03,04,05,06,07,08,09,10,11,12,13
	// 10.250.5.29:8080/groups?size=3&name=GRUPO&members=01,02,03,04,05,06,07,08,09,10,11,12,13
	@Autowired
	private GroupsGeneratorService groupsGeneratorService;
	
	@GetMapping("/groups")
	public Map<String,List<String>> getGroups(@RequestParam("size") int groupSize,
												@RequestParam("name") String groupName,
												@RequestParam("members") List<String> members) {
		
		System.out.println("groupSize: " + groupSize);
		System.out.println("name: " + groupName);
		System.out.println("members: " + members);
		
		String[] membersArray = new String[members.size()];
		
		Map<String,List<String>> grupos = null;
		try {
			grupos = groupsGeneratorService.
						generate(groupSize, 
					   			 groupName, 
					   			 members.toArray(membersArray));
		} catch (Exception e) {
			System.out.println(e.getClass().getSimpleName() + ": " + e.getMessage());
		}
		
		return grupos;
	}
}
