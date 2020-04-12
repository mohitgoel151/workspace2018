package leetcode.weekly._173;

public class Enco {

    public static void main(String[] args) {
    	
        System.out.println(countNegatives(new int[][] { 
            {3,-1,-3,-3,-3},
            {2,-2,-3,-3,-3},
            {1,-2,-3,-3,-3},
            {0,-3,-3,-3,-3}
       }));

    }

    public static int countNegatives(int[][] grid) {

        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        int count = 0;
        for (int row = 0; row < grid.length; row++) {
            count += negativeInRow(grid[row]);
        }
        return count;
    }

    public static int negativeInRow(int[] row) {

        if (row[0] < 0) {
            return row.length;
        }

        int low = 1;
        int high = row.length - 1;
        int mid;

        while (low <= high) {

            mid = (low + high) / 2;

            if (mid == row.length) {

            }

            if (row[mid - 1] >= 0 && row[mid] < 0) {
                return row.length - mid;
            } else if (row[mid] >= 0) {
                low = mid + 1;
            } else if (row[mid] < 0) {
                high = mid;
            }
        }
        return 0;
    }

}
