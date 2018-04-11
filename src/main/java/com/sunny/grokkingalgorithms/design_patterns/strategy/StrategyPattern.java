package com.sunny.grokkingalgorithms.design_patterns.strategy;

import com.sunny.grokkingalgorithms.design_patterns.strategy.impl.Context;
import com.sunny.grokkingalgorithms.design_patterns.strategy.impl.DateTimeAlternate;
import com.sunny.grokkingalgorithms.design_patterns.strategy.impl.DateTimeDefault;

import java.util.Scanner;

/**
 * Created by sundas on 4/11/2018.
 */
public class StrategyPattern {


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    Context context = new Context();
    Scanner scanner = new Scanner(System.in);
    for(int i = 0 ; i < 5; i++){
      System.out.println("Enter your choice 1 or 2");
      String choice = scanner.next();
      switch(choice){
        case "1":
           context.setiChoice(new DateTimeDefault());
           break;
        case "2":
          context.setiChoice(new DateTimeAlternate());
          break;
        default:
          System.out.println("Invalid choice");
          break;
      }
      context.execute();
    }
  }
}
