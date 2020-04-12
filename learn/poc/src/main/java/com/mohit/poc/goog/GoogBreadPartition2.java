package com.mohit.poc.goog;

public class GoogBreadPartition2 {
	
	public static void main(String[] args) {
		GoogBreadPartition2Sol sol = new GoogBreadPartition2Sol();
		sol.execute();
	}
}

class GoogBreadPartition2Sol {

    public void execute() {

        System.out.println("5 3 6 2 7 4 8 1 ************");
        printMembersInOrder(8);

        System.out.println();
        System.out.println("3 2 4 1  ************");
        printMembersInOrder(4);

        System.out.println();
        System.out.println("5 3 6 2 4 1  **************");
        printMembersInOrder(6);

        System.out.println();
        System.out.println("5 3 2 4 1  **************");
        printMembersInOrder(5);
    }
    

    private void printMembersInOrder(int members) {

        double size = log(members);
        if (size - (int) (size) > 0) {
            size++;
        }

        int newSize = (int)Math.pow(2,  (int)size);
        
        int len = newSize * 2 - 1;
        
        int num = 1;

        int[] arr = new int[len];
        arr[0] = num;
        num++;

        for (int i = 0; 2 * i + 2 < len; i++) {
            if(num <= members) {
                arr[2 * i + 1] = num++;
            } else {
                arr[2 * i + 1] = -1;
            }
            arr[2 * i + 2] = arr[i];
        }

        for (int i = len - newSize; i < len; i++) {
            if(arr[i] != -1) {
                System.out.print(arr[i] + " ");
            }
        }

        System.out.println();
        System.out.println();
    }
    
    public double log(int x) {
        return (Math.log(x) / Math.log(2));
    }

}

// 0 1 2 3 4 5 6 7 8 9 10 11 12 13 14
// 1 2 1 3 2 4 1 5 3 6 2  7  4  8  1
