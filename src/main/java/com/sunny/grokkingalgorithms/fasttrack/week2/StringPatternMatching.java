package com.sunny.grokkingalgorithms.fasttrack.week2;

/**
 * Created by sundas on 6/25/2018.
 */
public class StringPatternMatching {

  /*
  KMP

  Preprocessing Overview:

KMP algorithm preprocesses pat[] and constructs an auxiliary lps[] of size m (same as size of pattern) which is used to skip characters while matching.
name lps indicates longest proper prefix which is also suffix.. A proper prefix is prefix with whole string not allowed. For example, prefixes of “ABC” are “”, “A”, “AB” and “ABC”. Proper prefixes are “”, “A” and “AB”. Suffixes of the string are “”, “C”, “BC” and “ABC”.
For each sub-pattern pat[0..i] where i = 0 to m-1, lps[i] stores length of the maximum matching proper prefix which is also a suffix of the sub-pattern pat[0..i].
   lps[i] = the longest proper prefix of pat[0..i]
              which is also a suffix of pat[0..i].
Note : lps[i] could also be defined as longest prefix which is also proper suffix. We need to use properly at one place to make sure that the whole substring is not considered.

Examples of lps[] construction:
For the pattern “AAAA”,
lps[] is [0, 1, 2, 3]

For the pattern “ABCDE”,
lps[] is [0, 0, 0, 0, 0]

For the pattern “AABAACAABAA”,
lps[] is [0, 1, 0, 1, 2, 0, 1, 2, 3, 4, 5]

For the pattern “AAACAAAAAC”,
lps[] is [0, 1, 2, 0, 1, 2, 3, 3, 3, 4]

For the pattern “AAABAAA”,
lps[] is [0, 1, 2, 0, 1, 2, 3]

Unlike Naive algorithm, where we slide the pattern by one and compare all characters at each shift, we use a value from lps[] to decide the next characters to be matched. The idea is to not match a character that we know will anyway match.

How to use lps[] to decide next positions (or to know a number of characters to be skipped)?

We start comparison of pat[j] with j = 0 with characters of current window of text.
We keep matching characters txt[i] and pat[j] and keep incrementing i and j while pat[j] and txt[i] keep matching.
When we see a mismatch
We know that characters pat[0..j-1] match with txt[i-j+1…i-1] (Note that j starts with 0 and increment it only when there is a match).
We also know (from above definition) that lps[j-1] is count of characters of pat[0…j-1] that are both proper prefix and suffix.
From above two points, we can conclude that we do not need to match these lps[j-1] characters with txt[i-j…i-1] because we know that these characters will anyway match.
   */

  /**
   *
   * @param s
   * @param pattern
   * @return
   */
  public static int kmpMatch(String s,
                             String pattern){
    return -1;
  }

  /*
  Naive approach
   */

  /**
   *
   * @param s
   * @param pattern
   * @return
   */
  public static int match(String s, String pattern){
    int index = -1;
    /*
    Sliding window approach
     */
    for(int i = 0 ; i < s.length() ; i++){
      char current = s.charAt(i);
      boolean subStringExists = checkIfSubStringExists(s,i,pattern);
      if(subStringExists){
        index = i;
        break;
      }
      else if(pattern.length()
          > (s.length() - 1 - i + 1)){
        break;
      }
    }
    return index;
  }

  /**
   *
   * @param s
   * @param i
   * @param pattern
   * @return
   */
  public static boolean checkIfSubStringExists(String s,
                                               int i,
                                               String pattern){
    boolean matched = false;
    int count =  0;
    for(int j = 0 ; j < pattern.length() ; j++){
      if(i < s.length()
          && s.charAt(i) == pattern.charAt(j)){
        count++;
        i++;
      }
      else{
        break;
      }
    }
    if(count == pattern.length()){
      matched = true;
    }
    return matched;
  }


  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    String s =  "abcdefgh";
    String pattern = "cde";
    System.out.println(match(s,pattern));
    pattern = "xyz";
    System.out.println(match(s,pattern));
    s = "abc";
    pattern = "abc";
    System.out.println(match(s,pattern));
    pattern = "abcd";
    System.out.println(match(s,pattern));
  }


}
