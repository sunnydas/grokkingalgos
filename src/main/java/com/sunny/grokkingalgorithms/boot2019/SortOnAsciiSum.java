package com.sunny.grokkingalgorithms.boot2019;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SortOnAsciiSum {


    public static void printSortedOnAsciiSum(List<String> lines){
        if(lines != null){
            long[] asciiScores = new long[lines.size()];
            for(int i = 0 ; i < lines.size() ; i++){
                long asciiCount = 0;
                String line = lines.get(i);
                for(int j = 0 ; j < line.length() ; j++){
                    asciiCount += (int) line.charAt(j);
                }
                asciiScores[i] = asciiCount;
                //System.out.println(line);
                //System.out.println(asciiCount);
            }
            Arrays.sort(asciiScores);
            for(int i = 0 ; i < asciiScores.length ; i++){
                System.out.println(asciiScores[i]);
            }
        }
    }

    public static List<String> parseLines(String fileName) throws IOException {
        List<String> lines = new ArrayList<>();
        if(fileName != null){
            File file = new File(fileName);
            if(file.exists()){
                FileReader fileReader = null;
                BufferedReader bufferedReader = null;
                try{
                    fileReader = new FileReader(file);
                    bufferedReader = new BufferedReader(fileReader);
                    String line = null;
                    while((line = bufferedReader.readLine()) != null){
                        lines.add(line);
                    }
                } finally {
                    closeSilently(fileReader, bufferedReader);
                }
            }
        }
        return lines;
    }

    private static void closeSilently(FileReader fileReader, BufferedReader bufferedReader) {
        if(fileReader != null){
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if(bufferedReader != null){
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        String file = "notes_for_use";
        List<String> lines = parseLines(file);
        printSortedOnAsciiSum(lines);
    }

}
