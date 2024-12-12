package FINAL.Others;

import java.util.Scanner;

public class LargestNum {
    public static void findLargest(Scanner scan) {
        int count = 0;

        System.out.println("Enter 3 integers: ");
        System.out.print("Integer [" + count + "] : ");
        int x = scan.nextInt();
        count++;
        System.out.print("Integer [" + count + "] : ");
        int y = scan.nextInt();
        count++;
        System.out.print("Integer [" + count + "] : ");
        int z = scan.nextInt();
        count++;

        int largest = findLargest(x, y, z);
        System.out.println("The largest number is: " + largest);
    }

    private static int findLargest(int x, int y, int z) {
        int largest = x;
        if (y > largest) {
            largest = y;
        }
        if (z > largest) {
            largest = z;
        }
        return largest;
    }
}
