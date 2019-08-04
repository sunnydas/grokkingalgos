package com.sunny.grokkingalgorithms.fasttrack.week2;

import java.util.*;

/**
 * Created by sundas on 6/26/2018.
 */
public class DependencyTracker {

  private static Map<String,Set<String>> dependencyMap =
      new HashMap<>();

  private static List<String> installedComponents = new ArrayList<>();

  private static List<String> installedViaDepends = new ArrayList<>();

  /**
   *
   * @param command
   */
  public static void execute(String command){
    if(command != null &&
        !command.equals("")){
      String[] parsed = command.split(" ");
      if(parsed != null &&
          parsed.length > 0){
        String action = parsed[0];
        if(action.equals("INSTALL")){
          String component = parsed[1];
          System.out.println(command);
          if(!installedComponents.contains(component)) {
            System.out.println("Installing " + component);
            installedComponents.add(component);
          }
          else{
            System.out.println(component + " is already installed");
          }
        }
        else if(action.equals("DEPEND")){
          System.out.println(command);
          for(int i = 2; i < parsed.length ; i++) {
            if(isValid(parsed[i - 1],parsed[i])){
              if(!installedViaDepends.contains(parsed[i - 1])){
                installedViaDepends.add(parsed[i - 1]);
              }
              if(!installedViaDepends.contains(parsed[i])){
                installedViaDepends.add(parsed[i]);
              }
              if (dependencyMap.containsKey(parsed[i - 1])) {
                Set<String> dependents = dependencyMap.get(parsed[i - 1]);
                dependents.add(parsed[i]);
              } else {
                Set<String> dependents = new HashSet<>();
                dependents.add(parsed[i]);
                dependencyMap.put(parsed[i - 1], dependents);
              }
            }
            else{
              System.out.println(parsed[i]
                  + " depends on " + parsed[i - 1] + ", ignoring command");
            }
          }
          //System.out.println(dependencyMap);
        }
        else if(action.equals("REMOVE")){
          System.out.println(command);
          String component = parsed[1];
          if(!isStillNeeded(component)) {
            boolean removed
                = installedComponents.remove(component);
            if (!removed) {
              System.out.println(component + " is not installed");
            } else {
              System.out.println("Removing " + component);
              updateDependencyMap(component);
            }
          }
          else{
            System.out.println(component + " is still needed");
          }
        }
        else if(action.equals("LIST")) {
          System.out.println(command);

            //Set<String> track = new HashSet<>();
            for (String component : installedComponents) {
              //if(!track.contains(component)) {
                if (component != null) {
                  System.out.println(component);
                }
              //}
              //else{
                //track.add(component);
              //}
            }

          for (String component : installedViaDepends) {
            //if(!track.contains(component)) {
            if (component != null) {
              System.out.println(component);
            }
            //}
            //else{
            //track.add(component);
            //}
          }


        }
      }
    }
  }

  /**
   *
   * @param component
   */
  public static void updateDependencyMap(String component){
    dependencyMap.remove(component);
  }

  /**
   *
   * @param component
   * @return
   */
  public static boolean isStillNeeded(String component){
    boolean needed = true;
    Iterator<Map.Entry<String,Set<String>>> iterator
        = dependencyMap.entrySet().iterator();
    while(iterator.hasNext()){
      Map.Entry<String,Set<String>> entry =
          iterator.next();
      if(entry.getValue().contains(component)){
        needed = false;
        break;
      }
    }
    return needed;
  }

  /**
   *
   * @param a
   * @param b
   * @return
   */
  public static boolean isValid(String a,String b){
    boolean valid = true;
    /*
    Valid if no dependency b -> a exists
     */
    if(dependencyMap.containsKey(b)){
      Set<String> dependencies = dependencyMap.get(b);
      if(dependencies.contains(a)){
        valid = false;
      }
    }
    return valid;
  }

  public static void main(String[] args) {

    //dequeue input from stdin
    Scanner scan = new Scanner(System.in);

    while (true) {
      String line = scan.nextLine();

      //no action for empty input
      if (line == null || line.length() == 0) {
        continue;
      }

      //the END command to stop the program
      if ("END".equals(line)) {
        System.out.println("END");
        break;
      }

      //Please provide your implementation here
      execute(line);
      //System.out.println(dependencyMap);
    }

  }

}
