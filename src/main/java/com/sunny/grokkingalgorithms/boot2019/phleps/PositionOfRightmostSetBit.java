package com.sunny.grokkingalgorithms.boot2019.phleps;

public class PositionOfRightmostSetBit {

    /*
    Write a one line function to return position of first 1 from right to left, in binary representation of an Integer.

I/P    18,   Binary Representation 010010
O/P   2
I/P    19,   Binary Representation 010011
O/P   1
     */

    public static int positionOfRightMostSetBit(int number){
        int mask = 1;
        int position = -1;
        while(number != 0){
            if(position < 0){
                position = 0;
            }
            if((number & mask) == 1){
                break;
            }
            number = number>>1;
            position++;
        }
        return (position + 1);
    }

    public static void main(String[] args) {
        int n = 18;
        System.out.println(positionOfRightMostSetBit(n));
        n = 19;
        System.out.println(positionOfRightMostSetBit(n));
        n = 12;
        System.out.println(positionOfRightMostSetBit(n));
    }

}
