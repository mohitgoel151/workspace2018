package com.mohit.skyscanner;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class CommonManagerSolution {
    
    static class TreeNode {
        /**
         * Making it public to save space of getter/setter
         */
        public String name;
        public TreeNode leftNode;
        public TreeNode rightNode;
        public TreeNode parentNode;

        TreeNode(String employeename) {
            this.name = employeename;
        }
        
    }
    
    static void OutputCommonManager(int count, Scanner in) {
        List<String> inputList = new ArrayList<>();

        while (in.hasNext()) {
            inputList.add(in.nextLine());
        }
        getCommom(inputList);
    }
    
    /**
     * Prints out the lowest common manager
     * @param inputList
     */
    static void getCommom(List<String> inputList) {

        // start making nodes from list index >= 2
        
        Map<String, TreeNode> employees = makeMap(inputList);
        TreeNode empOne = employees.get(inputList.get(0));
        TreeNode empTwo = employees.get(inputList.get(1));
        
        List<String> topToEmpOne = getTopToEmployeeHirerchy(empOne);
        List<String> topToEmpTwo = getTopToEmployeeHirerchy(empTwo);
        
        int minLength = (topToEmpOne.size() > topToEmpTwo.size()) ? topToEmpTwo.size() : topToEmpOne.size();
        
        int resultIndex = 0;
        for(int i=0; i< minLength; i++) {
            String nameOne = topToEmpOne.get(i);
            String nameTwo = topToEmpTwo.get(i);
            
            if(nameOne.equalsIgnoreCase(nameTwo) && (nameOne.equals(inputList.get(0)) == false) && 
                    (nameOne.equals(inputList.get(1)) == false)) {
                resultIndex = i;
                continue;
            } else if (nameOne.equalsIgnoreCase(nameTwo) == false) {
                resultIndex = i - 1;
                break;
            } else {
                resultIndex = i;
                break;
            }
            
        }
        System.out.println(topToEmpOne.get(resultIndex));

    }
    
    /**
     * This method will return list of employee names starting from top till that employee
     * @param employeeNode
     * @return
     */
    private static List<String> getTopToEmployeeHirerchy(TreeNode employeeNode) {
        List<String> hirerchy = new ArrayList<>();
        
        //while(employeeNode.parentNode != null) {
        while(employeeNode != null) {
            hirerchy.add(employeeNode.name);
            employeeNode = employeeNode.parentNode;
        }
        Collections.reverse(hirerchy);
        return hirerchy;
    }
    
    /**
     * This method will take input list and make Tree node and dependency between them.
     * @param inputList list of names
     * @return map of employee name versus its node having parent child dependency
     */
    private static Map<String, TreeNode> makeMap(List<String> inputList) {
        Map<String, TreeNode> employees = new HashMap<>();

        String[] mapping;
        String manager;
        String subordinate;
        TreeNode managerNode;
        TreeNode subordinateNode;
        for (int i = 2; i < inputList.size(); i++) {
            mapping = inputList.get(i).split("\\ ");

            manager = mapping[0];
            subordinate = mapping[1];

            managerNode = employees.get(manager);
            subordinateNode = employees.get(subordinate);

            if (managerNode == null) {
                managerNode = new TreeNode(manager);
                employees.put(manager, managerNode);
            }

            if (subordinateNode == null) {
                subordinateNode = new TreeNode(subordinate);
                employees.put(subordinate, subordinateNode);
            }
            subordinateNode.parentNode = managerNode;

            if (managerNode.leftNode == null) {
                managerNode.leftNode = subordinateNode;
            } else {
                managerNode.rightNode = subordinateNode;
            }
        }
        return employees;
    }

    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int _count;
        _count = Integer.parseInt(in.nextLine());

        OutputCommonManager(_count, in);
//        List<String> inputList = Arrays.asList("H", "S", "S P", "S F", "F J", "F H", "J J1");
//        getCommom(inputList);
    }

}
