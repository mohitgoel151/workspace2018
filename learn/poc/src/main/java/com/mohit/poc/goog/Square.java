package com.mohit.poc.goog;

public class Square {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}


//Map<Integer, Set<Integer>> pointsForX = new HashMap<>(); //X as key
//Map<Integer, Set<Integer>> pointsForY = new HashMap<>(); // y as key
//
//pointsForX
//    1 => 2, 5
//    4 => 2, 5
//    3 => 5
//
//pointsForY
//    2 => 1,4
//    5 => 1, 3, 4
//
//
//List<Point> points = new ArrayList<>();
//
//public boolean add(int x, int y) { 4, 5
//    
//    Point newPoint = new Point(x, y);
//
//    for(Point point : points) {
//        int x1 = point.x;  //1
//        int y1 = point.y;  //2
//
//        Set<Integer> yCoordinates = pointsForX.get(x (4)); //{2}
//        Set<Integer> xCoordinates = pointsForX.get(y (5)); //{1,3}
//        
//        if(yCoordinates == null || xCoordinates == null) {
//            continue;
//}
//        
//
//        boolean x2 = xCoordinates.contains(y1 (2)); //x2, y1 //4, 2
//        boolean y2 = yCoordinates.contains(x1 (1)); //x1, y2 //1, 5
//        if(x2 && y2) {
//            newPoint (x, y)
//            point //diagonal point (x1, y1)
//            other // (x1, y)
//                // (x, y1)
//        
//            if(Math.abs(x1 - x) == Math.abs(y1-y) && Math.abs(x1 - x) > 0) {
//                updateCache(x, y);
//                points.add(newPoint);
//                return true;
//            }
//                
//        }
//    
//    }
//    updateCache(x, y);
//point    s.add(newPoint);
//    return false;
//
//
//}
//
//private void updateCache (int x, int y) {
//    Set<Point> yCordinates = pointsForX(x);
//    if(yCordinates == null) {
//        yCordinates = new HashSet<>();
//        pointsForX.put(x, yCordinates);
//}
//yCordinates.add(y);
//
//    Set<Point> xCordinates = pointsForX(y);
//if(xCordinates == null) {
//        xCordinates = new HashSet<>();
//        pointsForX.put(x, xCordinates);
//}
//xCordinates.add(y);
//}
//
//n
//
//class Point {
//    int x;
//    int y;
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//}
//
//
//Same point
//Different quadrants


