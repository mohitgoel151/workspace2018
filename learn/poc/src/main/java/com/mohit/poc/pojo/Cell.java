package com.mohit.poc.pojo;

public class Cell {

    public Cell(int row, int column, int value) {
        super();
        this.row = row;
        this.column = column;
        this.value = value;
    }

    private int row;
    private int column = 0;
    private int value;

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Cell [row=" + row + ", column=" + column + ", value=" + value + "]";
    }

}
