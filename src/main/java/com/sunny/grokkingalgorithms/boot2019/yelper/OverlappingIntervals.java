package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.Arrays;

class Interval implements Comparable{
    public int startTime;
    public int endTime;

    @Override
    public String toString() {
        return "Interval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof  Interval){
            if(this.startTime < ((Interval) o).startTime){
                return -1;
            }
            if(this.startTime > ((Interval) o).startTime){
                return 1;
            }
        } else{
            throw new IllegalArgumentException("Invalid object = " + o);
        }
        return 0;
    }
}
public class OverlappingIntervals {

   public static int hasOverlappingIntervals(int[][] input){
       int hasOverlappingIntervals = 0;
       Interval[] intervals = new Interval[input.length];
       populateIntervals(input,intervals);
       Arrays.sort(intervals);
       System.out.println(Arrays.asList(intervals));
       for(int i = 1 ; i < intervals.length ; i++){
           if((intervals[i].startTime >= intervals[i  - 1].startTime
                   && intervals[i].startTime <= intervals[i - 1].endTime)){
               System.out.println(intervals[i]);
               hasOverlappingIntervals++;
           }
       }
       return hasOverlappingIntervals;
   }

   public static void populateIntervals(int[][] input,Interval[] intervals){
       for(int i = 0 ; i < input.length ; i++){
           Interval interval = new Interval();
           interval.startTime = input[i][0];
           interval.endTime = input[i][1];
           intervals[i] = interval;
       }
   }

    public static void main(String[] args) {
       int[][] input = new int[][]{{1, 3},
               {5, 7},
               {2, 4},
               {6, 8}};
        System.out.println(hasOverlappingIntervals(input));
        input = new int[][]{{1, 3},
                {7, 9},
                {4, 6},
                {10, 13}};
        System.out.println(hasOverlappingIntervals(input));
    }
}
