package com.mohit.poc.tree.m_way;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * Refer approach 3 ..... which has smallest serialized string
 *
 */
public class SerializedDserialTree2 {
    public static void main(String[] args) {
    	SerializedDserialTree2Sol obj = new SerializedDserialTree2Sol();
        obj.execute();
    }
}

class SerializedDserialTree2Sol {
    
    /**
     *                          A
     *                         / \
     *                        B   C
     *                          / / \ \
     *                         D E  F  G
     *                         | |    /|\
     *                         H I   J K L
     *                                 |
     *                                 M
     *                                 
     *   A(B()C(D(H())E(I())F()G(J()K(M())L()))) 
     */
    public void execute() {
        
        MWayTreeNode root = MWayTreeHelper.getSampleStringTree();
        
        String serializedTree = serailize(root);
        assertEquals(serializedTree, "aa4aa(b()c(dd4dd(hh4hh())e(i())f()g(j()k(m())ll4ll())))".toLowerCase());
        
        MWayTreeNode newRoot = deserial(serializedTree);
        assertEquals(root.getValue(), newRoot.getValue());
        
        System.out.println("all test cases passed " + this.getClass().getSimpleName());
    }
    
    public String serailize(MWayTreeNode node) {
        
        if(node == null) {
            throw new IllegalArgumentException("");
        }
        
        StringBuffer buffer = new StringBuffer();
        makeString(node, buffer);
        
        return buffer.toString();
    }
    
    /**
     * Embed child sub tree in '(' ')' 
     * @param node
     * @param buffer
     */
    private void makeString(MWayTreeNode node, StringBuffer buffer) {
        
        buffer.append(node.getValue());
        if(node.getChildren() != null && node.getChildren().size() > 0) {
            buffer.append("(");
            for(MWayTreeNode child : node.getChildren()) {
                makeString(child, buffer);
            }
            buffer.append(")");
        } else {
            buffer.append("()");
        }
    }
    
    private MWayTreeNode deserial(String input) {
        if(input == null || input.length() == 0) {
            return null;
        }
        
        String rootNodeValue = getNodeValue(input, 0);
        MWayTreeNode root = new MWayTreeNode(rootNodeValue);
        
        String childTreeSubstring = input.substring(rootNodeValue.length() + 1, input.length() - 1); //Removing start and end braces
        List<MWayTreeNode> children = buildChild(childTreeSubstring);
        root.setChildren(children);
        
        return root;
    }
    
    private List<MWayTreeNode> buildChild(String input) {
       
        if(input == null || input.length() == 0) {
            return null;
        }
        
        List<MWayTreeNode> children = new ArrayList<>();
        
        for(int index = 0; index < input.length(); index++) {
            
            String nodeValue = getNodeValue(input, index);
            
            MWayTreeNode aNode = new MWayTreeNode(nodeValue);
            String childString = getChildString(input.substring(index + nodeValue.length()));
            aNode.setChildren(buildChild(childString));
            index += nodeValue.length() + childString.length() + 1;
            
            children.add(aNode);
        }
        
        
        return children; 
    }
     
    private String getNodeValue(String input, int start) {
        
        for(int index = start; index < input.length(); index++) {
            if(input.charAt(index) == '(') {
                return input.substring(start, index);
            }
        }
        return input;
    }
    
    /**
     *  Find substring for child tree by maintaining count of open-close braces 
     */
    private String getChildString(String input) {
        
        if(input == null || input.length() == 0) {
            return "";
        }
        
        int openBraces = 0;
        
        int index = 0;
        for(; index < input.length(); index++) {  //First char of string should be '('
            if(input.charAt(index) == '(') {
                openBraces++;
            } else if (input.charAt(index) == ')') {
                openBraces--;
            }
            if(openBraces == 0) {
                break;
            }
        }
        
        return input.substring(1, index);
    }

}
