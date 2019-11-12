package com.sunny.grokkingalgorithms.boot2019.toast;

import java.util.Arrays;

public class ElectronicsShop {

    /*
    Monica wants to buy a keyboard and a USB drive from her favorite electronics store. The store has several models of each. Monica wants to spend as much as possible for the  items, given her budget.

Given the price lists for the store's keyboards and USB drives, and Monica's budget, find and print the amount of money Monica will spend. If she doesn't have enough money to both a keyboard and a USB drive, print -1 instead. She will buy only the two required items.

For example, suppose she has  to spend. Three types of keyboards cost . Two USB drives cost . She could purchase a , or a . She chooses the latter. She can't buy more than  items so she can't spend exactly .
    Sample Input 0

10 2 3
3 1
5 2 8
Sample Output 0

9
Explanation 0

She can buy the  keyboard and the  USB drive for a total cost of .
     */

    /*
     * Complete the getMoneySpent function below.
     */
    public static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int moneySpent = -1;
        for(int i = 0 ;i < keyboards.length ; i++){
            for(int j = 0; j < drives.length ; j++){
                int totalPrice = keyboards[i] + drives[j];
                if(totalPrice <= b && totalPrice > moneySpent){
                    moneySpent = totalPrice;
                }
            }
        }
        return moneySpent;
    }


    public static void main(String[] args) {


    }

}
