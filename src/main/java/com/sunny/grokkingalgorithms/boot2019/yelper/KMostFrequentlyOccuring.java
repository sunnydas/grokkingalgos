package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.io.*;
import java.util.*;

class FrequencyBox implements Comparable{
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FrequencyBox that = (FrequencyBox) o;
        return Objects.equals(word, that.word) &&
                Objects.equals(frequency, that.frequency);
    }

    @Override
    public String toString() {
        return "FrequencyBox{" +
                "word='" + word + '\'' +
                ", frequency=" + frequency +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(word, frequency);
    }

    private String word;
    private Long frequency;

    public FrequencyBox(String word, Long frequency) {
        this.word = word;
        this.frequency = frequency;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof  FrequencyBox){
            if(this.frequency > ((FrequencyBox) o).frequency){
                return 1;
            } else if(this.frequency < ((FrequencyBox) o).frequency){
                return -1;
            }
        } else{
            throw new IllegalArgumentException("Invalid object " + o);
        }
        return 0;
    }
}
public class KMostFrequentlyOccuring {

    /*
    Given a log file of n lines, find k most frequently occuring words
     */

    public static void printKMostFrequentLines(String fileName,int k) throws IOException {
        Map<String,Long> frequencyMap = new HashMap<>();
        File file = new File("log.txt");
        FileReader fileReader = new FileReader(file);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while((line = bufferedReader.readLine()) != null){
            String[] splitted = line.split("\\s+");
            for(String word : splitted){
                if(frequencyMap.containsKey(word)){
                    frequencyMap.put(word,frequencyMap.get(word) + 1);
                } else{
                    frequencyMap.put(word,1L);
                }
            }
        }
        System.out.println(frequencyMap);
        PriorityQueue<FrequencyBox> frequencyBoxes = new PriorityQueue<>(Collections.reverseOrder());
        Iterator<Map.Entry<String,Long>> entryIterator = frequencyMap.entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String,Long> entry = entryIterator.next();
            frequencyBoxes.add(new FrequencyBox(entry.getKey(),entry.getValue()));
        }
        for(int i = 0 ; i < k && !frequencyBoxes.isEmpty();i++){
            System.out.println("rank = " + i);
            System.out.println(frequencyBoxes.poll());
        }
    }

    public static void main(String[] args) throws IOException {
        printKMostFrequentLines("log.tx".toString(),10);
    }
}
