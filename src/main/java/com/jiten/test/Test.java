package com.jiten.test;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jittu
 *
 */
public class Test {

	public static void main(String[] args) {
		
		Map<String,String> map = new HashMap<>();
		map.put("Jit", "Irving");
		map.put("Jiten", "75063");
		
		map.entrySet()
		.stream()
		.forEach(e -> System.out.println(e.getKey()+ " : "+ e.getValue()));
		
	}
	
	
	
	
}


