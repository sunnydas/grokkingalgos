package com.sunny.grokkingalgorithms.gfg.intuit;

import sun.management.ManagementFactoryHelper;

import java.lang.management.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Created by sundas on 2/21/2018.
 */
public class ConvertNumbersToWords {

  /*
  GIven a number convert it into a word form like
  123 = One hundred twenty three
  or 44500 = Forty four thousand five hundred
   */


  /**
   * A hack way to convert integer to words within a range
   *
   * @param number
   * @return
   */
  public static String convertNumberToWords(int number){
    /*
    Base dictionary to for conversion
     */
    String[] base = new String[]{"one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve",
        "thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen"};
    //Need these since we need their string values
    String[] decades = new String[]{"ten","twenty","thirty","forty","fifty","sixty","seventy","eighty","ninety"};
    StringBuilder converted = new StringBuilder();
    //Range check
    if(number > 99000 || number <= 0){
      System.out.println("Conversion not supported for number = " + number);
      return null;
    }
    //This information can be fetched from the dictionary directly
    if(number < 20){
      converted.append(base[number - 1]);
    }
    else{
      // Stack since with this method the string is produced in reverse
      Stack<String> conversionTracker = new Stack<>();
      int powerCount = 0;
      int dividend = number;
      int divisor = 10;
      boolean thousandFlag = false;
      /*
      What is the idea here
      with every division we are adding 10.pow(powercount)
      which will initially be 1 , then 10 , 100 etc
      for example:
      123/10 -> remainder 3 quotient 12
      12/10 -> remainder 2 quotient 1
      1/10 -> 1
       I need to find a better way to do this and minimise the if else loops
       */
      while(dividend >= divisor){
        int quotient = dividend/divisor;
        int remainder = dividend%divisor;
        if(powerCount == 0){
          if(remainder > 0){
            conversionTracker.add(base[remainder - 1]);
          }
        }
        else if(powerCount == 1){
          if(remainder > 0){
            conversionTracker.add(decades[remainder - 1]);
          }
        }
        else if(powerCount == 2){
          if(remainder > 0){
            conversionTracker.add(base[remainder - 1] + "hundred");
          }
        }
        else if(powerCount == 3){
          if(remainder > 0){
            conversionTracker.add(base[remainder - 1] + "thousand");
            thousandFlag = true;
          }
        }
        else if(powerCount == 4){
          if(remainder > 0){
            String value = decades[remainder - 1];
            if(!thousandFlag){
              value += "thousand";
              thousandFlag = true;
            }
            conversionTracker.add(value);
          }
        }
        dividend = quotient;
        powerCount++;
      }
      // To handle cases where dividend is less than divisor (i.e. 10)
      if(dividend > 0){
        if(powerCount == 1){
          conversionTracker.add(decades[dividend - 1]);
        }
        else if(powerCount == 2){
          conversionTracker.add(base[dividend - 1] + "hundred");
        }
        else if(powerCount == 3){
          conversionTracker.add(base[dividend - 1] + "thousand");
        }
        else if(powerCount == 4){
          String value = decades[dividend - 1];
          if(!thousandFlag){
            value += "thousand";
            thousandFlag = true;
          }
          conversionTracker.add(value);
        }
        else if(powerCount > 4){

        }
      }
      while(!conversionTracker.isEmpty()){
        converted.append(conversionTracker.pop());
      }

  }
    return converted.toString();
  }


  public static void main(String[] args) throws InterruptedException {
    System.out.println(convertNumberToWords(123));
    System.out.println(convertNumberToWords(44500));
    System.out.println(convertNumberToWords(1234));
    System.out.println(convertNumberToWords(1));
    System.out.println(convertNumberToWords(50));
    System.out.println(convertNumberToWords(11));
    System.out.println(convertNumberToWords(20));
    System.out.println(convertNumberToWords(21));
    System.out.println(convertNumberToWords(31));
    System.out.println(convertNumberToWords(91));
    System.out.println(convertNumberToWords(90000));
    System.out.println(convertNumberToWords(91000));
    System.out.println(convertNumberToWords(100));
    System.out.println(convertNumberToWords(1000));
    System.out.println(convertNumberToWords(999));
    System.out.println(convertNumberToWords(10000));
    System.out.println(convertNumberToWords(9000));
    System.out.println(convertNumberToWords(100000));
    System.out.println(convertNumberToWords(11000));
    System.out.println(convertNumberToWords(1100));
    System.out.println(convertNumberToWords(110));
    System.out.println(convertNumberToWords(21000));

    // general JMX entries
    Map<String, String> memoryMap = new HashMap<>();
    OperatingSystemMXBean osMxBean = ManagementFactory.getOperatingSystemMXBean();

    int count = 0;
    while(count < 2){
      double cpu = osMxBean.getSystemLoadAverage();
      System.out.println(cpu);
      memoryMap.put("cpuLoad", ""+cpu);
      count++;
      Thread.sleep(1000);
    }


    System.out.println( ManagementFactoryHelper.getOperatingSystemMXBean().getSystemLoadAverage());


    ThreadMXBean threadmxBean = ManagementFactory.getThreadMXBean();
    int threadCount = threadmxBean.getThreadCount();
    memoryMap.put("cpuRunningThreads", String.valueOf(threadCount));

    MemoryMXBean memBean = ManagementFactory.getMemoryMXBean();
    MemoryUsage memHeapUsage = memBean.getHeapMemoryUsage();
    MemoryUsage nonHeapUsage = memBean.getNonHeapMemoryUsage();
    memoryMap.put("heapInit", String.valueOf(memHeapUsage.getInit()));
    memoryMap.put("heapMax", String.valueOf(memHeapUsage.getMax()));
    memoryMap.put("heapCommit", String.valueOf(memHeapUsage.getCommitted()));
    memoryMap.put("heapUsed", String.valueOf(memHeapUsage.getUsed()));
    memoryMap.put("nonHeapInit", String.valueOf(nonHeapUsage.getInit()));
    memoryMap.put("nonHeapMax", String.valueOf(nonHeapUsage.getMax()));
    memoryMap.put("nonHeapCommit", String.valueOf(nonHeapUsage.getCommitted()));
    memoryMap.put("nonHeapUsed", String.valueOf(nonHeapUsage.getUsed()));
    System.out.println(memoryMap);
  }

}
