package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.*;

class TInterval implements Comparable{
    public int startTime;
    public int endTime;

    public int getStartTime() {
        return startTime;
    }

    @Override
    public String toString() {
        return "TInterval{" +
                "startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TInterval tInterval = (TInterval) o;
        return startTime == tInterval.startTime &&
                endTime == tInterval.endTime;
    }

    @Override
    public int hashCode() {
        return Objects.hash(startTime, endTime);
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public TInterval(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    @Override
    public int compareTo(Object o) {
        if(o instanceof TInterval){
            if(this.startTime > ((TInterval) o).startTime){
                return 1;
            }
            else if(this.startTime < ((TInterval) o).startTime){
                return -1;
            }
        }else{
            throw new IllegalArgumentException("Invalid " + o);
        }
        return 0;
    }
}
public class MergeAdjacentDays {

    /*
    There is a HashMap contains 7 Keys, which is Monday through Sunday.
    Each key is corresponding to a List of (Start time, end time) pairs.
    The pairs is unsorted. What I have to do is to merge the time slots that are adjacent.
     And finally return another
     HashMap that contains the same structure but with merged time slots.
     */

    /*
    Given a set of time intervals in any order, merge all overlapping intervals into
    one and output the result which should have only mutually exclusive intervals.
    Let the intervals be represented as pairs of integers for simplicity.
For example, let the given set of intervals be {{1,3}, {2,4}, {5,7}, {6,8} }.
 The intervals {1,3} and {2,4} overlap with each other,
 so they should be merged and become {1, 4}.
 Similarly {5, 7} and {6, 8} should be merged and become {5, 8}
     */

    public static List<TInterval> mergeIntervals(List<TInterval> tIntervals){
        Collections.sort(tIntervals);
        int curStart = tIntervals.get(0).startTime;
        int curEnd = tIntervals.get(1).endTime;
        List<TInterval> merged = new ArrayList<>();
        for(int i = 0;i < tIntervals.size() ; i++){
            TInterval tInterval = tIntervals.get(i);
            if(tInterval.startTime >= curStart
                    && tInterval.startTime <= curEnd){
                curEnd = Math.max(tInterval.endTime,curEnd);
                if(i == tIntervals.size() - 1){
                    merged.add(new TInterval(curStart,curEnd));
                }
            } else{
                // end of merging
                merged.add(new TInterval(curStart,curEnd));
                curStart = tInterval.getStartTime();
                curEnd = tInterval.getEndTime();
                if(i == tIntervals.size() - 1){
                    merged.add(new TInterval(curStart,curEnd));
                }
            }
        }
        return merged;
    }

    public static List<TInterval> mergeAdjacentTimesUsingStack(List<TInterval> intervals){
        Stack<TInterval> stack = new Stack<>();
        Collections.sort(intervals);
        for(TInterval tInterval : intervals){
            if(!stack.isEmpty() && tInterval.startTime >= stack.peek().startTime &&
            tInterval.startTime <= stack.peek().endTime){
                stack.peek().setEndTime(tInterval.endTime);
            } else{
                stack.push(tInterval);
            }
        }
        return stack;
    }

    public static void main(String[] args) {
        List<TInterval> tIntervals = new ArrayList<>();
        TInterval ti1 = new TInterval(1,3);
        TInterval ti2 = new TInterval(2,4);
        TInterval ti3 = new TInterval(5,7);
        TInterval ti4 = new TInterval(6,8);
        TInterval ti5 = new TInterval(9,10);
        TInterval ti6 = new TInterval(6,9);
        TInterval ti7 = new TInterval(11,12);
        tIntervals.add(ti1);
        tIntervals.add(ti2);
        tIntervals.add(ti3);
        tIntervals.add(ti4);
        tIntervals.add(ti5);
        tIntervals.add(ti6);
        tIntervals.add(ti7);
        System.out.println(tIntervals);
        System.out.println(mergeIntervals(tIntervals));
        tIntervals = new ArrayList<>();
        tIntervals.add(ti1);
        tIntervals.add(ti2);
        tIntervals.add(ti3);
        tIntervals.add(ti4);
        tIntervals.add(ti5);
        tIntervals.add(ti6);
        tIntervals.add(ti7);
        System.out.println(mergeAdjacentTimesUsingStack(tIntervals));
    }


}
