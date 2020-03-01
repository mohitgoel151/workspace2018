package com.mohit.poc.topological_sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * 
 * https://leetcode.com/problems/course-schedule-ii/
 * 
 * 
 * There are a total of n courses you have to take, labeled from 0 to n-1. 
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
 * which is expressed as a pair: [0,1]. 
 * 
 * Given the total number of courses and a list of prerequisite pairs, 
 * return the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. 
 * If it is impossible to finish all courses, return an empty array.
 *
 */
public class CourseScheduleDFS {
    
    public void execute() {
        
        System.out.println(findOrder(2, new int[][] {})); // 0,1 || 1,0
        
        System.out.println(findOrder(2, new int[][] {{1,0}})); // 0,1
        
        System.out.println(findOrder(3, new int[][] {{1,0}})); // 2,0,1
        
        System.out.println(findOrder(2, new int[][] {{1,0}, {0,1}})); // Empty list because of cyclic dependency
        
//      1    2   4
//              / \
//             3   0
//              \ / \
//               5   7
//                \ /
//                 6
//                 |
//                 8  

        System.out.println(findOrder(9, new int[][] {
            {4, 3}, {4, 0},
            {3, 5}, {0, 5},{0,7},
            {5, 6}, {7, 6}, {6,8}
        })); 
        //1, 2, 8, 6, 5, 7, 0, 3, 4
    }
    
    public List<Integer> findOrder(int numCourses, int[][] prerequisites) {
        
        if(numCourses < 0 || prerequisites == null) {
            throw new IllegalArgumentException("");
        }
        
        Map<Integer, Set<Integer>> dependencyMap = new HashMap<>();
        
        for(int[] prerequisite : prerequisites) {
            Set<Integer> coursePrerequisite = dependencyMap.get(prerequisite[0]);
            if(coursePrerequisite == null) {
                coursePrerequisite = new HashSet<>();
                dependencyMap.put(prerequisite[0], coursePrerequisite);
            }
            coursePrerequisite.add(prerequisite[1]);
        }
        
        Set<Integer> traversed = new HashSet<>();
        
        List<Integer> result = new ArrayList<>();
        
        try {
            for(Map.Entry<Integer, Set<Integer>> entry : dependencyMap.entrySet()) {
                List<Integer> dependency = getDependencies(entry.getKey(), dependencyMap, traversed, new HashSet<Integer>());
                result.addAll(dependency);
            } 
        } catch (RuntimeException e) {
            return Collections.emptyList();
        }
        
        //Add items which doesn't have any dependencies
        List<Integer> tempResult = new ArrayList<>();
        
        for(int index = 0; index < numCourses; index++) {
            if(!traversed.contains(index)) {
                tempResult.add(index);
            }
        }
        tempResult.addAll(result);
        return tempResult;
    }
    
    private List<Integer> getDependencies(int courseId, Map<Integer, Set<Integer>> dependencyMap, Set<Integer> traversed, Set<Integer> inPath) {
        
        if(traversed.contains(courseId)) {
            return Collections.emptyList();
        }
        
        if(inPath.contains(courseId)) {
            throw new RuntimeException("cyclic dependency");
        }
        
        List<Integer> result = new ArrayList<>();

        
        Set<Integer> courseDependecies = dependencyMap.get(courseId);
        
        if(courseDependecies != null) {
            inPath.add(courseId);
            
            for(int dependency : courseDependecies) {
                
                List<Integer> dep = getDependencies(dependency, dependencyMap, traversed, inPath);
                result.addAll(dep);
                
            }
            inPath.remove(courseId);
        }
        
        traversed.add(courseId);
        result.add(courseId);
        return result;
    }

}
