package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.*;

public class MigratoryBirds {

    /*
    https://www.hackerrank.com/challenges/migratory-birds/problem
    You have been asked to help study the population of birds migrating across the continent.
    Each type of bird you are interested in will be identified by an integer value.
    Each time a particular kind of bird is spotted, its id number will be added to
    your array of sightings. You would like to be able to find out which type of bird
    is most common given a list of sightings. Your task is to print the type number of
     that bird and if two or more types of birds are equally common, choose the type with t
     he smallest ID number.

For example, assume your bird sightings are of types .
There are two each of types  and , and one sighting of type .
Pick the lower of the two types seen twice: type .

     */

    public static int migratoryBirdsAlt(List<Integer> arr){
        int birdIndex = -1;
        int[] tracker = new int[6];
        for(int i : arr){
            tracker[i]++;
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < tracker.length ; i++){
            if(tracker[i] > max){
                max = tracker[i];
                birdIndex = i;
            }
        }
        return birdIndex;
    }

    // Complete the migratoryBirds function below.
    public static int migratoryBirds(List<Integer> arr) {
        Map<Integer,Integer> tracker = new TreeMap<>();
        int maxKey = -1;
        for(int i = 0 ; i < arr.size() ; i++){
            int key = arr.get(i);
            if(tracker.containsKey(key)){
                tracker.put(key,tracker.get(key) + 1);
            } else{
                tracker.put(key,1);
            }
        }
        int max = Integer.MIN_VALUE;
        Map.Entry<Integer,Integer> entry = null;
        Iterator<Map.Entry<Integer,Integer>> entryIterator = tracker.entrySet().iterator();
        while(entryIterator.hasNext()){
            entry = entryIterator.next();
            if(entry.getValue() > max){
                max = entry.getValue();
            }
        }
        //System.out.println(max);
        entryIterator = tracker.entrySet().iterator();
        while(entryIterator.hasNext()){
            entry = entryIterator.next();
            if(entry.getValue() == max){
                maxKey = entry.getKey();
                break;
            }
        }
        return maxKey;
    }

    public static void main(String[] args) {
        List<Integer> birds = new ArrayList<>();
        //1 2 3 4 5 4 3 2 1 3 4
        birds.add(1);
        birds.add(2);
        birds.add(3);
        birds.add(4);
        birds.add(5);
        birds.add(4);
        birds.add(3);
        birds.add(2);
        birds.add(1);
        birds.add(3);
        birds.add(4);
        System.out.println(migratoryBirds(birds));
        System.out.println(migratoryBirdsAlt(birds));
    }

}
