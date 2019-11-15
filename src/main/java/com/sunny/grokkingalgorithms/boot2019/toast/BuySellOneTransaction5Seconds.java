package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.ArrayList;
import java.util.List;

public class BuySellOneTransaction5Seconds {

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
        System.out.println(maxProfit(prices));
    }


}
