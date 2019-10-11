package com.sunny.grokkingalgorithms.boot2019.twize;

import java.util.NavigableMap;
import java.util.TreeMap;

public class ConvertIntegerToRoman {

    /*
    Input : 9
Output : IX

Input : 40
Output : XL

Input :  1904
Output : MCMIV

1
5
10
50
100
500
1000
I
V
X
L
C
D
M

How to convert number to roman numerals
How to convert decimal number to roman numerals.

Decimal number to roman numerals conversion
For decimal number x:

From the following table, find the highest decimal value v that is less than or equal to the decimal number x
and its corresponding roman numeral n:



Decimal value (v)	Roman numeral (n)
1	I
4	IV
5	V
9	IX
10	X
40	XL
50	L
90	XC
100	C
400	CD
500	D
900	CM
1000	M


Write the roman numeral n that you found and subtract its value v from x:
x = x - v

Repeat stages 1 and 2 until you get zero result of x.
Example #1
x = 36

Iteration #	Decimal number (x)	Highest decimal value (v)	Highest roman numeral (n)	Temporary result
1	36	10	X	X
2	26	10	X	XX
3	16	10	X	XXX
4	6	5	V	XXXV
5	1	1	I	XXXVI

Example #2
x = 2012

Iteration #	Decimal number (x)	Highest decimal value (v)	Highest roman numeral (n)	Temporary result
1	2012	1000	M	M
2	1012	1000	M	MM
3	12	10	X	MMX
4	2	1	I	MMXI
5	1	1	I	MMXII

Example #3
x = 1996

Iteration #	Decimal number (x)	Highest decimal value (v)	Highest roman numeral (n)	Temporary result
1	1996	1000
     */


    public static void convertToRomanString(int number){
        NavigableMap<Integer,String> romanNumeralChart = new TreeMap<>();
        romanNumeralChart.put(1,"I");
        romanNumeralChart.put(4,"IV");
        romanNumeralChart.put(5,"V");
        romanNumeralChart.put(9,"IX");
        romanNumeralChart.put(10,"X");
        romanNumeralChart.put(40,"XL");
        romanNumeralChart.put(50,"L");
        romanNumeralChart.put(90,"XC");
        romanNumeralChart.put(100,"C");
        romanNumeralChart.put(400,"CD");
        romanNumeralChart.put(500,"D");
        romanNumeralChart.put(900,"CM");
        romanNumeralChart.put(1000,"M");
        StringBuilder romanNumeral = new StringBuilder();
        while(number > 0){
            int key = romanNumeralChart.floorKey(number);
            romanNumeral.append(romanNumeralChart.get(key));
            number -= key;
        }
        System.out.println(romanNumeral);
    }

    public static void main(String[] args) {
        convertToRomanString(1904);
        convertToRomanString(40);
        convertToRomanString(99);
        convertToRomanString(3549);
        convertToRomanString(3724);
    }
}
