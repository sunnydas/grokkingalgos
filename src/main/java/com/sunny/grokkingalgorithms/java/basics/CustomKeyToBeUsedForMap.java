package com.sunny.grokkingalgorithms.java.basics;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sundas on 4/8/2018.
 */
public class CustomKeyToBeUsedForMap {

  private int id;

  private String lName;

  private String fName;

  private List<String> values;

  /**
   *
   * @return
   */
  public int hashCode(){
    int hashCode = 31 + id;
    hashCode += 31 + ((lName != null)?lName.hashCode():17);
    hashCode += 31 + ((fName != null)?fName.hashCode():21);
    hashCode += 31 + ((values != null)?values.hashCode():32);
    return hashCode;
  }


  /**
   *
   * @param anotherObject
   * @return
   */
  public boolean equals(Object anotherObject){
    /*
    Same object
     */
    if(this == anotherObject){
      return true;
    }
    /*
    Base condition
     */
    if(anotherObject == null || getClass() != anotherObject.getClass()){
      return false;
    }
    CustomKeyToBeUsedForMap another = (CustomKeyToBeUsedForMap) anotherObject;
    /*
    Base checks
     */
    if(this.id != another.id){
      return false;
    }
    if((this.fName != null)?!this.fName.equals(another.fName):another.fName != null){
      return false;
    }
    if((this.lName != null)?!this.lName.equals(another.lName):another.lName != null){
      return false;
    }
    return (this.values != null)? this.values.equals(another.values):another.values == null;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    CustomKeyToBeUsedForMap a = new CustomKeyToBeUsedForMap();
    a.fName = "sunny";
    a.lName = "das";
    a.id = 1;
    List<String> values = new ArrayList<>();
    values.add("a");
    values.add("b");
    a.values = values;
    CustomKeyToBeUsedForMap b = new CustomKeyToBeUsedForMap();
    b.fName = "sunny";
    b.lName = "das";
    b.id = 1;
    List<String> values1 = new ArrayList<>();
    values1.add("a");
    values1.add("b");
    b.values = values1;
    CustomKeyToBeUsedForMap c = new CustomKeyToBeUsedForMap();
    c.fName = "sunny";
    c.lName = "das";
    c.id = 1;
    List<String> values2 = new ArrayList<>();
    values2.add("a");
    //values2.add("b");
    c.values = values2;
    System.out.println(" a.equals(b) " + a.equals(b));
    System.out.println(" b.equals(a) " + b.equals(a));
    System.out.println(" a.equals(a) " + a.equals(a));
    System.out.println(" a.equals(c) " + a.equals(c));
    System.out.println(" b.equals(c) " + b.equals(c));
    System.out.println(" c.equals(c) " + c.equals(c));
    System.out.println(" c.equals(a) " + c.equals(a));
    System.out.println(a.hashCode());
    System.out.println(b.hashCode());
    System.out.println(c.hashCode());
  }

}
