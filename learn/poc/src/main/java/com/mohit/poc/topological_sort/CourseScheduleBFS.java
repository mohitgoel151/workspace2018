package com.mohit.poc.topological_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


/**
 * 
 * Approach 2
 * https://leetcode.com/articles/course-schedule-ii/
 *
 */
public class CourseScheduleBFS {
    
    public void execute() {
        
        System.out.println(findOrder(2, new int[][] {})); // 0,1 || 1,0
        
        System.out.println(findOrder(2, new int[][] {{1,0}})); // 0,1  // 1 is dependent on 0. Therefore 0 has to be done first
        
        System.out.println(findOrder(3, new int[][] {{1,0}})); // 0,2,1 (2 can come any where but 1 will come after 0)
        
        System.out.println(findOrder(2, new int[][] {{1,0}, {0,1}})); // Empty list because of cyclic dependency
        
        
//                     1    2   4
//                             / \
//                            3   0
//                             \ / \
//                              5   7
//                               \ /
//                                6
//                                |
//                                8  
        
        System.out.println(findOrder(9, new int[][] {
            {4, 3}, {4, 0},
            {3, 5}, {0, 5},{0,7},
            {5, 6}, {7, 6}, {6,8}
        })); 
        // 1,2, 8,6,5,7,3,0,4
        
    }
    
    public List<Integer> findOrder(int numCourses, int[][] prerequisites) {
        
        if(numCourses < 0 || prerequisites == null) {
            throw new IllegalArgumentException("");
        }
        
        Map<Integer, Set<Integer>> dependenciesMap = new HashMap<>();  // key task is to be completed before value tasks (values are dependent on keys)
        Map<Integer, Set<Integer>> pendingDependenciesMap = new HashMap<>(); //key task will be done after all value tasks (key is dependent on values)
        
        for(int index = 0; index < numCourses; index++) {
            dependenciesMap.put(index, new HashSet<>());
            pendingDependenciesMap.put(index, new HashSet<>());
        }
        
        //Map incoming edges
        for(int[] prerequisite : prerequisites) {
            Set<Integer> dependency = dependenciesMap.get(prerequisite[1]);
            dependency.add(prerequisite[0]);
            
            Set<Integer> pendingDependency = pendingDependenciesMap.get(prerequisite[0]);
            pendingDependency.add(prerequisite[1]);
        }
        
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> completedDependencies = new HashSet<>();
        
        //Add all nodes which doesn't have any dependency
        for(Map.Entry<Integer, Set<Integer>> entry : pendingDependenciesMap.entrySet()) {
            if(entry.getValue().size() == 0) {
                queue.add(entry.getKey());
            }
        }
        
        while(!queue.isEmpty()) {
            Integer course = queue.poll();
            Set<Integer> dependencies = dependenciesMap.get(course);
            
            for(Integer dependency : dependencies) {
                if(completedDependencies.contains(dependency)) { //cyclic dependency
                    return Collections.emptyList();
                }
                
                pendingDependenciesMap.get(dependency).remove(course);
                if(pendingDependenciesMap.get(dependency).size() == 0) {  // If all dependent tasks are done .. add to queue 
                    queue.add(dependency);
                }
            }
            completedDependencies.add(course);
            result.add(course);
        }
        return result;
    }

}
