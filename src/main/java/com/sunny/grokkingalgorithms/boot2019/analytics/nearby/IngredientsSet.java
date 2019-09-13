package com.sunny.grokkingalgorithms.boot2019.analytics.nearby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
/**
 * Business class that consists of a business name and a hashmap of nearby businesses.
 */
class Business {
    /**
     * The name of the business.
     */
    String name;

    /**
     * A Map of nearbyBusinesses where the key is the nearby Business object
     * and the value is distance from the current Business to the nearby Business.
     */
    Map<Business, Integer> nearbyBusinesses;

    public Business(String name) {
        this.name = name;
        this.nearbyBusinesses = new HashMap<Business, Integer>();
    }

    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return "Business{" +
                "name='" + name + '\'' +
                ", nearbyBusinesses=" + nearbyBusinesses +
                '}';
    }

    public Map<Business, Integer> getNearbyBusinesses() {
        return this.nearbyBusinesses;
    }
}


class Solution {
    public static List<String> findReachableBusinesses(Business startingBusiness, int distance) {
        startingBusiness.name = "X";
        return findNearbyRecursive(startingBusiness,distance);
    }

    public static List<String> findNearbyRecursive(Business nearby,int distance){
        if (distance < 0 || nearby == null) {
            return new ArrayList<>();
        }
        List<String> finalReachableBusinesses = new ArrayList<>();
        Iterator<Map.Entry<Business, Integer>> iterator = nearby.getNearbyBusinesses().entrySet().iterator();
        while(iterator.hasNext()){
            Map.Entry<Business,Integer> businessIntegerEntry = iterator.next();
            List<String> reachableBusinnesses = findNearbyRecursive(businessIntegerEntry.getKey(),distance - businessIntegerEntry.getValue());
            if(!reachableBusinnesses.isEmpty()){
                finalReachableBusinesses.addAll(reachableBusinnesses);
            }
        }
        if(finalReachableBusinesses != null && !nearby.getName().equals("X")){
            finalReachableBusinesses.add(nearby.getName());
        }
        return finalReachableBusinesses;

    }

}
public class IngredientsSet {


    public static void main(String[] args) {
        List<String> ings = new ArrayList<>();
        ings.add("chips");
        ings.add("salsa");
        List<String> ing1 = new ArrayList<>();
        ing1.add("chips");
        ing1.add("salsa");
        List<String> ing2 = new ArrayList<>();
        ing2.add("salsa");
        ing2.add("chips");
        Set<List<String>> listSet = new HashSet<>();
        listSet.add(ings);
        listSet.add(ing1);
        listSet.add(ing2);
        System.out.println(listSet);
        Business udupi = new Business("udupi");
        Map<Business,Integer> nearby = new LinkedHashMap<>();
        Business infinitea = new Business("infinitea");
        Map<Business,Integer> nearby1 = new LinkedHashMap<>();
        Business chaipoint = new Business("chaipoint");
        Map<Business,Integer> nearby2 = new LinkedHashMap<>();
        Business smokeHouseDeli = new Business("smokehousedeli");
        Map<Business,Integer> nearby3 = new LinkedHashMap<>();
        nearby.put(chaipoint,2);
        nearby.put(infinitea,4);
        nearby2.put(smokeHouseDeli,3);
        udupi.nearbyBusinesses = nearby;
        chaipoint.nearbyBusinesses = nearby2;
        smokeHouseDeli.nearbyBusinesses = nearby3;
        infinitea.nearbyBusinesses = nearby1;
        System.out.println(udupi);
        System.out.println(Solution.findReachableBusinesses(udupi,7));
        System.out.println(Solution.findReachableBusinesses(udupi,2));
        System.out.println(Solution.findReachableBusinesses(udupi,4));
        System.out.println(Solution.findReachableBusinesses(chaipoint,4));
    }
}