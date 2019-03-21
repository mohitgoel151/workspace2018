package com.mohit.poc.tree.m_way;

import java.util.List;

public class MWayTreeNode {

    private char value;
    private List<MWayTreeNode> children;

    public MWayTreeNode(char c) {
        value = c;
    }

    public char getValue() {
        return value;
    }

    public void setValue(char value) {
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
