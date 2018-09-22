package com.sunny.grokkingalgorithms.refresh.ctci.arraysandstrings;

public class UrlEncodeSpaces {

    /*
    Url encode strings, essentially replace spaces with %20.
     */


    /**
     *
     * @param input
     * @param actualLength
     */
    public static void encodeAlt(char[] input,
                              int actualLength){
        int spaceCount = countSpaces(input,actualLength);
        int index = actualLength + 2*spaceCount - 1;
        int i = actualLength - 1;
        while(i >= 0){
            if(input[i] == ' '){
                input[index] = '0';
                input[index - 1] = '2';
                input[index - 2] = '%';
                index -= 3;
            }
            else{
                input[index] = input[i];
                index--;
            }
            i--;
        }
    }

    /**
     *
     * @param input
     * @param actualLength
     * @return
     */
    public static int countSpaces(char[] input, int actualLength){
        int spaceCount = 0;
        for(int i = 0 ; i < actualLength ; i++){
            if(input[i] == ' '){
                spaceCount++;
            }
        }
        return spaceCount;
    }

    /**
     *
     * @param input
     * @param  actualStringLength
     * @return
     */
    public static char[] encode(char[] input,
                                int actualStringLength){
        int i = actualStringLength - 1;
        while(i >= 0){
            if(input[i] == ' '){
                shiftUp(input,i);
                input[i] = '%';
                input[i + 1] = '2';
                input[i + 2] = '0';
            }
            i--;
        }
        return input;
    }

    public static void shiftUp(char[] input,int index){
        int startIndex = findStartIndex(input,index);
        int i = startIndex;
        while(i > index){
            if((i+2) < input.length){
                input[i + 2] = input[i];
            }
            i--;
        }
    }

    public static int findStartIndex(char[] input,int index){
        int i = index + 1;
        while(i < input.length){
            if(input[i] == ' '){
                break;
            }
            i++;
        }
        return i;
    }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        String str = "Mr abc   ";
        char[] converted = str.toCharArray();
        char[] output = encode(converted,6);
        System.out.println(String.valueOf(output));
        str = "Mr Someone  Somewhere      ";
        converted = str.toCharArray();
        System.out.println(converted.length);
        output = encode(converted,21);
        System.out.println(String.valueOf(output));
        System.out.println(String.valueOf(output).length());
        str = "Mr Someone  Somewhere      ";
        converted = str.toCharArray();
        System.out.println(converted.length);
        encodeAlt(converted,21);
        System.out.println(String.valueOf(converted));
        System.out.println(String.valueOf(converted).length());

    }

}
