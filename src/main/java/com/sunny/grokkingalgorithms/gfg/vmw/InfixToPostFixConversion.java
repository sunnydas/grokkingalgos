package com.sunny.grokkingalgorithms.gfg.vmw;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sundas on 4/15/2018.
 */
public class InfixToPostFixConversion {

  /*
  Any expression can be represented using three types of expressions (Infix, Postfix and Prefix). We can also convert one type of expression to another type of expression like Infix to Postfix, Infix to Prefix, Postfix to Prefix and vice versa.

To convert any Infix expression into Postfix or Prefix expression we can use the following procedure...

Find all the operators in the given Infix Expression.
Find the order of operators evaluated according to their Operator precedence.
Convert each operator into required type of expression (Postfix or Prefix) in the same order.
Example
Consider the following Infix Expression to be converted into Postfix Expression...

D = A + B * C
Step 1: The Operators in the given Infix Expression : = , + , *
Step 2: The Order of Operators according to their preference : * , + , =
Step 3: Now, convert the first operator * ----- D = A + B C *
Step 4: Convert the next operator + ----- D = A BC* +
Step 5: Convert the next operator = ----- D ABC*+ =
Finally, given Infix Expression is converted into Postfix Expression as follows...

D A B C * + =
Infix to Postfix Conversion using Stack Data Structure
To convert Infix Expression into Postfix Expression using a stack data structure, We can use the following steps...

Read all the symbols one by one from left to right in the given Infix Expression.
If the reading symbol is operand, then directly print it to the result (Output).
If the reading symbol is left parenthesis '(', then Push it on to the Stack.
If the reading symbol is right parenthesis ')', then Pop all the contents of stack until respective left parenthesis is poped and print each poped symbol to the result.
If the reading symbol is operator (+ , - , * , / etc.,), then Push it on to the Stack. However, first pop the operators which are already on the stack that have higher or equal precedence than current operator and print them to the result.
Example
Consider the following Infix Expression...

( A + B ) * ( C - D )
The given infix expression can be converted into postfix expression using Stack data Structure as follows..
   */




  /**
   *
   * @param infix
   * @return
   */
  public static String infixToPostFixOperator(String infix){
    String postfix = null;
    Stack<String> stack = new Stack<>();
    StringBuilder builder = new StringBuilder();
    int i = 0;
    Map<String,Integer> bodmas = new HashMap<>();
    bodmas.put("(",10);
    bodmas.put(")",10);
    bodmas.put("/",9);
    bodmas.put("*",8);
    bodmas.put("+",7);
    bodmas.put("-",6);
    while(i < infix.length()){
      /*
      A summary of the rules follows:

1.	Print operands as they arrive.

2.	If the stack is empty or contains a left parenthesis on top, push the incoming operator onto the stack.

3.	If the incoming symbol is a left parenthesis, push it on the stack.

4.	If the incoming symbol is a right parenthesis, pop the stack and print the operators until you see a left parenthesis. Discard the pair of parentheses.

5.	If the incoming symbol has higher precedence than the top of the stack, push it on the stack.

6.	If the incoming symbol has equal precedence with the top of the stack, use association. If the association is left to right, pop and print the top of the stack and then push the incoming operator. If the association is right to left, push the incoming operator.

7.	If the incoming symbol has lower precedence than the symbol on the top of the stack, pop the stack and print the top operator. Then test the incoming operator against the new top of stack.

8.	At the end of the expression, pop and print all operators on the stack. (No parentheses should remain.)


       */
      String val = infix.charAt(i)+"";
      if(!bodmas.containsKey(val)){
        builder.append(val);
      }
      else if(val.equals("(")){
        stack.push(val);
      }
      else if(val.equals(")")){
        while(!stack.isEmpty() && !stack.peek().equals("(")){
          builder.append(stack.pop());
        }
        if(stack.peek().equals("(")){
          stack.pop();
        }
      }
      else if(!stack.isEmpty() && bodmas.containsKey(val) && bodmas.containsKey(stack.peek()) && bodmas.get(val)
          >= bodmas.get(stack.peek())){
        stack.push(val);
      }
      else{
        if(!stack.isEmpty() && bodmas.containsKey(val) && bodmas.containsKey(stack.peek()) && bodmas.get(val)
            < bodmas.get(stack.peek())){
          while(!stack.isEmpty() &&  !stack.peek().equals("(") && !stack.peek().equals(")") &&
              bodmas.containsKey(stack.peek()) && bodmas.get(val)
              < bodmas.get(stack.peek())){
            builder.append(stack.pop());
          }
        }
        stack.push(val);
      }
      i++;
    }
    while(!stack.isEmpty()){
      builder.append(stack.pop());
    }
    postfix = builder.toString();
    return postfix;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String infix = "(A+B)*(C-D)";
    System.out.println(infixToPostFixOperator(infix));
    infix = "A+B*C";
    System.out.println(infixToPostFixOperator(infix));
  }


}
