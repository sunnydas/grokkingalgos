package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class FirstNonRepeatedCharacter {
	
	public static Character 
	  findFirstNonRepeated(String input) {
		Character firstNonRepeated=null;
		if(input != null) {
			Map<Character,Integer> trackingMap = new LinkedHashMap<Character,
					Integer>();
			for(int i = 0 ; i < input.length() ; i++) {
				char current =  input.charAt(i);
				if(trackingMap.containsKey(current)) {
					int count = trackingMap.get(current);
					trackingMap.put(current,++count);
				}else {
					trackingMap.put(current,1);
				}
			}
			Iterator<Map.Entry<Character, Integer>> iterator =
					  trackingMap.entrySet().iterator();
			while(iterator.hasNext()) {
				Map.Entry<Character, Integer> entry =
						iterator.next();
				if(entry.getValue() == 1) {
					firstNonRepeated = entry.getKey();
					break;
				}
			}
		}
		return firstNonRepeated;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(findFirstNonRepeated("ABAAAABCDEFAA"));
	}

}
