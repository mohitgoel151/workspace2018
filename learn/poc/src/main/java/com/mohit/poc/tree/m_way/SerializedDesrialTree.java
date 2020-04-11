package com.mohit.poc.tree.m_way;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * Refer approach 3 ..... which has smallest serialized string
 *
 */
public class SerializedDesrialTree {
	
    public static void main(String[] args) {
    	SerializedDesrialTreeSol obj = new SerializedDesrialTreeSol();
        obj.execute();
    }
}

class SerializedDesrialTreeSol {
    
    public void execute() {
        MWayTreeNode root = MWayTreeHelper.getSampleTree();
     
        String serializedValue = serialize(root);
        System.out.println(serializedValue);
        
        MWayTreeNode deserialRootNode = deserialize(serializedValue);
        
        String serializedValue2 = serialize(deserialRootNode);
        System.out.println(serializedValue2);
        
    }
    
    private String serialize(MWayTreeNode root) {
        
        StringBuilder builder = new StringBuilder();
        
        Queue<MWayTreeNode> queue = new LinkedList<>();
        queue.add(root);
        
        while(!queue.isEmpty()) {
            MWayTreeNode node = queue.poll();
            builder.append(node.getValue());
            
            if(node.getChildren() != null && node.getChildren().size() > 0) {
                builder.append(node.getChildren().size());
                for (MWayTreeNode child : node.getChildren()) {
                    queue.add(child);
                }
            } else {
                builder.append("0");
            }
        }
        
        return builder.toString();
    }
    
    private MWayTreeNode deserialize(String input) {
        //validation
        
        int index = 0;
        Queue<MWayTreeNode> queue = new LinkedList<>();
        Queue<Integer> ccq = new LinkedList<>(); //child Count Queue
        
        MWayTreeNode root = new MWayTreeNode(input.charAt(index++));
        
        queue.add(root);
        ccq.add(Integer.parseInt(String.valueOf(input.charAt(index++)))); //Assuming node's child count < 10 (taking single digit)
        
        while(!queue.isEmpty()) {
            MWayTreeNode n = queue.poll();
            int children = ccq.poll();
            
            if(children > 0) {
                
                n.setChildren(new ArrayList<>(children));
                for(int i = 0; i < children; i++) {
                
                    MWayTreeNode cNode = new MWayTreeNode(input.charAt(index++));
                    int cNodeChild = Integer.parseInt(String.valueOf(input.charAt(index++))); //Assuming node's child count < 10 (taking single digit)
                    n.getChildren().add(cNode);
                    
                    queue.add(cNode);
                    ccq.add(cNodeChild);
                }
            }
        }
        return root;
    }

}
