package com.sunny.grokkingalgorithms.boot2019.twize;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.net.URI;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseDomainnameFromStrings {


    public static String getPotentialDomainNames(List<String> lines){
        List<String> domainNames = new ArrayList<>();
        String regex = "(http://|https://)(.*)(/.*)";
        Pattern pattern = Pattern.compile(regex);
        for(String line: lines){
            Matcher matcher = pattern.matcher(line);
            while(matcher.find()){
                domainNames.add(matcher.group(2));
            }
        }
        Collections.sort(domainNames);
        return getDomainNames(domainNames);
    }

    public static String getDomainNames(List<String> domainNames){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0 ; i < domainNames.size() ; i++){
            stringBuilder.append(domainNames.get(i));
            if(i != (domainNames.size() - 1)) {
                stringBuilder.append(";");
            }
        }
        return stringBuilder.toString();
    }

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
        List<String> lines = new ArrayList<>();
        lines.add("adaadasdsadqajdladjhttps://sunny.com/test");
        lines.add("hello world");
        lines.add("http://test.com/use");
        System.out.println(getPotentialDomainNames(lines));
    }

}
