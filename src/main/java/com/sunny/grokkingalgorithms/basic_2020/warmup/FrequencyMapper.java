package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class FrequencyMapper {
	
	
	private static Map<String,Integer> readFile(String fileName) throws IOException {
		File file = new File(fileName);
		FileReader fileReader = new FileReader(file);
		BufferedReader bufferedReader = new BufferedReader(fileReader);
		String line = null;
		Map<String,Integer> tracker = new HashMap();
		while((line = bufferedReader.readLine()) 
				!= null) {
			String[] splitted = line.split("\\s+");
			for(String s: splitted) {
				if(tracker.containsKey(s)) {
					tracker.put(s,tracker.get(s)+1);					
				}else {
					tracker.put(s, 1);
				}
			}
		}
		return tracker;
	}
	
	public static void print(Map<String,Integer> tracker) {
		Iterator<Map.Entry<String, Integer>> iterator = tracker.entrySet().iterator();
		while(iterator.hasNext()) {
			Map.Entry<String, Integer> entry = iterator.next();
			for(int i = 1; i <= entry.getValue() ; i++) {
				System.out.print("= ");				
			}
			System.out.print(entry.getKey());
			System.out.println();
		}
	}
	
	public static void plot(String fileName) {
		try {
			print(readFile(fileName));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		plot("my_dump");
	}

}
