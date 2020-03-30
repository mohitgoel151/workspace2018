package com.mohit.poc.graph;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.mohit.models.Point;

/**
 * https://hackernoon.com/google-interview-questions-deconstructed-the-knights-dialer-f780d516f029
 *
 */
public class KnightDialerProblem {
	
	public static void main(String[] args) {
		KnightDialerProblemSol obj = new KnightDialerProblemSol();
		obj.execute();

	}
}

class KnightDialerProblemSol {
    
    List<Point> possibleMoves = null;
    
    public void execute() {
        
        int[][] dialerPad = new int[][] {
            {1,2,3},
            {4,5,6},
            {7,8,9},
            {-1,0,-1}
        };
        
        possibleMoves = getPossibleMoves();
        
        assertEquals(6, getDistinctNumbers(dialerPad, new Point(1, 2), 2));
        assertEquals(16, getDistinctNumbers(dialerPad, new Point(1, 2), 3));
        
        System.out.println("All test cases Passed " + this.getClass().getSimpleName());
    }
    
    private int getDistinctNumbers(int[][] dialerPad, final Point start, final int hops) {
        
        if(dialerPad == null || !isInBounds(dialerPad, start) || hops < 1) {
            throw new IllegalArgumentException("");
        }
        return getMoves(dialerPad, start, hops);
    }
    
    private int getMoves(int[][] dialerPad, final Point position, final int hopsRemaining) {
        
        if(hopsRemaining == 0) {
            return 1;
        }
        
        List<Point> movesforPosition = getMovesForPosition(dialerPad, position);
        
        int moves = 0;
        
        for(Point newCell :  movesforPosition) {
            moves += getMoves(dialerPad, newCell, hopsRemaining-1);
        }
        
        return moves;
    }
    
    private List<Point> getMovesForPosition(final int[][] dialerPad, Point position) {
        
        List<Point> moves = new ArrayList<>();
        
        for(Point jump: possibleMoves) {
            Point newLocation = new Point(position.getX() + jump.getX(), position.getY() + jump.getY());
            if(isInBounds(dialerPad, newLocation)) {
                moves.add(newLocation);
            }
        }
        
        return moves;
    }

    private boolean isInBounds(final int[][] dialerPad, final Point point) {
        
        if(point.getX() < 0 || point.getY() < 0 || point.getX() >= dialerPad.length || point.getY() >= dialerPad[0].length || dialerPad[point.getX()][point.getY()] == -1) {
            return false;
        }
        return true;
    }
    
    
    private List<Point> getPossibleMoves() {

        return Collections.unmodifiableList(
                        Arrays.asList(
                                new Point(2, 1), new Point(2, -1), new Point(-2, 1), new Point(-2, -1), 
                                new Point(1, 2), new Point(1, -2), new Point(-1, 2), new Point(-1, -2)
                        )
               );
    }
    

}
