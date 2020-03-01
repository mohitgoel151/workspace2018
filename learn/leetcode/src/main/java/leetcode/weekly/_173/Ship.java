package leetcode.weekly._173;

public class Ship {

    public static void main(String[] args) {

        int[] input = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int re = shipWithinDays(input, 5);
        System.out.println(re);
    }

    public static int shipWithinDays(int[] weights, int D) {

        if (weights == null || weights.length == 0 || D < 1) {
            return 0;
        }

        int totalWeight = 0;
        for (int w : weights) {
            totalWeight += w;
        }

        if (D == 1) {
            return totalWeight;
        }

        int low = totalWeight / D;
        int high = totalWeight;

        int mid = 0;
        int result = Integer.MAX_VALUE;

        while (low <= high) {

            mid = (low + high) / 2;
            int res = isValid(weights, D, mid);
            if (res == 1) {
                if(mid < result) {
                    result = mid;
                }
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return result;
    }

    public static int isValid(int[] weights, int days, int cap) {

        int tw = 0;

        for (int i = 0; i < weights.length; i++) {

            if (cap < weights[i]) {
                return -1;
            }

            if (tw + weights[i] <= cap) {
                tw += weights[i];
            } else {
                days--;
                tw = weights[i];
            }
        }

        if (days < 1) {
            return -1; // Need to increase cap
        } else if (tw > cap) {
            return -1; // Need to increase cap
        }
        return 1; // Weight can be reduced
    }

}
