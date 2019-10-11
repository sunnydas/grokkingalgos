package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.*;

class AnagramString implements Comparable{

    private String anagram;

    public String getAnagram() {
        return anagram;
    }

    @Override
    public String toString() {
        return "AnagramString{" +
                "anagram='" + anagram + '\'' +
                ", index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AnagramString that = (AnagramString) o;
        return index == that.index &&
                Objects.equals(anagram, that.anagram);
    }

    @Override
    public int hashCode() {
        return Objects.hash(anagram, index);
    }

    public void setAnagram(String anagram) {
        this.anagram = anagram;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    private int index;

    @Override
    public int compareTo(Object o) {
        if(o instanceof AnagramString){
            return this.anagram.compareTo(((AnagramString) o).anagram);
        }else{
            throw new IllegalArgumentException("invalid input = " + o);
        }
    }
}
public class AnagramGrouping {



    public static void groupAnagramsTogether(String[] input){
        AnagramString[] anagramStrings = new AnagramString[input.length];
        for(int i = 0 ; i < input.length ; i++){
            char[] cVer = input[i].toCharArray();
            Arrays.sort(cVer);
            anagramStrings[i] = new AnagramString();
            anagramStrings[i].setAnagram(String.valueOf(cVer));
            anagramStrings[i].setIndex(i);
        }
        Arrays.sort(anagramStrings);
        System.out.println(Arrays.asList(anagramStrings));
        for(int i = 0 ; i < anagramStrings.length ; i++){
            System.out.print(input[anagramStrings[i].getIndex()] + " ");
        }
        System.out.println();
    }

    public static void groupAnagramsTogetherUsingHash(String[] input){
        Map<Long, List<String>> hashedStrings = new HashMap<>();
        for(String s : input){
            long hash = calculateHash(s);
            if(hashedStrings.containsKey(hash)){
                hashedStrings.get(hash).add(s);
            }
            else{
                List<String> anagrams = new ArrayList<>();
                anagrams.add(s);
                hashedStrings.put(hash,anagrams);
            }
        }
        System.out.println(hashedStrings);
        Iterator<Map.Entry<Long,List<String>>> entryIterator = hashedStrings.entrySet().iterator();
        while(entryIterator.hasNext()){
            Map.Entry<Long,List<String>> entry = entryIterator.next();
            System.out.print(entry.getValue());
        }
        System.out.println();
    }

    public static long calculateHash(String s){
        long hash = 0L;
        for(int i = 0 ; i < s.length() ; i++){
            hash += s.charAt(i)%s.length();
        }
        return hash;
    }

    public static String[] groupAnagramsTogetherWithoutSort(String[] input){
        for(int i = 0 ; i < input.length; i++){
            int k = i + 1;
            for(int j = k ; j < input.length;j++){
                if(areEssentiallyAnagrams(input[i],input[j])){
                    String temp = input[k];
                    input[k] = input[j];
                    input[j] = temp;
                    k++;
                }
            }
        }
        return input;
    }

    public static boolean areEssentiallyAnagrams(String s1,String s2){
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();
        boolean areAnagrams = true;
        if(s1c.length == s2c.length){
            Set<Character> s1Set = new HashSet<>();
            for(char c : s1c){
                s1Set.add(c);
            }
            for(char c : s2c){
                if(!s1Set.contains(c)){
                    areAnagrams = false;
                    break;
                }
            }
        } else{
            areAnagrams = false;
        }
        return  areAnagrams;
    }

    public static String[] groupAnagramsUsingSort(String[] input){
        for(int i = 0 ; i < input.length; i++){
            int k = i + 1;
            for(int j = k ; j < input.length;j++){
                if(areSortedEqual(input[i],input[j])){
                    String temp = input[k];
                    input[k] = input[j];
                    input[j] = temp;
                    k++;
                }
            }
        }
        return input;
    }

    public static boolean areSortedEqual(String s1,String s2){
        char[] s1c = s1.toCharArray();
        char[] s2c = s2.toCharArray();
        Arrays.sort(s1c);
        Arrays.sort(s2c);
        return  Arrays.equals(s1c,s2c);
    }

    public static void main(String[] args) {
        String[] animals = new String[]{"cat", "dog", "tac", "god", "act","doggo","ooggd","santorio","ogd"};
        System.out.println(Arrays.asList(groupAnagramsUsingSort(animals)));
        animals = new String[]{"cat", "dog", "tac", "god", "act","doggo","ooggd","santorio","ogd"};
        System.out.println(Arrays.asList(groupAnagramsTogetherWithoutSort(animals)));
        animals = new String[]{"cat", "dog", "tac", "god", "act","doggo","ooggd","santorio","ogd"};
        groupAnagramsTogetherUsingHash(animals);
        animals = new String[]{"cat", "dog", "tac", "god", "act","doggo","ooggd","santorio","ogd"};
        groupAnagramsTogether(animals);
    }

}
