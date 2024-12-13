package FINAL.Others;

import java.util.Scanner;

public class SumAndProd {
    public static void SumAndProduct(Scanner scan) {
        int input;
        int sum = 0;
        long prod = 1;
        int count = 0;

        System.out.print("Enter how many integers u want to input : ");
        int nums = scan.nextInt();

        for (int i = 0; i < nums; i++) {
            System.out.print("Integer [" + count + "] : ");
            input = scan.nextInt();
            if (input > 0) {
                sum += input;
                prod *= input;
            }
            count++;
        }

        System.out.println("\nSum: " + sum);
        System.out.println("Product: " + prod);
    }
}
