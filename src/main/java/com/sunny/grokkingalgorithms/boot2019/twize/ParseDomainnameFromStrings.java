package com.sunny.grokkingalgorithms.boot2019.twize;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.net.URI;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseDomainnameFromStrings {

    public static void main(String[] args) {
        String urlString = "https://www.example.domain.com/tester?query=5&query1=78";
        URI uri = URI.create(urlString);
        System.out.println(uri.getHost());
        String regex = "(http:|https://)(.*)(/.*)";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(urlString);
        while(matcher.find()){
            System.out.println(matcher.group(2));
        }
    }

}
