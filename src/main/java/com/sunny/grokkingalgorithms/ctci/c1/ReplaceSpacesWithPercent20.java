package com.sunny.grokkingalgorithms.ctci.c1;

/**
 * Created by sundas on 3/10/2018.
 */
public class ReplaceSpacesWithPercent20 {


  /*
  Replace all characters in a string assume enoigh spaces at the end of the string . Use char array
   */

  /**\
   *
   * @param str
   * @return
   */
  public static  char[] replaceSpacesWithPercent20Alternate(char[] str,int actualStringLength){
    /*
    Count spaces
     */
    int spaceCount = 0;
    for(int i = 0 ; i < actualStringLength ; i++){
      if(str[i] == ' '){
        spaceCount++;
      }
    }
    /*
    Calculate new length , so %20 is three characters so we need tow spaces apart from space provided by the current space
    */
    int newLength = actualStringLength + spaceCount*2;
    int rearPointer = newLength - 1;
    int curPointer = actualStringLength - 1;
    for(curPointer = actualStringLength - 1 ; curPointer >= 0 ; curPointer--){
      if(str[curPointer] == ' '){
        /*
        replace with %20
         */
        str[rearPointer] = '0';
        str[rearPointer - 1] = '2';
        str[rearPointer - 2] = '%';
        rearPointer -= 3;
      }
      else{
        str[rearPointer] = str[curPointer];
        rearPointer--;
      }
    }
    return str;
  }

  /**
   *
   * @param str
   * @return
   */
  public static char[] replaceSpacesWithPercent20(char[] str){
    // Needs to be in place
    /*
    The free space is at the end of the string
     */
    int rearPointer = str.length - 1;
    int curPointer = 0;
    /*
    %20 is essentially three characters %,2,0 so for each replacement we will need two slots from the end.One space
    available here and two for the 2 and 0
     */
    /*
    Find index of first character from the end
     */
    while(rearPointer > 0){
      if(str[rearPointer] != ' '){
        break;
      }
      rearPointer--;
    }
    //Now rear pointer is at the first character from the left
    /*
    Begin inspection
     */
    while(curPointer < rearPointer
        && rearPointer < str.length){
      if(str[curPointer] == ' '){
        /*
        This necessitates replacement to %20
         */
        // First we need to create space for 2 and 0
        // so essentially we shift all elements to the right by two plcase starting from the
        // end
        int shifterPointer = rearPointer;
        while(shifterPointer > curPointer){
          /*
          Shift begins
           */
          str[shifterPointer + 2] = str[shifterPointer];
          /*
          decrement
           */
          shifterPointer--;
        }
        rearPointer +=2;
        //Add this point all the elements on the right of current element have been shifted by 2
        //Now replace easily
        str[curPointer] = '%';
        str[curPointer+1] = '2';
        str[curPointer+2] = '0';
        curPointer += 1;
      }
      //next
      curPointer++;
    }
    return str;
  }

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    char[] str = new char[]{'M','R',' ','B','R','O','W','N',' ',' ',' ',' ','i','s',' ','n','a','m','e',' ',
        ' ',' ',' ',' ',' ',
        ' ',' ',' ',' ',
        ' ',' ',' ',' ',
        ' ',' ',' ',' '};
    char[] replaced = replaceSpacesWithPercent20(str);
    System.out.println(String.valueOf(replaced));
    str = new char[]{'M','R',' ','B','R','O','W','N',' ',' ',' ',' ','i','s',' ','n','a','m','e',' ',
        ' ',' ',' ',' ',' ',
        ' ',' ',' ',' ',
        ' ',' ',' ',' ',
        ' ',' ',' ',' '};
    replaced = replaceSpacesWithPercent20Alternate(str,19);
    System.out.println(String.valueOf(replaced));
  }
}
