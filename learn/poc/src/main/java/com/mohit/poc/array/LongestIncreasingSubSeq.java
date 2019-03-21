package com.mohit.poc.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import javax.management.RuntimeErrorException;

import com.mohit.poc.pojo.PersonHeightWeight;

/**
 * A circus is designing a tower routine consisting of people standing atop one another's shoulders. For
 * practical and aesthetic reasons, each person must be both shorter and lighter than the person below him or
 * her. Given the heights and weights of each person in the circus, write a method to compute the largest
 * possible number of people in such a tower.
 * 
 * @author mmt6413
 *
 */

public class LongestIncreasingSubSeq {

    public void execute() {
        List<PersonHeightWeight> input = new ArrayList<>();
        input.add(new PersonHeightWeight(0, 40, 100));
        
        
        
        
        List<PersonHeightWeight> result = getLongestSeq(input);
        result.stream().forEach(System.out::println);
        
    }

    private List<PersonHeightWeight> getLongestSeq(List<PersonHeightWeight> input) {
        
        if(input == null || input.size() == 0) {
            throw new RuntimeException("Invalid input");
        }
        
        Collections.sort(input, new Comparator<PersonHeightWeight>() {

            @Override
            public int compare(PersonHeightWeight o1, PersonHeightWeight o2) {
                if(o1.getWeight() > o2.getWeight()) {
                    return 1;
                }
                return 0;
            }
            
        });
        
        List<PersonHeightWeight> result = new ArrayList<>();
        
        List<List<PersonHeightWeight>> temp = new ArrayList<>();
        for (int i = 0; i <= input.size(); i++) { //TODO for improvement
            temp.add(i, new ArrayList<>()); 
        }
        
        for (PersonHeightWeight currentPerson : input) {
            //check how this person can be used in existing sub seq
            
            for(int j = 1; ; j++) {
                List<PersonHeightWeight> tempList = temp.get(j);
                
//                if((temp.isEmpty()) || (currentPerson.getHeight() < tempList.get(tempList.size() - 1).getHeight())) {
//                    List<PersonHeightWeight> cloned = temp.get(j-1).stream().map(d -> d.clone()).collect(ArrayList::new);//.clone();
//                    cloned.add(currentPerson);
//                    temp.set(j, cloned);
//                } else if (currentPerson.getHeight() == tempList.get(tempList.size() - 1).getHeight() && currentPerson.getId() == tempList.get(tempList.size() - 1).getId()) {
//                    //skip
//                    break;
//                }
//                else {
//                    List<PersonHeightWeight> cloned = temp.get(j).stream().map(d -> d.clone()).collect(ArrayList::new);
//                    cloned.add(currentPerson);
//                    temp.set(j + 1, cloned);
//                }
                
                
                
                
            }
            
            
            
            
            
            
            
        }
        
        
        
        
        return result;
    }
    
    
    

}
