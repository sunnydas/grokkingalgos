package com.sunny.grokkingalgorithms.java;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * Created by sundas on 6/11/2017.
 */
public class PrintClassLoaderHierarchy {

  /**
   *
   * @param args
   */
  public static void main(String[] args) {
    URLClassLoader urlClassLoader = (URLClassLoader) ClassLoader.getSystemClassLoader();
    while(urlClassLoader != null){
      System.out.println(urlClassLoader.getClass());
      URL[] urls = urlClassLoader.getURLs();
      for(URL url : urls){
        System.out.println(url);
      }
      urlClassLoader = (URLClassLoader) urlClassLoader.getParent();
      System.out.println("-----------------------------------------------");
    }
  }

}
