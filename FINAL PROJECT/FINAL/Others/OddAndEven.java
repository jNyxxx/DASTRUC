package FINAL.Others;

import java.util.Scanner;

public class OddAndEven {
    public static void runOddAndEven(Scanner scan) {
        int[] evenNums = new int[10];
        int[] oddNums = new int[10];    
        int evenCount = 0, oddCount = 0;
        int count = 0;

        System.out.print("Enter how many integers u want to input : ");
        int nums = scan.nextInt();

        for (int i = 0; i < nums; i++){
            System.out.print("Integer [" + count + "] : ");
            int num = scan.nextInt();
            if (num % 2 == 0) {
                evenNums[evenCount++] = num;
            } else {
                oddNums[oddCount++] = num;
            }
            count++;
        }

        System.out.println("\nEven\t\t\t\tOdd");
        for (int i = 0; i < Math.max(evenCount, oddCount); i++) {
            if (i < evenCount) {
                System.out.print(evenNums[i] + "\t\t\t\t");
            } else {
                System.out.print("\t\t\t\t");
            }

            if (i < oddCount) {
                System.out.println(oddNums[i]);
            } else {
                System.out.println();
            }
        }
    }
}
