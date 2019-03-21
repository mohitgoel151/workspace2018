package com.mohit.poc.pojo;

public class PersonHeightWeight {

    private int id;
    private int height;
    private int weight;

    public PersonHeightWeight(int id, int h, int w) {
        this.id = id;
        this.height = h;
        this.weight = w;
    }

    public int getId() {
        return id;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }
    
    public PersonHeightWeight clone() {
        return new PersonHeightWeight(id, height, weight);
    }

    @Override
    public String toString() {
        return "PersonHeightWeight [id=" + id + ", height=" + height + ", weight=" + weight + "]";
    }

}
