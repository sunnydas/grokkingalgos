package com.sunny.grokkingalgorithms.boot2019.yelper;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {

    /*
    Input:  str1 = "aab", str2 = "xxy"
Output: True
'a' is mapped to 'x' and 'b' is mapped to 'y'.

Input:  str1 = "aab", str2 = "xyz"
Output: False
One occurrence of 'a' in str1 has 'x' in str2 and
other occurrence of 'a' has 'y'.
     */

    public static boolean isIsomorphic(String str1,String str2){
        boolean isIsoMorphic = true;
        if(str1.length() == str2.length()){
            Map<Character,Character> isoMorphTracker = new HashMap<>();
            int i = 0;
            while (i < str1.length()){
                char cur = str1.charAt(i);
                if(isoMorphTracker.containsKey(cur)){
                    Character mapped = isoMorphTracker.get(cur);
                    if(str2.charAt(i) != mapped) {
                        isIsoMorphic = false;
                        break;
                    }
                } else{
                    isoMorphTracker.put(cur,str2.charAt(i));
                }
                i++;
            }
        } else{
            isIsoMorphic = false;
        }
        return isIsoMorphic;
    }

    public static void main(String[] args) {
        String str1 = "aab";
        String str2 = "xxy";
        System.out.println(isIsomorphic(str1,str2));
        str1 = "aab";
        str2 = "xyz";
        System.out.println(isIsomorphic(str1,str2));
    }
}
