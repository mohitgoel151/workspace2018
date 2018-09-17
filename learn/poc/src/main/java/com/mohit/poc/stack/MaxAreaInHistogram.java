package com.mohit.poc.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import com.mohit.models.Point;

import junit.framework.Assert;

public class MaxAreaInHistogram {

    public void test() {
        List<Point> pointsList = new ArrayList<>();

        pointsList.add(new Point(0, 0));
        pointsList.add(new Point(1, 2));
        pointsList.add(new Point(2, 3));
        pointsList.add(new Point(3, 4));
        pointsList.add(new Point(4, 3));
        pointsList.add(new Point(5, 1));
        pointsList.add(new Point(6, 0));

        pointsList.add(new Point(7, 5));
        pointsList.add(new Point(8, 5));
        pointsList.add(new Point(9, 0));

        Assert.assertEquals(10, getMaxHistogramArea(pointsList));

    }

    public int getMaxHistogramArea(List<Point> pointsList) {

        if (pointsList == null || pointsList.size() == 0) {
            throw new RuntimeException("Null or empty list provided");
        }

        int maxArea = 0;
        int tempArea;
        Point tempPoint;
        Stack<Point> stack = new Stack<>();
        pointsList.add(new Point(pointsList.get(pointsList.size() - 1).getX() + 1, 0));

        for (Point point : pointsList) {
            if (stack.isEmpty()) {
                stack.push(point);
            }

            if (stack.peek().getY() < point.getY()) {
                stack.push(point);
            } else if (stack.peek().getY() > point.getY()) {
                while (stack.size() > 0 && stack.peek().getY() > point.getY()) {
                    tempPoint = stack.pop();
                    tempArea = (point.getX() - tempPoint.getX()) * tempPoint.getY();
                    maxArea = (tempArea > maxArea) ? tempArea : maxArea;
                }
                if (stack.isEmpty()) {
                    stack.push(new Point(0, point.getY()));
                } else {
                    stack.push(point);
                }
            }
        }

        System.out.println("Max Area = " + maxArea);
        return maxArea;
    }

}
