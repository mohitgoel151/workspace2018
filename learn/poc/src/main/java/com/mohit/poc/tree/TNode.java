package com.mohit.poc.tree;

public class TNode {

    public int value;
    public TNode leftNode;
    public TNode rightNode;

    public TNode(int val) {
        value = val;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public TNode getLeftNode() {
        return leftNode;
    }

    public void setLeftNode(TNode leftNode) {
        this.leftNode = leftNode;
    }

    public TNode getRightNode() {
        return rightNode;
    }

    public void setRightNode(TNode rightNode) {
        this.rightNode = rightNode;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + value;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TNode other = (TNode) obj;
        if (value != other.value)
            return false;
        return true;
    }

}
