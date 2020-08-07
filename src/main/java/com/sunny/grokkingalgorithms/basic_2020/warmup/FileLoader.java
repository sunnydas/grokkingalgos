package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileLoader {
	
	
	public static List<Integer> parse(String fileName){
		List<Integer> parsed = new ArrayList<Integer>();
		File file = new File(fileName);
		FileReader fileReader = null;
        BufferedReader bufferedReader = null;
        try {
        	fileReader = new FileReader(file);
        	bufferedReader = new BufferedReader(fileReader);
        	String line = null;
        	while((line = bufferedReader.readLine())
        			!= null) {
        		parsed.add(Integer.parseInt(line));        		        		        		
        	}
        }catch(Exception e) {
        	e.printStackTrace();        	
        }finally {
        	if(bufferedReader != null) {
        		try {
					bufferedReader.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}        		
        	}
        }
        return parsed;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
