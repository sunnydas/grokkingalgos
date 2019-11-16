package com.sunny.grokkingalgorithms.boot2019.eft;

import java.util.Collections;
import java.util.ArrayList;

class Main {

    public static class ChargePlan {

        private final int powerkWh;
        private final int priceEuroPerkWh;

        public ChargePlan(int powerkWh, int priceEuroPerkWh) {
            this.powerkWh = powerkWh;
            this.priceEuroPerkWh = priceEuroPerkWh;
        }

        public int getPowerkWh() {
            return powerkWh;
        }

        public int getPriceEuroPerkWh() {
            return priceEuroPerkWh;
        }

        @Override
        public String toString() {
            return "charge " + getPowerkWh() + "kWh at price " + getPriceEuroPerkWh() + "€/kWh";
        }
    }

    public static void main(String[] args) {

        final ArrayList<Integer> hourlyPrices = new ArrayList<>();
        hourlyPrices.add(13);
        hourlyPrices.add(10);
        hourlyPrices.add(8);
        hourlyPrices.add(10);
        hourlyPrices.add(8);
        hourlyPrices.add(10);
        hourlyPrices.add(11);
        hourlyPrices.add(15);

        System.out.println("scenario number 1:");
        for (ChargePlan cp : calculateChargePlan(4, 40, 10, 32, hourlyPrices)) {
            System.out.println(cp);
        }

        System.out.println("scenario number 2:");
        for (ChargePlan cp : calculateChargePlan(5, 40, 30, 40, hourlyPrices)) {
            System.out.println(cp);
        }

        System.out.println("scenario number 3:");
        for (ChargePlan cp : calculateChargePlan(4, 40, 38, 40, hourlyPrices)) {
            System.out.println(cp);
        }
        int a = 1;
        int b = 2;
        if ( a <= b && a >= b && a != b ) {
            System.out.println("success");
        }
        boolean c = false;
        do{
            System.out.println("here");
        }while(c = !c);
    }

    public static ArrayList<ChargePlan> calculateChargePlan(int chargerPower,
                                                            int batteryMaxEnergy,
                                                            int batteryActualEnergy,
                                                            int batteryRequiredEnergy,
                                                            ArrayList<Integer> energyPrices) {
        ArrayList<ChargePlan> chargePlanList = new ArrayList<>();
        Collections.sort(energyPrices);
        //System.out.println(energyPrices);
        for(int i = 0; i < energyPrices.size() ; i++){
            if(batteryActualEnergy >= batteryRequiredEnergy){
                break;
            } else{
                int currentPowerPossible = Math.min(chargerPower,batteryMaxEnergy - batteryActualEnergy);
                int currentPrice = energyPrices.get(i)*currentPowerPossible;
                batteryActualEnergy += currentPowerPossible;
                ChargePlan chargePlan = new ChargePlan(currentPowerPossible,currentPrice);
                chargePlanList.add(chargePlan);
            }
        }
        return chargePlanList;
    }
}
