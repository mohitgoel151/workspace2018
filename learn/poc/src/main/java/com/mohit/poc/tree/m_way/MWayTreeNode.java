package com.mohit.poc.tree.m_way;

import java.util.List;

public class MWayTreeNode {

    private String value;
    private List<MWayTreeNode> children;

    public MWayTreeNode(String c) {
        value = c;
    }
    
    public MWayTreeNode(char c) {
        this(c + "");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public List<MWayTreeNode> getChildren() {
        return children;
    }

    public void setChildren(List<MWayTreeNode> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "MWayTreeNode [value=" + value + ", children=" + children + "]";
    }

}
