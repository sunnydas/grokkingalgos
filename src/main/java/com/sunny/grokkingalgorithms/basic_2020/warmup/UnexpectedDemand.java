package com.sunny.grokkingalgorithms.basic_2020.warmup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class UnexpectedDemand {
	
	 /*
     * Complete the 'filledOrders' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY order
     *  2. INTEGER k
     */

    public static int filledOrders(List<Integer> order, int k) {
    // Write your code here
    	int filledOrders = 0;
    	Collections.sort(order);
    	//System.out.println(order);
    	for(int orderItem : order) {
    		if(k >= orderItem) {
	    		k = k -  orderItem;
	    		if(k >= 0) {
	    			filledOrders++;    			
	    		}else {
	    			break;
	    		}
    		}
    	}
    	return filledOrders;

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> order = new ArrayList<Integer>();
		order.add(10);
		order.add(30);
		System.out.println(filledOrders(order, 40));
	}

}
