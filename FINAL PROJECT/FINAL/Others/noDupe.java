package FINAL.Others;

import java.util.*;

public class noDupe
{
   public static void noDuplicate(Scanner input)
   {
      int[] num = new int[10];
      String result = "";
      int x;
      int count;
      int arr_count = 0;
      int integerCounter = 0;
      
      System.out.println("Enter 10 numbers:");
      for(count = 0; count < 10; count = count + 1)
      {
         System.out.print("Integer [" + integerCounter + "] : ");
         x = input.nextInt();
         if(!isExisting(x, arr_count, num))
         {
            num[arr_count++] = x;
            result += x + "\n";
         }
         integerCounter++;
      }

      System.out.println("\nUnique Numbers: ");
      System.out.println(result);
   }
   
   public static boolean isExisting(int x, int arr_count, int[] arr)
   {
      for(int i=0; i<arr_count; i++)
      {
         if(x == arr[i])
            return true;
      }
      
      return false;
   
   }
   
}
