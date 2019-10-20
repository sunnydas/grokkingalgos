package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.Stack;

public class CDCommandImplementation {

    /*
    CareerCup
Questions

Forum

Salaries

Resume Tips

RSS

Sign In
Yelp Interview Question
yelp-interview-questions0
of 2 votes
4
Answers
implement the 'cd' command i.e. given a function cd('a/b','c/../d/e/../f'),
where 1st param is current directory and 2nd param is the sequence of operations,
find the final directory that the user will be in when the cd command is executed

- jason.sarka 5 years ago in United States | Report Duplicate | Flag |
Yelp

     */

    public static String whereCDWillEnd(String cdCommand){
        String finalDestination = null;
        Stack<String> destination = new Stack<>();
        String[] individualCommands = cdCommand.split(",");
        String curDirectory = individualCommands[0];
        String correspondingOperations = individualCommands[1];
        String[] cur = curDirectory.split("/");
        String[] next = correspondingOperations.split("/");
        for(int i = 0 ; i < cur.length ; i++){
            if(!destination.isEmpty() && cur[i].equals("..")){
                destination.pop();
            } else{
               destination.add(cur[i]);
            }
        }
        for(int i = 0 ; i < next.length ; i++){
            if(!destination.isEmpty() && next[i].equals("..")){
                destination.pop();
            } else{
                destination.add(next[i]);
            }
        }
        if(!destination.isEmpty()){
            finalDestination = destination.peek();
        }
        return finalDestination;
    }

    public static void main(String[] args) {
        String cdCommand = "'a/b','c/../d/e/../f'";
        System.out.println(whereCDWillEnd(cdCommand));
    }

}
