package com.nhoksoft.helloworld.backend.services;

import java.util.List;
import java.util.Map;

public interface GroupsGeneratorService {
	
	public Map<String,List<String>> generate(int groupSize, String groupName, String... members);
}
