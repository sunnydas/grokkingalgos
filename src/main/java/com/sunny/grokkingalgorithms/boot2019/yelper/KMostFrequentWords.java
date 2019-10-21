package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.*;

class FrequencyHolder implements Comparable{

    public long frequency;


    public String word;

    public long getFrequency() {
        return frequency;
    }

    public void setFrequency(long frequency) {
        this.frequency = frequency;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public FrequencyHolder(long frequency, String word) {
        this.frequency = frequency;
        this.word = word;
    }

    @Override
    public String toString() {
        return "FrequencyHolder{" +
                "frequency=" + frequency +
                ", word='" + word + '\'' +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof FrequencyHolder){
            if(this.frequency > ((FrequencyHolder) o).frequency){
                return 1;
            }else if(this.frequency == ((FrequencyHolder) o).frequency){
                return ((FrequencyHolder) o).word.compareTo(this.word);
            }
        } else{
            throw new IllegalArgumentException("Invalid o " + o);
        }
        return -1;
    }
}
public class KMostFrequentWords {

    /*
    Given a non-empty list of words, return the k most frequent elements.

Your answer should be sorted by frequency from highest to lowest. If two words have the same frequency, then the word with the lower alphabetical order comes first.

Example 1:
Input: ["i", "love", "leetcode", "i", "love", "coding"], k = 2
Output: ["i", "love"]
Explanation: "i" and "love" are the two most frequent words.
    Note that "i" comes before "love" due to a lower alphabetical order.
Example 2:
Input: ["the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"], k = 4
Output: ["the", "is", "sunny", "day"]
Explanation: "the", "is", "sunny" and "day" are the four most frequent words,
    with the number of occurrence being 4, 3, 2 and 1 respectively.
     */

    public static List<String> topKFrequent(String[] words, int k) {
        List<String> frequentWords = new LinkedList<>();
        Map<String,Long> frequencyMap = new HashMap();
        for(int i = 0 ; i < words.length ;i++){
            if(frequencyMap.containsKey(words[i])){
                frequencyMap.put(words[i],frequencyMap.get(words[i]) + 1);
            } else{
                frequencyMap.put(words[i],1L);
            }
        }
        PriorityQueue<FrequencyHolder> priorityQueue = new PriorityQueue(Comparator.reverseOrder());
        Iterator<Map.Entry<String,Long>> entryIterator = frequencyMap.entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<String,Long> entry = entryIterator.next();
            priorityQueue.add(new FrequencyHolder(entry.getValue(),entry.getKey()));
        }
        //System.out.println(frequencyMap);
        //System.out.println(priorityQueue);
        int i = 0;
        while(!priorityQueue.isEmpty()&& i < k){
            frequentWords.add(priorityQueue.poll().getWord());
            i++;
        }
       return frequentWords;
    }

    public static void main(String[] args) {
        String[] words = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        System.out.println(topKFrequent(words,2));
    }
}
