package com.sunny.grokkingalgorithms;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class CheckIfWordIsJumbled {

    public static String isWordInDict(String[] input,
                                      String str){
        String found = null;
        for(int i = 0 ; i < input.length ; i++){
            String dictionaryWord = input[i];
            if(contains(dictionaryWord,str)){
                found = dictionaryWord;
                break;
            }
        }
        return found;
    }

    public static boolean contains(String dictionaryWord,String input){
        boolean contains = true;
        Map<Character,Integer> charCountForDictionaryWordMap = new HashMap<>();
        for(int i = 0 ; i < dictionaryWord.length() ; i++){
            char c = dictionaryWord.charAt(i);
            if(charCountForDictionaryWordMap.containsKey(c)){
                charCountForDictionaryWordMap.put(c,charCountForDictionaryWordMap.get(c) + 1);
            }else{
                charCountForDictionaryWordMap.put(c,
                        1);
            }
        }
        for(int i = 0 ; i < input.length() ; i++){
            char c = input.charAt(i);
            if(charCountForDictionaryWordMap.containsKey(c)){
                charCountForDictionaryWordMap.put(c,charCountForDictionaryWordMap.get(c) - 1);
            }
        }
        Iterator<Map.Entry<Character,Integer>> iterator = charCountForDictionaryWordMap.entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Character,Integer> entry = iterator.next();
            if(entry.getValue() > 0){
                contains = false;
                break;
            }
        }
        return contains;
    }

    public static void main(String[] args) {
        String[] input = new String[]{"terrain","catalyst","proclaim","destination"};
        String str = "ainterrterr";
        System.out.println(isWordInDict(input,str));
        str = "ppppppppppppppclaimpro";
        System.out.println(isWordInDict(input,str));
        str = "nation";
        System.out.println(isWordInDict(input,str));
    }

}