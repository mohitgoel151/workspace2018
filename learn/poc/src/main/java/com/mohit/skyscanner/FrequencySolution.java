package com.mohit.skyscanner;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class FrequencySolution {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = Integer.parseInt(scanner.nextLine());
        OutputMostPopularDestination(count, scanner);
    }
    
    static void OutputMostPopularDestination(int count, Scanner in) {
        Map<String, Integer> countryMapCount = new HashMap<>();
        String maxFrequencyCountry = "";
        int maxCount = 0;

        String countryName;
        Integer frequency;
        Integer updatedValue;
        for (int i = 0; i < count; i++) {
            
            countryName = in.nextLine();
            frequency = countryMapCount.get(countryName);
            
            if(frequency == null) {
                updatedValue = 1;
            } else {
                updatedValue = frequency + 1;
            }
            countryMapCount.put(countryName, updatedValue);
            
            if (updatedValue > maxCount) {
                maxFrequencyCountry = countryName;
                maxCount = updatedValue;
            }
        }

        System.out.println(maxFrequencyCountry);

    }

}
