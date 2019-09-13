package com.sunny.grokkingalgorithms.boot2019.analytics;

import java.io.*;
import java.util.*;

public class AverageLatencyFinder {

    /*
    Given a log file with API names, start and end timestamps, write a program that prints the average latency for each API call.

$ cat log

get_foo start 2222222100

get_foo end 2222222150

get_bar start 2222222200

get_foo start 2222222220

get_bar end 2222222230

get_foo end 2222222250

solution : $ cat log | myprog

get_foo: average = 40 get_bar: average = 30
     */

    public static void findAverageLatencyForAPIs(String apiFileName){
        if(apiFileName != null && !apiFileName.trim().equalsIgnoreCase("")){
            File apiFile = new File(apiFileName);
            FileReader fileReader = null;
            BufferedReader bufferedReader = null;
            Map<String, List<Long>> apiToLatenciesMap = new HashMap<>();
            try{
                fileReader = new FileReader(apiFile);
                bufferedReader = new BufferedReader(fileReader);
                String line = null;
                parseLatencyData(bufferedReader, apiToLatenciesMap);
                if(!apiToLatenciesMap.isEmpty()){
                    printAverageLatencies(apiToLatenciesMap);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                close(fileReader);
                close(bufferedReader);
            }
        }
    }

    private static void parseLatencyData(BufferedReader bufferedReader, Map<String, List<Long>> apiToLatenciesMap) throws IOException {
        String line;
        while((line = bufferedReader.readLine()) != null){
            String[] splitted = line.split("\\s+");
            if(splitted != null && splitted.length == 3){
                String apiName = splitted[0];
                String timeToken = splitted[1];
                String ts = splitted[2];
                if(apiToLatenciesMap.containsKey(apiName)){
                    apiToLatenciesMap.get(apiName).add(Long.parseLong(ts));
                } else{
                    List<Long> latenciesList = new LinkedList<>();
                    latenciesList.add(Long.parseLong(ts));
                    apiToLatenciesMap.put(apiName,latenciesList);
                }
            }
        }
    }

    private static void printAverageLatencies(Map<String,List<Long>> apiToLatenciesMap){
        Iterator<Map.Entry<String,List<Long>>> iterator = apiToLatenciesMap.entrySet().iterator();
        Map.Entry<String,List<Long>> entry = null;
        while(iterator.hasNext()){
            entry = iterator.next();
            String apiName = entry.getKey();
            List<Long> latencies = entry.getValue();
            System.out.println("api = " + apiName + " avg latency = " + getAverageLatency(latencies));
        }
    }

    private static long getAverageLatency(List<Long> latencies){
        long averageLatency = 0;
        if(latencies != null && !latencies.isEmpty()) {
            List<Long> actualLatencyList = computeActualLatencies(latencies);
            long sum = getSum(actualLatencyList);
            averageLatency = getAverage(actualLatencyList, sum);
        }
        return averageLatency;
    }

    private static List<Long> computeActualLatencies(List<Long> latencies) {
        // Diff the pairs
        List<Long> actualLatencyList = new LinkedList<>();
        for(int i = 1; i < latencies.size() ; i=i+2){
            actualLatencyList.add(latencies.get(i) - latencies.get(i - 1));
        }
        return actualLatencyList;
    }

    private static long getAverage(List<Long> actualLatencyList, long sum) {
        long averageLatency = 0;
        if(actualLatencyList.size() > 0) {
            averageLatency = sum / actualLatencyList.size();
        }
        return averageLatency;
    }

    private static long getSum(List<Long> actualLatencyList) {
        long sum = 0;
        for(int i = 0 ; i < actualLatencyList.size() ; i++){
            sum += actualLatencyList.get(i);
        }
        return sum;
    }

    private static void close(Reader fileReader) {
        try {
            fileReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        findAverageLatencyForAPIs("latencies.txt");
    }

}
