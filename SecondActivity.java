import java.util.Scanner;

class SecondActivity {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] oddCount = new int[10];
        int[] evenCount = new int[10];
        int oddIndex = 0;
        int evenIndex = 0;
        

        System.out.print("Enter 10 integer numbers: ");

        for (int i = 0; i < 10; i++) {
            int input = scan.nextInt();
            
            if (input % 2 == 0) { 
                evenCount[evenIndex++] = input;
            } else {
                oddCount[oddIndex++] = input;
            }
        }
        
        System.out.printf("%-9s%-10s%n", "Even", "Odd");
        
        int maxLength = Math.max(evenIndex, oddIndex);
        for (int i = 0; i < maxLength; i++) {
            if (i < evenIndex) {
                System.out.print(evenCount[i] + "\t\t\t");
            } else {
                System.out.print("\t\t\t");
            }
            
            if (i < oddIndex) {
                System.out.print(oddCount[i]);
            }
            
            System.out.println();
        }
    }
}
