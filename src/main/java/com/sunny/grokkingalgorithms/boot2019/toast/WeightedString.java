package com.sunny.grokkingalgorithms.boot2019.toast;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class WeightedString {

    /*
    A weighted string is a string of lowercase English letters where each letter has a weight.
    Character weights are  to  from  to  as shown below:

    A uniform string consists of a single character repeated zero or more times.
    For example, ccc and a are uniform strings, but bcb and cd are not.

    Given a string, , let  be the set of weights for all possible uniform contiguous substrings of string . You have to answer  queries, where each query  consists of a single integer, . For each query, print Yes on a new line if ; otherwise, print No instead.

Note: The  symbol den
Sample Input 0

abccddde
6
1
3
12
5
9
10
Sample Output 0

Yes
Yes
Yes
Yes
No
No
     */




    private static final Scanner scanner = new Scanner(System.in);

    // Complete the weightedUniformStrings function below.
    public static String[] weightedUniformStrings(String s, int[] queries) {
        String[] answers = new String[queries.length];
        for(int i = 0 ; i < queries.length ; i++){
            int query = queries[i];
            int curSum = Math.abs('a' - s.charAt(0)) + 1;
            if(curSum == query){
                answers[i] = "Yes";
                continue;
            }
            for(int j = 1;j < s.length() ;j++){
                if(curSum == query){
                    answers[i] = "Yes";
                    break;
                }
                else if(s.charAt(j) == s.charAt(j - 1)){
                    int val = Math.abs('a' - s.charAt(j)) + 1;
                    //System.out.println("asdas " + val);
                    curSum += val;
                } else{
                    int val = Math.abs('a' - s.charAt(j)) + 1;
                    curSum = val;
                    //System.out.println("dasd " + val);
                }
            }
            if(curSum == query){
                answers[i] = "Yes";
                continue;
            }
            if(answers[i] == null){
                answers[i] = "No";
            }
        }
        return answers;
    }


    public static void main(String[] args) throws IOException {
        /*
        abccddde
1
12
No
         */
            //BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

            String s = scanner.nextLine();

            int queriesCount = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] queries = new int[queriesCount];

            for (int i = 0; i < queriesCount; i++) {
                int queriesItem = scanner.nextInt();
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
                queries[i] = queriesItem;
            }

            String[] result = weightedUniformStrings(s, queries);

            for(int i = 0 ; i < result.length ;i++){
                System.out.println(result[i]);
            }

            scanner.close();
        }


}
