package com.nhoksoft.helloworld.backend.services.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.nhoksoft.helloworld.backend.services.GroupsGeneratorService;

@Service
public class GroupsGeneratorServiceImpl implements GroupsGeneratorService{
	
	@Override
	public Map<String, List<String>> generate(int groupSize, String groupName, String... members) {
		
		if(groupName == null) {
			throw new IllegalArgumentException("groupName is null!");
		}
		
		if(groupSize <= 0) {
			throw new IllegalArgumentException("groupSize is zero or negative!");
		}
		
		if(members.length == 0) {
			throw new IllegalArgumentException("No members specified");
		} 
		
		if(groupSize > members.length) {
			throw new IllegalArgumentException("Groups size is larger than number of members!");
		}
		
		int groupsNumber = members.length / groupSize;
		
		List<Integer> groupsId = new ArrayList<>();
		
		for (int i = 0; i < members.length; i++) {
			groupsId.add(i % groupsNumber);
		}
		
		Collections.shuffle(groupsId);
		
		Map<String, List<String>> groupsMaps = new HashMap<>();
		
		for (int i = 0; i < groupsNumber; i++) {
			groupsMaps.put(groupName + "_" + i, new ArrayList<String>());
		}
		
		for (int j = 0; j < members.length; j++) {
			String index = groupName + "_" + groupsId.get(j);
			if (members[j] == null) {
				throw new IllegalArgumentException("null value detected in members!");
			}
			groupsMaps.get(index).add(members[j]);
			
		}
		
		return groupsMaps;
	}
}
