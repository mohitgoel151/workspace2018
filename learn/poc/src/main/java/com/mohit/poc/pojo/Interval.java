package com.mohit.poc.pojo;

public class Interval {

    private int start;
    private int end;

    public Interval(int st, int ed) {
        start = st;
        end = ed;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Interval [start=" + start + ", end=" + end + "]";
    }

}
