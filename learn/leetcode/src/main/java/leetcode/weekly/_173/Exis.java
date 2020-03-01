package leetcode.weekly._173;

import java.util.HashSet;
import java.util.Set;

public class Exis {

    public static void main(String[] args) {
        System.out.println(checkIfExist(new int[] { 7, 1, 14, 11 }));

    }

    public static boolean checkIfExist(int[] arr) {

        Set<String> self = new HashSet<>();

        for (int no : arr) {

            // Check if this no is double of any no
            float selfHalf = ((float) no / 2);
            if (self.contains(String.valueOf(selfHalf))) {
                return true;
            }

            // Check if this no is half of other
            if (self.contains(String.valueOf((float)(2 * no)))) {
                return true;
            }
            self.add(String.valueOf((float)no));
        }
        return false;

    }

}
