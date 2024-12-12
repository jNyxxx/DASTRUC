package FINAL.Main;

import java.util.*;

import FINAL.Array.*;
import FINAL.InfToPostf.InfixtoPostfix;
import FINAL.Nodes.*;
import FINAL.Others.*;


public class Compilation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choice;
        

        do{
            System.out.println("\n\t|---------Compilation Main Menu---------|");
            System.out.println("\t|\t[0] Sum and Product Program.\t|");
            System.out.println("\t|\t[1] Odd and Even Program.\t|");
            System.out.println("\t|\t[2] Largest Number.\t\t|");
            System.out.println("\t|\t[3] No Duplicate.\t\t|");
            System.out.println("\t|\t[4] Node List Program.\t\t|");
            System.out.println("\t|\t[5] Stack Array Program.\t|");
            System.out.println("\t|\t[6] Stack List Program.\t\t|");
            System.out.println("\t|\t[7] Infix to Postfix Program.\t|");
            System.out.println("\t|\t[8] Queue Array Program.\t|");
            System.out.println("\t|\t[9] Queue Node Program.\t\t|");
            System.out.println("\t|\t[x] Exit the Program..\t\t|");
            System.out.println("\t|---------------------------------------|");
            System.out.print("\tSelect which program you want to use : ");
            choice = scan.nextLine();
            System.out.println();
            

            switch(choice){
                case "0": 
                // Sum and Product
                System.out.println("Sum and Product Program selected. \n");
                SumAndProd.SumAndProduct(scan);
                break;

                case "1":
                // Odd and Even
                System.out.println("Odd and Even Program selected. \n");
                OddAndEven.runOddAndEven(scan);
                break;

                case "2":
                // Largest Number
                System.out.println("Largest Program Program selected. \n");
                LargestNum.findLargest(scan);
                break;

                case "3":
                // No Duplicate
                System.out.println("No Duplicate Program selected. \n");
                noDupe.noDuplicate(scan);
                break;

                case "4":
                // Node List
                System.out.println("Node List Program selected. ");
                NodeList.nodeList(scan);
                break;

                case "5":
                // Stack Array
                System.out.println("Stack Array Program selected. \n");
                StackArray.stackArray(scan);
                break;

                case "6":
                // Stack Node
                System.out.println("Stack Node Program selected. \n");
                StackList.stackList(scan);
                break;

                case "7":
                // Infix to Postfix 
                InfixtoPostfix.menuInfixToPostfix(scan);
                break;

                case "8":
                // Queue Array
                System.out.println("Queue Array Program selected. \n"); 
                QueueArray.menuQueueArray(scan);
                break;

                case "9":
                // Queue Node
                System.out.println("Queue Node Program selected. \n");
                QueueNode.menuQueueNode(scan);
                break;

                case "x":
                case "X":
                System.out.println("Exiting the Program...");
                break;


            }
        }
        while (!choice.equalsIgnoreCase("x"));

        scan.close();
    }
}
