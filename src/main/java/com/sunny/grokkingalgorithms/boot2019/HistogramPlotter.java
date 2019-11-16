package com.sunny.grokkingalgorithms.boot2019;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class HistogramPlotter {


    public static void plotHistogram(List<String> lines){
        Map<Character,Long> frequencyTracker = new HashMap<>();
        for(String line : lines){
            for(int i = 0 ; i < line.length() ; i++){
                char current = line.charAt(i);
                if(frequencyTracker.containsKey(current)){
                    frequencyTracker.put(current,frequencyTracker.get(current) + 1);
                } else{
                    frequencyTracker.put(current,1L);
                }
            }
        }
        Iterator<Map.Entry<Character,Long>> entryIterator = frequencyTracker.entrySet().iterator();
        Map.Entry<Character,Long> characterLongEntry = null;
        while(entryIterator.hasNext()){
            characterLongEntry = entryIterator.next();
            long count = characterLongEntry.getValue();
            System.out.print(characterLongEntry.getKey());
            for(int i = 0 ; i < count ; i++){
                System.out.print("-");
            }
            System.out.print(count);
            System.out.println();
        }
    }

    public static void main(String[] args) throws IOException {
        List<String> lines = SortOnAsciiSum.parseLines("notes_for_use");
        plotHistogram(lines);
    }

}
