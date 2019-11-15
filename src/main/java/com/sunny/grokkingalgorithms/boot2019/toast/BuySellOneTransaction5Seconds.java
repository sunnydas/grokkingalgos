package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.ArrayList;
import java.util.List;

public class BuySellOneTransaction5Seconds {

    public static long maxProfitAlt(List<Long> prices){
       long maxProfit = 0;
       long min = prices.get(0);
       int i = 0;
       int j = i+5;
       while(j < prices.size()){
           long cur = prices.get(i);
           if(cur < min){
               min = cur;
           }
           long diff = prices.get(j) - min;
           if(diff > 0){
               maxProfit = Math.max(maxProfit,diff);
           }
           i++;
           j++;
       }
       return maxProfit;
    }

    public static long  maxProfit(List<Long> prices){
        long maxProfit = 0;
        for(int i = 0 ; i < prices.size() ; i++){
            for(int j = i+5; j < prices.size() ; j++){
                long diff = prices.get(j) - prices.get(i);
                maxProfit = Math.max(diff,maxProfit);
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        List<Long> prices = new ArrayList<>();
        prices.add(1L);
        prices.add(0L);
        prices.add(3L);
        prices.add(4L);
        prices.add(5L);
        prices.add(6L);
        prices.add(7L);
        System.out.println(maxProfit(prices));
        System.out.println(maxProfitAlt(prices));
    }


}
