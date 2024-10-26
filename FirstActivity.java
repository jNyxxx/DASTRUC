import java.util.Scanner;
class FirstActivity {
    public static void main(String[] args) {
        Scanner scan = new Scanner (System.in);
        int input, sum = 0, prod = 1;
        
        System.out.print("Input 10 integer numbers: ");
        
        for(int i = 1; i <= 10; i++){
            input = scan.nextInt();
            
            if(input > 0){
                sum += input;
                prod *= input;
            }
        }
                System.out.print("The total sum is: " + sum);
                System.out.print("\nThe total product is: " + prod);
    }
}