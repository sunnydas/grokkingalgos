package com.sunny.grokkingalgorithms.boot2019.rktn;

import java.util.*;

class Val implements Comparable{

    public int getValue() {
        return value;
    }

    public int getIndex() {
        return index;
    }

    private int value;

    public Val(int value, int index) {
        this.value = value;
        this.index = index;
    }

    private int index;

    @Override
    public String toString() {
        return "Val{" +
                "value=" + value +
                ", index=" + index +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof Val){
            if(this.value > ((Val) o).value){
                return 1;
            } else if(this.value < ((Val) o).value){
                return -1;
            }
        } else {
            throw new IllegalArgumentException("Invalid val");
        }
        return 0;
    }
}
class Store{
    int count;
    int index;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Store(int count, int index) {
        this.count = count;
        this.index = index;
    }

    @Override
    public String toString() {
        return "Store{" +
                "count=" + count +
                ", index=" + index +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return count == store.count &&
                index == store.index;
    }

    @Override
    public int hashCode() {
        return Objects.hash(count, index);
    }
}
public class Identical {


    public static int solution(int[] input){
        int count = 0;
        Map<Integer,Store> tracker = new HashMap<>();
        for(int i = 0 ; i < input.length ; i++){
            if(tracker.containsKey(input[i])){
                Store store = tracker.get(input[i]);
                if(i > store.getIndex()){
                    store.setCount(store.getCount() + 1);
                }
            } else{
                Store store = new Store(1,i);
                tracker.put(input[i],store);
            }
        }
        Map.Entry<Integer,Store> entry = null;
        Iterator<Map.Entry<Integer,Store>> entryIterator = tracker.entrySet().iterator();
        //System.out.println(tracker);
        while(entryIterator.hasNext()){
            entry = entryIterator.next();
            if(count == 1000000000){
                return 1000000000;
            }
            if(entry.getValue().getCount() > 1){
                count += Math.pow(2,entry.getValue().getCount() - 1) - 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int[] input = new int[]{3,5,6,3,3,5};
        System.out.println(solution(input));
        input = new int[]{1,1,1,1,1};
        System.out.println(solution(input));
    }

}
