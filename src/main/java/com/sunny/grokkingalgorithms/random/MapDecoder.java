package com.sunny.grokkingalgorithms.random;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by sundas on 3/1/2018.
 */
public class MapDecoder {

  /*
  Convert a steing to its mapped equvalent
  one = one
  two = two for example
   */


  public Map<String, String> decode(String s) {
    Map<String,String> decoded = new HashMap<>();
    if(s != null){
      String[] split1 = s.split("&");
      if(split1 != null){
        for(String keyValues : split1){
          if(keyValues != null){
            String[] split2 = keyValues.split("=");
            if(split2 != null){
              if(split2.length == 2){
              String key = split2[0];
              String value = split2[1];
              decoded.put(key,value);
            }
            else if(split2.length == 1){
                decoded.put(split2[0],"");
              }
            }
          }
        }
      }
    }
    return decoded;
  }

  public static void main(String[] args) {
    String s = "one=1&two=2";
    MapDecoder mapDecoder = new MapDecoder();
    System.out.println(mapDecoder.decode(s));
    s = "three=&";
    System.out.println(mapDecoder.decode(s));
  }

}
