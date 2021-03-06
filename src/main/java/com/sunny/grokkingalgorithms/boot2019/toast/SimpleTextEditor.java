package com.sunny.grokkingalgorithms.boot2019.toast;


import java.util.Scanner;
import java.util.Stack;

public class SimpleTextEditor {

    /*
    https://www.hackerrank.com/challenges/simple-text-editor/problem
      In this challenge, you must implement a simple text editor. Initially, your editor contains an empty string, . You must perform  operations of the following  types:

append - Append string  to the end of .
delete - Delete the last  characters of .
print - Print the  character of .
undo - Undo the last (not previously undone) operation of type  or , reverting  to the state it was in prior to that operation.

Sample Input

8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1
Sample Output

c
y
a
Explanation

Initially,  is empty. The following sequence of  operations are described below:

. We append  to , so .
Print the  character on a new line. Currently, the  character is c.
Delete the last  characters in  (), so .
Append  to , so .
Print the  character on a new line. Currently, the  character is y.
Undo the last update to , making  empty again (i.e., ).
Undo the next to last update to  (the deletion of the last  characters), making .
Print the  character on a new line. Currently, the  character is a.

     */

    public static void simpleTextEditor(String operation,
                                        Stack<String> undoStack,
                                        StringBuilder myText){
        String[] parsed = parseOperation(operation);
        switch (parsed[0]) {
            case "1":
                myText.append(parsed[1]);
                undoStack.push(operation);
                break;
            case "2":
                StringBuilder orig = new StringBuilder(myText);
                deleteChars(myText, Integer.parseInt(parsed[1]));
                //System.out.println(orig);
                undoStack.push(operation + " "
                        + orig.substring(orig.length() -
                        Integer.parseInt(parsed[1])));
                break;
            case "3":
                //System.out.println(myText);
                System.out.println(myText.charAt(Integer.parseInt(parsed[1]) - 1));
                break;
            case "4":
                undoLastOperation(myText, undoStack);
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }

    public static void simpleTextEditorAlt(String operation,
                                        Stack<String> undoStack){
        String[] parsed = parseOperation(operation);
        switch (parsed[0]) {
            case "1":
                String prev = undoStack.peek();
                undoStack.push(prev + parsed[1]);
                break;
            case "2":
                prev = undoStack.peek();
                undoStack.push(prev.substring(0,prev.length()
                        - Integer.parseInt(parsed[1])));
                break;
            case "3":
                //System.out.println(myText);
                prev = undoStack.peek();
                //System.out.println(prev);
                System.out.println(prev.charAt(Integer.parseInt(parsed[1]) - 1));
                break;
            case "4":
                undoStack.pop();
                break;
            default:
                throw new IllegalArgumentException("Invalid operation");
        }
    }


    public static void simpleTextEditor(String[] operations){
        StringBuilder myText = new StringBuilder();
        Stack<String> undoStack = new Stack<>();
        for(int i = 0 ; i < operations.length ; i++){
            String operation =  operations[i];
            //System.out.println(operation);
            String[] parsed = parseOperation(operation);
            switch (parsed[0]){
                case "1":
                    myText.append(parsed[1]);
                    undoStack.push(operation);
                    break;
                case "2":
                    StringBuilder orig = new StringBuilder(myText);
                    deleteChars(myText,Integer.parseInt(parsed[1]));
                    //System.out.println(orig);
                    undoStack.push(operation + " "
                            + orig.substring(orig.length() -
                            Integer.parseInt(parsed[1])));
                    break;
                case "3":
                    //System.out.println(myText);
                    System.out.println(myText.charAt(Integer.parseInt(parsed[1]) - 1));
                    break;
                case "4":
                    undoLastOperation(myText,undoStack);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid operation");
            }
        }
    }

    private static void undoLastOperation(StringBuilder myText,Stack<String> undoStack){
        if(!undoStack.isEmpty()){
            String operation = undoStack.pop();
            String[] parsed = operation.split("\\s+");
            switch(parsed[0]){
                case "1":
                    int startIndex = myText.length() - parsed[1].length();
                    myText.delete(startIndex,myText.length());
                    break;
                case "2":
                    String deletedString = parsed[2];
                    myText.append(deletedString);
                    break;
                default:
                    throw new IllegalArgumentException("Invalid undo operation");
            }
        }
    }

    private static void deleteChars(StringBuilder myText,int k){
        int index = myText.length();
        myText.delete(index - k,myText.length());
    }

    private static String[] parseOperation(String operation){
        return operation.split("\\s+");
    }

    public static void main(String[] args) {
        /*
        8
1 abc
3 3
2 3
1 xy
3 2
4
4
3 1
         */
        /*Scanner scanner = new Scanner(System.in);
        int numOperations = scanner.nextInt();
        String[] operations = new String[numOperations];
        scanner.nextLine();
        for(int i = 0 ; i < numOperations; i++){
            operations[i] = scanner.nextLine();
        }
        simpleTextEditor(operations);*/
        /*Stack<String> undoStack = new Stack<>();
        StringBuilder myText = new StringBuilder();
        for(int i = 0 ; i < numOperations ; i++){
            simpleTextEditor(scanner.nextLine(),undoStack,myText);
        }*/
        Scanner scanner = new Scanner(System.in);
        int numOperations = scanner.nextInt();
        scanner.nextLine();
        Stack<String> undoStack = new Stack<>();
        //StringBuilder myText = new StringBuilder();
        undoStack.push("");
        for(int i = 0 ; i < numOperations ; i++){
            simpleTextEditorAlt(scanner.nextLine(),undoStack);
        }
    }
}
