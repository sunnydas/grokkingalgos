package com.sunny.grokkingalgorithms.design_patterns.flyweight.factory;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by sundas on 4/19/2018.
 */
public class FWFactory {


  private static Map<String,Object> objectMap = new HashMap<>();

  public static Object getObject(String type){
    if(objectMap.containsKey(type)){
      return objectMap.get(type);
    }
    Object o = null;
    switch(type){
      case "list":
        o = new ArrayList<>();
        ((List) o).add("s");
        objectMap.put(type,o);
        break;
      case "bigdecimal":
        o = BigDecimal.valueOf(0.0d);
        objectMap.put(type,o);
        break;
    }
    return o;
  }

}
