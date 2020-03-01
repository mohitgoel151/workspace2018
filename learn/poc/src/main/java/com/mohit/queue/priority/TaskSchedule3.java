package com.mohit.queue.priority;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 
 * https://leetcode.com/problems/course-schedule-iii/
 * 
 * There are n different online courses numbered from 1 to n. Each course has some duration(course length) t and closed on dth day. 
 * A course should be taken continuously for t days and must be finished before or on the dth day. You will start at the 1st day. 
 * Given n online courses represented by pairs (t,d), your task is to find the maximal number of courses that can be taken.
 *
 */
public class TaskSchedule3 {

    public void execute() {
        assertEquals(5, scheduleCourse(new int[][] { { 5, 15 }, { 3, 19 }, { 6, 7 }, { 2, 10 }, { 5, 16 }, { 8, 14 }, { 10, 11 }, { 2, 19 } }));
        assertEquals(3, scheduleCourse(new int[][] { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } }));
        assertEquals(2, scheduleCourse(new int[][] { { 1, 2 }, { 2, 3 } }));
        assertEquals(2, scheduleCourse(new int[][] { { 5, 5 }, { 4, 6 }, { 2, 6 } }));

        assertEquals(5, scheduleCourseWithPQ(new int[][] { { 5, 15 }, { 3, 19 }, { 6, 7 }, { 2, 10 }, { 5, 16 }, { 8, 14 }, { 10, 11 }, { 2, 19 } }));
        assertEquals(3, scheduleCourseWithPQ(new int[][] { { 100, 200 }, { 200, 1300 }, { 1000, 1250 }, { 2000, 3200 } }));
        assertEquals(2, scheduleCourseWithPQ(new int[][] { { 1, 2 }, { 2, 3 } }));
        assertEquals(2, scheduleCourseWithPQ(new int[][] { { 5, 5 }, { 4, 6 }, { 2, 6 } }));
        
        int[][] in = new int[][] {
            {1,7},{2,3},{1,8},{2,3},{5,7},{4,5},{4,8},{2,10},{2,9},{2,10},{5,9},{5,7},{7,10},{3,5},{1,8},{5,8},{1,8},{5,5},{6,6},{3,3},{2,4},{1,3},{2,10},{2,9},{2,2},{1,7},{4,6},{9,10},{1,4},{8,10},{6,9},{3,9},{6,9},{1,9},{2,5},{7,8},{7,8},{1,8},{2,4},{2,8},{2,5},{1,1},{8,8},{8,9},{5,6},{1,2},{3,8},{1,8},{5,9},{1,6},{3,9},{1,9},{5,6},{1,8},{1,10},{4,9},{5,5},{6,7},{1,8},{7,8},{8,9},{3,10},{6,6},{4,5},{3,7},{7,7},{4,6},{3,6},{1,3},{1,10},{8,9},{1,9},{3,9},{2,8},{5,10},{4,10},{1,4},{7,10},{5,5},{3,4},{2,6},{4,8},{8,9},{6,8},{1,10},{2,8},{4,7},{2,8},{2,10},{1,4},{2,9},{2,2},{2,2},{4,4},{6,6},{3,4},{6,8},{2,2},{5,7},{1,5},{4,9},{5,8},{5,6},{1,10},{9,9},{5,8},{4,6},{7,9},{6,8},{6,6},{5,10},{1,3},{2,9},{3,4},{9,10},{1,10},{1,2},{3,10},{3,9},{1,8},{1,2},{3,6},{3,10},{3,4},{8,9},{3,8},{8,8},{4,9},{1,2},{8,8},{7,10},{6,10},{2,2},{1,7},{7,8},{4,10},{5,7},{4,6},{9,10},{4,7},{1,8},{7,7},{4,10},{6,8},{4,10},{1,2},{2,9},{8,10},{3,9},{3,3},{1,9},{1,9},{1,6},{5,9},{7,10},{3,8},{6,9},{5,9},{5,8},{4,7},{2,8},{10,10},{7,9},{5,7},{1,2},{1,2},{5,7},{1,1},{1,4},{5,5},{6,7},{1,7},{4,10},{9,10},{6,8},{2,6},{5,8},{7,10},{4,5},{2,9},{6,7},{1,4},{3,9},{1,9},{7,7},{3,8},{1,5},{2,7},{2,4},{2,8},{5,5},{2,9},{2,4},{1,8},{2,5},{4,10},{8,10},{3,7},{5,6},{1,5},{2,8},{1,2},{3,9},{3,4},{5,6},{3,10},{3,10},{2,10},{2,5},{6,8},{3,7},{9,10},{1,10},{3,6},{3,8},{4,10},{5,8},{4,8},{1,7},{1,2},{1,7},{2,5},{7,8},{8,10},{2,7},{5,6},{4,7},{1,6},{2,7},{7,8},{3,6},{1,7},{3,7},{9,9},{1,9},{1,2},{5,10},{1,7},{5,9},{2,4},{4,9},{5,10},{2,5},{3,7},{8,9},{4,7},{6,7},{2,4},{1,9},{5,7},{8,9},{4,6},{8,10},{4,8},{1,7},{6,10},{8,9},{3,3},{2,3},{3,6},{3,9},{3,5},{9,9},{2,10},{1,5},{1,2},{3,8},{1,6},{5,6},{1,4},{3,9},{6,9},{4,7},{9,9},{6,8},{7,8},{4,5},{1,9},{1,9},{7,10},{1,4},{4,9},{4,7},{2,8},{4,8},{6,7},{2,8},{7,10},{4,5},{3,5},{5,7},{6,7},{2,8},{2,4},{4,6},{4,9},{4,7},{3,6},{7,9},{7,8},{3,7},{8,9},{2,9},{3,3},{3,8},{5,10},{6,6},{7,10},{3,10},{7,9},{2,6},{3,5},{9,9},{6,7},{1,7},{2,8},{3,8},{5,8},{1,3},{1,1},{2,3},{2,3},{4,5},{5,7},{7,10},{2,7},{7,10},{4,10},{2,10},{6,9},{3,6},{1,5},{7,7},{3,5},{2,8},{2,5},{2,5},{8,10},{2,6},{2,7},{4,10},{9,10},{4,9},{1,9},{1,8},{1,2},{1,5},{7,9},{3,9},{4,8},{3,7},{5,5},{4,6},{9,10},{9,10},{4,7},{5,10},{6,9},{2,4},{8,9},{1,3},{6,10},{1,3},{7,10},{2,10},{3,10},{3,4},{1,10},{9,10},{1,2},{5,9},{5,7},{3,5},{2,10},{4,4},{3,9},{4,8},{6,8},{2,3},{4,5},{1,10},{5,7},{1,10},{2,2},{1,2},{5,10},{3,6},{1,3},{7,10},{5,9},{6,9},{1,10},{2,6},{4,10},{3,4},{1,9},{3,4},{7,9},{6,10},{3,10},{5,8},{8,10},{6,8},{1,7},{6,8},{6,8},{4,4},{5,8},{2,10},{2,10},{2,9},{3,9},{8,10},{6,9},{1,8},{5,8},{6,8},{5,8},{5,8},{5,9},{5,10},{2,3},{1,6},{3,7},{6,10},{6,7},{1,5},{4,10},{1,8},{3,4},{4,8},{4,9},{3,4},{3,4},{4,9},{3,7},{3,9},{5,9},{4,7},{3,7},{5,5},{4,9},{5,6},{1,2},{5,6},{2,3},{6,6},{3,7},{3,5},{1,10},{5,9},{9,10},{3,6},{5,8},{3,6},{2,5},{9,10},{2,8},{4,5},{1,7},{6,8},{2,7},{6,8},{7,9},{5,6},{6,10},{2,7},{7,10},{1,6},{3,10},{2,8},{1,2},{4,5},{6,10},{1,8},{6,9},{5,8},{4,7},{1,10},{2,7},{3,9},{2,9},{6,8},{4,10},{4,6},{1,8},{5,7},{2,7},{4,10},{2,9},{1,7},{1,6},{3,6},{8,9},{3,8},{7,9},{3,7},{2,8},{2,9},{2,6},{3,9},{6,7},{1,10},{5,8},{5,7},{2,4},{7,7},{6,7},{7,8},{1,8},{1,2},{9,9},{2,4},{4,6},{2,3},{8,10},{5,8},{2,3},{6,6},{7,7},{6,10},{6,9},{2,9},{6,8},{5,9},{4,10},{4,8},{2,9},{1,2},{4,7},{2,8},{3,10},{3,6},{6,10},{4,10},{4,5},{1,1},{2,7},{3,10},{6,7},{5,8},{4,5},{2,5},{6,10},{4,6},{7,7},{1,7},{7,8},{2,6},{1,2},{7,8},{1,4},{2,7},{1,7},{4,8},{4,4},{4,9},{2,7},{3,6},{2,2},{2,9},{2,4},{3,5},{5,10},{5,8},{2,2},{8,10},{5,5},{2,3},{1,4},{1,5},{4,4},{2,7},{1,8},{3,4},{6,6},{1,4},{4,10},{4,8},{6,9},{5,10},{2,9},{4,5},{6,7},{1,9},{2,7},{4,10},{1,3},{6,8},{2,3},{7,10},{8,10},{1,9},{10,10},{3,6},{5,5},{8,9},{3,10},{1,5},{3,4},{1,7},{2,7},{4,9},{5,7},{6,7},{1,8},{4,6},{4,7},{3,7},{4,5},{7,7},{8,10},{7,10},{4,7},{3,7},{3,6},{1,5},{2,10},{5,10},{7,7},{4,4},{2,4},{4,7},{5,10},{4,8},{3,7},{1,5},{8,10},{8,8},{8,10},{2,9},{1,9},{2,2},{5,6},{7,9},{8,9},{4,8},{1,3},{9,9},{2,9},{5,6},{7,8},{5,10},{8,9},{3,4},{2,4},{4,10},{1,8},{2,2},{8,9},{4,9},{7,9},{1,9},{3,8},{3,6},{6,7},{2,5},{5,8},{4,8},{1,9},{8,9},{7,8},{8,9},{9,10},{1,1},{2,9},{1,5},{7,8},{3,6},{7,9},{5,7},{6,9},{5,10},{4,9},{4,8},{5,7},{8,9},{1,10},{4,8},{1,3},{2,8},{1,10},{2,4},{3,5},{2,5},{5,9},{2,10},{6,8},{4,8},{7,10},{5,9},{3,7},{2,3},{1,8},{3,7},{5,6},{1,6},{1,9},{2,7},{5,6},{2,3},{8,10},{3,9},{2,7},{2,2},{9,10},{1,5},{2,10},{2,10},{1,2},{4,9},{1,6},{1,1},{2,5},{2,10},{1,6},{3,8},{8,8},{2,7},{6,6},{1,5},{5,5},{6,9},{4,6},{4,9},{3,8},{1,6},{6,8},{8,9},{2,10},{2,3},{7,8},{2,6},{6,6},{1,4},{2,8},{5,10},{8,8},{1,10},{1,3},{6,7},{1,9},{6,8},{3,10},{3,7},{5,7},{3,3},{1,10},{3,8},{1,5},{2,5},{1,7},{4,6},{1,2},{7,9},{1,4},{2,2},{2,8},{7,10},{2,6},{5,10},{6,7},{1,9},{2,3},{4,9},{1,4},{3,5},{7,9},{4,8},{6,9},{1,3},{7,9},{4,9},{5,8},{4,7},{9,9},{9,10},{8,10},{7,7},{8,10},{6,9},{7,7},{4,4},{1,8},{3,4},{2,8},{4,8},{2,6},{8,10},{2,9},{3,8},{8,10},{5,7},{5,8},{7,8},{3,9},{3,8},{2,10},{7,8},{2,9},{7,8},{2,9},{1,8},{2,9},{1,6},{1,8},{1,6},{5,9},{10,10},{2,8},{3,4},{1,4},{4,9},{4,8},{2,4},{4,5},{2,2},{1,4},{6,9},{1,4},{3,7},{1,10},{5,10},{2,10},{5,10},{3,8},{3,5},{4,10},{7,10},{7,8},{3,8},{3,8},{4,6},{3,5},{2,6},{9,9},{3,8},{3,8},{3,4},{3,10},{3,7},{8,8},{4,7},{3,4},{3,8},{9,10},{3,7},{1,9},{7,10},{2,4},{9,9},{4,7},{3,8},{3,3},{5,6},{2,3},{5,10},{1,4},{1,3},{1,10},{3,7},{1,4},{3,6},{5,10},{1,8},{2,4},{6,10},{1,2},{5,8},{5,5},{7,9},{1,2},{5,6},{7,10},{2,7},{7,10},{7,10},{4,4},{2,9},{5,7},{2,4},{6,9},{4,10},{2,9},{9,9},{6,10},{6,10},{1,1},{1,7},{2,7},{2,6},{7,7},{1,5},{8,9},{6,7},{2,5},{1,2},{6,7},{4,6},{7,8},{3,10},{1,2},{2,4},{3,8},{1,6},{8,9},{4,9},{8,10},{3,4},{1,7},{8,9},{10,10},{2,3},{6,6},{4,9},{7,10},{6,9},{8,9},{3,6},{1,4},{3,10},{2,2},{3,3},{1,6},{3,8},{4,5},{5,6},{10,10},{1,6},{1,5},{4,9},{4,8},{2,9},{6,9},{4,10},{7,8},{3,5},{5,8},{3,8},{2,5},{7,8},{3,10},{4,8},{8,9},{1,5},{3,10},{1,3},{2,4},{9,10},{1,7},{2,4},{1,8},{1,5},{7,9},{7,10},{9,9},{1,9},{3,10},{2,8},{1,2},{2,10},{1,3},{5,7},{2,10},{7,8},{5,6},{6,10},{6,9},{4,6},{5,8},{5,8},{6,8},{6,7},{7,9},{3,3},{1,9},{2,7},{3,9},{3,4},{7,9},{1,3},{3,6},{4,8},{6,7},{2,10},{1,9},{1,1},{4,10},{1,3},{1,7},{6,10},{3,6},{4,10},{7,9},{4,7},{2,9},{2,3},{8,8},{7,8},{3,8}
        };
        
        assertEquals(10, scheduleCourseWithPQ(in));

        System.out.println("All test cases passes " + this.getClass().getSimpleName());

    }

    public int scheduleCourseWithPQ(int[][] courses) {
        if (courses == null || courses.length == 0) {
            // IllegalArg Exception
        }

        Arrays.sort(courses, new IntervalComparator());

        Queue<int[]> pq = new PriorityQueue<>(new TaskComparator());

        int count = 0;
        int start = 0;

        for (int[] course : courses) {

            if (start + course[0] <= course[1]) {
                pq.add(course);
                count++;
                start += course[0];
            } else if (pq.peek()[0] > course[0]) {
                int[] front = pq.poll();
                pq.add(course);
                start += (course[0] - front[0]);
            }
        }
        return count;
    }

    public int scheduleCourse(int[][] courses) {

        if (courses == null || courses.length == 0) {
            // IllegalArg Exception
        }

        Arrays.sort(courses, new IntervalComparator());

        int startD = 0;
        int endD = courses[courses.length - 1][1];

        Map<String, Integer> cache = new HashMap<>();

        return getMax(startD, endD, 0, courses, cache);
    }

    private int getMax(int startD, int endD, int courseIndex, int[][] courses, Map<String, Integer> cache) {

        if (courseIndex == courses.length) {
            return 0;
        }

        String key = startD + "_" + courseIndex;
        Integer value = cache.get(key);

        if (value == null) {
            int withNext = 0;
            int withOutNext = 0;

            int[] currentCourse = courses[courseIndex];

            if (startD + currentCourse[0] <= currentCourse[1]) {
                withNext = 1 + getMax(startD + currentCourse[0], endD, courseIndex + 1, courses, cache);
            }

            withOutNext = getMax(startD, endD, courseIndex + 1, courses, cache);
            value = Math.max(withNext, withOutNext);

            cache.put(key, value);
        }
        return value;
    }
}

class TaskComparator implements Comparator<int[]> {
    @Override
    public int compare(int[] a, int[] b) {
        return -1 * (a[0] - b[0]);
    }
}

class IntervalComparator implements Comparator<int[]> {
    public int compare(int[] a, int[] b) {
        return a[1] - b[1];
    }
}
