package com.mohit.poc.set.disjoint;

import java.util.LinkedList;
import java.util.List;

public class DSetNode<T> {

    private T value;
    private DSetNode<T> parent;
    private List<DSetNode<T>> children;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public DSetNode<T> getParent() {
        return parent;
    }

    public void setParent(DSetNode<T> parent) {
        this.parent = parent;
    }

    public List<DSetNode<T>> getChildren() {
        return children;
    }

    public void setChildren(List<DSetNode<T>> children) {
        this.children = children;
    }

    public void addChildren(DSetNode<T> child) {
        if (children == null) {
            children = new LinkedList<DSetNode<T>>();
        }
        children.add(child);
    }

    @Override
    public String toString() {
        return "DSetNode [value=" + value + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((value == null) ? 0 : value.hashCode());
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
        DSetNode other = (DSetNode) obj;
        if (value == null) {
            if (other.value != null)
                return false;
        } else if (!value.equals(other.value))
            return false;
        return true;
    }

    
}
